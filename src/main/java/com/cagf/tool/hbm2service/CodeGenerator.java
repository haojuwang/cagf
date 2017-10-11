package com.cagf.tool.hbm2service;

public class CodeGenerator {
    private static String outputPath;

    public static void main(String... args) {
        System.out.println("length :  " + args.length);
        int count = 0;
        System.out.println("start crate *.service....");
        for (String temp : args) {
            if (temp.startsWith("--output=")) {
                //设定源代码输出目录
                outputPath = temp.substring(9);

            } else if (temp.startsWith("--rootpath=")) {
                //设置模板文件的绝对路径
                Configer.getInstance().setServiceTemplatePath(temp.substring(11));
            } else {
                System.out.println("create *.service");
                ++count;
                //开始真正执行生成
                Helper.getInstance().generateService(temp, outputPath);
            }
        }

        System.out.println("create service over");
        System.out.println("count " + count + " service");

        System.out.println("----------------------------------------------");
    }
}
