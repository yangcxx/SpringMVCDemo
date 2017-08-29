package org.format.demo.aop;

import org.format.demo.editor.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * Function: 类型转换器配置方式三：@ControllerAdvice 注解方法
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/29 15:00 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@ControllerAdvice
public class InitBinderControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,new DateEditor());
    }

}
