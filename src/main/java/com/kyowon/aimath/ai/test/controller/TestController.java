package com.kyowon.aimath.ai.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kyowon.aimath.ai.test.service.TestServiceImpl;
import io.swagger.annotations.Api;
import net.bitnine.agensgraph.graph.Vertex;

@RestController
@Api(tags = {"TEST"}, description = "테스트용 Api입니다.")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestServiceImpl testService;

    @ExceptionHandler(Exception.class)
    public String handlerException(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return null;
    }

    /**
     *
     * @param locale
     * @param model
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat =
                DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "/main";
    }

    /**
     *
     * @param locale
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/matchList", method = RequestMethod.GET)
    public String matchClauseList(Locale locale, Model model) throws Exception {
        logger.info("==================== TestController > /matchList");
        List<Map<String, Object>> list = testService.matchClauseList();
        return ((Vertex) list.get(0).get("ku")).toString();
    }

    @RequestMapping(value = "/matchOne", method = RequestMethod.GET)
    public String matchClauseOne(Locale locale, Model model) throws Exception {
        logger.info("==================== TestController > /matchOne");
        Map<String, Object> list = testService.matchClauseOne();
        return ((Vertex) list.get("ku")).toString();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createClause(Locale locale, Model model) throws Exception {
        logger.info("==================== TestController > /create");
        testService.createClause();
        return null;
    }

    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public int setClause(Locale locale, Model model) throws Exception {
        logger.info("==================== TestController > /set");
        return testService.setClause();
        
    }

    @RequestMapping(value = "/merge", method = RequestMethod.GET)
    public String mergeClause(Locale locale, Model model) throws Exception {
        logger.info("==================== TestController > /merge");
        testService.mergeClause();
        return null;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteClause(Locale locale, Model model) throws Exception {
        logger.info("==================== TestController > /delete");
        testService.deleteClause();
        return null;
    }
    
    @RequestMapping(value = "/agetl", method = RequestMethod.GET)
    public String agetlClause(Locale locale, Model model) throws Exception {
        logger.info("==================== TestController > /test");
        testService.agetlClause();
        return null;
    }
}
