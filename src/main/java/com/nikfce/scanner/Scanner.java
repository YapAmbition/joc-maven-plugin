package com.nikfce.scanner;

import java.io.File;
import java.util.List;

/**
 * @author shenzhencheng on 2021/12/2
 */
public interface Scanner<T> {

    List<T> scan(File file) ;

}
