package gechan.core.service;

import gechan.core.domain.Member;
import gechan.core.repository.MemberRepository;
import gechan.core.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // findByName()의 반환타입이 Optional이기 때문에 ifPresent 사용 가능
            .ifPresent(m -> { throw new IllegalStateException("이미 존재하는 회원입니다"); });
        // ifPresent는 null이 아니라 어떤 값이 있으면 실행, 여기서는 getName()을 통해 얻은 이름을 의미
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    /*
     * 회원 한명 Id로 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
