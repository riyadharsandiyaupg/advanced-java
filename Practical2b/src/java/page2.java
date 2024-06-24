import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class page2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pagr2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<body bgcolor=green>");
            Cookie[] ck=request.getCookies();
            for(int i=0;i<ck.length;i++)
            {
                if(ck[i].getName().equals("visit"))
                {
                    int count=Integer.parseInt(ck[i].getValue())+1;
                    out.println("<h1>Visit No:"+count+"</h1>");
                    ck[i]=new Cookie("visit",count+"");
                    response.addCookie(ck[i]);
                }
                else
                {
                    out.println("Welcome"+ck[i].getValue());
                }
                
            }
            
            out.println("<a href=page3>Click here to visit Page3</a><br>");
            out.println("<a href=page4>Click here to visit Page4</a><br>");
            out.println("<a href=page5>Click here to visit Page5</a><br>");
            out.println("</body>");
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
