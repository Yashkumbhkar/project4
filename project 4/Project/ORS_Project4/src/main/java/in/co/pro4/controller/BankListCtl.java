package in.co.pro4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BankBean;
import in.co.pro4.bean.BaseBean;
import in.co.pro4.bean.OrderBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.model.BankModel;
import in.co.pro4.model.OrderModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.ServletUtility;

@WebServlet(name = "BankListCtl", urlPatterns = { "/ctl/BankListCtl" })
public class BankListCtl  extends BaseCtl{
	
	 private static final String Bank_List_Ctl = null;


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
	  
		  List list = null;
			

			int pageNo = 1;

			int pageSize =10 ;

			BankBean bean = (BankBean) populateBean(request);
			String op = DataUtility.getString(request.getParameter("operation"));


			BankModel model = new BankModel();

			try {
				list = model.search(bean, pageNo, pageSize);
			

				ServletUtility.setList(list, request);
				ServletUtility.setPageNo(pageNo, request);
				ServletUtility.setPageSize(pageSize, request);
				
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			}
			
			ServletUtility.forward(getView(), request, response);
		}
	 
	   
	   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		     
			List list;
			

			int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
			int pageSize = DataUtility.getInt(request.getParameter("pageSize"));
			pageNo = (pageNo == 0) ? 1 : pageNo;

			pageSize = (pageSize == 0) ? 10 : pageSize;
			String op = DataUtility.getString(request.getParameter("operation"));
			BankBean bean = (BankBean) populateBean(request);
			
			String[] ids = request.getParameterValues("ids");
			BankModel model = new BankModel();
			System.out.println("qqwerty");
			if (OP_SEARCH.equalsIgnoreCase(op)) {
				System.out.println("qwerty");
				pageNo =1;
			}
				System.out.println("Reset chli");
			if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					BankBean delete = new BankBean();
					for (String id : ids) {
						delete.setId(DataUtility.getInt(id));
						try {
							model.delete(delete);
						} catch (ApplicationException e) {
							ServletUtility.handleException(e, request, response);
							return;
						}

						ServletUtility.setSuccessMessage("Bank is Deleted Successfully", request);
					}
				} else {
					ServletUtility.setErrorMessage("Select at least one record", request);
				}
			}
			try {
System.out.println("qwertyuio");
				list = model.search(bean, pageNo, pageSize);




			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			}
System.out.println("qwertyui");
			ServletUtility.setList(list, request);
			ServletUtility.setBean(bean, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			
			ServletUtility.forward(getView(), request, response);

		}
	

	@Override
	protected String getView() {
		
		return  ORSView.BANK_LIST_VIEW;
	}

}
