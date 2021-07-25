package hello.core.scan;

import hello.core.Member.Member;
import hello.core.Member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        ApplicationContext ac = AnnotationConfigApplicationContext(AutoApppConfig.class);
       MemberService memberService= ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
