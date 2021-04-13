package com.guighost.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/02/08
 * 说明：
 */
@Data
public class Teacher {
    private int id;
    private String name;
    //一个老师拥有多个学生
    private List<Student> students;
}
