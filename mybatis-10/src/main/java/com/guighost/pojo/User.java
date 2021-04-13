package com.guighost.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuiGhost
 * @date 2021/02/16
 * 说明：
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;
}
