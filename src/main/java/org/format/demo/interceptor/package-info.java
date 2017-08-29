/**
 * Function: 拦截器定义及配置
 * Reason:
 *  定义：CustomInterceptor extends HandlerInterceptorAdapter
 *  配置：
 *      1、*-dispatcher.xml配置文件中添加 <mvc:interceptors>配置 cxy 建议使用此配置 - 被解析为 MappedInterceptor.java
 *      2、配置 RequestMappingHandlerMapping ，并配置属性 interceptors
 * Date: 2017/8/29 15:16 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
package org.format.demo.interceptor;