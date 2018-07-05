package com.kyowon.aimath.ai.test.service;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kyowon.aimath.ai.test.dao.TestDAO;

@Service
public class TestService implements TestServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    @Autowired
    TestDAO testDao;

    @Override
    public List<Map<String, Object>> matchClauseList() throws Exception {
        logger.info("==================== TestService > matchList");

        List<Map<String, Object>> list = testDao.matchClauseList();

        return list;
    }

    @Override
    public Map<String, Object> matchClauseOne() throws Exception {
        logger.info("==================== TestService > matchOne()");

        Map<String, Object> map = testDao.matchClauseOne();

        return map;

    }

    @Override
    public void createClause() throws Exception {
        logger.info("==================== TestService > create()");

        testDao.createClause();

    }

    @Override
    public int setClause() throws Exception {
        logger.info("==================== TestService > set");

        return testDao.setClause();

    }

    @Override
    public void mergeClause() throws Exception {
        logger.info("==================== TestService > merge)");

        testDao.mergeClause();

    }

    @Override
    public void deleteClause() throws Exception {
        logger.info("==================== TestService > delete");

        testDao.deleteClause();

    }
}
