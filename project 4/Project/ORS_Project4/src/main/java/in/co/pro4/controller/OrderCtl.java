package in.co.pro4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BaseBean;
import in.co.pro4.bean.OrderBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.model.OrderModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.DataValidator;
import in.co.pro4.utility.PropertyReader;
import in.co.pro4.utility.ServletUtility;

@WebServlet(name = "OrderCtl", urlPatterns = { "/ctl/OrderCtl" })
public class OrderCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("shop"))) {
			request.setAttribute("shop", PropertyReader.getValue("error.require", "shop Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("shop"))) {
			request.setAttribute("shop", "Shop name must contains alphabet only");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("type"))) {
			request.setAttribute("type", PropertyReader.getValue("error.require", "type"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("type"))) {
			request.setAttribute("type", "type must contains alphabet only");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("price"))) {
			request.setAttribute("price", PropertyReader.getValue("error.require", "price"));
			pass = false;
		} else if (!DataValidator.isInteger(request.getParameter("price"))) {
			request.setAttribute("price", " Price must contains number only");
			pass = false;
		}

		return pass;
	}

	protected BaseBean populateBean(HttpServletRequest request) {

		OrderBean bean = new OrderBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setShop(DataUtility.getString(request.getParameter("shop")));
		bean.setType(DataUtility.getString(request.getParameter("type")));
		bean.setPrice(DataUtility.getInt(request.getParameter("price")));

		populateDTO(bean, request);

		return bean;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println(op);
		OrderModel model = new OrderModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println(id);
		if (id > 0 || op != null) {
			OrderBean bean;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));

		OrderModel model = new OrderModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			OrderBean bean = (OrderBean) populateBean(request);

			if (id > 0) {

				try {
					model.update(bean);
					ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("Order is successfully Updated", request);
					ServletUtility.forward(getView(), request, response);
				} catch (ApplicationException | DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				long pk;
				try {
					pk = model.add(bean);
					ServletUtility.setSuccessMessage("Order is successfully adding", request);
					bean.setId(pk);
					ServletUtility.forward(getView(), request, response);
				} catch (ApplicationException | DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			ServletUtility.forward(getView(), request, response);

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect("OrderListCtl", request, response);
			return;
		}

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {

		return ORSView.ORDER_VIEW;
	}
}