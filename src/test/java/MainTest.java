import org.apache.commons.lang3.StringUtils;
import org.format.demo.model.TestModel;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/21 13:58 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MainTest {

    public static void main(String[] args){
        //TestModel model = new TestModel();
        //BeanWrapper wrapper = new BeanWrapperImpl(model);
        //wrapper.setPropertyValue("good", "on");
        //bw.setPropertyValue("good", "1");
        //bw.setPropertyValue("good", "true");
        //bw.setPropertyValue("good", "yes");
        //System.out.println(model);

        //TestModel tm = new TestModel();
        //BeanWrapperImpl bw = new BeanWrapperImpl(false);
        //bw.setWrappedInstance(tm);
        //bw.setPropertyValue("good", "1");
        //System.out.println(tm);

        TestModel tm = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(tm);
        bw.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        bw.setPropertyValue("birth", "1990-01-01");
        System.out.println(tm);
    }

}
