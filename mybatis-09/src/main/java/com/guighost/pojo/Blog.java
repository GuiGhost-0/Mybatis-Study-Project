package com.guighost.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author GuiGhost
 * @date 2021/02/12
 * 说明：博客实体类
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;//属性名与字段名不一致，所以应在核心配置文件中开启驼峰命名
    private int views;
}
