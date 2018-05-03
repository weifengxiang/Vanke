/**   
* @Title: DictUtils.java 
* @Package org.es.sys.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2016-10-9 上午10:25:57 
* @version V1.0   
*/


package org.sky.sys.utils;

import java.util.List;

import org.sky.sys.model.SysDictItem;

/** 
 * @ClassName: DictUtils 
 * @Description: TODO(字典工具类) 
 * @author 位峰祥 
 * @date 2016-10-9 上午10:25:57 
 * @version V1.0 
 */
public class DictUtils {
	/**
	 * 
	* @Title: getDictItem 
	* @Description: TODO(获取字典DS) 
	* @param @param type
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getDictItem(String type) throws Exception{
		String dataOptions="";
		List<SysDictItem> typelist=ApplicationCached.getDictItemByDicType(type);
		for(int i=0;i<typelist.size();i++){
			SysDictItem it=typelist.get(i);
			if(i==typelist.size()-1){
				dataOptions+="{\"code\":\""+it.getCode()+"\",\"name\":\""+it.getName()+"\"}";
			}else{
				dataOptions+="{\"code\":\""+it.getCode()+"\",\"name\":\""+it.getName()+"\"},";
			}
		}
		return "["+dataOptions+"]";
	}
	/**
	 * 
	* @Title: getDictItem_text
	* @Description: TODO(获取字典DS) 
	* @param @param type
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getDictItem_text(String type) throws Exception{
		String dataOptions="";
		List<SysDictItem> typelist=ApplicationCached.getDictItemByDicType(type);
		if("PTTYPE".equals(type)){
		System.out.println(JsonUtils.obj2json(typelist));
		}
		for(int i=0;i<typelist.size();i++){
			SysDictItem it=typelist.get(i);
			if(i==typelist.size()-1){
				dataOptions+="{\"code\":\""+it.getCode()+"\",\"name\":\""+it.getName()+"\"}";
			}else{
				dataOptions+="{\"code\":\""+it.getCode()+"\",\"name\":\""+it.getName()+"\"},";
			}
		}
		return "["+dataOptions+"]";
	}
}
