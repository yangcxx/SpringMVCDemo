package org.format.demo.viewresolver;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.view.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/26 12:25 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Getter
@Setter
public class CustomViewResolver extends UrlBasedViewResolver {

    public static final String JSP_URL_PREFIX = "jsp:";
    public static final String FTL_URL_PREFIX = "freemarker:";

    private static final boolean jstlPresent = ClassUtils.isPresent("javax.servlet.jsp.jstl.core.Config", CustomViewResolver.class.getClassLoader());

    private Boolean exposePathVariables = false;

    private boolean exposeRequestAttributes = false;

    private boolean allowRequestOverride = false;

    private boolean exposeSessionAttributes = false;

    private boolean allowSessionOverride = false;

    private boolean exposeSpringMacroHelpers = true;

    public CustomViewResolver() {
        this.setViewClass(FreeMarkerView.class);
    }

    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        if (viewName.startsWith(FTL_URL_PREFIX)) {
            return buildFreeMarkerView(viewName.substring(FTL_URL_PREFIX.length()));
        } else if (viewName.startsWith(JSP_URL_PREFIX)) {
            /**
             * 如果有 JSTL 依赖，构造 JSTL 视图，否则构造 InternalResourceView
             */
            Class<? extends InternalResourceView> viewCls = jstlPresent ? JstlView.class : InternalResourceView.class;
            return build(viewCls, viewName.substring(JSP_URL_PREFIX.length()), getPrefix(), ".jsp");//cxy
        } else {
            return buildFreeMarkerView(viewName);
        }
    }

    private AbstractUrlBasedView buildFreeMarkerView(String viewName) {
        AbstractTemplateView view = (AbstractTemplateView) build(FreeMarkerView.class, viewName, "", getSuffix());
        view.setExposeRequestAttributes(this.exposeRequestAttributes);
        view.setAllowRequestOverride(this.allowRequestOverride);
        view.setExposeSessionAttributes(this.exposeSessionAttributes);
        view.setAllowSessionOverride(this.allowSessionOverride);
        view.setExposeSpringMacroHelpers(this.exposeSpringMacroHelpers);
        return view;
    }

    private AbstractUrlBasedView build(Class viewClass, String viewName, String prefix, String suffix) {
        AbstractUrlBasedView view = (AbstractUrlBasedView) BeanUtils.instantiateClass(viewClass);
        view.setUrl(prefix + viewName + suffix);
        String contentType = getContentType();
        if (null != contentType) {
            view.setContentType(contentType);
        }
        view.setRequestContextAttribute(getRequestContextAttribute());
        view.setAttributesMap(getAttributesMap());
        if (this.exposePathVariables != null) {
            view.setExposePathVariables(exposePathVariables);
        }
        return view;
    }
}
