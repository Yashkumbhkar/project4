package in.co.pro4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BaseBean;

import in.co.pro4.bean.PaymentBean;
import in.co.pro4.exception.ApplicationException;

import in.co.pro4.model.PaymentModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.ServletUtility;

@WebServlet(name = "PaymentListCtl", urlPatterns = { "/ctl/PaymentListCtl" })
public class PaymentListCtl  extends BaseCtl {
	 
	 
 @Override
protected BaseBean populateBean(HttpServletRequest request) { 
	   

		PaymentBean bean = new PaymentBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setPaymentType(DataUtility.getString(request.getParameter("paymentType")));
		bean.setBankName(DataUtility.getString(request.getParameter("bankName")));
		bean.setAmount(DataUtility.getInt(request.getParameter("amount")));
		bean.setCustomerName(DataUtility.getString(request.getParameter("customerName")));
		bean.setTransactionId(DataUtility.getInt(request.getParameter("transactionId")));
		return bean;

}
  
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  List list = null;
		List nextList = null;

		int pageNo = 1;

		int pageSize =10 ;

		PaymentBean bean = (PaymentBean) populateBean(request);
		String op = DataUtility.getString(request.getParameter("operation"));


		PaymentModel model = new PaymentModel();

		try {
			list = model.search(bean, pageNo, pageSize);
			System.out.println("list" + list);

			nextList = model.search(bean, pageNo, pageSize);

			request.setAttribute("nextlist", nextList.size());


			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServletUtility.forward(getView(), request, response);
	}
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = null;
		List nextList = null;
		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));
		pageNo = (pageNo == 0) ? 1 : pageNo;

		pageSize = (pageSize == 0) ? 10 : pageSize;
		String op = DataUtility.getString(request.getParameter("operation"));
		PaymentBean bean = (PaymentBean) populateBean(request);
		
		String[] ids = request.getParameterValues("ids");
		PaymentModel model = new PaymentModel();
		

		if (OP_DELETE.equalsIgnoreCase(op)) {
			pageNo = 1;
			if (ids != null && ids.length > 0) {
				PaymentBean delete = new PaymentBean();
				for (String id : ids) {
					delete.setId(DataUtility.getInt(id));
					try {
						model.delete(bean);
					} catch (ApplicationException e) {
						ServletUtility.handleException(e, request, response);
						return;
					}

					ServletUtility.setSuccessMessage("Payment is Deleted Successfully", request);
				}
			} else {
				ServletUtility.setErrorMessage("Select at least one record", request);
			}
		}
		try {

			try {
				list = model.search(bean, pageNo, pageSize);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			nextList = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("nextlist", nextList.size());

		} catch (Exception e) {
			ServletUtility.handleException(e, request, response);
			return;
		}

		ServletUtility.setList(list, request);
		ServletUtility.setBean(bean, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		
		return ORSView.PAYMENT_LIST_VIEW;
	}

}
