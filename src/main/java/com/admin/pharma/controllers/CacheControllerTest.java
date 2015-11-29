package com.admin.pharma.controllers;

import org.apache.log4j.Logger;
        import org.springframework.cache.annotation.Cacheable;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CacheControllerTest {

    private static final Logger log = Logger.getLogger(CacheControllerTest.class);

    @RequestMapping(value = "/cacheTest", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable("calculateResult")
    public String calculateResult() {
        log.debug("Performing expensive calculation...");
        // perform computationally expensive calculation
        return "result";
    }
}