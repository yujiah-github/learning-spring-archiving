package hello.servlet.basic.request;

import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestparamservlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paraName -> System.out.println(paraName + "=" + request.getParameter(paraName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("단일 파라미터 조회");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username)= " + username);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValues(username)");
        String[] usernames = request.getParameterValues("usernames");
        for (String name : usernames) {
            System.out.println("username= " +name);
        }

        response.getWriter().write("ok");



    }
}
