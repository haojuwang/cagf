package com.cagf.tool.hbm2action;

import java.io.File;

public class Configer {
    private String addActionextPath = File.separator + "add_action_template.java";
    private String listActionextPath = File.separator + "list_action_template.java";
    private String updateActionextPath = File.separator + "update_action_template.java";
    private String updatepActionextPath = File.separator + "updatep_action_template.java";
    private String deleteActionextPath = File.separator + "delete_action_template.java";

    private String rootPath;
    private static Configer configer = new Configer();


    private Configer() {

    }

    public static Configer getInstance() {
        return configer;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getAddActionextPath() {
        return rootPath + addActionextPath;
    }


    public String getListActionextPath() {
        return rootPath + listActionextPath;
    }

    public String getUpdateActionextPath() {
        return rootPath + updateActionextPath;
    }

    public String getUpdatepActionextPath() {
        return rootPath + updatepActionextPath;
    }

    public String getDeleteActionextPath() {
        return rootPath + deleteActionextPath;
    }
}
