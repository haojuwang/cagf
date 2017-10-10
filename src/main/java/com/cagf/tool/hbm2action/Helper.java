package com.cagf.tool.hbm2action;

import com.cagf.tool.util.HbmUtil;
import org.apache.commons.io.FileUtils;

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

    }

    private void  genrateAddAction() {

        //完成.java与struts.xml生成
        this.generateAddActionFile();
    }


    private void generateAddActionFile() {

        try {
            String addActionTemplate = FileUtils.readFileToString(new File(Configer.getInstance().getAddActionextPath()), Charset.forName("utf-8"));

            addActionTemplate = addActionTemplate.replaceAll("@ACTIONPACKAGENAME@",hbmUtil.getActionPackageName());
            addActionTemplate = addActionTemplate.replaceAll("@BEANPACKAGENAME@",hbmUtil.getBeanPackageName()+".*");
            addActionTemplate = addActionTemplate.replaceAll("@SERVICEPACKAGENAME@",hbmUtil.getServicePackageName()+".*");
            addActionTemplate = addActionTemplate.replaceAll("@CLASSNAME@",hbmUtil.getClassName());
            addActionTemplate = addActionTemplate.replaceAll("@bean@",hbmUtil.getFirstLetterLowerBeanname());

            System.out.println("data: "+addActionTemplate);
            String fileName = this.outputPath+File.separator+hbmUtil.getActionPathName()+File.separator+"Add"+hbmUtil.getClassName()+".java";

            System.out.println("filename: "+fileName);
            System.out.println("html:   "+hbmUtil);

            FileUtils.writeStringToFile(new File(fileName),addActionTemplate,Charset.forName("utf-8"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
