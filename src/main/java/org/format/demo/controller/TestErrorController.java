package org.format.demo.controller;

import org.format.demo.exception.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/27 18:14 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Controller
@RequestMapping(value = "/error")
public class TestErrorController {

    @RequestMapping("/exception")
    public ModelAndView exception(ModelAndView view) throws ClassNotFoundException {
        view.setViewName("error");
        throw new ClassNotFoundException("class not found");
    }

    @RequestMapping("/npe")
    public ModelAndView npe(ModelAndView view) {
        view.setViewName("error");
        String str = null;
        str.length();
        return view;
    }

    /*@ExceptionHandler(RuntimeException.class)
    public ModelAndView error(RuntimeException error, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("param", "Runtime error");
        return mav;
    }

    @ExceptionHandler()
    public ModelAndView error(Exception error, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("param", "Exception error");
        return mav;
    }*/

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView error(ModelAndView mav) {
        mav.setViewName("error");
        mav.addObject("param", "NullPointer error");
        return mav;
    }

    @RequestMapping("/unAuth")
    public ModelAndView unAuth(ModelAndView view) {
        view.setViewName("index");
        throw new UnauthorizedException();
    }

    @RequestMapping("/noHandleMethod")
    public ModelAndView noHandleMethod(ModelAndView view, HttpServletRequest request) throws NoSuchRequestHandlingMethodException {
        view.setViewName("index");
        throw new NoSuchRequestHandlingMethodException(request);
    }

}
