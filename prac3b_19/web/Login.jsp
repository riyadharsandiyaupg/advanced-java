<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
        String name=request.getParameter("name");
        String pass=request.getParameter("pass");
           
         try
         {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");  
            String sql="select * from registration_19 where username=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,name);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                if(rs.getString(2).equals(pass))
                {
                    out.println("Logged in successfully");
                }
                else
                {
                     out.println("Password incorrect");
                    %>
                      <jsp:include page="Login.html" ></jsp:include>
                    <%
                 }
            }
            else
            {
                out.println("Please register");
                %>
                         <jsp:include page="Registration.html" ></jsp:include>
                <%
            }
         }
         catch(Exception e)
         {
             out.println("Exception"+e);
         }
        %>
    </body>
</html>
