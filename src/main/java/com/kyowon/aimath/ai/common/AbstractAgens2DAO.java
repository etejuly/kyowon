/**
 * @title	:	title
 * @filename:	AbstractAgens2DAO.java
 * @author	:	smlee@bitnine.net
 * @since	:	2018. 7. 12.
 */
package com.kyowon.aimath.ai.common;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kyowon.aimath.ai.test.controller.TestController;

public class AbstractAgens2DAO {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Resource(name="dsOneSqlSessionTemplate")
    private SqlSessionTemplate dsOneSqlSessionFactory;
	
	protected void printQueryId(String queryId) {
        if (logger.isDebugEnabled()) {
            logger.debug("\t QueryId  \t:  " + queryId);
        }
    }
	
	public int update(String queryId, Object params) {
        printQueryId(queryId);
        return dsOneSqlSessionFactory.update(queryId, params);
    }
    
}
