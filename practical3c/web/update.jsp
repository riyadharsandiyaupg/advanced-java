<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@page import="java.io.*,java.util.*,java.sql.*"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <div>Update record</div>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="root" />
        <sql:query dataSource="${dbsource}" var="result">
            SELECT * FROM product_details_19 where pid=?;<sql:param value="${param.pid}"/>
        </sql:query>
            
            <form action="updateDb.jsp" method="post">
                <table border="1">
                    <tr>
                        <th>Product Name:</th>
                        <th>Product quantity</th>
                    </tr>
                    <tr>
                        <c:forEach var="row" items="${result.rows}">
                        <tr>
                            <td><input type="hidden" value="${param.pid}" name="pid"/>
                            <input type="text" value="${row.pname}" name="pname"/>
                            </td>
                            <td><input type="text"value="${row.quantity}" name="quantity"/></td>
                            <td><input type="submit" value="update"/></td>
                        </tr>
                        </c:forEach>
                    </tr>
                </table>
                <a href="index.html">Go Back</a>
            </form>
    </body>
</html>
