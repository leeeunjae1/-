package com.ohgiraffers.section04.enviroment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class EnvAnnotationTests {

    // 수업목표 : 운영체제, JRE에 따라 테스트를 수행할 수 있다.

    // 테스트 메서드는 특정 OS 환경에서만 테스트를 진행되게 할 수 있다.
    // 이 때, 특정 OS에서 무시되는 사유를 disabledReason에 기술하여
    // 테스트 코드가 무시되는 사유를 다른 사람도 함께 알 수 있게 한다.

//    @Test
//    @EnabledOnOs(value = OS.MAC, disabledReason = "맥에서만 테스트합니다.")
//    public void testMAC() {}
//
//    @Test
//    @EnabledOnOs(value = {OS.WINDOWS, OS.LINUX},  disabledReason = "윈도우와 리눅스만 테스트합니다.")
//    public void testWindowsAndLinux() {}
//
//    @Test
//    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "윈도우 환경에서는 테스트를 무시합니다.")
//    public void testDisabledOnWindows() {}

    // @EnableOnJre를 이용하여 특정 JRE 버전에서만 테스트 하는 것도 가능하다.
    // @DisabledOnJre를 이용하여 특정 JRE 버전에서만 테스트를 Disabled하는 것도 가능하다.
    // @EnableForJreRange를 이용하면 min과 max 속성 사이의 버전에서 테스트 하는 것도 가능하다.
    // (min만 작성시 min~최신버전까지, max만 작성 시 이전 버전부터 max까지만 테스트를 한다.)

    @Test
    @EnabledOnJre(value = JRE.JAVA_8, disabledReason = "JRE 1.8. 환경에서만 테스트합니다.")
    public void testJRE() {}

    @Test
    @EnabledOnJre(value = {JRE.JAVA_8, JRE.JAVA_17})
    public void testJRE8ANDJRE17() {}

    @Test
    @DisabledOnJre(value = JRE.JAVA_17)
    public void testDisabledJRE17() {}

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
    public void testFromJRE8TOJRE17() {}

}
