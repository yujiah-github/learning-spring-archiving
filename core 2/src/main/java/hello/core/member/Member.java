package hello.core.member;

public class Member {
    private Long id; //회원의 아이디
    private String name; // 회원의 이름
    private Grade grade; //회원의 등급

    public Long getId() { //아이디 읽기
        return id;
    }

    public void setId(Long id) { //아이디 설정
        this.id = id;
    }

    public String getName() { //이름 읽기
        return name;
    }

    public void setName(String name) { //이름 설정
        this.name = name;
    }

    public Grade getGrade() { //등급 읽기
        return grade;
    }

    public void setGrade(Grade grade) { //등급 설정
        this.grade = grade;
    }

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

}
