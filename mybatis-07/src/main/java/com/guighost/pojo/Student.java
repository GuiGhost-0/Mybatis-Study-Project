package com.guighost.pojo;

import lombok.Data;

/**
 * @author GuiGhost
 * @date 2021/02/08
 * 说明：
 */
@Data
public class Student {
    private int id;
    private String name;
    //学生需要关联一个老师
    private Teacher teacher;
}
