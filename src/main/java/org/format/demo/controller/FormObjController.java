package org.format.demo.controller;

import org.format.demo.annotation.FormObj;
import org.format.demo.model.Dept;
import org.format.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/24 19:07 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Controller
@RequestMapping(value = "/foc")
public class FormObjController {

    @RequestMapping("/test1")
    public String test1(Dept dept, Employee emp, Model model) {
        System.out.println(dept + " : " + emp);
        model.addAttribute("welcome", "welcome");
        model.addAttribute("dept", dept);
        model.addAttribute("emp", emp);
        return "index";
    }

    @RequestMapping("/test2")
    public String test2(@FormObj("d") Dept dept, @FormObj("e") Employee emp, Model model) {
        model.addAttribute("dept", dept);
        model.addAttribute("emp", emp);
        model.addAttribute("welcome", "welcome");
        return "index";
    }

    @RequestMapping("/test3")
    public String test3(@FormObj(value = "d", show = false) Dept dept, @FormObj("e") Employee emp, Model model) {
        model.addAttribute("dept", dept);
        model.addAttribute("emp", emp);
        model.addAttribute("welcome", "welcome");
        return "index";
    }

}
