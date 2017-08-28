package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/19 12:26 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Controller
@RequestMapping("wildcard")
public class TestWildcardController {

    @RequestMapping("/test/**")
    public String test1(Model model) {
        model.addAttribute("welcome", "TestWildcardController -> test/**");
        return "index";
    }

    @RequestMapping("/test/*")
    public String test2(Model model) {
        model.addAttribute("welcome", "TestWildcardController -> test/*");
        return "index";
    }

    @RequestMapping("test?")
    public String test3(Model model) {
        model.addAttribute("welcome", "TestWildcardController -> test?");
        return "index";
    }

    @RequestMapping("test*")
    public String test4(Model model) {
        model.addAttribute("welcome", "TestWildcardController -> test*");
        return "index";
    }

}
