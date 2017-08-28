package org.format.demo.model;

import java.util.Date;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/25 11:43 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class TestModel {

    private int age;
    private Date birth;
    private String name;
    private boolean good;
    private long times;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "age=" + age +
                ", birth=" + birth +
                ", name='" + name + '\'' +
                ", good=" + good +
                ", times=" + times +
                '}';
    }
}
