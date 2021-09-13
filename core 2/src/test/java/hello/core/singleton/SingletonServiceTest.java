package hello.core.singleton;


import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

@Test
@DisplayName("싱글톤 패턴을 적용한 객체 사용")
public class SingletonServiceTest {

    SingletonService singletonService1 = SingletonService.getInstance();

    SingletonService singletonService2 = SingletonService.getInstance();

     System.out.println("singletonService1= " +singletonService1);
      System.out.println("singletonService2= " +singletonService2);

      assertThat(SingletonService1).isSameAs(singletonService2);

      singletonService1.logic();








}
