package in.co.pro4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.pro4.bean.BaseBean;
import in.co.pro4.bean.TopicBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.model.TopicModel;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.DataValidator;
import in.co.pro4.utility.PropertyReader;
import in.co.pro4.utility.ServletUtility;

@WebServlet(name = "TopicCtl", urlPatterns = { "/ctl/TopicCtl" })
public class TopicCtl  extends BaseCtl{
	
	
	
	@Override
	protected boolean validate(HttpServletRequest request) {
		
		
		
		   boolean pass = true ;
			  
			  if (DataValidator.isNull(request.getParameter("name"))) {
					request.setAttribute("name", PropertyReader.getValue("error.require", "name"));
					pass = false;
				} else if (!DataValidator.isName(request.getParameter("name"))) {
					request.setAttribute("name", "Name must contains alphabet only");
					pass = false;
				}

				if (DataValidator.isNull(request.getParameter("destruction"))) {
					request.setAttribute("destruction", PropertyReader.getValue("error.require", "destruction"));
					pass = false;
				} else if (!DataValidator.isName(request.getParameter("destruction"))) {
					request.setAttribute("destruction", " destruction must contains alphabet only");
					pass = false;
		}
				return pass;

	
		}
	
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
	
		TopicBean bean = new TopicBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setDestruction(DataUtility.getString(request.getParameter("destruction")));
		return bean;

		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String op = DataUtility.getString(request.getParameter("operation"));
			System.out.println(op);
			TopicModel model = new TopicModel();
			long id = DataUtility.getLong(request.getParameter("id"));
			System.out.println(id);
			if (id > 0 || op != null) {
				TopicBean bean;
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

		TopicModel model = new TopicModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			TopicBean bean = (TopicBean) populateBean(request);

			if (id > 0) {

				try {
					System.out.println(" update hua ");
					model.update(bean);
					ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("Topic is successfully Updated", request);
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
					ServletUtility.setSuccessMessage("Topic is successfully adding", request);
					bean.setId(pk);
					ServletUtility.forward(getView(), request, response);
				} catch (ApplicationException | DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			ServletUtility.forward(getView(), request, response);

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect("TopicListCtl", request, response);
			return;
		}

		ServletUtility.forward(getView(), request, response);

	}


	
	

	@Override
	protected String getView() {
		
			return ORSView.TOPIC_VIEW ;	
			}


}