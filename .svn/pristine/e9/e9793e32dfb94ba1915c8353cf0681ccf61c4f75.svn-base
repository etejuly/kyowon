package com.kyowon.aimath.ai.access;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kyowon.aimath.ai.util.CommonUtil;
import com.kyowon.aimath.ai.util.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.bitnine.agensgraph.deps.org.json.simple.JSONObject;
import net.bitnine.agensgraph.deps.org.json.simple.parser.JSONParser;

@RestController
@Api(tags={"ACCESS"}, description="접속토큰 발급용 Api입니다.")
public class AccessController {
	private static final Logger logger = LoggerFactory.getLogger(AccessController.class);
	
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
	
	@ApiOperation(value="토큰 발급", notes="accessToken 발행 시 사용하는 api 입니다.")
	@ApiResponses(value={
		@ApiResponse(code=200, message="OK")
		, @ApiResponse(code=204, message="NO_CONTENT")
		, @ApiResponse(code=400, message="BAD_REQUEST")
		, @ApiResponse(code=404, message="NOT_FOUND")
		, @ApiResponse(code=500, message="INTERNAL_SERVER_ERROR")
	})
	@RequestMapping(value="/authToken", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> authToken(@ApiParam(value="요청JSON", required=true) @RequestBody String body) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		JSONParser parser = new JSONParser();
		JSONObject reqObj = new JSONObject();
		reqObj = (JSONObject)parser.parse(body);
		String authUserKey = StringUtil.ifNull((String)reqObj.get("authUserKey")); 
		
		String accessToken = CommonUtil.getAuthToken(authUserKey);
		logger.info("accessToken:" + accessToken);
		
    	resultMap.put("accessToken", accessToken);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
}