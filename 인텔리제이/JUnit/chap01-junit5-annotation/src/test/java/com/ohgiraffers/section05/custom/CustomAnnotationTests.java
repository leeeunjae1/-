package com.ohgiraffers.section05.custom;

import org.junit.jupiter.api.*;

public class CustomAnnotationTests {

    // 수업목표: 원하는 어노테이션을 조합하여 커스텀 어노테이션을 만들어서 사용할 수 있다.

    @MacTest
    public void testOnMacOS() {}

    @DevelopmentTest
    public void testDevelopmentCustomTag() {}

    @TimeTest
    public void testTime() throws InterruptedException{
        Thread.sleep(100);
    }

    @LifeCycle
    public void testLifeCycle() {
        testbefore();
        test1();
        test2();
        afterEach();
        afterAll();
    }

    @BeforeAll
    public static void testbefore() {
        System.out.println("beforeAll");
    }

    public void test1() {
        System.out.println("test1");
    }

    public void test2() {
        System.out.println("test2");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

}
