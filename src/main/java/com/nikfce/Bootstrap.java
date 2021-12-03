package com.nikfce;

import com.alibaba.fastjson.JSON;
import com.nikfce.appender.Appender;
import com.nikfce.appender.ConsoleAppender;
import com.nikfce.appender.FileAppender;
import com.nikfce.scanner.Comment;
import com.nikfce.scanner.CommentScanner;
import com.nikfce.scanner.Scanner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenzhencheng on 2021/12/2
 */
public class Bootstrap {

    public static void main(String[] args) throws IOException {
        start() ;
    }

    /**
     * 启动器,从本项目根目录开始扫描,扫描内部的所有java类的文件
     */
    public static void start() throws IOException {
        List<File> allFileList = scanFiles() ;
        Appender appender = new FileAppender("/Users/shenzhencheng/Desktop/abc.log") ;
        Scanner<Comment> scanner = new CommentScanner();
        for (File file : allFileList) {
            List<Comment> commentList = scanner.scan(file) ;
            appender.append("|======\n");
            Map<String, Object> map = new HashMap<>() ;
            map.put("filename", file.getAbsolutePath()) ;
            map.put("comments", commentList) ;
            appender.append(JSON.toJSONString(map));
            appender.append("\n------|");
        }
        appender.close();
    }

    /**
     * 扫描当前项目目录中所有的Java文件
     */
    private static List<File> scanFiles() {
        String cwd = System.getProperty("user.dir") ;
        File root = new File(cwd) ;
        List<File> allFiles = new ArrayList<>();
        scanFiles(root, allFiles) ;
        return allFiles ;
    }

    private static void scanFiles(File file, List<File> allFiles) {
        if (file == null) return ;
        if (!file.exists()) return ;
        if (file.isFile()) {
            if (file.getName().endsWith(".java")) {
                allFiles.add(file) ;
            }
        } else if (file.isDirectory()) {
            File[] subFiles = file.listFiles() ;
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    scanFiles(subFile, allFiles) ;
                }
            }
        }
    }


}
