<%@page import="in.co.pro4.controller.BaseCtl"%>
<%@page import="in.co.pro4.controller.BankCtl"%>
<%@page import="in.co.pro4.bean.BankBean"%>
<%@page import="in.co.pro4.utility.ServletUtility"%>
<%@page import="in.co.pro4.utility.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bean" class="in.co.pro4.bean.BankBean"
		scope="request"></jsp:useBean>


	<%@include file="Header.jsp"%>

	<center>

		<form action="<%=ORSView.BANK_CTL%>" method="post">

			<div align="center">
				<h1>

					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<tr>
						<th><font size="5px"> Update Bank </font></th>
					</tr>
					<%
						} else {
					%>
					<tr>
						<th><font size="5px"> Bank Add</font></th>
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
					<th align="left">AccountName<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="accountName"
						placeholder="Enter Account Name" size="25"
						value="<%=DataUtility.getStringData(bean.getAccountName())%>"></td>

					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("accountName", request)%></font></td>

				</tr>

				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">Type<span style="color: red">*</span> :
					</th>

					<td><input type="text" name="type"
						placeholder="Enter order type" size="25"
						value="<%=DataUtility.getStringData(bean.getType())%>"></td>

					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("type", request)%></font></td>
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
						name="operation" value="<%=BankCtl.OP_UPDATE%>"> &nbsp;
						&nbsp; <input type="submit" name="operation"
						value="<%=BankCtl.OP_CANCEL%>"></td>
			


					<%
						} else {
					%>

					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation" value="<%=BankCtl.OP_SAVE%>"> &nbsp;
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