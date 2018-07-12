/**
 * @title	:	title
 * @filename:	AbstractAgens1DAO.java
 * @author	:	smlee@bitnine.net
 * @since	:	2018. 7. 12.
 */
package com.kyowon.aimath.ai.common;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kyowon.aimath.ai.test.controller.TestController;

public class AbstractAgens1DAO {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource(name="dsTwoSqlSessionTemplate")
    private SqlSessionTemplate dsTwoSqlSessionFactory;

    protected void printQueryId(String queryId) {
        if (logger.isDebugEnabled()) {
            logger.debug("\t QueryId  \t:  " + queryId);
        }
    }

    public Object selectOne(String queryId) {
        printQueryId(queryId);
        return dsTwoSqlSessionFactory.selectOne(queryId);
    }

    public Object selectOne(String queryId, Object params) {
        printQueryId(queryId);
        return dsTwoSqlSessionFactory.selectOne(queryId, params);
    }

    @SuppressWarnings("rawtypes")
    public List selectList(String queryId) {
        printQueryId(queryId);
        return dsTwoSqlSessionFactory.selectList(queryId);
    }

    @SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params) {
        printQueryId(queryId);
        return dsTwoSqlSessionFactory.selectList(queryId, params);
    }
}
