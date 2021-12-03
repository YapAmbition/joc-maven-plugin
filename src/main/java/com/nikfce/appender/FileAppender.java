package com.nikfce.appender;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author shenzhencheng on 2021/12/3
 */
public class FileAppender implements Appender {

    private PrintWriter pw ;

    public FileAppender(String filepath) {
        File file = new File(filepath) ;
        try {
            if (file.exists() && file.isFile()) {
                file.delete() ;
            }
            file.createNewFile() ;
            pw = new PrintWriter(file) ;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e) ;
        }

    }

    @Override
    public void append(String content) {
        pw.print(content);
    }

    @Override
    public void close() throws IOException {
        pw.close();
    }
}
