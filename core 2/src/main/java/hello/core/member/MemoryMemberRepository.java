package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private  static Map<Long,Member> store = new HashMap<>();
    //실무에선 컨커런트 해쉬맵을 사용하나 예제에서는 간단하게 하기 위해서 맵을 사용
    // store는 memorymemberrepository의 저장소임

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
