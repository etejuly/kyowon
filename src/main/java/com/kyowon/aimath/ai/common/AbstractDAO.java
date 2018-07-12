package com.kyowon.aimath.ai.common;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.kyowon.aimath.ai.test.controller.TestController;

public class AbstractDAO {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

//    @Autowired
//    private SqlSessionTemplate sqlSession;
    @Resource(name="dsOneSqlSessionTemplate")
    private SqlSessionTemplate dsOneSqlSessionFactory;
    
    @Resource(name="dsTwoSqlSessionTemplate")
    private SqlSessionTemplate dsTwoSqlSessionFactory;

    protected void printQueryId(String queryId) {
        if (logger.isDebugEnabled()) {
            logger.debug("\t QueryId  \t:  " + queryId);
        }
    }

    public Object insert(String queryId, Object params) {
        printQueryId(queryId);
        return dsOneSqlSessionFactory.insert(queryId, params);
    }

    public int update(String queryId, Object params) {
        printQueryId(queryId);
        return dsOneSqlSessionFactory.update(queryId, params);
    }

    public Object delete(String queryId, Object params) {
        printQueryId(queryId);
        return dsOneSqlSessionFactory.delete(queryId, params);
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
