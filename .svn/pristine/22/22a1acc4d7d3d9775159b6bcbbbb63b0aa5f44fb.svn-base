package com.kyowon.aimath.ai.util;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.configuration.Configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.bitnine.agensgraph.deps.org.json.simple.parser.ParseException;

/** 
* <pre>
* com.kyowon.aimath.ai.util
*	- CommonUtil.java
* </pre>
*
* @ClassName	: CommonUtil 
* @Description	: 공통유틸 
* @author 		: TR-ROOT
* @date 		: 2018. 6. 11.
* @Version 		: 1.0 
* @Company 		: Copyright ⓒ SK주식회사 C&C. All Right Reserved
*
*/ 
public class CommonUtil {
	/** globals.properties의 Configuration객체 */
	private static Configuration globalsConfig = ConfigurationFactory.getInstance().getGlobalsConfig();
	/** jwt signkey */
	public static final String JWT_SIGNKEY = globalsConfig.getString("Globals.jwt.signkey", "");
	/** access_token 만료시간 (분 단위) */
	private static int expirationTime = 30;
	
	/** 
	* @Title		: getDateToken 
	* @Description	: 날짜로 만든 토큰 키
	* @param @return
	* @return int
	*/ 
	public static String getDateToken(int add) {
		Calendar cal = Calendar.getInstance();
		if(add < 0) {
			cal.add(Calendar.DATE, add);
		}
		
		int strYear  = cal.get(Calendar.YEAR);
		int strMonth = cal.get(Calendar.MONTH) + 1;
		int strDate  = cal.get(Calendar.DATE);
		
		int dateKey	 = ((strYear + strDate)  + (strMonth * strDate)  + ((strMonth * strDate) - strYear));
		
		return Integer.toString(dateKey);
	}
	
	/** 
	* @Title		: getAuthToken 
	* @Description	: 토큰 발급
	* @param @param body
	* @param @return
	* @param @throws UnsupportedEncodingException
	* @param @throws ParseException
	* @return String
	*/ 
	public static String getAuthToken(String authUserKey) throws UnsupportedEncodingException, ParseException {
		String accessToken = Jwts.builder()
		  .setExpiration(new Date(System.currentTimeMillis() + ( (1000*60) * expirationTime) ))
		  .claim("authUserKey", authUserKey)
		  .claim("requestToken", getDateToken(0))
		  .signWith(SignatureAlgorithm.HS512, JWT_SIGNKEY.getBytes("UTF-8"))
		  .compact();
		
		return accessToken;
	}
}