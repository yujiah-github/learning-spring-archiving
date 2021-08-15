package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/request-param?username=hello&age=20
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age)=" + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValues(username)");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username=" + name);
        }
        //복수 파라미터에서 단일 파라미터 조회
        //username=hello&username=kim 과 같이 파라미터 이름은 하나인데, 값이 중복이면 어떻게 될까?
        //request.getParameter() 는 하나의 파라미터 이름에 대해서 단 하나의 값만 있을 때 사용해야 한다.
        // 지금처럼 중복일 때는 request.getParameterValues() 를 사용해야 한다.
        //참고로 이렇게 중복일 때 request.getParameter() 를 사용하면 request.getParameterValues() 의
        //첫 번째 값을 반환한다.



        response.getWriter().write("ok");
    }
}


//content-type: application/x-www-form-urlencoded message body: username=hello&age=20
// application/x-www-form-urlencoded 형식은 앞서 GET에서 살펴본 쿼리 파라미터 형식과 같다.
// 따라서 쿼리 파라미터 조회 메서드를 그대로 사용하면 된다.
//클라이언트(웹 브라우저) 입장에서는 두 방식에 차이가 있지만, 서버 입장에서는 둘의 형식이 동일하므로, request.getParameter() 로 편리하게 구분없이 조회할 수 있다.
// 정리하면 request.getParameter() 는 GET URL 쿼리 파라미터 형식도 지원하고, POST HTML Form 형식도 둘 다 지원한다.
// > 참고
// > content-type은 HTTP 메시지 바디의 데이터 형식을 지정한다.
// > GET URL 쿼리 파라미터 형식으로 클라이언트에서 서버로 데이터를 전달할 때는 HTTP 메시지 바디를 사용하지 않기 때문에 content-type이 없다.
// > POST HTML Form 형식으로 데이터를 전달하면 HTTP 메시지 바디에 해당 데이터를 포함해서 보내기때문에 바디에 포함된 데이터가 어떤 형식인지 content-type을 꼭 지정해야 한다.
// 이렇게 폼으로 데이터를 전송하는 형식을 application/x-www-form-urlencoded 라 한다.
// Postman을 사용한 테스트
// 이런 간단한 테스트에 HTML form을 만들기는 귀찮다. 이때는 Postman을 사용하면 된다.
// Postman 테스트 주의사항 POST 전송시
// Body x-www-form-urlencoded 선택
// Headers에서 content-type: application/x-www-form-urlencoded 로 지정된 부분 꼭 확인
