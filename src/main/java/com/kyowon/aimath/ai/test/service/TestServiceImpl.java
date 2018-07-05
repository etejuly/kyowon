package com.kyowon.aimath.ai.test.service;

import java.util.List;
import java.util.Map;

public interface TestServiceImpl {
    List<Map<String, Object>> matchClauseList() throws Exception;

    Map<String, Object> matchClauseOne() throws Exception;

    void createClause() throws Exception;

    void mergeClause() throws Exception;

    int setClause() throws Exception;

    void deleteClause() throws Exception;

}
