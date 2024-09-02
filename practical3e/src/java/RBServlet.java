import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import mybean.RRBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/RBServlet"})
public class RBServlet extends HttpServlet {

    @EJB
    RRBean obj;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RBServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String customer_name=request.getParameter("name");
            String customer_mobile=request.getParameter("mob");
            String roomType=request.getParameter("roomtype");
            String msg=obj.roombooking(customer_name,customer_mobile,roomType);
            out.print(msg);
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
