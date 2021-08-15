package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //lombok이 자동으로 getter setter 제공
public class HelloData {
    private String username;
    private int age;
}
