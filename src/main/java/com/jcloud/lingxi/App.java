package com.jcloud.lingxi;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

/**
 * Solon主应用类
 * 演示如何使用@SolonMain访问数据库
 */
@SolonMain
public class App {

    public static void main(String[] args) {
        // 启动Solon应用
        Solon.start(App.class, args);
    }
}