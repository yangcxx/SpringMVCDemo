package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/26 13:49 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
@Controller
@RequestMapping(value = "/tvrc")
public class TestViewResolverController {

    @RequestMapping("jsp")
    public ModelAndView jsp(ModelAndView view) {
        view.setViewName("jsp:trvc/index");
        return view;
    }

    @RequestMapping("/ftl")
    public ModelAndView freemarker(ModelAndView view) {
        view.setViewName("freemarker:trvc/index");
        return view;
    }

}
