<%@page import="in.co.pro4.controller.TopicCtl"%>
<%@page import="in.co.pro4.utility.DataUtility"%>
<%@page import="in.co.pro4.utility.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   
    <jsp:useBean id="bean" class="in.co.pro4.bean.TopicBean"
		scope="request"></jsp:useBean>


	<%@include file="Header.jsp"%>

	<center>

		<form action="<%=ORSView.TOPIC_CTL%>" method="post">

			<div align="center">
				<h1>

					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<tr>
						<th><font size="5px"> Topic Update </font></th>
					</tr>
					<%
						} else {
					%>
					<tr>
						<th><font size="5px"> Topic Add</font></th>
					</tr>
					<%
						}
					%>
				</h1>

				<h3>
					<font color="red"> <%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"> <%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>

			</div>
			<input type="hidden" name="id" value="<%=bean.getId()%>">


			<table>
				<tr>
					<th align="left">Name<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="name"
						placeholder="Enter  Name" size="25"
						value="<%=DataUtility.getStringData(bean.getName())%>"></td>
						
					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("name", request)%></font></td>

				</tr>
				

				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">Description<span style="color: red">*</span> :
					</th>

					<td><input type="text" name="destruction"
						placeholder="Enter Description" size="25"
						value="<%=DataUtility.getStringData(bean.getDestruction())%>"></td>

					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("destruction", request)%></font></td>
				</tr>
				
				</tr>

				<tr>
					<th style="padding: 3px"></th>
				</tr>



				<tr>
					<th></th>
					<%
						if (bean.getId() > 0) {
					%>
					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation" value="<%=TopicCtl.OP_UPDATE%>"> &nbsp;
						&nbsp; <input type="submit" name="operation"
						value="<%=TopicCtl.OP_CANCEL%>"></td>
			


					<%
						} else {
					%>

					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation" value="<%=TopicCtl.OP_SAVE%>"> &nbsp;
						&nbsp; <%-- <input type="submit" name="operation" value="<%=BankCtl.OP_RESET%>"> --%></td>

					<%
						}
					%>
				</tr>
			</table>
		</form>
	</center>

	<%@ include file="Footer.jsp"%>

    
</body>
</html>