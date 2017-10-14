package com.cagf.tool.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class HbmUtil {
    private String beanPackageName;

    private String servicePackageName;

    private String generalPackageName;

    private String className;

    private String beanPathName;

    private String actionPackageName;

    private String actionPathName;

    private String servicePathName;

    private String firstLetterLowerBeanname;


    public String getBeanPackageName() {
        return beanPackageName;
    }

    public void setBeanPackageName(String beanPackageName) {
        this.beanPackageName = beanPackageName;
    }

    public String getServicePackageName() {
        return servicePackageName;
    }

    public void setServicePackageName(String servicePackageName) {
        this.servicePackageName = servicePackageName;
    }

    public String getGeneralPackageName() {
        return generalPackageName;
    }

    public void setGeneralPackageName(String generalPackageName) {
        this.generalPackageName = generalPackageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBeanPathName() {
        return beanPathName;
    }

    public void setBeanPathName(String beanPathName) {
        this.beanPathName = beanPathName;
    }

    public String getActionPackageName() {
        return actionPackageName;
    }

    public void setActionPackageName(String actionPackageName) {
        this.actionPackageName = actionPackageName;
    }

    public String getActionPathName() {
        return actionPathName;
    }

    public void setActionPathName(String actionPathName) {
        this.actionPathName = actionPathName;
    }

    public String getServicePathName() {
        return servicePathName;
    }

    public void setServicePathName(String servicePathName) {
        this.servicePathName = servicePathName;
    }

    public String getFirstLetterLowerBeanname() {
        return firstLetterLowerBeanname;
    }

    public void setFirstLetterLowerBeanname(String firstLetterLowerBeanname) {
        this.firstLetterLowerBeanname = firstLetterLowerBeanname;
    }

    public HbmUtil(String hbmFileName) {
        try {
            String hbmData = FileUtils.readFileToString(new File(hbmFileName), Charset.forName("utf-8"));
            int pos1 = hbmData.indexOf("name");
            int pos2 = hbmData.indexOf("\"", pos1);
            int pos3 = hbmData.indexOf("\"", pos2 + 1);

            //com.git.bean.DocumentCatalog
            String beanFullName = hbmData.substring(pos2 + 1, pos3); //bean的全路径

            //DocumentCatalog bean的名称
            this.className = beanFullName.substring(beanFullName.lastIndexOf(".") + 1);

            //documentCatalog 首字母小写的bean名称
            this.firstLetterLowerBeanname = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());

            //com.git.bean   bean的包名
            this.beanPackageName = beanFullName.substring(0,beanFullName.lastIndexOf("."));

            //com.git 包名
            this.generalPackageName = beanPackageName.substring(0,beanPackageName.lastIndexOf("."));

            //com.git.service 包名
            this.servicePackageName = generalPackageName+".service";

            this.actionPackageName = generalPackageName+".action."+className.toLowerCase();



            //paths
            this.beanPathName = package2Path(beanPackageName);
            this.servicePathName = package2Path(servicePackageName);
            this.actionPathName = package2Path(actionPackageName);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String package2Path(String packageName){
        return packageName.replaceAll("\\.",File.separator);
    }


    @Override
    public String toString() {
        return "HbmUtil{" +
                "beanPackageName='" + beanPackageName + '\'' +
                ", servicePackageName='" + servicePackageName + '\'' +
                ", generalPackageName='" + generalPackageName + '\'' +
                ", className='" + className + '\'' +
                ", beanPathName='" + beanPathName + '\'' +
                ", actionPackageName='" + actionPackageName + '\'' +
                ", actionPathName='" + actionPathName + '\'' +
                ", servicePathName='" + servicePathName + '\'' +
                '}';
    }
}
