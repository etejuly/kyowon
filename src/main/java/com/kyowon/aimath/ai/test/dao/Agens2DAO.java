/**
 * @title	:	title
 * @filename:	Agens2DAO.java
 * @author	:	smlee@bitnine.net
 * @since	:	2018. 7. 11.
 */
package com.kyowon.aimath.ai.test.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kyowon.aimath.ai.common.AbstractAgens2DAO;

@Repository
public class Agens2DAO extends AbstractAgens2DAO{

	//AgensGraph DAO 접근하여 데이터 넣기 (Agens2)
    @SuppressWarnings("unchecked")
	public int agetlClause(String ku_id, String ku_nm) throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        
        param.put("kuId", ku_id);
        param.put("kuNm", ku_nm);
        int result2 = update("test.setTest2", param);
        System.out.println("========== setClause result Begin ==========");
        /* Mybatis는 Update쿼리 수행시 Update된 행의 개수를 리턴하지만 Cypher구문에서는 수정여부와 상관없이 항상 0을 리턴 */
        System.out.println(result2);
        System.out.println("========== setClause result End ==========");
        return result2;
    }
}
