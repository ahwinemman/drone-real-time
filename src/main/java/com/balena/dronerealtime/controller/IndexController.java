package com.balena.dronerealtime.controller;

import com.google.common.net.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String goHome(HttpServletResponse response) {
        response.setHeader(HttpHeaders.CACHE_CONTROL,
                "no-cache, no-store, max-age=0, must-revalidate");
        return "index.html";
    }

}
