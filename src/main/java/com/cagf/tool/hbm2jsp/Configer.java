package com.cagf.tool.hbm2jsp;

import java.io.File;

public class Configer {
    private String addJspPath = File.separator + "add_jsp_template.jsp";
    private String listJspPath = File.separator + "list_jsp_template.jsp";
    private String updateJspPath = File.separator + "update_jsp_template.jsp";

    private String rootPath;
    private static Configer configer = new Configer();


    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    private Configer() {

    }

    public static Configer getInstance() {
        return configer;
    }


    public String getAddJspPath() {
        return rootPath + addJspPath;
    }

    public String getListJspPath() {
        return rootPath + listJspPath;
    }

    public String getUpdateJspPath() {
        return rootPath + updateJspPath;
    }
}
