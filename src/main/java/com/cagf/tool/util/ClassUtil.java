package com.cagf.tool.util;

import java.lang.reflect.Field;

public class ClassUtil {
    public static String[][] getFields(String hbmFilePath) {
        HbmUtil hbmUtil = new HbmUtil(hbmFilePath);

        String className = hbmUtil.getBeanPackageName()+"."+hbmUtil.getClassName();
        System.out.println("classname  "+className);

        try {
            Class<?> c = Class.forName(className);

            Field[] f = c.getDeclaredFields();

            String[][] fileds = new String[f.length][2];
            for (int i=0;i<f.length;i++){
                fileds[i][0] = f[i].getName();
                fileds[i][1] = f[i].getType().getName();

            }

            return fileds;


        } catch (Exception ex){
            ex.printStackTrace();

            return null;
        }

    }
}
