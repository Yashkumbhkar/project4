<%@page import="in.co.pro4.controller.PaymentCtl"%>
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
	<jsp:useBean id="bean" class="in.co.pro4.bean.PaymentBean"
		scope="request"></jsp:useBean>


	<%@include file="Header.jsp"%>

	<center>

		<form action="<%=ORSView.PAYMENT_CTL%>" method="post">

			<div align="center">
				<h1>

					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<tr>
						<th><font size="5px"> Update Payment </font></th>
					</tr>
					<%
						} else {
					%>
					<tr>
						<th><font size="5px"> Payment Add</font></th>
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
					<th align="left">PaymentType<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="paymentType"
						placeholder="Enter Shop Name" size="25"
						value="<%=DataUtility.getStringData(bean.getPaymentType())%>"></td>

					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("paymentType", request)%></font></td>

				</tr>

				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">Amount<span style="color: red">*</span> :
					</th>

					<td><input type="text" name="amount"
						placeholder="Enter  Amount " size="25"
						value = "<%=DataUtility.getStringData(bean.getAmount()).equals("0")? ""
								: DataUtility.getStringData(bean.getAmount())%>"></td>
							

					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("amount", request)%></font></td>
				</tr>
				<tr>
					<th align="left">BankName<span style="color: red">*</span> :
					</th>

					<td><input type="text" name="bankName" placeholder="Enter Bank Name"
						size="25"
						value="<%=DataUtility.getStringData(bean.getBankName())%>"></td>
					
											<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("bankName",request)%></font></td>
				</tr>
                            	<tr>
					<th align="left">CustomerName<span style="color: red">*</span> :
					</th>

					<td><input type="text" name="customerName" placeholder="Enter customer Name"
						size="25"
						value="<%=DataUtility.getStringData(bean.getCustomerName())%>"></td>
					
											<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("customerName", request)%></font></td>
				</tr>	<tr>
					<th align="left">TransactionId<span style="color: red">*</span> :
					</th>

					<td><input type="text" name="transactionId" placeholder="Enter transactionId "
						size="25"
						value="<%=DataUtility.getStringData(bean.getTransactionId()).equals("0") ? "" : DataUtility.getStringData(bean.getTransactionId())%>"></td>
					
											<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("transactionId", request)%></font></td>
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
						name="operation" value="<%=PaymentCtl.OP_UPDATE%>"> &nbsp;
						&nbsp; <input type="submit" name="operation"
						value="<%=PaymentCtl.OP_CANCEL%>"></td>



					<%
						} else {
					%>

					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation" value="<%=PaymentCtl.OP_SAVE%>"> &nbsp;
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