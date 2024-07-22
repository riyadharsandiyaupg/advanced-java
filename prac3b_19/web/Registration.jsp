<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //jsp scriptlet
            String name=request.getParameter("name");
            String pass=request.getParameter("pass");
            String repass=request.getParameter("repass");
            String email=request.getParameter("email");
            String country=request.getParameter("country");
            if(pass.equals(repass))
            {
                try
                {
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
                     PreparedStatement pst=conn.prepareStatement("insert into registration_19 value(?,?,?,?)");
                     pst.setString(1,name);
                     pst.setString(2,pass);
                     pst.setString(3,email);
                     pst.setString(4,country);
                     int rows=pst.executeUpdate();
                     if(rows==1)
                     {
                         out.println("Registered succesfully");
                     }
                     else
                     {
                         out.println("Registration failed Try once again");
                         %>
                         <jsp:include page="Registration.html" ></jsp:include>
                         <%
                     }
                }
                catch(Exception e)
                {
                     out.println("Error"+e);
                }
                
            }
            else
            {
                out.println("Password mismatch...Register once again");
        %>
        <jsp:include page="Registration.html"></jsp:include>       
        <%
            }
         %>
    </body>
</html>
