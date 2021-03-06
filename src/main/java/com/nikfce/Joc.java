package com.nikfce;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author shenzhencheng on 2021/12/2
 */
@Mojo(name = "parse", defaultPhase = LifecyclePhase.COMPILE)
public class Joc extends AbstractMojo {

    /** 扫描路径 **/
    @Parameter(property = "path")
    private String path;

    /** 不扫描的文件名,多个文件以英文分号分割 **/
    @Parameter(property = "exclude-files")
    private String excludeFiles;

    /**
     * 执行任务
     *
     * @throws MojoExecutionException 第一个异常
     * @throws MojoFailureException 第二个异常
     */
    public void execute() throws MojoExecutionException, MojoFailureException {

    }

    /**
     * asdaffff
     *
     * mock handle
     * ddfdsdasdasd
     * greeeee
     * @param a 这是参数a
     * @return 执行结果
     */
    public String handle(String a) {
        return null ;
    }

}
