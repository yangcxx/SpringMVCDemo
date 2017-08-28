package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/25 18:58 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(value = {"/", ""})
    public String index() {
        return "login";
    }

    @RequestMapping("/auth")
    public String auth(@RequestParam String username, HttpServletRequest req) {
        req.getSession().setAttribute("loginUser", username);
        return "redirect:/index";
    }

    @RequestMapping("/out")
    public String out(HttpServletRequest req) {
        req.getSession().removeAttribute("loginUser");
        return "redirect:/login";
    }

}
