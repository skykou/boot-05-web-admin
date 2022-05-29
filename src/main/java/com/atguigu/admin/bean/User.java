package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangtao
 * @date 2022/5/23 - 21:55
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
public class User {

    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    private String name;
    private Long id;
    private Integer age;
    private String email;
}
