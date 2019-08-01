<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="email" method="post">
 
        <table border="0" width="35%" align="center">
        
            <caption><h2>Create E-mail</h2></caption>
            
            <tr>
                <td width="50%">To </td>
                <td><input type="text" name="to" size="50"/></td>
            </tr>
            
            <tr>
                <td>Subject </td>
                <td><input type="text" name="subject" size="50"/></td>
            </tr>
            
            <tr>
                <td>Content </td>
                <td><textarea rows="10" cols="39" name="msg"></textarea> </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Send"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>