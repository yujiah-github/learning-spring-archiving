package hello.core.member;

import java.lang.reflect.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);

}
