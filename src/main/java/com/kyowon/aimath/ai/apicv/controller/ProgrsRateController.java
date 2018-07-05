package com.kyowon.aimath.ai.apicv.controller;

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
import net.bitnine.agensgraph.deps.org.json.simple.JSONObject;

/** 
* <pre>
* com.kyowon.aimath.ai.apicv.controller
*	- ProgrsRateController.java
* </pre>
*
* @ClassName	: ProgrsRateController 
* @Description	: 누적학습 진도율 
* @author 		: TRIPHOS-MOJO
* @date 		: 2018. 6. 11.
* @Version 		: 1.0 
* @Company 		: Copyright ⓒ SK주식회사 C&C. All Right Reserved
*
*/
@RestController
@RequestMapping(value="/v1/apicv/progrs_rate", method=RequestMethod.GET)
@Api(tags={"CV"}, description="")
public class ProgrsRateController {
	private static final Logger logger = LoggerFactory.getLogger(ProgrsRateController.class);

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
	* @Title		: 누적학습 진도율 
	* @Description	: 누적학습 진도율에 따른 피드백
	* @param @param accessToken
	* @param @param studentid	수강생
	* @param @param lssnid		회차 정보
	* @param @param lflowid		학습플로우
	* @param @param actvttypecd	활동코드
	* @param @return
	* @param @throws Exception
	* @return ResponseEntity<Map<String,Object>>
	*/
	@SuppressWarnings("unchecked")
	@ApiOperation(value="누적학습 진도율-CV0120", notes="누적학습 진도율에 따른 피드백")
	@ApiResponses(value={
		@ApiResponse(code=200, message="OK")
		, @ApiResponse(code=204, message="NO_CONTENT")
		, @ApiResponse(code=400, message="BAD_REQUEST")
		, @ApiResponse(code=404, message="NOT_FOUND")
		, @ApiResponse(code=500, message="INTERNAL_SERVER_ERROR")
	})
	@RequestMapping(value="/students/{studentid}/lssn/{lssnid}/lflow/{lflowid}/actvttype/{actvttypecd}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> progrsRate(@ApiParam(value="요청JSON", required=true) @RequestHeader(value="access_token") String accessToken
			, @ApiParam(value="수강생 아이디", required=true) @PathVariable String studentid
			, @ApiParam(value="회차 정보", required=true) @PathVariable String lssnid
			, @ApiParam(value="학습플로우", required=true) @PathVariable String lflowid
			, @ApiParam(value="활동코드", required=true) @PathVariable String actvttypecd) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		logger.info("accessToken:" + accessToken);
		logger.info("studentId:" + studentid);
		logger.info("lssnId:" + lssnid);
		logger.info("lflowId:" + lflowid);
		logger.info("actvttypeCd:" + actvttypecd);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("prgRateYn", "prgRateYn_dt");
		jsonObject.put("prgRateCd", "prgRateCd_dt");
		
		resultMap.put("data", jsonObject);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
}
