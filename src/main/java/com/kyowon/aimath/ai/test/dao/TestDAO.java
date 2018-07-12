package com.kyowon.aimath.ai.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.kyowon.aimath.ai.common.AbstractDAO;

import net.bitnine.agensgraph.graph.Vertex;

@Repository
public class TestDAO extends AbstractDAO {

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
        param.put("lssnId", "A006");
        Map<String, Object> result = (Map<String, Object>) selectOne("test.matchOneTest", param);
        System.out.println("========== matchClauseList result Begin ==========");
        System.out.println(result);
        System.out.println("========== matchClauseList result End ==========");
        return result;
    }

    public void createClause() throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("unitId", "TTT");
        Object result = update("test.createTest2", param);
        System.out.println("========== createClause result Begin ==========");
        /* Mybatis는 Insert쿼리 수행시 Insert가 성공하였으면 1을 아니라면 0을 리턴하지 Cypher구문에서는 생성여부와 상관없이 항상 0을 리턴 */
        System.out.println(result);
        System.out.println("========== createClause result End ==========");

        /*
         * int result = (Integer) selectOne("test.createTest", param); createTest쿼리와 같이
         * Mybatis의<select>를 통하여 Create Cypher구문을 실행하고 count리턴값으로 데이터의 입력 된 오브젝트의 개수를 리턴하여 판단은 가능하나
         * Agens-Mybatis 연동가이드 또는 정책에 맞는 기준 요청
         */
    }

    @SuppressWarnings("unchecked")
    public void mergeClause() throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("unitId", "TTT");
        List<Map<String, Object>> result = selectList("test.mergeTest", param);
        System.out.println("========== mergeClause result Begin ==========");
        System.out.println(result);
        System.out.println("========== mergeClause result End ==========");

        /*
         * Merge는 경우에따라 Match가 될 수도 Create가 될 수도 있는 관계로 Agens-Mybatis 연동가이드 또는 정책에 맞는 기준 요청
         */
    }

    @SuppressWarnings("unchecked")
	public int setClause() throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("lssnId", "A006");
        Map<String, Object> result = (Map<String, Object>) selectOne("test.matchOneTest", param);
        System.out.println("result"+result);
        System.out.println("result"+result.get("ku"));
        Vertex ku = (Vertex) result.get("ku");
        String lssn_id = ku.getString("lssn_id");
        param.put("unitId", lssn_id);
        int result2 = update("test.setTest2", param);
        System.out.println("========== setClause result Begin ==========");
        System.out.println(result2);
        System.out.println("========== setClause result End ==========");
        return result2;

    }

    public void deleteClause() throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("unitId", "TTT");
        Object result = delete("test.deleteTest2", param);
        System.out.println("========== deleteClause result Begin ==========");
        /* Mybatis는 Delete쿼리 수행시 Delete된 행의 개수를 리턴하지만 Cypher구문에서는 삭제여부와 상관없이 항상 0을 리턴 */
        System.out.println(result);
        System.out.println("========== deleteClause result End ==========");

        /*
         * int result = (Integer) selectOne("test.deleteTest", param); deleteTest쿼리와 같이
         * Mybatis의<select>를 통하여 Match-Delete Cypher구문을 실행하고 count리턴값으로 데이터의 삭제 된 오브젝트의 개수를 리턴하여 판단은
         * 가능하나 Agens-Mybatis 연동가이드 또는 정책에 맞는 기준 요청
         */
    }
}
