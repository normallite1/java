import logic.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/hello")
public class FirstServlet extends HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

//        HttpSession session = request.getSession();
//
//        Cart cart = (Cart) session.getAttribute("cart");
//        String name = request.getParameter("name");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//
//        if(cart == null){
//            cart = new Cart();
//            cart.setName(name);
//            cart.setQuantity(quantity);
//        }
//        session.setAttribute("cart", cart);
//
//        getServletContext().getRequestDispatcher("/firstJsp").forward(request,response);
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1> Your counte is: </h1>");
        out.println("</body></html>");


    }


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

    }
}
