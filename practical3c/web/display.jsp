<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display</title>
        <script>
            function confirmGo(m,u){  //m-mesage u-record to delete
                if(confirm(m)){
                    window.location=u;
                }
            } 

        </script>
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="root" />
        <sql:query dataSource="${dbsource}" var="result">
            SELECT * FROM product_details_19;
        </sql:query>
            <form>
            <table border="1">
                <tr>
                    <th>ProductID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><c:out value="${row.pid}"></c:out></td>
                        <td><c:out value="${row.pname}"></c:out></td>
                        <td><c:out value="${row.quantity}"></c:out></td>
                        <td><a href="update.jsp?pid=<c:out value="${row.pid}"></c:out>">Update</a></td>
                        <td><a href="javascript:confirmGo('Sure to delete this record?','deleteDb.jsp?pid=<c:out value="${row.pid}" />')">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
                <a href='index.html'>Go home</a>
            </form>
           
    </body>
</html>
