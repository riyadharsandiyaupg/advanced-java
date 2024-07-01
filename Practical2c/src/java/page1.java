
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class page1 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page1</title>");            
            out.println("</head>");
            out.println("<body bgcolor=yellow>");
            HttpSession hs=request.getSession(true);
            if(hs.isNew())
            {
               
                String name=request.getParameter("uname");
                hs.setAttribute("uname", name);
                hs.setAttribute("visit","1");
                out.println("<h1>Welcome First Time "+hs.getAttribute("uname")+"</h1>");
            }
            else
            {
                out.println("<h1>Welcome Again "+hs.getAttribute("uname")+"</h1>");
                int visit=Integer.parseInt((String)hs.getAttribute("visit"))+1;
                out.println("<h1>You visited "+visit+" Times</h1>");
                hs.setAttribute("visit",""+visit);
            }
            out.println("<h1>Your session id is "+hs.getId()+"</h1>");
            out.println("<h1>You logged in at "+new java.util.Date(hs.getCreationTime())+"</h1>");
            out.println();
            out.println("<a href=page2>Click here to visit page2</a><br />");
            out.println("<a href=page3>Click here to visit page3</a> <br />");
            out.println("<a href=page4>Click here to visit page4</a> <br />");
            out.println("<a href=LogoutServlet>Click here to terminate</a> <br />");
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
