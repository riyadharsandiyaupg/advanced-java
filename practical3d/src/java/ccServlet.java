import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mybeans.CCBean;

@WebServlet(urlPatterns = {"/ccServlet"})
public class ccServlet extends HttpServlet {
    @EJB
    CCBean obj;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ccServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            double amount=Double.parseDouble(request.getParameter("amount"));
            if(request.getParameter("currency").equals("rtod"))
            {
                double res=obj.r2Dollar(amount);
                out.println("Rupee "+amount+" to dollar "+res);
            }
            else
            {
                double res=obj.d2Rupees(amount);
                out.println("Dollar "+amount+" to Rupees "+res);
            }
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
