package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/19 14:29 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Controller
@RequestMapping(value = "/priority")
public class TestPriorityController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String test1(Model view) {
        view.addAttribute("welcome", "其他condition相同，带有method属性的优先级高");
        return "index";
    }

    @RequestMapping()
    @ResponseBody
    public String test2(Model view) {
        view.addAttribute("welcome", "其他condition相同，不带method属性的优先级高");
        return "index";
    }
}
