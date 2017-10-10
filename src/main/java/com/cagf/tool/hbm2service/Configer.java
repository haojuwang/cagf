package com.cagf.tool.hbm2service;

import java.io.File;

public class Configer {
    private String extPath = File.separator+"service_template.java";

    private String daoTemplatePath;
    private static Configer configer = new Configer();


    private Configer() {

    }

    public static Configer getInstance() {
        return  configer;
    }

    public String getServiceTemplatePath() {
        return daoTemplatePath;
    }

    public void setServiceTemplatePath(String daoTemplatePath) {
        this.daoTemplatePath = daoTemplatePath+extPath;
    }
}
