<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		 <%@include file="header.jsp" %>
	<spring:form action="employee" method="post" modelAttribute="emodel">
		<table>

			<tr>
				<td>FirstName</td>
				<td><spring:input path="fname" /></td>

			</tr>
			<tr>
				<td>LastName</td>
				<td><spring:input path="lname" /></td>

			</tr>
			<tr>
				<td>dob</td>
				<td><spring:input path="dob" type="date" /></td>

			</tr>
			<tr>
				<td>Post</td>
				<td><spring:input path="post" /></td>

			</tr>
			<tr>
				<td>JoiningDate</td>
				<td><spring:input path="joindDate" type="date"/></td>

			</tr>
			<tr>
				<td>Salary</td>
				<td><spring:input path="salary"  required="true"/></td>

			</tr>
			<tr>
				<td>Gender</td>
				<td>
				<spring:radiobutton path="gender" value="male"/>Male
				<spring:radiobutton path="gender" value="female"/>Female
				
				</td>

			</tr>
			<tr>
				<td>Company</td>
				<td><spring:input path="company" /></td>

			</tr>
			<tr>
				<td>Email</td>
				<td><spring:input path="email" /></td>

			</tr>
			<tr>
				<td>Address</td>
				<td><spring:input path="address.country" /></td>

			</tr>
			<tr>
				<td>State</td>
				<td><spring:input path="address.state" /></td>

			</tr>
			<tr>
				<td>Zip</td>
				<td>
				<spring:select path="address.state">
				<spring:option value="">Select</spring:option>
				<spring:option value="1">State-1</spring:option>
				<spring:option value="2">State-2</spring:option>
				<spring:option value="3">State-3</spring:option>
				<spring:option value="4">State-4</spring:option>
				<spring:option value="5">State-5</spring:option>
				<spring:option value="6">State-6</spring:option>
				<spring:option value="7">State-7</spring:option>
				</spring:select>
				
				</td>

			</tr>
			<tr>
				<td>City</td>
				<td><spring:input path="address.city" /></td>

			</tr>

			</tr>
			<tr>

				<td><input type="submit" value="Save" ></td>

			</tr>


		</table>

	</spring:form>

</body>
</html>