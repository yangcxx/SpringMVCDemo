package org.format.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Function: 自定义参数解析注解
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/24 23:00 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnno {

    String name() default "";

    boolean required() default false;

}
