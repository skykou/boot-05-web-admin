package com.atguigu.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhangtao
 * @date 2022/5/27 - 11:14
 */
@SpringBootTest
@DisplayName("Junit5功能测试")
public class Junit5Test {

    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    public void testassumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println(111);
    }

    /**
     * 断言：前面断言失败，后面的代码都不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    public void testSimpleAssertions(){
        int cal = cal(2, 3);
        assertEquals(5,cal,"业务逻辑计算失败");
        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1,o2,"两个对象不一样");
    }

    @DisplayName("array")
    @Test
    public void testArray(){
        assertArrayEquals(new int[]{2,1},new int[]{1,2},"数组内容不相等");
    }

    @DisplayName("组合断言")
    @Test
    public void testall(){
        /**
         * 所有断言全部需要成功
         */
        assertAll("test",
                ()->assertTrue(true && true,"结果不为true"),
                ()->assertEquals(1,2,"结果不是1"));
        System.out.println("========");
    }

    @DisplayName("异常断言")
    @Test
    public void testException() {
        assertThrows(ArithmeticException.class, () -> {
            int i = 10 / 2;
        }, "业务逻辑居然正常运行?");
    }

    @DisplayName("快速失败")
    @Test
    public void testFail(){
        if(2==2){
            fail("测试失败");
        }
    }

    int cal(int i,int j){
        return i+j;
    }

    @DisplayName("测试DisplayName注解")
    @Test
    public void testDisplayName(){
        System.out.println(1);
    }
    @Disabled
    @DisplayName("测试方法2")
    @Test
    public void test2(){
        System.out.println(2);
    }

    @RepeatedTest(5)
    @Test
    public void test3(){
        System.out.println(5);
    }

    /**
     * 规定方法超时时间
     * @throws InterruptedException
     */
    @Timeout(value = 5,unit = TimeUnit.MICROSECONDS)
    @Test
    public void testTimeOut() throws InterruptedException {
        Thread.sleep(500);
    }

    @BeforeEach
    public void testBeforeEach(){
        System.out.println("测试就要开始了..");
    }
    @AfterEach
    public void testAfterEach(){
        System.out.println("测试结束了");
    }

    @BeforeAll
    static public void testBeforeAll(){
        System.out.println("所有测试都要开始了。。");
    }

    @AfterAll
    static public void testAfterAll(){
        System.out.println("所有测试都结束了。");
    }
}
