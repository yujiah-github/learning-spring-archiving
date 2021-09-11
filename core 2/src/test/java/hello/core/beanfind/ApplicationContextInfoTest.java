package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기") // 콘솔 창에 출력될 화면
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //스프링에 등록된 모든 빈 이름을 조회해서 beandefinitionnames에 저장
        for (String beanDefinitionName : beanDefinitionNames) { //beandefinitionName이 전체 반복
            Object bean = ac.getBean(beanDefinitionName); //beandefinitionname에 저장된 모든 빈을 bean에 저장
            System.out.println("name= " + beanDefinitionName + "object= " + bean);

        }

    }

        @Test
        @DisplayName("애플리케이션 빈 출력하기") // 콘솔 창에 출력될 화면
        void findApplicationBean(){
            String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //스프링에 등록된 모든 빈 이름을 조회해서 beandefinitionnames에 저장
            for (String beanDefinitionName : beanDefinitionNames) { //beandefinitionName이 전체 반복
                BeanDefinition beanDefinition = (BeanDefinition) ac.getBean(beanDefinitionName); //beandefinitionname에 저장된 모든 빈을 bean에 저장
               if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                   //role_infrastructure는 스프링이 내부에서 사용하는 빈
                   //roe_application은 직접 등록한 애플리케이션 빈
                   if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                       Object bean = ac.getBean(beanDefinitionName);
                       System.out.println("name= " + beanDefinitionName + "object= " + bean);
                   }

               }

            }





    }
}
