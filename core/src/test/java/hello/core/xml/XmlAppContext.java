package hello.core.xml;

import hello.core.Member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.beans.Beans;

import static org.hamcrest.MatcherAssert.assertThat;

public class XmlAppContext {
    @Test
    void xmlAppContext(){
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appconfig.xml");

        MemberService memberService = ac.getBean("memberService",
                MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
