package gechan.core.repository;

import gechan.core.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository // @Component를 내장하고 있음, 그렇기 때문에 컴포넌트 스캔이 가능
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) { // Member 객체를 매개변수로 받을때 이름은 객체에 포함되어있는 상태
        member.setId(++sequence); // id는 sequence를 통해 부여
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // Optional을 사용하게되면 id가 없어서 null 이라도 클라이언트에서 처리가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
