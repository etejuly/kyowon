package com.kyowon.aimath.ai.apilm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/** 
* <pre>
* com.kyowon.aimath.ai.apilm.controller
*	- LssnAchvInfoController.java
* </pre>
*
* @ClassName	: LssnAchvInfoController 
* @Description	: 개인 학습 성취도 분석 정보 요청  
* @author 		: TR-ROOT
* @date 		: 2018. 6. 11.
* @Version 		: 1.0 
* @Company 		: Copyright ⓒ SK주식회사 C&C. All Right Reserved
*
*/ 
@RestController
@RequestMapping(value="/v1/apilm/lssn_achv_info", method=RequestMethod.GET)
@Api(tags={"LMS"}, description="")
public class LssnAchvInfoController {
	private static final Logger logger = LoggerFactory.getLogger(LssnAchvInfoController.class);

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
	
	/** 
	* @Title		: 개인 학습 성취도 분석 정보 요청 
	* @Description	: 개인학습 성향 분석 (학습결과 피드백, 재학습실시, 진도율, 취약 계통)
	* @param @param accessToken
	* @param @param studentId 	수강생
	* @param @param lssnId 		회차
	* @param @param activityId 	활동
	* @param @return
	* @param @throws Exception
	* @return ResponseEntity<Map<String,Object>>
	*/ 
	@ApiOperation(value="개인 학습 성취도 분석 정보 요청-LM0110", notes="개인학습 성향 분석 (학습결과 피드백, 재학습실시, 진도율, 취약 계통)")
	@ApiResponses(value={
		@ApiResponse(code=200, message="OK")
		, @ApiResponse(code=204, message="NO_CONTENT")
		, @ApiResponse(code=400, message="BAD_REQUEST")
		, @ApiResponse(code=404, message="NOT_FOUND")
		, @ApiResponse(code=500, message="INTERNAL_SERVER_ERROR")
	})
	@RequestMapping(value="/students/{studentid}/lssn/{lssnid}/activity/{activityid}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> lssnAchvInfo(@ApiParam(value="요청JSON", required=true) @RequestHeader(value="access_token") String accessToken
			, @ApiParam(value="수강생 아이디", required=true) @PathVariable String studentid
			, @ApiParam(value="회차 정보", required=true) @PathVariable String lssnid
			, @ApiParam(value="활동코드", required=true) @PathVariable String activityid) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		logger.info("accessToken:" + accessToken);
		logger.info("studentId:" + studentid);
		logger.info("lssnId:" + lssnid);
		logger.info("activityId:" + activityid);
		
		resultMap.put("resultData", accessToken);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
}
