package in.co.pro4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BaseBean;
import in.co.pro4.bean.OrderBean;
import in.co.pro4.bean.PaymentBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.model.OrderModel;
import in.co.pro4.model.PaymentModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.DataValidator;
import in.co.pro4.utility.PropertyReader;
import in.co.pro4.utility.ServletUtility;

@WebServlet(name = "PaymentCtl", urlPatterns = { "/ctl/PaymentCtl" })
public class PaymentCtl extends BaseCtl {
	
	 @Override
	protected boolean validate(HttpServletRequest request) {
		  
		 boolean pass = true;

			if (DataValidator.isNull(request.getParameter("paymentType"))) {
				request.setAttribute("paymentType", PropertyReader.getValue("error.require", "paymentType "));
				pass = false;
			} else if (!DataValidator.isName(request.getParameter("paymentType"))) {
				request.setAttribute("paymentType", "paymentType name must contains alphabet only");
				pass = false;
			}

			if (DataValidator.isNull(request.getParameter("amount"))) {
				request.setAttribute("amount", PropertyReader.getValue("error.require", "amount"));
				pass = false;
			} else if (!DataValidator.isInteger(request.getParameter("amount"))) {
				request.setAttribute("amount", "amount must contains alphabet only");
				pass = false;
			}
			if (DataValidator.isNull(request.getParameter("bankName"))) {
				request.setAttribute("bankName", PropertyReader.getValue("error.require" , "bankName"));
				pass = false;
			} else if (!DataValidator.isName(request.getParameter("bankName"))) {
				request.setAttribute("bankName", " bank Name must contains number only");
				pass = false;
			}if (DataValidator.isNull(request.getParameter("customerName"))) {
				request.setAttribute("customerName", PropertyReader.getValue("error.require" , "customerName"));
				pass = false;
			} else if (!DataValidator.isName(request.getParameter("customerName"))) {
				request.setAttribute("customerName" , "customer Name must contains number only");
				pass = false;
				
			}	if (DataValidator.isNull(request.getParameter("transactionId"))) {
					request.setAttribute("transactionId" , PropertyReader.getValue("error.require", "transactionId"));
					pass = false;
				} else if (!DataValidator.isInteger(request.getParameter("transactionId"))) {
					request.setAttribute("transactionId" , " transaction Id must contains number only");
					pass = false;
				}
			
			return pass;	  
	}
	  
	  @Override
	protected BaseBean populateBean(HttpServletRequest request) {

			PaymentBean bean = new PaymentBean();

			bean.setId(DataUtility.getLong(request.getParameter("id")));
			bean.setPaymentType(DataUtility.getString(request.getParameter("paymentType")));
			bean.setAmount(DataUtility.getInt(request.getParameter("amount")));
			bean.setBankName(DataUtility.getString(request.getParameter("bankName")));
			bean.setTransactionId(DataUtility.getInt(request.getParameter("transactionId")));
			bean.setCustomerName(DataUtility.getString(request.getParameter("customerName")));

			populateDTO(bean, request);

			return bean;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println(op);
		PaymentModel model = new PaymentModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println(id);
		if (id > 0 || op != null) {
			PaymentBean bean;
			try {
				bean = model.findByPK(id);

				System.out.println(bean);
				ServletUtility.setBean(bean, request);
				ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			}
		}

		ServletUtility.forward(getView(), request, response);

	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));

		PaymentModel model = new PaymentModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			PaymentBean bean = (PaymentBean) populateBean(request);
   System.out.println(id);
			if (id > 0) {
				try {
					model.update(bean);
					System.out.println();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage(" Payment is successfully Updated", request);
				ServletUtility.forward(getView(), request, response);

			} else {
				long pk;
				try {
					pk = model.add(bean);
					ServletUtility.setSuccessMessage("Payment is successfully adding", request);
					bean.setId(pk);
					ServletUtility.forward(getView(), request, response);
				} catch (ApplicationException | DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			ServletUtility.forward(getView(), request, response);

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect("PaymentListCtl", request, response);
			return;
		}

		ServletUtility.forward(getView(), request, response);

	
	}

	@Override
	protected String getView() {
		
		return ORSView.PAYMENT_VIEW ;
	}

}
