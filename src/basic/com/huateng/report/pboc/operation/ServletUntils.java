package com.huateng.report.pboc.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ServletUntils {
	


	private static String getX(String str, int j) {
		String str2 = "";
		for (int i = 0; i < j; i++) {
			str2 += str;
		}
		return str2;
	}

	@SuppressWarnings("unchecked")
	public static Object getNewValue(String key0,String key,Object obj) {
		Object result = "";
		if (obj != "{}" && obj != null) {
			//hashmap类  CR_PER_PRH，CR_PER_PIM，CR_PER_PMM， CR_PER_PRH.PA01BD02
			if (obj instanceof java.lang.String) {			
				String str = obj.toString();
				
				if (key0.equals("CR_PER_PRH")) {//基本信息CR_PER_PRH.PA01BD01
					if (key.equals("PA01AI01")||key.equals("PA01BD02")||key.equals("PA01AR01")||key.equals("PA01BD01")) {
						result=str;
					}else if (key.equals("PA01BQ01")) {
						result = str.substring(0, 1) + getX("*", str.length() - 1);
						//result=getX("*",str.length());
					} else{
						result=getElseValue(str);	
					}
				}
				if (key0.equals("CR_PER_PIM")) {//个人身份信息  CR_PER_PIM.PB01AD04
					if (key.equals("PB01AD05")||key.equals("PB01AD02")) {
						result=str;
					}else if(key.equals("PB01AR01")){//出生日期
						result="****-**-**";
					}else if (key.equals("PB01AD04")) {
						result=getX("*",str.length());
					} else{
						result=getElseValue(str);
					}
				}
				if (key0.equals("CR_PER_PMM")) {//身份信息-婚姻状况
					if (key.equals("PB020D01")) {//PB020D01
						result=getX("*",str.length());
					}else if (key.equals("PB020Q01")) {
						result = str.substring(0, 1) + getX("*", str.length() - 1);
						//result=getX("*",str.length());
					}else{
						result=getElseValue(str);
					}
				}
				
			}
			if (obj instanceof java.util.HashMap) {
				//arraylist类CR_PER_PA01CH，CR_PER_PB01BH，CR_PER_PRM
				HashMap<String, Object> hs = (HashMap<String, Object>) obj;
				for (Entry<String, Object> entry : hs.entrySet()) {
					//CR_PER_POQ,CR_PER_POM,
//					if (key0.equals("CR_PER_PA01CH")||key0.equals("CR_PER_PB01BH")||key0.equals("CR_PER_PRM")||key0.equals("CR_PER_POM")||key0.equals("CR_PER_POQ")) {
					if (key0.equals("CR_PER_PA01CH")||key0.equals("CR_PER_PB01BH")||key0.equals("CR_PER_PRM")||key0.equals("CR_PER_POM")) {
						hs.put(entry.getKey(), getStringValue(key0,entry.getKey(),entry.getValue()));
					}
			
				}
				result = hs;
			}
		}
		return result;
	}

/*	//前一后一
	public static Object  getElseValue(String str){
		Object result = "";
		if (str.length() > 2) {
			result = str.substring(0, 1) + getX("*", str.length() - 2)
			+ str.substring(str.length() - 2, str.length() - 1);
		}else  if  (str.length() == 2)  {
			result = str.substring(0, 1) +"*";
		}else{
			result=str;
		}
		return result;
		
	}
*/	//前3后3
	public static Object  getElseValue(String str){
		Object result = "";
		   if (str.length() > 6) {
				result = str.substring(0, 3) + getX("*", str.length() - 6)
						+ str.substring(str.length() - 3, str.length());
			/*}else  if  (str.length() == 2)  {
				result = str.substring(0, 1) +"*";*/
			}else{
				result=str;
			}
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	public static Object getCorpValue(String key,Object obj) {
		Object result = "";
		if (obj != "{}" && obj != null) {			
			if (obj instanceof java.util.HashMap) {
				HashMap<String, Object> hs = (HashMap<String, Object>) obj;
				for (Entry<String, Object> entry : hs.entrySet()) {	
					if (entry.getKey().equals("EC050Q01")||entry.getKey().equals("EC050I01")) {
						hs.put(entry.getKey(), getStringValue2(entry.getKey(),entry.getValue()));
					}
						
				}
				result = hs;
			}
		}
		return result;
	}
	public static Object getStringValue(String key0,String key,Object obj) {
		Object result = "";
		if (obj!=""&&obj!=null) {
			String str=obj.toString();	
			/*if (key0.equals("CR_PER_POQ")) {//基本信息 
				if (key.equals("PH010Q03")) {
					result=str;
				} else{
					result=getElseValue(str);
				}
			}else*/
			if (key0.equals("CR_PER_POM")) {//职业信息//PB040D01  PB040D05
				if (key.equals("PB040R01")||key.equals("PB040D02")||key.equals("PB040D01")||key.equals("PB040R02")) {
					result=str;
				}else if(key.equals("PB040D05")) {
					result=getX("*",str.length());
				} else {
					result=getElseValue(str);
				}
			}else if (key0.equals("CR_PER_PRM")) {//CR_PER_PRM.PB030Q01
				if (key.equals("PB030Q01")) {
				  result=getX("*",str.length());
				}else if (key.equals("PB030D01")||key.equals("PB030Q02")||key.equals("PB030R01")) {
					result=str;
				}
			}else if (key0.equals("CR_PER_PB01BH")) {//手机号和信息日期
				if (key.equals("PB01BQ01")) {
					result = str.substring(0, 1) + getX("*", str.length() - 2)
					//+ str.substring(str.length() - 2, str.length() - 1);	
					+ str.substring(str.length() - 1, str.length());	
				}else if (key.equals("PB01BR01")) {
					result=str;
				}
			} 
			
			else{
				result=getX("*",str.length());
			}
		}
		
		return result;

	}
	public static Object getStringValue2(String key,Object obj) {
		String result = "";
		if (obj!=""&&obj!=null) {
			String str=obj.toString();		
			if (key.equals("EC050Q01")) {//姓名
				result = str.substring(0, 1) + getX("*", str.length() - 1);
			}else if(key.equals("EC050I01")){//证件号码
				result = str.substring(0, 3) + getX("*", str.length() - 6)
				+ str.substring(str.length() - 4, str.length() - 1);
			}
		}
		
		return result;

	}
     /**
      * 
     * @Title: getNewMap
     * @Description: TODO(个人脱敏)
     * @param @param map
     * @param @return    参数
     * @return Map<String,Object>    返回类型
     * @throws
      */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getNewMap(Map<String, Object> map) {
		try {
			for (Entry<String, Object> entry2 : map.entrySet()) {
				String key=entry2.getKey();
				Object obj = entry2.getValue();
				if (obj != "{}" && obj != null) {
					if (obj instanceof java.util.HashMap) {
						HashMap<String, Object> hs = (HashMap<String, Object>) obj;
						for (Entry<String, Object> entry : hs.entrySet()) {
							//需要加*的类CR_PER_PRH
							if (key.equals("CR_PER_PRH")||key.equals("CR_PER_PIM")||key.equals("CR_PER_PMM")) {
								hs.put(entry.getKey(), getNewValue(key,entry.getKey(),entry.getValue()));	
							}							
						}
						map.put(key, hs);
					}
					if (obj instanceof java.util.ArrayList) {
						List hs = (List) obj;
						List list = new ArrayList<>();
						for (int i = 0; i < hs.size(); i++) {
							list.add(getNewValue(key,"map",hs.get(i)));
						}
						map.put(entry2.getKey(), list);
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 
	* @Title: getCorpMap
	* @Description: TODO(企业脱敏)
	* @param @param map
	* @param @return    参数
	* @return Map<String,Object>    返回类型
	* @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getCorpMap(Map<String, Object> map) {
		try {
			for (Entry<String, Object> entry2 : map.entrySet()) {
				String key=entry2.getKey();
				Object obj = entry2.getValue();		
					if (obj != "{}" && obj != null) {
						if (obj instanceof java.util.ArrayList) {
						if (key.equals("EC050H")) {
							List hs = (List) obj;
							List list = new ArrayList<>();
							for (int i = 0; i < hs.size(); i++) {
								list.add(getCorpValue(key,hs.get(i)));
							}
							map.put(entry2.getKey(), list);
						}	
						}
					}	
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
     * 
    * @Title: getCorpMap1
    * @Description: TODO(企业脱敏)
    * @param @param map  
    * @param @return    参数
    * @return Map<String,Object>    返回类型
    * @throws
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getCorpMap1(Map<String, Object> map) {
		try {
			for (Entry<String, Object> entry2 : map.entrySet()) {
				String key=entry2.getKey();
				Object obj = entry2.getValue();
				if (obj != "{}" && obj != null) {
					/*if (obj instanceof java.util.HashMap) {
						HashMap<String, Object> hs = (HashMap<String, Object>) obj;
						for (Entry<String, Object> entry : hs.entrySet()) {
							//需要加*的类  //EC020H 出资人  EC030H 主要组成人员   EC050H 实际控制人
							if (key.equals("EC020H")||key.equals("EC030H")||key.equals("EC050H")) {
								hs.put(entry.getKey(), getNewValue1(key,entry.getKey(),entry.getValue()));	
							}							
						}
						map.put(key, hs);
					}*/
					if (obj instanceof java.util.ArrayList) {
						List hs = (List) obj;
						List list = new ArrayList<>();
						for (int i = 0; i < hs.size(); i++) {
							list.add(getNewValue1(key,"map",hs.get(i)));
						}
						map.put(entry2.getKey(), list);
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

@SuppressWarnings("unchecked")
	public static Object getNewValue1(String key0,String key,Object obj) {
		Object result = "";
		if (obj != "{}" && obj != null) {
			//hashmap类  //EC020H 出资人  EC030H 主要组成人员   EC050H 实际控制人
			/*if (obj instanceof java.lang.String) {			
				String str = obj.toString();
				
				if (key0.equals("EC020H")) {//EC020H 出资人
					if (key.equals("EC020D01")||key.equals("EC020D02")||key.equals("EC020D03")||key.equals("EC020Q02")) {
						result=str;
					}else if (key.equals("EC020Q01")) {
						result = str.substring(0, 1) + getX("*", str.length() - 1);
					} else{
						result=getElseValue(str);	
					}
				}
				if (key0.equals("EC030H")) {//EC030H 主要组成人员
					if (key.equals("EC030D01")||key.equals("EC030D02")) {
						result=str;
					}else if(key.equals("EC030Q01")){
						result=getX("*",str.length());
					} else{
						result=getElseValue(str);
					}
				}
				if (key0.equals("EC050H")) {//EC050H 实际控制人
					if (key.equals("EC050D01")||key.equals("EC050D02")) {
						result=str;
					if (key.equals("EC050Q01")) {
						result=getX("*",str.length());
					}else{
						result=getElseValue(str);
					}
				}
				
			}*/
			if (obj instanceof java.util.HashMap) {
				//arraylist类  //EC020H 出资人  EC030H 主要组成人员   EC050H 实际控制人
				HashMap<String, Object> hs = (HashMap<String, Object>) obj;
				for (Entry<String, Object> entry : hs.entrySet()) {
					if (key0.equals("EC020H")||key0.equals("EC030H")||key0.equals("EC050H")) {
						hs.put(entry.getKey(), getStringValue1(key0,entry.getKey(),entry.getValue()));
					}
			
				}
				result = hs;
			}
		}
		return result;
	}

public static Object getStringValue1(String key0,String key,Object obj) {
		Object result = "";
		if (obj!=""&&obj!=null) {
			String str=obj.toString();	
			if (key0.equals("EC020H")) {//EC020H 出资人
					if (key.equals("EC020D01")||key.equals("EC020D02")||key.equals("EC020D03")||key.equals("EC020Q02")) {
						result=str;
					}else if (key.equals("EC020Q01")) {
						result = str.substring(0, 1) + getX("*", str.length() - 1);
					} else{
						result=getElseValue(str);	
					}
				}
			if (key0.equals("EC030H")) {//EC030H 主要组成人员
					if (key.equals("EC030D01")||key.equals("EC030D02")) {
						result=str;
					}else if(key.equals("EC030Q01")){
						//result=getX("*",str.length());
						result = str.substring(0, 1) + getX("*", str.length() - 1);
					} else{
						result=getElseValue(str);
					}
				}
			if (key0.equals("EC050H")) {//EC050H 实际控制人
					if (key.equals("EC050D01")||key.equals("EC050D02")) {
						result=str;
					//modify by chensibi
					}else if (key.equals("EC050Q01")) {
						//result=getX("*",str.length());
						result = str.substring(0, 1) + getX("*", str.length() - 1);
					}else{
						result=getElseValue(str);
					}
				}
		}
		return result;
	}
	

}
