package org.sky.app.utils;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.ResultData;

import com.alibaba.fastjson.JSONObject;

public class JwtUtil {
	
	/**
	 * token生成配置
	 */
	private static final String stringKey = "com.sky.vanke";
    public static final int JWT_EXP = 60*60*1000;
    public static final int JWT_REFRESH_TTL = 30*24*60*60*1000;
    public static final String TOKEN_TYPE = "tokenType";//token类型名
	public static final String TOKEN_TYPE_LOGIN = "1";//长效token类型值
	public static final String TOKEN_TYPE_REQUEST = "2";//请求token类型值

	/**
	 * 由字符串生成加密key
	 * 
	 * @return
	 */
	public static SecretKey generalKey() {
		byte[] encodedKey = Base64.decodeBase64(stringKey);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length,"AES");
		return key;
	}

	/**
	 * 创建jwt
	 * @param subject
	 * @param tokenType
	 * @param extTime
	 * @return
	 * @throws Exception
	 */
	public static String createJWT(String subject,String tokenType,int extTime) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey key = generalKey();
		JwtBuilder builder = Jwts.builder()
				.setIssuedAt(now)
				.setSubject(subject)
				.claim(JwtUtil.TOKEN_TYPE, tokenType)
				.signWith(signatureAlgorithm, key);
		if (extTime >= 0) {
			long expMillis = nowMillis + extTime;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	/**
	 * 解密jwt
	 * 
	 * @param jwt
	 * @return
	 * @throws Exception
	 */
	public static ResultData parseJWT(String jwt,String tokenType){
		ResultData rd = new ResultData();
		try{
			SecretKey key = generalKey();
			Claims claims = Jwts.parser()
					.setSigningKey(key)
					.parseClaimsJws(jwt)
					.getBody();
			String subject = claims.getSubject();
			if(!tokenType.equals(claims.get(JwtUtil.TOKEN_TYPE, String.class))){
				rd.setCode(AppConst.TOKEN_ERROR);
				rd.setName(AppConst.TOKEN_ERROR_DESCRIPTION);
			}else{
				rd.setCode(AppConst.SUCCESS);
				rd.setName(AppConst.SUCCESS_DESCRIPTION);
				rd.setData(subject);
			}
		} catch(SignatureException | MalformedJwtException e){//jwt解析错误
			rd.setCode(AppConst.TOKEN_ERROR);
			rd.setName(AppConst.TOKEN_ERROR_DESCRIPTION);
		} catch(ExpiredJwtException e){//jwt过期
			rd.setCode(AppConst.TOKEN_EXP);
			rd.setName(AppConst.TOKEN_EXP_DESCRIPTION);
		}
		return rd;
	}

}
