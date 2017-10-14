package com.cagf.tool.hbm2xml.struts;


import com.cagf.tool.util.HbmUtil;
import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.util.List;

public class Helper {

    private String SPOT = ".";
    private String SERVICEIMPL = "service.impl";
    private String DAO = "dao";
    private String SERVICE = "service";
    private String SERVICE_EXT = "ServiceImpl.java";
    private String ANCHOR = "name";
    private String QUOTE = "\"";

    private String PREFIX = "/oa";

    private static Helper helper = new Helper();

    private Helper() {

    }

    public static Helper getInstance() {
        return helper;
    }


    public void generateStrutsxml(List<String> hbmPaths, String outputPath, String strutsxml) {


        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(strutsxml);
            Element root = document.getRootElement();

            List<Element> packages = root.elements("package");


            for (String hbmPath : hbmPaths) {

                boolean isExit = false;
                HbmUtil hbmUtil = new HbmUtil(hbmPath);
                String className = hbmUtil.getClassName();


                for (Element element : packages) {

                    String name = element.attributeValue("name");
                    System.out.println("===name ----------------------" + name);

                    if (className.equals(name)) {
                        isExit = true;
                        break;
                    }

                }


                //创建action 配置文件
                if (!isExit) {
                    Element packageElement = root.addElement("package");
                    packageElement.addAttribute("name", className)
                            .addAttribute("namespace", PREFIX + "/" + className)
                            .addAttribute("extends", "struts-default");

                    //add action
                    Element actionElement = packageElement.addElement("action");
                    actionElement.addAttribute("name","add"+className)
                            .addAttribute("class",hbmUtil.getActionPackageName()+"."+"Add"+className+"Action");

                    Element resultElement =  actionElement.addElement("result");
                    resultElement.addAttribute("name","success");
                    resultElement.addAttribute("name","actionName");
                    resultElement.addText("list"+className);


                    //list action
                    Element listAction = packageElement.addElement("action");
                    listAction.addAttribute("name","list"+className)
                            .addAttribute("class",hbmUtil.getActionPackageName()+"."+"List"+className+"Action");

                    Element listResult =  listAction.addElement("result");
                    listResult.addAttribute("name","success");
                    listResult.addText("list"+className+".jsp");

                    //delete action
                    Element deleteAction = packageElement.addElement("action");
                    deleteAction.addAttribute("name","delete"+className)
                            .addAttribute("class",hbmUtil.getActionPackageName()+"."+"Delete"+className+"Action");

                    Element deleteResult =  deleteAction.addElement("result");
                    deleteResult.addAttribute("name","success").addAttribute("type","redirectAction");
                    Element deleteParam = deleteResult.addElement("param");
                    deleteParam.addAttribute("name","actionName");
                    deleteParam.addText("list"+className);



                    //updatep action
                    Element updatepAction = packageElement.addElement("action");
                    updatepAction.addAttribute("name","updatep"+className)
                            .addAttribute("class",hbmUtil.getActionPackageName()+"."+"Updatep"+className+"Action");

                    Element updatepResult =  updatepAction.addElement("result");
                    updatepResult.addAttribute("name","success");
                    updatepResult.addText("updatep"+className+".jsp");



                    //update action
                    Element updateAction = packageElement.addElement("action");
                    updateAction.addAttribute("name","update"+className)
                            .addAttribute("class",hbmUtil.getActionPackageName()+"."+"Update"+className+"Action");

                    Element updateResult =  updateAction.addElement("result");
                    updateResult.addAttribute("name","success").addAttribute("type","redirectAction");
                    Element updateParam = updateResult.addElement("param");
                    updateParam.addAttribute("name","actionName");
                    updateParam.addText("list"+className);


                    System.out.println("===packageElement ----------------------" + packageElement.attributeValue("name"));

                    //输出到文件
                    writerDocumentToNewFile(document, outputPath);

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //document写入新的文件
    public void writerDocumentToNewFile(Document document, String outputPath) throws Exception {
        //输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置编码
        format.setEncoding("UTF-8");
        //XMLWriter 指定输出文件以及格式
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File(outputPath + File.separator + "struts.xml")), "UTF-8"), format);

        //写入新文件
        writer.write(document);
        writer.flush();
        writer.close();
    }


}
