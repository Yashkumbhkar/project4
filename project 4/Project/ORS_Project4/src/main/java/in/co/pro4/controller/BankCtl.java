package in.co.pro4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BankBean;
import in.co.pro4.bean.BaseBean;
import in.co.pro4.bean.OrderBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.model.BankModel;
import in.co.pro4.model.OrderModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.DataValidator;
import in.co.pro4.utility.PropertyReader;
import in.co.pro4.utility.ServletUtility;

@WebServlet(name = "BankCtl", urlPatterns = { "/ctl/BankCtl" })
public class BankCtl  extends BaseCtl{
	 
	  @Override
	protected boolean validate(HttpServletRequest request) {
		  
		   boolean pass = true ;
	  
		  if (DataValidator.isNull(request.getParameter("accountName"))) {
				request.setAttribute("accountName", PropertyReader.getValue("error.require", "account name "));
				pass = false;
			} else if (!DataValidator.isName(request.getParameter("accountName"))) {
				request.setAttribute("accountName", " AccountName name must contains alphabet only");
				pass = false;
			}

			if (DataValidator.isNull(request.getParameter("type"))) {
				request.setAttribute("type", PropertyReader.getValue(" error.require", "type"));
				pass = false;
			} else if (!DataValidator.isName(request.getParameter("type"))) {
				request.setAttribute("type", " type must contains alphabet only");
				pass = false;
	}
			return pass;
	  }
	   
	   @Override
	protected BaseBean populateBean(HttpServletRequest request) {
		 

				BankBean bean = new BankBean();

				bean.setId(DataUtility.getLong(request.getParameter("id")));
				bean.setAccountName(DataUtility.getString(request.getParameter("accountName")));
				bean.setType(DataUtility.getString(request.getParameter("type")));
				return bean;
	}
	   
	   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String op = DataUtility.getString(request.getParameter("operation"));
			System.out.println(op);
			BankModel model = new BankModel();
			long id = DataUtility.getLong(request.getParameter("id"));
			System.out.println(id);
			if (id > 0 || op != null) {
				BankBean bean;
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

			BankModel model = new BankModel();
			if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

				BankBean bean = (BankBean) populateBean(request);

				if (id > 0) {

					try {
						System.out.println(" update hua ");
						model.update(bean);
						ServletUtility.setBean(bean, request);
						ServletUtility.setSuccessMessage("Bank is successfully Updated", request);
						ServletUtility.forward(getView(), request, response);
					} catch (ApplicationException | DuplicateRecordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					long pk;
					try {
						pk = model.add(bean);
						ServletUtility.setSuccessMessage("Bank is successfully adding", request);
						bean.setId(pk);
						ServletUtility.forward(getView(), request, response);
					} catch (ApplicationException | DuplicateRecordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				ServletUtility.forward(getView(), request, response);

			} else if (OP_CANCEL.equalsIgnoreCase(op)) {
				ServletUtility.redirect("BankListCtl", request, response);
				return;
			}

			ServletUtility.forward(getView(), request, response);

		}

	    		    

	    
	    
	@Override
	protected String getView() {
		
		return ORSView.BANK_CTL_VIEW;
	}

}
