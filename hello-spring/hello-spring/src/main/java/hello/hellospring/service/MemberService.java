package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional // 저장 변경을 할때는 필요함
public class MemberService {
    private final MemberRepository memberRepository;

    //DI = 외부에서 참조하는 형식
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){

        // AOP 적용 전
        /*long start = System.currentTimeMillis();
        try{*/
            // 같은 이름이 있는 중복 x
            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
       /* } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");

        }*/

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                     throw new IllegalStateException("이미 존재하는 회원입니다.");
                 });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public  Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
