package com.cagf.tool.hbm2daoimpl;

import java.io.File;

public class Configer {
    private String extPath = File.separator+"dao_impl_template.ftl";

    private String daoTemplatePath;
    private static Configer configer = new Configer();


    private Configer() {

    }

    public static Configer getInstance() {
        return  configer;
    }

    public String getDaoTemplatePath() {
        return daoTemplatePath;
    }

    public void setDaoTemplatePath(String daoTemplatePath) {
        this.daoTemplatePath = daoTemplatePath+extPath;
    }
}
