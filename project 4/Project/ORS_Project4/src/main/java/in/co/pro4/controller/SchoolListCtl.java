package in.co.pro4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BankBean;
import in.co.pro4.bean.BaseBean;
import in.co.pro4.bean.SchoolBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.model.BankModel;
import in.co.pro4.model.SchoolModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.ServletUtility;

@WebServlet(name = "SchoolListCtl", urlPatterns = { "/ctl/SchoolListCtl" })
public class SchoolListCtl extends BaseCtl {

	
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
	
		
	   SchoolBean bean = new SchoolBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setLocation(DataUtility.getString(request.getParameter("location")));
		return bean;


	}
	 
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  List list = null;
			

			int pageNo = 1;

			int pageSize =10 ;

			SchoolBean bean = (SchoolBean) populateBean(request);
			String op = DataUtility.getString(request.getParameter("operation"));


			SchoolModel model = new SchoolModel();

			try {
				list = model.search(bean, pageNo, pageSize);
			

				ServletUtility.setList(list, request);
				ServletUtility.setPageNo(pageNo, request);
				ServletUtility.setPageSize(pageSize, request);
				
				
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
					SchoolBean bean = (SchoolBean) populateBean(request);
					
					String[] ids = request.getParameterValues("ids");
					SchoolModel model = new SchoolModel();
					System.out.println("qqwerty");
					if (OP_SEARCH.equalsIgnoreCase(op)) {
						System.out.println("qwerty");
						pageNo =1;
					}
						System.out.println("Reset chli");
					if (OP_DELETE.equalsIgnoreCase(op)) {
						pageNo = 1;
						if (ids != null && ids.length > 0) {
							SchoolBean delete = new SchoolBean();
							for (String id : ids) {
								delete.setId(DataUtility.getInt(id));
								try {
									model.delete(delete);
								} catch (ApplicationException e) {
									ServletUtility.handleException(e, request, response);
									return;
								}

								ServletUtility.setSuccessMessage("School is Deleted Successfully", request);
							}
						} else {
							ServletUtility.setErrorMessage("Select at least one record", request);
						}
					}
					try {
						list = model.search(bean, pageNo, pageSize);
						ServletUtility.setList(list, request);
						ServletUtility.setBean(bean, request);
						ServletUtility.setPageNo(pageNo, request);
						ServletUtility.setPageSize(pageSize, request);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();}

				
					
					ServletUtility.forward(getView(), request, response);

				}
			

	
	
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.SCHOOL_LIST_VIEW;
	}

}
