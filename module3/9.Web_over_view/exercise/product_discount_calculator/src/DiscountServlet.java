import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet",urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float price = Float.parseFloat(request.getParameter("price"));
        float percent = Float.parseFloat(request.getParameter("percent"));
        String discount = request.getParameter("discount");

        float total= (float) (price*percent*0.01);
        float priceDiscount = price -total;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description: " + discount+ "</h1>");
        writer.println("<h1>List Price " + price+ "</h1>");
        writer.println("<h1>Discount Percent:  " + percent+ "</h1>");
        writer.println("<h1>Discount Amount: " + total+ "</h1>");
        writer.println("<h1>Discount Price: " + priceDiscount+ "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
