package org.sky.app.utils;

import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.sky.sys.utils.ResultData;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
/**
 * 
 * @ClassName:  JWTUtils   
 * @Description:TODO(JSON WEB TOKEN工具类)   
 * @author: weifx 
 * @date:   2018年4月12日 上午10:32:59   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class JWTUtils {
	
	/**
	 * token生成配置
	 */
	private static final String stringKey = "SKY";
	public static final String JWT_LOGIN_TYPE = "1";//登录状态长效token类型值
	private static final int JWT_LOGIN_EXP = 30*24*60*60*1000;
	public static final String JWT_REQUEST_TYPE = "2";//请求token类型值
	private static final int JWT_REQUEST_EXP = 60*60*1000;    
    private static final String TOKEN_TYPE = "JWT";//token类型名
	private static final String ISSUSER="www.sky.org";//JWT的签发主体
	
	/**
	 * 由字符串生成加密key
	 * @return
	 */
	public static SecretKey generalKey() {
		byte[] encodedKey = Base64.decodeBase64(stringKey);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length,"AES");
		return key;
	}

	/**
	 * 创建JWT
	 * @param subject(JWT的主体,即它的所有人登录用户CODE)
	 * @param audience(JWT的接收对象)
	 * @param tokenType(登录TOKEN/请求TOKEN)
	 * @return
	 * @throws Exception
	 */
	public static String createJWT(String subject,String audience,
			String tokenType) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey key = generalKey();
		JwtBuilder builder = Jwts.builder()
				.setIssuer(ISSUSER)
				.setSubject(subject)
				.setAudience(audience)
				.setNotBefore(now)
				.setIssuedAt(now)
				.setSubject(subject)
				.claim(JWTUtils.TOKEN_TYPE, tokenType)
				.signWith(signatureAlgorithm, key);
		int expTime = 0;
		if(JWTUtils.JWT_LOGIN_TYPE.equals(tokenType)) {
			expTime = JWTUtils.JWT_LOGIN_EXP;
		}else if(JWTUtils.JWT_REQUEST_TYPE.equals(tokenType)) {
			expTime = JWTUtils.JWT_REQUEST_EXP;
		}
		if (expTime >= 0) {
			long expMillis = nowMillis + expTime;
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
			if(!tokenType.equals(claims.get(JWTUtils.TOKEN_TYPE, String.class))){
				rd.setCode(AppConst.TOKEN_ERROR);
				rd.setName(AppConst.TOKEN_ERROR_NAME);
			}else{
				rd.setCode(AppConst.TOKEN_SUCCESS);
				rd.setName(subject);
			}
		} catch(SignatureException | MalformedJwtException e){//jwt解析错误
			rd.setCode(AppConst.TOKEN_ERROR);
			rd.setName(AppConst.TOKEN_ERROR_NAME);
		} catch(ExpiredJwtException e){//jwt过期
			rd.setCode(AppConst.TOKEN_EXP);
			rd.setName(AppConst.TOKEN_EXP_NAME);
		}
		return rd;
	}

	/**
	 * 生成subject信息
	 * 
	 * @param user
	 * @return
	 */
	public static String generalSubject(String userId) {
		return userId;
	}
}
