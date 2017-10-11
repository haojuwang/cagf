package com.cagf.tool.hbm2action;

import com.cagf.tool.util.ClassUtil;
import com.cagf.tool.util.HbmUtil;
import com.cagf.tool.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.components.Bean;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Helper {
    private static Helper helper = new Helper();
    private String hbmFilePath;
    private String outputPath;

    private HbmUtil hbmUtil;

    private Helper() {

    }

    public static Helper getInstance() {
        return helper;
    }

    public void generateActions(String hbmFilePath, String outputPath) {
        this.hbmFilePath = hbmFilePath;
        this.outputPath = outputPath;
        hbmUtil = new HbmUtil(hbmFilePath);


        //完成crud Action 生成
        this.genrateAddAction();

        this.genrateListAction();

        this.genrateUpdateAction();

    }

    private void genrateAddAction() {

        //完成.java与struts.xml生成
        this.generateAddActionFile();


    }

    private void genrateListAction() {
        this.generateListActionFile();
    }

    private void genrateUpdateAction() {
        this.generateUpdateActionFile();
    }


    private void generateAddActionFile() {

        try {
            String addActionTemplate = FileUtils.readFileToString(new File(Configer.getInstance().getAddActionextPath()), Charset.forName("utf-8"));

            addActionTemplate = addActionTemplate.replaceAll("@ACTIONPACKAGENAME@", hbmUtil.getActionPackageName());
            addActionTemplate = addActionTemplate.replaceAll("@BEANPACKAGENAME@", hbmUtil.getBeanPackageName() + ".*");
            addActionTemplate = addActionTemplate.replaceAll("@SERVICEPACKAGENAME@", hbmUtil.getServicePackageName() + ".*");
            addActionTemplate = addActionTemplate.replaceAll("@CLASSNAME@", hbmUtil.getClassName());
            addActionTemplate = addActionTemplate.replaceAll("@bean@", hbmUtil.getFirstLetterLowerBeanname());


            addActionTemplate = addActionTemplate.replaceAll("@ADDBEAN@", this.getAddActionFieldData()+this.getAddActionSetGetData());
            addActionTemplate = addActionTemplate.replaceAll("@SETPROPERTY@", this.getSetPropertyData());

            String fileName = this.outputPath + File.separator + hbmUtil.getActionPathName() + File.separator + "Add" + hbmUtil.getClassName() + "Action.java";


            FileUtils.writeStringToFile(new File(fileName), addActionTemplate, Charset.forName("utf-8"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成list action
     */
    private void generateListActionFile() {
        try {
            String listActionTemplate = FileUtils.readFileToString(new File(Configer.getInstance().getListActionextPath()), Charset.forName("utf-8"));

            listActionTemplate = listActionTemplate.replaceAll("@ACTIONPACKAGENAME@", hbmUtil.getActionPackageName());
            listActionTemplate = listActionTemplate.replaceAll("@BEANPACKAGENAME@", hbmUtil.getBeanPackageName() + ".*");
            listActionTemplate = listActionTemplate.replaceAll("@SERVICEPACKAGENAME@", hbmUtil.getServicePackageName() + ".*");
            listActionTemplate = listActionTemplate.replaceAll("@CLASSNAME@", hbmUtil.getClassName());
            listActionTemplate = listActionTemplate.replaceAll("@bean@", hbmUtil.getFirstLetterLowerBeanname());


            String fileName = this.outputPath + File.separator + hbmUtil.getActionPathName() + File.separator + "List" + hbmUtil.getClassName() + "Action.java";


            FileUtils.writeStringToFile(new File(fileName), listActionTemplate, Charset.forName("utf-8"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成updatep 文件
     */
    private void generateUpdateActionFile() {
        try {
            String updateActionTemplate = FileUtils.readFileToString(new File(Configer.getInstance().getUpdateActionextPath()), Charset.forName("utf-8"));

            updateActionTemplate = updateActionTemplate.replaceAll("@ACTIONPACKAGENAME@", hbmUtil.getActionPackageName());
            updateActionTemplate = updateActionTemplate.replaceAll("@BEANPACKAGENAME@", hbmUtil.getBeanPackageName() + ".*");
            updateActionTemplate = updateActionTemplate.replaceAll("@SERVICEPACKAGENAME@", hbmUtil.getServicePackageName() + ".*");
            updateActionTemplate = updateActionTemplate.replaceAll("@CLASSNAME@", hbmUtil.getClassName());
            updateActionTemplate = updateActionTemplate.replaceAll("@bean@", hbmUtil.getFirstLetterLowerBeanname());


            updateActionTemplate = updateActionTemplate.replaceAll("@UPDATEBEAN@", this.getAddActionFieldData()+this.getAddActionSetGetData());
            updateActionTemplate = updateActionTemplate.replaceAll("@UPDATEPROPERTY@", this.getUpdateproperty());

            String fileName = this.outputPath + File.separator + hbmUtil.getActionPathName() + File.separator + "Update" + hbmUtil.getClassName() + "Action.java";


            FileUtils.writeStringToFile(new File(fileName), updateActionTemplate, Charset.forName("utf-8"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String getAddActionFieldData() {

        String[][] fields = ClassUtil.getFields(hbmFilePath);

        StringBuffer sb = new StringBuffer();

        // 属性
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i][0];
            String type = fields[i][1];
            type = type.substring(type.lastIndexOf(".") + 1);

            sb.append("\t");
            sb.append("private " + type + " " + name + " ;");
            sb.append("\n\n");

        }

        return sb.toString();

    }

    private String getAddActionSetGetData() {
        String[][] fields = ClassUtil.getFields(hbmFilePath);

        StringBuffer sb = new StringBuffer();
        //get set
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i][0];
            String type = fields[i][1];
            type = type.substring(type.lastIndexOf(".") + 1);

            //get
            sb.append("\n\t").append("public ").append(type).append(" ").append(StringUtil.obtainGetMethodName(name))
                    .append("()").append(" {").append("\n\t\t").append("return ").append(name).append(";")
                    .append("\n\t}").append("\n");

            //set
            sb.append("\n\t").append("public ").append("void ").append(StringUtil.obtainSetMehodName(name))
                    .append("(").append(type).append(" ").append(name).append(") ").append("{")
                    .append("\n\t\t").append("this.").append(name).append(" = ").append(name).append(";\n\t}").append("\n");


        }

        return sb.toString();
    }


    public String getSetPropertyData() {
        String[][] fields = ClassUtil.getFields(hbmFilePath);

        StringBuffer sb = new StringBuffer();
        sb.append(hbmUtil.getClassName()).append(" bean = new ")
                .append(hbmUtil.getClassName()).append("();\n\n\t\t");

        for (int i = 0; i < fields.length; i++) {
            String name = fields[i][0];

            String setMethodName = StringUtil.obtainSetMehodName(name);
            sb.append("bean.").append(setMethodName).append("(").append(name).append(") ;\n\t\t");


        }
        sb.append("\n\tthis.").append(hbmUtil.getFirstLetterLowerBeanname()+"Service").append(".save").append(hbmUtil.getClassName())
                .append("(bean);");

        return sb.toString();

    }


    private String getUpdateproperty() {

        String[][] fields = ClassUtil.getFields(hbmFilePath);

        StringBuffer sb = new StringBuffer();


        for (int i = 0; i < fields.length; i++) {
            String name = fields[i][0];
            String setMethodName = StringUtil.obtainSetMehodName(name);
            sb.append("bean.").append(setMethodName).append("(").append(name).append(") ;\n\t\t");

        }


        return sb.toString();
    }



}
