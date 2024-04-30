package in.co.pro4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BaseBean;
import in.co.pro4.bean.LessionBean;
import in.co.pro4.bean.OrderBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.model.LessionModel;
import in.co.pro4.model.OrderModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.DataValidator;
import in.co.pro4.utility.PropertyReader;
import in.co.pro4.utility.ServletUtility;

@WebServlet(name = "LessionCtl", urlPatterns = { "/ctl/LessionCtl" })
public class LessionCtl  extends BaseCtl{
	
	 @Override
	protected boolean validate(HttpServletRequest request) {
		 
		  boolean pass  = true;

			if (DataValidator.isNull(request.getParameter("name"))) {
				request.setAttribute("name", PropertyReader.getValue("error.require", "name "));
				pass = false;
			} else if (!DataValidator.isName(request.getParameter("name"))) {
				request.setAttribute("name", "Name must contains alphabet only");
				pass = false;
			}
			return pass;

			
			}
	 
	  @Override
	protected BaseBean populateBean(HttpServletRequest request) {
	
			LessionBean bean = new LessionBean();

			bean.setId(DataUtility.getLong(request.getParameter("id")));
			bean.setName(DataUtility.getString(request.getParameter("name")));
			return bean;

	  }
	 
	  
	   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String op = DataUtility.getString(request.getParameter("operation"));
			System.out.println(op);
			LessionModel model = new LessionModel();
			long id = DataUtility.getLong(request.getParameter("id"));
			System.out.println(id);
			if (id > 0 || op != null) {
				LessionBean bean;
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

			LessionModel model = new LessionModel();
			if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

				LessionBean bean = (LessionBean) populateBean(request);

				if (id > 0) {

					try {
						model.update(bean);
						ServletUtility.setBean(bean, request);
						ServletUtility.setSuccessMessage("Lession is successfully Updated", request);
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
						ServletUtility.setSuccessMessage("Lession is successfully adding", request);
						bean.setId(pk);
						ServletUtility.forward(getView(), request, response);
					} catch (ApplicationException | DuplicateRecordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				ServletUtility.forward(getView(), request, response);

			} else if (OP_CANCEL.equalsIgnoreCase(op)) {
				ServletUtility.redirect("LessionListCtl", request, response);
				return;
			}

			ServletUtility.forward(getView(), request, response);


	    }

	@Override
	protected String getView() {
		
		return ORSView.LESSION_VIEW ;
	}

}
