package org.format.demo.argumentresolver;

import org.apache.commons.lang3.StringUtils;
import org.format.demo.annotation.FormObj;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.ServletRequest;
import java.lang.annotation.Annotation;
import java.net.BindException;
import java.util.Enumeration;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/24 17:58 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Component
public class FormObjArgumentResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(FormObj.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        FormObj formObj = parameter.getParameterAnnotation(FormObj.class);
        String alias = getAlias(formObj, parameter);

        //拿到Obj 从 ModelAndView 中拿，没有则 new 一个参数类型的实例
        Object obj = (mavContainer.containsAttribute(alias)) ? mavContainer.getModel().get(alias) : createAttribute(parameter);

        //获得 WebDataBinder - ExtendedServletRequestDataBinder
        WebDataBinder binder = binderFactory.createBinder(webRequest, obj, alias);

        Object target = binder.getTarget();
        if (null != target) {
            //绑定参数
            bindParameters(webRequest, binder, alias);
            //JSR303校验
            validateIfApplicable(binder, parameter);
            if (binder.getBindingResult().hasErrors() && isBindExceptionRequired(parameter)) {
                throw new BindException();
            }
        }

        if (formObj.show()) {
            mavContainer.addAttribute(alias, target);
        }
        return target;
    }

    private boolean isBindExceptionRequired(MethodParameter parameter) {
        int index = parameter.getParameterIndex();
        Class<?>[] parameterTypes = parameter.getMethod().getParameterTypes();
        boolean hasBindingResult = parameterTypes.length > (index + 1) && Errors.class.isAssignableFrom(parameterTypes[index + 1]);
        return !hasBindingResult;
    }

    /**
     * JSR303校验
     *
     * @param binder
     * @param parameter
     */
    private void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
        Annotation[] annotations = parameter.getParameterAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().getSimpleName().startsWith("Valid")) {
                Object hints = AnnotationUtils.getValue(annotation);
                Object[] validateHints = (hints instanceof Object[]) ? (Object[]) hints : new Object[]{hints};
                binder.validate(validateHints);
                break;
            }
        }
    }

    private Object createAttribute(MethodParameter parameter) {
        return BeanUtils.instantiateClass(parameter.getParameterType());
    }

    /**
     * 参数绑定
     *
     * @param request
     * @param binder
     * @param alias
     */
    private void bindParameters(NativeWebRequest request, WebDataBinder binder, String alias) {
        ServletRequest servletRequest = request.getNativeRequest(ServletRequest.class);

        MockHttpServletRequest newRequest = new MockHttpServletRequest();

        Enumeration<String> enu = servletRequest.getParameterNames();
        while (enu.hasMoreElements()) {
            String paramName = enu.nextElement();
            if (paramName.startsWith(alias)) {
                newRequest.setParameter(paramName.substring(alias.length() + 1), servletRequest.getParameter(paramName));
            }
        }
        ((ExtendedServletRequestDataBinder) binder).bind(newRequest);

    }

    private String getAlias(FormObj formObj, MethodParameter methodParameter) {
        //value属性-别名
        String alias = formObj.value();
        if (StringUtils.isBlank(alias)) {
            //别名为空，去对象简称的首字母小写
            String simpleName = methodParameter.getParameterType().getSimpleName();
            alias = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
        }
        return alias;
    }
}
