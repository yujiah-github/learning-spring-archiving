package hello.servlet.basic.domain.member;
//회원 관리 웹 어플리케이션 요구사항
import javax.sound.midi.Sequence;
import java.util.HashMap;
import java.util.Map;

public class MemberRepository { //커멘드+시프트+t 누르면 테스트코드로 이동
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }
    private MemberRepository(){ //싱글톤 생성
    }
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;

    }
}
