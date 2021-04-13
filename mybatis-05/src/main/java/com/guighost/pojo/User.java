package com.guighost.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author GuiGhost
 * @Date 2021/01/26 13:48
 * @Version 1.0
 **/
@Data//该注解自动生成-->无参构造、getter、setter、toString、HashCode、equals
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
}
