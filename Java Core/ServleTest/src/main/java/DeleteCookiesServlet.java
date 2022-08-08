import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("some_id", "");
        Cookie cookie1 = new Cookie("some_name", "");

        cookie1.setMaxAge(0);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
