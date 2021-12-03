package com.nikfce.doclet;

import com.sun.javadoc.*;

/**
 * 执行类注释解析时必要的类
 * @author shenzhencheng on 2021/12/2
 */
public class Joclet {

    private static RootDoc root;

    /**
     * 此方法是让doclet调用的,是标准的接口
     */
    public static boolean start(RootDoc root) {
        Joclet.root = root;
        return true;
    }

    /**
     * 开始执行doclet逻辑
     * @param filepath 待解析的文件路径(Java文件)
     * @param callback (解析结束后的回调)
     */
    public static void execute(String filepath, JocletCallback callback) {
        com.sun.tools.javadoc.Main.execute(new String[] {"-doclet",
                Joclet.class.getName(),
                "-encoding","utf-8",
                "-quiet",
                filepath});
        callback.callback(root.classes());
    }

}
