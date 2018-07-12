package com.kyowon.aimath.ai.test.service;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kyowon.aimath.ai.test.dao.Agens1DAO;
import com.kyowon.aimath.ai.test.dao.Agens2DAO;
import com.kyowon.aimath.ai.test.dao.TestDAO;

import net.bitnine.agensgraph.graph.Vertex;

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
    @Transactional
    public void createClause() throws Exception {
        logger.info("==================== TestService > create()");

        testDao.createClause();
        System.out.println("========== *1* ==========");
        testDao.createClause();
        System.out.println("========== *2* ==========");
        testDao.createClause();
        System.out.println("========== *3* ==========");
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
    

	@Autowired
	Agens1DAO agens1DAO;  
	@Autowired
	Agens2DAO agens2DAO; 
	
    /*
     * 여러 DAO를 호출하여 여러번의 데이터 접근, 갱신을 하여 트랜잭션으로 묶음
     * Oracle DAO 접근하여 데이터 읽기 (Agens1)
     * AgensGraph DAO 접근하여 데이터 넣기 (Agens2)
     */
	
	@Override
	@Transactional
    public void agetlClause() throws Exception {
		
		logger.info("==================== TestService > agetl ");
		Map<String, Object> result1 = agens1DAO.matchClauseOne();
		Vertex ku = (Vertex) result1.get("ku");
		String ku_id = ku.getString("ku_id");
		String ku_nm = ku.getString("ku_nm");
		agens2DAO.agetlClause(ku_id, ku_nm);
		agens2DAO.agetlClause(ku_id, ku_nm);
		
    }
}
