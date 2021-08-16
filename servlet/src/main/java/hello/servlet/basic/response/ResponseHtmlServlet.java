package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html"); //이 코드랑 아래 코드 없으면 한글 꺠짐
      response.setCharacterEncoding("utf-8");

        PrintWriter write = response.getWriter();
        write.println("<html>");
        write.println("<body>");
        write.println("<div>안녕?<div>");
        write.println("</body>");
        write.println("</html>");


    }
}