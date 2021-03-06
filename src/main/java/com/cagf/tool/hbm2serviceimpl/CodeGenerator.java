package com.cagf.tool.hbm2serviceimpl;

public class CodeGenerator {
    private static String outputPath;

    public static void main(String... args) {
        System.out.println("length :  " + args.length);
        int count = 0;
        System.out.println("start crate *.serviceimpl....");
        for (String temp : args) {
            if (temp.startsWith("--output=")) {
                //设定源代码输出目录
                outputPath = temp.substring(9);

            } else if (temp.startsWith("--rootpath=")) {
                //设置模板文件的绝对路径
                Configer.getInstance().setServiceImplTemplatePath(temp.substring(11));
            } else {
                System.out.println("create *.dao");
                ++count;
                //开始真正执行生成
                Helper.getInstance().generateDAOImpl(temp, outputPath);
            }
        }

        System.out.println("create serviceimpl  over");
        System.out.println("count " + count + " service impl");

        System.out.println("----------------------------------------------");
    }
}
