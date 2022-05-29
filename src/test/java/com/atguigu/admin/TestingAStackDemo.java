package com.atguigu.admin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhangtao
 * @date 2022/5/27 - 19:12
 */
@DisplayName("嵌套测试")
@SpringBootTest
public class TestingAStackDemo {

    Stack<Object> stack;

    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    void testParamterized(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("参数化测试")
    @MethodSource("stringProvider")
    void testParamterized2(String i){
        System.out.println(i);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana","atguigu");
    }

    @Test
    @DisplayName("new Stack()")
    public void isInstantiateWithNew(){
        new Stack<>();
        //嵌套测试情况下，外层的Test不能驱动内层的BeforeEach(After)/All之类的方法提前/之后运行
        assertNull(stack);
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {
        @BeforeEach
        void createNewStack(){
            stack=new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty(){
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped(){
            assertThrows(EmptyStackException.class,stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPeeked(){
            assertThrows(EmptyStackException.class,stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing{
            String anEmlement = "an element";

            @BeforeEach
            void pushAnElement(){
                stack.push(anEmlement);
            }

            /**
             * 内层可以驱动外层的BeforeEach(After)/All之类的方法提前/之后运行
             */
            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty(){
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped(){
                assertEquals(anEmlement,stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked(){
                assertEquals(anEmlement,stack.peek());
                assertFalse(stack.isEmpty());
            }

        }

    }


}
