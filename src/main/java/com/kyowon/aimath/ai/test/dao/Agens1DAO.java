/**
 * @title	:	Agens1DAO
 * @filename:	Agens1DAO.java
 * @author	:	smlee@bitnine.net
 * @since	:	2018. 7. 11.
 */
package com.kyowon.aimath.ai.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kyowon.aimath.ai.common.AbstractAgens1DAO;

@Repository
public class Agens1DAO extends AbstractAgens1DAO{

	//Oracle DAO 접근하여 데이터 읽기 (Agens1)
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> matchClauseList() throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("unitId", "TTT");
        List<Map<String, Object>> result = selectList("test.matchListTest", param);
        System.out.println("========== matchClauseList result Begin ==========");
        System.out.println(result);
        System.out.println("========== matchClauseList result End ==========");
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public Map<String, Object> matchClauseOne() throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("kuId", "200");
        Map<String, Object> result = (Map<String, Object>) selectOne("test.matchOneTest", param);
        System.out.println("========== matchClauseList result Begin ==========");
        System.out.println(result);
        System.out.println("========== matchClauseList result End ==========");
        return result;
    }
    
//    @SuppressWarnings("unchecked")
//	public int agetlClause() throws Exception {
//        Map<String, Object> param = new HashMap<String, Object>();
//        
//        param.put("unitId", "GGG");
//        int result2 = update("test.setTest2", param);
//        System.out.println("========== setClause result Begin ==========");
//        /* Mybatis는 Update쿼리 수행시 Update된 행의 개수를 리턴하지만 Cypher구문에서는 수정여부와 상관없이 항상 0을 리턴 */
//        System.out.println(result2);
//        System.out.println("========== setClause result End ==========");
//        return result2;
//    }
}
