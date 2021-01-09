package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration ->스프링이 이것을 사용하여 싱글톤을 적용 시켜준다
@Configuration
public class AppConfig {

    // @Autowired MemberRepository memberRepository;

    @Bean
    public MemberService memberService(){
        // 생성자 주입(연결)
        return new MemberServiceImpl(memberRepository());
        // @Autowired을 이용해도 싱글톤 적용 할수있다.
        // return new MemberServiceImpl(memberRepository);
    }
    @Bean
    public OrderService orderService(){
        // 생성자 주입(연결)
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //리팩토링 중복 제거
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
