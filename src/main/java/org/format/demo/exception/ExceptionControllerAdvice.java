package org.format.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/28 11:49 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Map<String, Object> ajaxError(Throwable error, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", error.getMessage());
        map.put("result", "error");
        return map;
    }

}
