/**
 * Function: 自定义属性编辑器
 * Reason:
 *  实现：
 *      CustomPropertyEditor extends PropertyEditorSupport 并重写方法 setAsText 方法
 *  配置生效：
 *      1、Controller 中添加 @InitBinder 注解方法
 *      2、实现 WebBindingInitializer 接口 - HandlerAdapter 构造 WebDataBinderFactory 的时候，会传递 HandlerAdapter 的属性 webBindingInitializer
 *      3、@ControllerAdvice 注解方法
 * Date: 2017/8/29 14:53 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
package org.format.demo.editor;