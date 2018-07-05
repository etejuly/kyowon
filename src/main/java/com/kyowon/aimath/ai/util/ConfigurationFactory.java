package com.kyowon.aimath.ai.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationFactory {
	private static final Logger logger = LoggerFactory.getLogger(ConfigurationFactory.class);
	private static ConfigurationFactory instance = null;
	private PropertiesConfiguration globalsConfig = null;

	/** 
	* @Title		: getInstance 
	* @Description	: 환경설정 Factory 인스턴스를 반환한다
	* @param @return
	* @return ConfigurationFactory
	*/ 
	public static ConfigurationFactory getInstance() {
		if(instance == null) {
			synchronized(ConfigurationFactory.class) {
				instance = new ConfigurationFactory();
				PropertiesConfiguration p1 = null;	
				try {
					logger.info("serverType:"+ System.getProperty("serverType"));
					p1 = new PropertiesConfiguration("props/" + System.getProperty("serverType") + ".properties");
					p1.setReloadingStrategy(new FileChangedReloadingStrategy());
					instance.setGlobalsConfig(p1);
				}catch(ConfigurationException e){
					logger.error(e.getMessage());
				}
			}
		}
		
		return instance;
	}
	
	/** 
	* @Title		: setGlobalsConfig 
	* @Description	: globals.properties의 참조를 셋팅한다
	* @param @param globalsConfig
	* @return void
	*/ 
	private void setGlobalsConfig(PropertiesConfiguration globalsConfig) {
		this.globalsConfig = globalsConfig;
	}
	
	/** 
	* @Title		: getGlobalsConfig 
	* @Description	: globals.properties의 참조를 리턴한다
	* @param @return
	* @return Configuration
	*/ 
	public Configuration getGlobalsConfig() {
		return this.globalsConfig;
	}
}
