package org.format.demo.argumentResolver;

import org.apache.commons.lang3.StringUtils;
import org.format.demo.annotation.CustomAnno;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.ServletRequest;
import java.lang.annotation.Annotation;
import java.util.Enumeration;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/24 23:03 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class CustomerArgumentResolver implements HandlerMethodArgumentResolver {


    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CustomAnno.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //获取参数名称
        String alias = getAlias(parameter);
        //创建参数对象
        Object obj = mavContainer.containsAttribute(alias) ? mavContainer.getModel().get(alias) : createAttribute(parameter);
        //获取绑定工厂
        WebDataBinder binder = binderFactory.createBinder(webRequest, obj, alias);
        //待绑定包装对象
        Object target = binder.getTarget();
        if (null != target) {
            //参数设置
            bindParameters(webRequest, binder, alias);
            //参数校验
            validateIfApplicable(binder, parameter);
        }
        return target;
    }

    private void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
        Annotation[] parameterAnnotations = parameter.getParameterAnnotations();
        for (Annotation annotation : parameterAnnotations) {
            if (annotation.annotationType().getSimpleName().startsWith("Valid")) {
                Object hint = AnnotationUtils.getValue(annotation);
                Object[] hints = hint instanceof Object[] ? (Object[]) hint : new Object[]{hint};
                binder.validate(hints);
                break;
            }
        }
    }

    private void bindParameters(NativeWebRequest webRequest, WebDataBinder binder, String alias) {
        ServletRequest servletRequest = webRequest.getNativeRequest(ServletRequest.class);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        Enumeration<String> attributeNames = servletRequest.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            if (attributeName.startsWith(alias)) {
                //参数属性 - class.attName
                mockHttpServletRequest.setAttribute(attributeName.substring(alias.length() + 1), servletRequest.getAttribute(attributeName));
            }
        }
        ((ExtendedServletRequestDataBinder) binder).bind(mockHttpServletRequest);
    }

    private Object createAttribute(MethodParameter parameter) {
        return BeanUtils.instantiateClass(parameter.getParameterType());
    }

    private String getAlias(MethodParameter parameter) {
        String alias = parameter.getParameterName();
        Annotation[] annotations = parameter.getParameterAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof CustomAnno) {
                String name = ((CustomAnno) annotation).name();
                if (StringUtils.isNotBlank(name)) {
                    alias = name;
                }
                break;
            }
        }
        return alias;
    }
}
