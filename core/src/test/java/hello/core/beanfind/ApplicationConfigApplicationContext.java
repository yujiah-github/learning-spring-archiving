package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;

public class ApplicationConfigApplicationContext {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

@Test
    @DisplayName("빈 이름으로 조회")
    Void findBeanByName(){
    MemberService memberService = ac.getBean("memberservice",MemberService.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);


@Test
@DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
}
    @Test
    @DisplayName("구체 타입으로 조회")
    Void findBeanByName2(){
        MemberService memberService = ac.getBean("memberservice",MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

@Test
@DisplayName("빈 이름으로 조회 x")
void findBeanByNameX(){
    ac.getBean("XXXXX", MemberService.class);
    MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
    Assertions.assertThrows(NoSuchBeanDefinitionException.class,
            () -> ac.getBean("xxxxx", MemberService.class)
}





}
