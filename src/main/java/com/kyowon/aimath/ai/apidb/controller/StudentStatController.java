package com.kyowon.aimath.ai.apidb.controller;

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
* com.kyowon.aimath.ai.apidb.controller
*	- StudentStatController.java
* </pre>
*
* @ClassName	: StudentStatController 
* @Description	: 수강생 정보 조회 
* @author 		: TRIPHOS-MOJO
* @date 		: 2018. 6. 11.
* @Version 		: 1.0 
* @Company 		: Copyright ⓒ SK주식회사 C&C. All Right Reserved
*
*/
@RestController
@RequestMapping(value="/v1/apidb/student_stat", method=RequestMethod.GET)
@Api(tags={"DashBoard"}, description="")
public class StudentStatController {
	private static final Logger logger = LoggerFactory.getLogger(StudentStatController.class);

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
	* @Title		: 수강생 정보 조회 
	* @Description	: 대시보드(화상샘)의 학생 현황 정보
	* @param @param accessToken
	* @param @param techertid	선생님
	* @param @return
	* @param @throws Exception
	* @return ResponseEntity<Map<String,Object>>
	*/
	@ApiOperation(value="수강생 정보 조회-DB0300", notes="대시보드(화상샘)의 학생 현황 정보")
	@ApiResponses(value={
		@ApiResponse(code=200, message="OK")
		, @ApiResponse(code=204, message="NO_CONTENT")
		, @ApiResponse(code=400, message="BAD_REQUEST")
		, @ApiResponse(code=404, message="NOT_FOUND")
		, @ApiResponse(code=500, message="INTERNAL_SERVER_ERROR")
	})
	@RequestMapping(value="/techers/{techertid}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> studentStat(@ApiParam(value="요청JSON", required=true) @RequestHeader(value="access_token") String accessToken
			, @ApiParam(value="선생님 아이디", required=true) @PathVariable String techertid) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		logger.info("accessToken:" + accessToken);
		logger.info("techertId:" + techertid);
		
		resultMap.put("resultData", accessToken);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
}
