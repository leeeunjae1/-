package com.ohgiraffers.section05.custom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// Retention -> 어노테이션이 언제까지 유지될지 명시하는 것
@Target(ElementType.METHOD)
// Target -> 이 어노테이션에 적용될 수 있는 JAVA 요소의 종류를 지정
@EnabledOnOs(value = OS.MAC, disabledReason = "맥 환경에서는 작동하지 않습니다.")
@Test
public @interface MacTest {

}
