package org.format.demo.editor;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/25 16:21 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class DateEditor extends PropertyEditorSupport {

    public static String[] DATE_PATTERNS = new String[]{"yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd", "yyyy-MM", "yyyyMM",
            "yyyy/MM", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd HH:mm", "yyyy-MM-dd HH:mm:ss",
            "yyyy/MM/dd HH:mm:ss"};

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            try {
                setValue(DateUtils.parseDate(text, DATE_PATTERNS));
            } catch (ParseException e) {
                IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + e.getMessage());
                iae.initCause(e);
                throw iae;
            }
        } else {
            setValue(null);
        }
    }
}
