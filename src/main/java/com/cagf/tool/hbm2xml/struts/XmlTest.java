package com.cagf.tool.hbm2xml.struts;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlTest {
    public static void main(String ...arg) {
        String filePath = "src/main/resources/struts.xml";

        try {
            System.out.println("strutsxml = "+filePath);
            SAXReader reader = new SAXReader();
            Document document = reader.read(filePath);
            Element root = document.getRootElement();

            System.out.println(root.getName());



        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
