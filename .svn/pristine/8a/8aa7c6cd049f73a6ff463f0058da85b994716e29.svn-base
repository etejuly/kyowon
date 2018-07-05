package com.kyowon.aimath.ai.util;

import net.bitnine.agensgraph.deps.org.json.simple.JSONArray;
import net.bitnine.agensgraph.deps.org.json.simple.JSONObject;

public class StringUtil {
	/** 
	 * @Title		: ifNull 
	 * @Description	: NULL인 경우 ""(빈값)을 리턴한다.
	 * @param @param arg
	 * @param @return
	 * @return String
	 */ 
	public static String ifNull(String arg) {
		if(arg == null) {
			arg = "";
		} else {
			arg.trim();
		}

		return arg;
	}
	
	/** 
	* @Title		: reJsonObj01 
	* @Description	: LMS
	* @param @param arg1	문제정보 리스트 - 문제구분코드(TMS/문제은행), 문제은행문제번호(TMS/문제은행), LMS문제번호, 문항번호, 문항난이도코드
	* @param @return
	* @return JSONObject
	*/
	@SuppressWarnings("unchecked")
	public static JSONObject reJsonObj01(JSONArray arg1) {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("data", arg1);

		return jsonObject;
	}
	
	/** 
	* @Title		: reJsonObj02 
	* @Description	: LMS
	* @param @param arg1	문제정보 리스트 - 문제구분코드(TMS/문제은행), 문제은행문제번호(TMS/문제은행), LMS문제번호, 문항번호, 문항난이도코드
	* @param @param arg2	취약 학습 여부
	* @param @return
	* @return JSONObject
	*/
	@SuppressWarnings("unchecked")
	public static JSONObject reJsonObj02(JSONArray arg1, String arg2) {
		JSONObject jsonObject = new JSONObject();

		JSONArray resultArray = new JSONArray();

		JSONObject resultObj = new JSONObject();
		resultObj.put("QST_INFO", arg1);
		resultObj.put("WEAK_CD", arg2);

		resultArray.add(resultObj);

		jsonObject.put("data", resultArray);

		return jsonObject;
	}	
	
	/** 
	* @Title		: reJsonObj03 
	* @Description	: LMS/SAM
	* @param @param arg1	학습결과 피드백 여부
	* @param @param arg2	재학습실시회수
	* @param @param arg3	진도율
	* @param @param arg4	취약개통 - 취약계통코드, 취약계통명
	* @param @return
	* @return JSONObject
	*/
	@SuppressWarnings("unchecked")
	public static JSONObject reJsonObj03(String arg1, int arg2, int arg3, JSONArray arg4) {
		JSONObject jsonObject = new JSONObject();

		JSONArray resultArray = new JSONArray();

		JSONObject resultObj = new JSONObject();
		resultObj.put("RSTL_FB_YN", arg1);
		resultObj.put("RTT_LSSN_CNT", arg2);
		resultObj.put("PROGRS_RT", arg3);
		resultObj.put("WEAK_LSSN", arg4);

		resultArray.add(resultObj);

		jsonObject.put("data", resultArray);

		return jsonObject;
	}
	
	/** 
	* @Title		: reJsonObj04 
	* @Description	: SAM
	* @param @param arg1	문제은행문제번호
	* @param @param arg2	문항번호
	* @param @param arg3	문항난이도코드
	* @param @return
	* @return JSONObject
	*/
	@SuppressWarnings("unchecked")
	public static JSONObject reJsonObj04(int arg1, int arg2, String arg3) {
		JSONObject jsonObject = new JSONObject();

		JSONArray resultArray = new JSONArray();

		JSONObject resultObj = new JSONObject();
		resultObj.put("QBNUM", arg1);
		resultObj.put("QST_NUM", arg2);
		resultObj.put("QST_LEVEL_CD", arg3);

		resultArray.add(resultObj);

		jsonObject.put("data", resultArray);

		return jsonObject;
	}
}