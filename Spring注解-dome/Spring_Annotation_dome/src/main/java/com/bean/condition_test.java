package com.bean;


public class condition_test {

    String os_name;

    public condition_test(String os_name) {
        this.os_name = os_name;
    }

    public String getOs_name() {
        return os_name;
    }

    public void setOs_name(String os_name) {
        this.os_name = os_name;
    }

    @Override
    public String toString() {
        return "condition_test{" +
                "os_name='" + os_name + '\'' +
                '}';
    }
}
