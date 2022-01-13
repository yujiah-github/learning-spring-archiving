package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") //서블릿 어노테이션, /hello로 들어가야 함
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        //http 요청으로 매핑된 URI 가 호출되면 request, response 를 객체로 던져준다

            throws ServletException, IOException {

        System.out.println("HelloServlet.service"); //콘솔창에 나오는 화면
        System.out.println("request = " + request); //던진 요청이 뭔지 콘솔창에 찍어줌
        System.out.println("response = " + response); //받는 요청이 뭔지 콘솔창에 찍어줌

        String username = request.getParameter("username"); // /hello 뒤에 받을 username의 파라미터를 받는다
        System.out.println("username = " + username); //받을 파라미터의 이름을 콘솔에 찍어줌

        response.setContentType("text/plain"); // http 헤더에 들어갈 정보
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello" +username); //화면에 띄어줌 -> getwriter()?는 뭔데?



    }
}
