package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // Interface 에서만 의존한다 - > 누군가 구현과 생성을 주입해줘야한다.(Config 사용)
    private final MemberRepository memberRepository;

    // 생성자 주입 -> AppConfig
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
