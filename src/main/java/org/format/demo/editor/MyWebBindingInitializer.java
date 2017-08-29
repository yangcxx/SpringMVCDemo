package org.format.demo.editor;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Function: 类型转换器配置方式一：实现接口 WebBindingInitializer
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/29 0:09 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MyWebBindingInitializer implements WebBindingInitializer {
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class,new DateEditor());
    }
}
