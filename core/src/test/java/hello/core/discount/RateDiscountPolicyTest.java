package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인")
    void vip(){
        Member member = new Member(1L, "VIPA", Grade.VIP);

        int result = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인x")
    void basic(){
        Member member = new Member(2L, "VIPB", Grade.BASIC);

        int result = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(result).isEqualTo(0);
    }
}