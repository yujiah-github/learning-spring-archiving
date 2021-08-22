package hello.servlet.basic.domain.member;
//회원 관리 웹 어플리케이션 요구사항
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*동시성 문제 고려 x , 실무에서는 ConcurrentHaspMap, AtomicLong 사용 고려
 */
public class MemberRepository { //커멘드+시프트+t 누르면 테스트코드로 이동
    private static Map<Long, Member> store = new HashMap<>();
    //딱 하나만 생성
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }
    private MemberRepository(){ //싱글톤 생성 - private로 막아둠
    }
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
        //스토어 자체를 보호
    }

    public void clearStore() {
        store.clear();
    } //스토어를 날려버리는 것

}
