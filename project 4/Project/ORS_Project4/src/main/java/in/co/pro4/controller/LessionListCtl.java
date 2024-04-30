package in.co.pro4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BankBean;
import in.co.pro4.bean.BaseBean;
import in.co.pro4.bean.LessionBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.model.BankModel;
import in.co.pro4.model.LessionModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.ServletUtility;

 @WebServlet(name = "LessionListCtl", urlPatterns = { "/ctl/LessionListCtl" })
public class LessionListCtl extends BaseCtl{
	
	
	
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
				 
						   
			LessionBean bean = new LessionBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
			bean.setName(DataUtility.getString(request.getParameter("name")));
							return bean;
			}
			 

	
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 

		  List list = null;
			

			int pageNo = 1;

			int pageSize =10 ;

			LessionBean bean = (LessionBean) populateBean(request);
			String op = DataUtility.getString(request.getParameter("operation"));


			LessionModel model = new LessionModel();

			try {
				list = model.search(bean, pageNo, pageSize);
			
            
				ServletUtility.setList(list, request);
				ServletUtility.setPageNo(pageNo, request);
				ServletUtility.setPageSize(pageSize, request);
			/* ServletUtility.forward(getView(), request, response); */

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
					
			List list;
					

					int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
					int pageSize = DataUtility.getInt(request.getParameter("pageSize"));
					pageNo = (pageNo == 0) ? 1 : pageNo;

					pageSize = (pageSize == 0) ? 10 : pageSize;
					String op = DataUtility.getString(request.getParameter("operation"));
					LessionBean bean = (LessionBean) populateBean(request);
					
					String[] ids = request.getParameterValues("ids");
					LessionModel model = new LessionModel();
					
					if (OP_SEARCH.equalsIgnoreCase(op)) {
						System.out.println("qwerty");
						pageNo =1;
					}
						System.out.println("Reset chli");
					if (OP_DELETE.equalsIgnoreCase(op)) {
						pageNo = 1;
						if (ids != null && ids.length > 0) {
							LessionBean delete = new LessionBean();
							for (String id : ids) {
								delete.setId(DataUtility.getInt(id));
								try {
									model.delete(delete);
								} catch (ApplicationException e) {
									ServletUtility.handleException(e, request, response);
									return;
								}

								ServletUtility.setSuccessMessage("Lesion is Deleted Successfully", request);
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
	protected String getView() {
		// TODO Auto-generated method stub
		return  ORSView.LESSION_LIST_VIEW ;
	}

}
