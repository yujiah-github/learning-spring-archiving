package hello.core.order;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classses = Configuration.class)
// excludeFilters를 이용해서 설정정보는 컴포넌트 스캔 대상에서 제외
public class AutoAppConfig {
}
