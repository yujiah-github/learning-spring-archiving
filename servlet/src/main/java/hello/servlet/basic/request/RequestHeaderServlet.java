package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 서블릿은 개발자가 HTTP 요청 메시지를 편리하게 사용할 수 있도록 개발자 대신에 HTTP 요청 메시지를 파싱한다.
// 그리고 그 결과를 HttpServletRequest 객체에 담아서 제공한다.
//요청 메세지
//POST /save HTTP/1.1 > START LINE HTTP 메소드,URL,쿼리 스트링,스키마, 프로토콜 헤더
//  Host: localhost:8080 > 헤더 조회
//  Content-Type: application/x-www-form-urlencoded

//  username=kim&age=20 > 바디
//        form 파라미터 형식 조회 message body 데이터 직접 조회

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);

        response.getWriter().write("ok");
    }

    //startline 정보
    private void printStartLine(HttpServletRequest request){
            System.out.println("--- REQUEST-LINE - start ---");
            System.out.println("request.getMethod() = " + request.getMethod()); //GET
            System.out.println("request.getProtocal() = " + request.getProtocol()); //HTTP/1.1
            System.out.println("request.getScheme() = " + request.getScheme()); //http:
            System.out.println("request.getRequestURL() = " + request.getRequestURL());
            // http://localhost:8080/request-header
            System.out.println("request.getRequestURI() = " + request.getRequestURI());
            // /request-test
            System.out.println("request.getQueryString() = " +
                    request.getQueryString());//username=hi
            System.out.println("request.isSecure() = " + request.isSecure()); //https 사용 유무
            System.out.println("--- REQUEST-LINE - end ---");
            System.out.println();
        }
    //Header 모든 정보
    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ":" + request.getHeader(headerName)));
        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    //Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request) { System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]"); System.out.println("request.getServerName() = " +
            request.getServerName()); //Host 헤더 System.out.println("request.getServerPort() = " +
        request.getServerPort(); //Host 헤더 System.out.println();
        System.out.println("[Accept-Language 편의 조회]"); request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();
        System.out.println("[cookie 편의 조회]"); if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            } }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " +
                request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }

//기타정보 조회(http 메세지와는 상관 없음)
    private void printEtc(HttpServletRequest request) { System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " +
                request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }

}
