package com.ohgiraffers.section02.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LifecycleAnnotationTests {

    // 수업 목표 : 테스트 메서드의 실행 전 후에 동작하는 어노테이션을 활용 할 수 있다.

    // 테스트가 실행되기 전 딱 한 번만 실행된다.

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    // 각각의 테스트 메서드가 실행되기 전 실행되나
    // @Test, @RepeatedTest, @ParameterizedTest, @TestFactory가 실행되기 전에 동작한다.
    // 주로 테스트 하기 전에 필요한 목업 데이터를 미리 세팅해줄 목적으로 사용된다.

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    // 각각의 테스트 메서드가 동작한 직후 동작을 한다.
    // @Test, @RepeatedTest, @ParameterizedTest, @TestFactory가 실행된 이후 동작한다..
    // 주로 단위 테스트들이 수행된 이후 사용한 자원을 해제할 목적으로 사용한다.

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    // 모든 단위테스트가 완전히 끝난 후 딱 한 번만 실행된다.

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }
}
