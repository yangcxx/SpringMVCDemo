package org.format.demo.editor;

import org.format.demo.model.Dept;

import java.beans.PropertyEditorSupport;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/25 16:21 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class CustomEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text.indexOf(",") > 0) {
            Dept dept = new Dept();
            String[] arr = text.split(",");
            dept.setId(Integer.parseInt(arr[0]));
            dept.setName(arr[1]);
            setValue(dept);
        } else {
            throw new IllegalArgumentException("dept param is error");
        }
    }
}
