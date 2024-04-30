<%@page import="in.co.pro4.controller.BankListCtl"%>
<%@page import="in.co.pro4.controller.BankCtl"%>
<%@page import="in.co.pro4.bean.BankBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
  	   <jsp:useBean id="bean" class="in.co.pro4.bean.BankBean"
		scope="request"></jsp:useBean>
		<%@include file = "Header.jsp" %>
	<form action="<%=ORSView.BANK_LIST_CTL%>" method="post">
	

		<center>

			<div align="center">
				<h1>Order List</h1>
				<h3>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>



				<%
					int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;

					List list = ServletUtility.getList(request);
					List list1 = ServletUtility.getList(request);
					Iterator <BankBean>it = list.iterator();

					if (list.size() != 0) {
						
						
				%>
				
				<table width="100%" align="center">
				<tr>
					<th></th>
					<td align="center"><label> Account Name : </label> <input
						type="text" name="accountName" style="width: 231px;"
						placeholder="Enter Account Name"
						value="<%=ServletUtility.getParameter("accountName", request)%>">
						
						&nbsp;&nbsp; <input type="submit" name="operation"
						value="<%=BankListCtl.OP_SEARCH%>"> &nbsp; &nbsp; 
						</td>
						</tr>
						
						
				<table border="1" width="100%" align="center" cellpadding=6px
				cellspacing=".2">
				<tr style="background: orange">
				  <th><input type="checkbox" id="select_all" name="select">Select
						All</th>
						
						<th>S.No.</th>
						<th>AccountName</th>
						<th>Type</th>
						
						<th>Edit</th>
					</tr>
					<%
					 while (it.hasNext()){
						 bean= it.next();
					 %>
					 	<tr align="center">

						<td><input type="checkbox" class="checkbox" name="ids"
							value="<%=bean.getId()%>"></td>
							 
							 	<td><%=index++%></td>
						<td><%=bean.getAccountName()%></td>
						<td><%=bean.getType()%></td>
					
						<td><a href="BankCtl?id=<%=bean.getId()%>">Edit</a></td>
					</tr>
					<%} %>
					<tr>
					<table>
					 <td><input type="submit" name="operation" 
							value="<%=BankCtl.OP_DELETE%>"></td>
						</center>
						</table>
						</tr>
						
								<%}
					              if(list.size()==0){%>	
					              <td align="center">	
			 <input type="submit" name="operation"
							value="<%=BankCtl.OP_BACK%>"> &nbsp; &nbsp;
						</td>
						<%} %>
					</tr>
				</table>
				<br>

			
					
				
					
					
			
				</table>


				</table>
		

				
	</form>
	</br>
	</br>
	</br>
	</br>

	</center>

	<%@include file="Footer.jsp"%>

  
</body>
</html>