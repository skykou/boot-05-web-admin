package com.atguigu.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhangtao
 * @date 2022/5/25 - 10:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    /**
     * 编号
     */
    private int id;

    /**
     * 姓名
     */
     private String name;

     /**
      * 年龄
      */
     private int age;

     /**
      * 性别
      */
      private String gender;

      /**
       * 地址
       */
       private String addr;

}
