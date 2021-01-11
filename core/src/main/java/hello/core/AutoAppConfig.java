package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages = "hello.core.member",   <- 스캔 탐색 대상 설정
        // 컴포넌트 스캔 대상에서 제외(@Configuration)
        // 기존 코드를 유지하기 위함 -> 실무에선 많이 사용하진 않는다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
