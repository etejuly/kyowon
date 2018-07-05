package com.kyowon.aimath.ai.common;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyowon.aimath.ai.util.CommonUtil;
import com.kyowon.aimath.ai.util.StringUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class TokenCheckInterceptor extends HandlerInterceptorAdapter {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	boolean returnVal = false;
    	String accessToken = StringUtil.ifNull(request.getHeader("access_token"));
		logger.info("==access_token=========================" + accessToken);
		
		// ExpiredJwtException : accessToken의 유효기간이 만료된 경우
		if(!"".equals(accessToken)) {
			String authUserKey = "", requestToken = "";
			try {
				Calendar cal = Calendar.getInstance();
				int strHour  = cal.get(Calendar.HOUR_OF_DAY);
				int strMins  = cal.get(Calendar.MINUTE);
				strHour = 0;
				
				Map<String, Object> payloadMap = new HashMap<>();
    			ObjectMapper om = new ObjectMapper();
    			String enTokenPayload = accessToken.split("\\.")[1]; // accessToken의 바디 부분을 추린다. 
    			String deTokenPayload = new String(new Base64(true).decode(enTokenPayload)); // accessToken의 바디를 디코딩한다.
    			payloadMap = om.readValue(deTokenPayload, new TypeReference<Map<String, Object>>(){}); // accessToken의 값을 Map으로 객체화 시킨다.
    			authUserKey  = StringUtil.ifNull((String)payloadMap.get("authUserKey"));
    			requestToken = StringUtil.ifNull((String)payloadMap.get("requestToken"));
    			logger.info("==authUserKey=========================" + authUserKey);
    			logger.info("==requestToken=========================" + requestToken);
    			logger.info("==getDateToken(0)=========================" + CommonUtil.getDateToken(0));
    			logger.info("==getDateToken(-1)=========================" + CommonUtil.getDateToken(-1));
    			logger.info("==getDateToken(0)=========================" + ( requestToken.equalsIgnoreCase(CommonUtil.getDateToken(0)) ));
    			logger.info("==getDateToken(-1)=========================" + ( strHour == 0 && strMins < 31 && requestToken.equalsIgnoreCase(CommonUtil.getDateToken(-1)) ));
    			
	    		if( ( requestToken.equalsIgnoreCase(CommonUtil.getDateToken(0)) )
	    				|| ( strHour == 0 && strMins < 31 && requestToken.equalsIgnoreCase(CommonUtil.getDateToken(-1)) ) ) {
	    			@SuppressWarnings("unused")
					Jws<Claims> claims = Jwts.parser()
	        		  .setSigningKey(CommonUtil.JWT_SIGNKEY.getBytes("UTF-8"))
	        		  .parseClaimsJws(accessToken);
	    			
	    			returnVal = true;
	    		} else {
	    			// requestToken 상이할 경우 접급권한을 불허 한다.
	    			logger.info(requestToken + " != " + CommonUtil.getDateToken(0));
	    			returnVal = false;
	    		}
			} catch (ExpiredJwtException e) {	
				// accessToken의 유효기간이 만료된 경우
				logger.info("TokenCheckInterceptor 유효기간 만료:" + e.getMessage());
				accessToken = CommonUtil.getAuthToken(authUserKey);
				response.setHeader("access_token", accessToken); // 새로운 accessToken을 응답헤더 기록한다.
			} catch(Exception e) {
				logger.info("TokenCheckInterceptor Exception:" + e.getMessage());
            }
		} 
		
		if(!returnVal) {
    		response.setStatus(401); // 접근권한 없음
    	} 
		
		return returnVal;
	}
}