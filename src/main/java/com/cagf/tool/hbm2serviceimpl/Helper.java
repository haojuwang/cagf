package com.cagf.tool.hbm2serviceimpl;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Helper {

    private String SPOT = ".";
    private String SERVICEIMPL = "service.impl";
    private String DAO = "dao";
    private String SERVICE = "service";
    private String SERVICE_EXT = "ServiceImpl.java";
    private String ANCHOR = "name";
    private String QUOTE = "\"";

    private static Helper helper = new Helper();

    private Helper() {

    }

    public static Helper getInstance() {
        return helper;
    }


    public void generateDAOImpl(String fileName, String outputPath) {

//        获取到hbm文件内容
        String hbmFileContent = this.getFileData(fileName);
//       获取到模板文件
        String templateFileData = this.getTemplateServerImpl();

//        获取hbm 文件中定义的类全名
        String hbm = this.getHBM(hbmFileContent);

        //获取并设定dao 包名
        String packageData = this.getPackageName(hbm);

        System.out.println("packageData---   " + packageData);
        String beansName = this.getBeansName(hbm);

        System.out.println("packageData:" + packageData);
        System.out.println("beansName:" + beansName);
//        System.out.println("templateFileData:"+templateFileData);
//
//
        String importbeans = getImportName(hbm);

        //替换模板文件
        templateFileData = repleaceTemplate(templateFileData, hbm, packageData, beansName, importbeans);


        generatorFile(outputPath, templateFileData, packageData, beansName);


    }

    private String repleaceTemplate(String templateFileData, String hbm, String packageData, String beansName, String importbeans) {
        templateFileData = templateFileData.replaceAll("@PACKAGE@", packageData);
        templateFileData = templateFileData.replaceAll("@IMPORTBEANS@", importbeans);
        templateFileData = templateFileData.replaceAll("@CLASSNAME@", beansName);
        templateFileData = templateFileData.replaceAll("@IMPORTDAOINTERFACE@",
                packageData.substring(0,packageData.lastIndexOf(".")+1)+STAR);

        String bean = getbean(hbm);
        templateFileData = templateFileData.replaceAll("@bean@", bean);
        templateFileData = templateFileData.replaceAll("@IMPORTDAOS@", getDaoPackageName(hbm));
        templateFileData = templateFileData.replaceAll("@IMPORTSERVICE@", getServicePackageName(hbm));
        return templateFileData;
    }

    /**
     * 生成文件
     * @param outputPath
     * @param templateFileData
     * @param packageData
     * @param beansName
     */
    private void generatorFile(String outputPath, String templateFileData, String packageData, String beansName) {
        String outpath = packageData.replaceAll("\\.", File.separator);

        File root = new File(outputPath + File.separator + outpath);

        try {
            FileUtils.forceMkdir(root);
            String outputFilename = beansName + SERVICE_EXT;
            File file = new File(root, outputFilename);
            FileWriter writer = new FileWriter(file);
            writer.write(templateFileData);
            writer.close();
            System.out.println("file success");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getTemplateServerImpl() {
        return this.getFileData(Configer.getInstance().getServiceImplTemplatePath());
    }


    public String getFileData(String filename) {

        try {
            File file = new File(filename);
            FileReader reader = new FileReader(file);
            char[] fileData = new char[(int) file.length()];
            reader.read(fileData);

            reader.close();
            return String.copyValueOf(fileData);

        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }

    }




    private String getHBM(String strSource) {
        int pos1 = strSource.indexOf(ANCHOR);
        int pos2 = strSource.indexOf(QUOTE, pos1);
        int pos3 = strSource.indexOf(QUOTE, pos2 + 1);

        String strHBM = strSource.substring(pos2 + 1, pos3);
        return strHBM;


    }



    private String getPackageName(String hbm) {
        hbm = hbm.substring(0, hbm.lastIndexOf(SPOT));
        return hbm.substring(0, hbm.lastIndexOf(SPOT)) + SPOT + SERVICEIMPL;
    }
    private String getDaoPackageName(String hbm) {
        hbm = hbm.substring(0, hbm.lastIndexOf(SPOT));
        return hbm.substring(0, hbm.lastIndexOf(SPOT)) + SPOT + DAO+SPOT+STAR;
    }
    private String getServicePackageName(String hbm) {
        hbm = hbm.substring(0, hbm.lastIndexOf(SPOT));
        return hbm.substring(0, hbm.lastIndexOf(SPOT)) + SPOT + SERVICE+SPOT+STAR;
    }

    private String getBeansName(String hbm) {
        return hbm.substring(hbm.lastIndexOf(SPOT) + 1, hbm.length());
    }

    private String STAR = "*";

    private String getImportName(String hbm) {
        return hbm.substring(0, hbm.lastIndexOf(SPOT, hbm.lastIndexOf(SPOT))) + SPOT + STAR;
    }

    private String getbean(String hbm) {
        String beannames = getBeansName(hbm);
        return beannames.substring(0, 1).toLowerCase() + beannames.substring(1, beannames.length());
    }

}
