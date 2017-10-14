package com.cagf.tool.hbm2jsp;

import com.cagf.tool.util.ClassUtil;
import com.cagf.tool.util.HbmUtil;
import com.cagf.tool.util.StringUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Helper {
    private static Helper helper = new Helper();
    private String hbmFilePath;
    private String outputPath;

    private HbmUtil hbmUtil;


    private String PREFIX = "oa";

    private Helper() {

    }

    public static Helper getInstance() {
        return helper;
    }

    public void generateJsps(String hbmFilePath, String outputPath) {
        this.hbmFilePath = hbmFilePath;
        this.outputPath = outputPath;
        hbmUtil = new HbmUtil(hbmFilePath);


        //完成add jsp
        this.generateAddJsp();
        this.generateListJsp();
        this.generateUpdateJsp();

    }

    /**
     * 生成添加jsp
     */
    private void generateAddJsp() {
        try {
            String addJspTemplate = FileUtils.readFileToString(new File(Configer.getInstance().getAddJspPath()), Charset.forName("utf-8"));

            addJspTemplate = addJspTemplate.replaceAll("@CLASSNAME@", hbmUtil.getClassName());
            addJspTemplate = addJspTemplate.replaceAll("@ACTIONCLASSNAME@", "add" + hbmUtil.getClassName());
            addJspTemplate = addJspTemplate.replaceAll("@ADD@", this.getAddFieldData());


            String fileName = this.outputPath + File.separator + PREFIX + File.separator + hbmUtil.getClassName() + File.separator
                    + "add" + hbmUtil.getClassName() + ".jsp";


            FileUtils.writeStringToFile(new File(fileName), addJspTemplate, Charset.forName("utf-8"));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void generateListJsp() {

        try {
            String addJspTemplate = FileUtils.readFileToString(new File(Configer.getInstance().getListJspPath()), Charset.forName("utf-8"));

            addJspTemplate = addJspTemplate.replaceAll("@CLASSNAME@", hbmUtil.getClassName());
            addJspTemplate = addJspTemplate.replaceAll("@ACTIONCLASSNAME@", "list" + hbmUtil.getClassName());
            addJspTemplate = addJspTemplate.replaceAll("@LIST1@", this.getLIST1FileData());
            addJspTemplate = addJspTemplate.replaceAll("@LIST2@", this.getLIST2FileData());


            String fileName = this.outputPath + File.separator + PREFIX + File.separator + hbmUtil.getClassName() + File.separator
                    + "list" + hbmUtil.getClassName() + ".jsp";


            FileUtils.writeStringToFile(new File(fileName), addJspTemplate, Charset.forName("utf-8"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void generateUpdateJsp() {
        try {
            String updateJspTemplate = FileUtils.readFileToString(new File(Configer.getInstance().getUpdateJspPath()), Charset.forName("utf-8"));

            updateJspTemplate = updateJspTemplate.replaceAll("@CLASSNAME@", hbmUtil.getClassName());
            updateJspTemplate = updateJspTemplate.replaceAll("@bean@", hbmUtil.getFirstLetterLowerBeanname());
            updateJspTemplate = updateJspTemplate.replaceAll("@UPDATE@", this.getUPDATEFileData());
            updateJspTemplate = updateJspTemplate.replaceAll("@ACTIONCLASSNAME@", "update" + hbmUtil.getClassName());


            String fileName = this.outputPath + File.separator + PREFIX + File.separator + hbmUtil.getClassName() + File.separator
                    + "update" + hbmUtil.getClassName() + ".jsp";


            FileUtils.writeStringToFile(new File(fileName), updateJspTemplate, Charset.forName("utf-8"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String getUPDATEFileData() {

        String jsp="                <td align=\"right\">@NAME@</td>\n" +
                "                <td>\n" +
                "                    <input type=\"text\" name=\"@NAME@\" size=\"50\" value=\"<s:property value='@bean@.name' />\"class=\"inpMain\">\n" +
                "                </td>";

        StringBuffer sb = new StringBuffer();
        String[][] fields = ClassUtil.getFields(hbmFilePath);
        for (int i = 0; i < fields.length; ++i) {
            String name = fields[i][0];

            if ("id".equals(name)) {
                continue;
            }

            String str = jsp.replaceAll("@NAME@", name).replaceAll("@bean@",hbmUtil.getFirstLetterLowerBeanname());
            sb.append(str).append("\n\n");

        }


        return sb.toString();
    }
    private String getLIST1FileData() {

        String jsp="                        <th width=\"80\" align=\"center\">@NAME@</th>";

        StringBuffer sb = new StringBuffer();
        String[][] fields = ClassUtil.getFields(hbmFilePath);
        for (int i = 0; i < fields.length; ++i) {
            String name = fields[i][0];

            if ("id".equals(name)) {
                continue;
            }

            String str = jsp.replaceAll("@NAME@", name);
            sb.append(str).append("\n\n");

        }


        return sb.toString();
    }

    private String getLIST2FileData() {
//        String jsp = "<td align=\"center\">${bean.@NAME@}</td>";
        String jsp = "                            <td align=\"center\">@NAME@</td>";
        StringBuffer sb = new StringBuffer();
        String[][] fields = ClassUtil.getFields(hbmFilePath);
        for (int i = 0; i < fields.length; ++i) {
            String name = fields[i][0];

            if ("id".equals(name)) {
                continue;
            }

            name = "{bean."+name+"}";

            String str = jsp.replaceAll("@NAME@", name);
            sb.append(str).append("\n\n");

        }


        return sb.toString();
    }





    private String getAddFieldData() {

        String jsp="                <tr>\n" +
                "                    <td align=\"right\">@NAME@</td>\n" +
                "                    <td>\n" +
                "                        <input type=\"text\" name=\"@NAME@\" size=\"50\" class=\"inpMain\">\n" +
                "                    </td>\n" +
                "                </tr>";

        StringBuffer sb = new StringBuffer();
        String[][] fields = ClassUtil.getFields(hbmFilePath);
        for (int i = 0; i < fields.length; ++i) {
            String name = fields[i][0];

            if ("id".equals(name)) {
                continue;
            }

            String str = jsp.replaceAll("@NAME@", name);
            sb.append(str).append("\n\n");

        }


        return sb.toString();
    }


}
