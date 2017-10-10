package com.cagf.tool.hbm2serviceimpl;

import java.io.File;

public class Configer {
    private String extPath = File.separator+"service_impl_template.java";

    private String serviceImplTemplatePath;
    private static Configer configer = new Configer();


    private Configer() {

    }

    public static Configer getInstance() {
        return  configer;
    }

    public String getServiceImplTemplatePath() {
        return serviceImplTemplatePath;
    }

    public void setServiceImplTemplatePath(String daoTemplatePath) {
        this.serviceImplTemplatePath = daoTemplatePath+extPath;
    }
}
