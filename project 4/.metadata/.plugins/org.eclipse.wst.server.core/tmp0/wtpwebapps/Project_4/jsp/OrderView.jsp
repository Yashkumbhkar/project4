<%@page import="in.co.pro4.controller.OrderCtl"%>
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
	<jsp:useBean id="bean" class="in.co.pro4.bean.OrderBean"
		scope="request"></jsp:useBean>


	<%@include file="Header.jsp"%>

	<center>

		<form action="<%=ORSView.ORDER_CTL%>" method="post">

			<div align="center">
				<h1>

					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<tr>
						<th><font size="5px"> Update Order </font></th>
					</tr>
					<%
						} else {
					%>
					<tr>
						<th><font size="5px"> Order Add</font></th>
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
					<th align="left">ShopName<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="shop"
						placeholder="Enter Shop Name" size="25"
						value="<%=DataUtility.getStringData(bean.getShop())%>"></td>

					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("shop", request)%></font></td>

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
				<tr>
					<th align="left">Price<span style="color: red">*</span> :
					</th>

					<td><input type="text" name="price" placeholder="Enter price"
						size="25"
						value="<%=(DataUtility.getStringData(bean.getPrice()).equals("0") ? ""
								: DataUtility.getStringData(bean.getPrice()))%>"></td>

											<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("price", request)%></font></td>
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
						name="operation" value="<%=OrderCtl.OP_UPDATE%>"> &nbsp;
						&nbsp; <input type="submit" name="operation"
						value="<%=OrderCtl.OP_CANCEL%>"></td>



					<%
						} else {
					%>

					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation" value="<%=OrderCtl.OP_SAVE%>"> &nbsp;
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