package com.atguigu.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhangtao
 * @date 2022/5/26 - 20:59
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Long id;
    private String name;
    private String state;
    private String country;
}
