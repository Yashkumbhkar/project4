package in.co.pro4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BaseBean;
import in.co.pro4.bean.OrderBean;
import in.co.pro4.bean.UserBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.model.OrderModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.PropertyReader;
import in.co.pro4.utility.ServletUtility;

@WebServlet(name = "OrderListCtl", urlPatterns = { "/ctl/OrderListCtl" })
public class OrderListCtl extends BaseCtl {

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		OrderBean bean = new OrderBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setShop(DataUtility.getString(request.getParameter("shop")));
		bean.setType(DataUtility.getString(request.getParameter("type")));
		bean.setPrice(DataUtility.getInt(request.getParameter("price")));
		return bean;

	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List list = null;
		List nextList = null;

		int pageNo = 1;

		int pageSize =10 ;

		OrderBean bean = (OrderBean) populateBean(request);
		String op = DataUtility.getString(request.getParameter("operation"));


		OrderModel model = new OrderModel();

		try {
			list = model.search(bean, pageNo, pageSize);
			System.out.println("list" + list);

			nextList = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("nextlist", nextList.size());


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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list;
		List nextList = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));
		pageNo = (pageNo == 0) ? 1 : pageNo;

		pageSize = (pageSize == 0) ? 10 : pageSize;
		String op = DataUtility.getString(request.getParameter("operation"));
		OrderBean bean = (OrderBean) populateBean(request);
		
		String[] ids = request.getParameterValues("ids");
		OrderModel model = new OrderModel();
		

		if (OP_DELETE.equalsIgnoreCase(op)) {
			pageNo = 1;
			if (ids != null && ids.length > 0) {
				OrderBean delete = new OrderBean();
				for (String id : ids) {
					delete.setId(DataUtility.getInt(id));
					try {
						model.delete(delete);
					} catch (ApplicationException e) {
						ServletUtility.handleException(e, request, response);
						return;
					}

					ServletUtility.setSuccessMessage("Order is Deleted Successfully", request);
				}
			} else {
				ServletUtility.setErrorMessage("Select at least one record", request);
			}
		}
		try {

			list = model.search(bean, pageNo, pageSize);

			nextList = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("nextlist", nextList.size());

		} catch (ApplicationException e) {
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
		return ORSView.ORDER_LIST_VIEW;
	}


}


