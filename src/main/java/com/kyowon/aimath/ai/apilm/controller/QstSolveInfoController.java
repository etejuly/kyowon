package com.kyowon.aimath.ai.apilm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kyowon.aimath.ai.util.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.bitnine.agensgraph.deps.org.json.simple.JSONArray;
import net.bitnine.agensgraph.deps.org.json.simple.JSONObject;
import net.bitnine.agensgraph.deps.org.json.simple.parser.JSONParser;

@RestController
@RequestMapping(value="/v1/apilm/qstSolveInfo", method=RequestMethod.POST)
@Api(tags={"LMS"}, description="")
public class QstSolveInfoController {
	private static final Logger logger = LoggerFactory.getLogger(QstSolveInfoController.class);

	/** 
	* @Title		: handlerException 
	* @Description	: Exception발생시 AnnotationMethodHandlerExceptionResolver에 의해 호출되는 메서드
	* @param @param response
	* @param @return
	* @return String
	*/
	@ExceptionHandler(Exception.class)
	public String handlerException(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return null;
	}
	
	@ApiOperation(value="문항풀이 정보 제공-LM0010", notes="문항풀이 정보를 저장합니다.")
	@ApiResponses(value={
		@ApiResponse(code=200, message="OK")
		, @ApiResponse(code=204, message="NO_CONTENT")
		, @ApiResponse(code=400, message="BAD_REQUEST")
		, @ApiResponse(code=404, message="NOT_FOUND")
		, @ApiResponse(code=500, message="INTERNAL_SERVER_ERROR")
	})
	@RequestMapping(value="/students/{studentid}/lssn/{lssnid}/activity/{activityid}", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> authToken(
			@ApiParam(value="요청JSON", required=true) @RequestHeader(value="access_token") String accessToken, 
			@ApiParam(value="요청JSON", required=true) @RequestBody String body) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		JSONParser parser = new JSONParser();
		JSONObject reqObj = new JSONObject();
		JSONArray  arrObj = new JSONArray();
		reqObj = (JSONObject)parser.parse(body);
		arrObj = (JSONArray)reqObj.get("QST_INFO"); // 문항 정보
		logger.info("reqObj:"+reqObj);
		logger.info("문항정보:"+arrObj.size());
		
		for(int i = 0 ; i < arrObj.size() ; i++) {
			JSONObject qstObj 	= (JSONObject)arrObj.get(i);
			String qst_num		= StringUtil.ifNull((String)qstObj.get("QST_NUM")); 		// 문항번호	
			String qb_num		= StringUtil.ifNull((String)qstObj.get("QB_NUM")); 			// 문제은행문제번호	
			String qst_level_cd = StringUtil.ifNull((String)qstObj.get("QST_LEVEL_CD")); 	// 문항난이도코드	
			String take_time	= StringUtil.ifNull((String)qstObj.get("TAKE_TIME")); 		// 소요시간	
			String strt_time	= StringUtil.ifNull((String)qstObj.get("STRT_TIME")); 		// 시작시간	
			String end_time	 	= StringUtil.ifNull((String)qstObj.get("END_TIME")); 		// 종료시간	
			String answ		 	= StringUtil.ifNull((String)qstObj.get("ANSW")); 			// 답변	
			String crrct		= StringUtil.ifNull((String)qstObj.get("CRRCT")); 			// 정답	
			String crrct_yn	 	= StringUtil.ifNull((String)qstObj.get("CRRCT_YN")); 		// 정답여부
			logger.info("qst_num:"+qst_num);
			logger.info("qb_num:"+qb_num);
			logger.info("qst_level_cd:"+qst_level_cd);
			logger.info("take_time:"+take_time);
			logger.info("strt_time:"+strt_time);
			logger.info("end_time:"+end_time);
			logger.info("answ:"+answ);
			logger.info("crrct:"+crrct);
			logger.info("crrct_yn:"+crrct_yn);
		}

		logger.info("상세정보★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		String student_id		= StringUtil.ifNull((String)reqObj.get("STUDENT_ID")); 			// 수강생ID			
		String actvt_id			= StringUtil.ifNull((String)reqObj.get("ACTVT_ID"));            // 활동ID
		String actvt_nm			= StringUtil.ifNull((String)reqObj.get("ACTVT_NM"));            // 활동명
		String actvt_clsf_cd	= StringUtil.ifNull((String)reqObj.get("ACTVT_CLSF_CD"));       // 활동구분코드
		String actvt_type_cd	= StringUtil.ifNull((String)reqObj.get("ACTVT_TYPE_CD"));       // 유형코드
		String unit_id			= StringUtil.ifNull((String)reqObj.get("UNIT_ID"));             // 단원코드
		String unit_nm			= StringUtil.ifNull((String)reqObj.get("UNIT_NM"));             // 단원명
		String lssn_cd			= StringUtil.ifNull((String)reqObj.get("LSSN_CD"));             // 회차코드
		String lssn_nm			= StringUtil.ifNull((String)reqObj.get("LSSN_NM"));             // 회차명
		String stdy_gole		= StringUtil.ifNull((String)reqObj.get("STDY_GOLE"));           // 학습목표
		String rstl_fb_yn		= StringUtil.ifNull((String)reqObj.get("RSTL_FB_YN"));          // 학습결과 피드백 여부
		String rtt_lssn_cnt		= StringUtil.ifNull((String)reqObj.get("RTT_LSSN_CNT"));        // 재학습실시회수
		String progrs_rt		= StringUtil.ifNull((String)reqObj.get("PROGRS_RT"));           // 진도율
		String lssn_id			= StringUtil.ifNull((String)reqObj.get("LSSN_ID"));             // 차시ID
		String dst			 	= StringUtil.ifNull((String)reqObj.get("DST"));                 // 일일학습량
		String taketime			= StringUtil.ifNull((String)reqObj.get("TAKETIME"));            // 소요시간
		String stdy_strtdt		= StringUtil.ifNull((String)reqObj.get("STDY_STRTDT"));         // 학습시작일시
		String stdy_enddt		= StringUtil.ifNull((String)reqObj.get("STDY_ENDDT"));          // 학습종료일시
		String stdy_time		= StringUtil.ifNull((String)reqObj.get("STDY_TIME"));           // 학습시간
		String lmdt			 	= StringUtil.ifNull((String)reqObj.get("LMDT"));                // 최종수정일시
		String lmusrid			= StringUtil.ifNull((String)reqObj.get("LMUSRID"));             // 최종수정자ID
		String qst_cnt			= StringUtil.ifNull((String)reqObj.get("QST_CNT"));             // 문항수
		String crrct_cnt		= StringUtil.ifNull((String)reqObj.get("CRRCT_CNT"));           // 정답수
		String crrct_rt			= StringUtil.ifNull((String)reqObj.get("CRRCT_RT"));            // 정답률
		String repeat_cd		= StringUtil.ifNull((String)reqObj.get("REPEAT_CD"));           // 반복 학습 여부
		String weak_cd			= StringUtil.ifNull((String)reqObj.get("WEAK_CD"));             // 취약 학습 여부
		String student_crcm_id	= StringUtil.ifNull((String)reqObj.get("STUDENT_CRCM_ID"));     // 수강생커리큘럼ID
		String student_level_cd	= StringUtil.ifNull((String)reqObj.get("STUDENT_LEVEL_CD"));    // 학생수준코드 
		String pass_yn			= StringUtil.ifNull((String)reqObj.get("PASS_YN"));             // 통과여부
		
		logger.info("student_id:"+student_id);
		logger.info("actvt_id:"+actvt_id);
		logger.info("actvt_nm:"+actvt_nm);
		logger.info("actvt_clsf_cd:"+actvt_clsf_cd);
		logger.info("actvt_type_cd:"+actvt_type_cd);
		logger.info("unit_id:"+unit_id);
		logger.info("unit_nm:"+unit_nm);
		logger.info("lssn_cd:"+lssn_cd);
		logger.info("lssn_nm:"+lssn_nm);
		logger.info("stdy_gole:"+stdy_gole);
		logger.info("rstl_fb_yn:"+rstl_fb_yn);
		logger.info("rtt_lssn_cnt:"+rtt_lssn_cnt);
		logger.info("progrs_rt:"+progrs_rt);
		logger.info("lssn_id:"+lssn_id);
		logger.info("dst:"+dst);
		logger.info("taketime:"+taketime);
		logger.info("stdy_strtdt:"+stdy_strtdt);
		logger.info("stdy_enddt:"+stdy_enddt);
		logger.info("stdy_time:"+stdy_time);
		logger.info("lmdt:"+lmdt);
		logger.info("lmusrid:"+lmusrid);
		logger.info("qst_cnt:"+qst_cnt);
		logger.info("crrct_cnt:"+crrct_cnt);
		logger.info("crrct_rt:"+crrct_rt);
		logger.info("repeat_cd:"+repeat_cd);
		logger.info("weak_cd:"+weak_cd);
		logger.info("student_crcm_id:"+student_crcm_id);
		logger.info("student_level_cd:"+student_level_cd);
		logger.info("pass_yn:"+pass_yn);
//		logger.info("qst_info:"+qst_info);
		
    	resultMap.put("data", "");
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
}