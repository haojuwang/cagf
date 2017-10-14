package com.cagf.tool.hbm2xml.struts;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    private static String outputPath;
    private static String strutsxml;

    public static void main(String... args) {
        System.out.println("length :  " + args.length);
        int count = 0;
        System.out.println("start crate *.strutsxml....");
        List<String> hbmPath = new ArrayList<>();
        for (String temp : args) {
            if (temp.startsWith("--output=")) {
                //设定源代码输出目录
                outputPath = temp.substring(9);

            } else if (temp.startsWith("--filename=")) {
                //设置模板文件的绝对路径
                strutsxml = temp.substring(11);
            } else {
                System.out.println("create *.strutsxml");
                ++count;
                //开始真正执行生成
                hbmPath.add(temp);

            }
        }

        Helper.getInstance().generateStrutsxml(hbmPath, outputPath,strutsxml);

        System.out.println("create strutsxml  over");
        System.out.println("count " + count + " strutsxml");

        System.out.println("----------------------------------------------");
    }
}
