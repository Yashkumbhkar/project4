/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2024-01-27 11:27:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import in.co.pro4.controller.SubjectListCtl;
import in.co.pro4.utility.HTMLUtility;
import java.util.Iterator;
import in.co.pro4.bean.SubjectBean;
import in.co.pro4.bean.CourseBean;
import java.util.List;
import in.co.pro4.utility.DataUtility;
import in.co.pro4.utility.ServletUtility;
import in.co.pro4.controller.ORSView;
import in.co.pro4.bean.RoleBean;
import in.co.pro4.controller.LoginCtl;
import in.co.pro4.controller.ORSView;
import in.co.pro4.bean.UserBean;

public final class SubjectListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/jsp/Footer.jsp", Long.valueOf(1672996946000L));
    _jspx_dependants.put("/jsp/Header.jsp", Long.valueOf(1701344018559L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("in.co.pro4.bean.CourseBean");
    _jspx_imports_classes.add("in.co.pro4.bean.SubjectBean");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("in.co.pro4.controller.ORSView");
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("in.co.pro4.bean.UserBean");
    _jspx_imports_classes.add("in.co.pro4.utility.DataUtility");
    _jspx_imports_classes.add("in.co.pro4.utility.ServletUtility");
    _jspx_imports_classes.add("in.co.pro4.controller.SubjectListCtl");
    _jspx_imports_classes.add("in.co.pro4.bean.RoleBean");
    _jspx_imports_classes.add("in.co.pro4.controller.LoginCtl");
    _jspx_imports_classes.add("in.co.pro4.utility.HTMLUtility");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/img/Raysicon.png\" sizes=\"16*16\" />\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/js/Checkbox11.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Subject List</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      in.co.pro4.bean.SubjectBean bean = null;
      bean = (in.co.pro4.bean.SubjectBean) _jspx_page_context.getAttribute("bean", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (bean == null){
        bean = new in.co.pro4.bean.SubjectBean();
        _jspx_page_context.setAttribute("bean", bean, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/img/Raysicon.png\" sizes=\"16*16\" />\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Header</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

		UserBean userBean = (UserBean) session.getAttribute("user");
		boolean userLoggedIn = userBean != null;
		String welcomeMsg = "Hi, ";
		if (userLoggedIn) {
			String role = (String) session.getAttribute("role");
			welcomeMsg += userBean.getFirstName() + " (" + role + ")";
		} else {
			welcomeMsg += "Guest";
		}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<table style=\"font-size: 18px\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th></th>\r\n");
      out.write("			<td width=\"90%\">\r\n");
      out.write("			<a href=\"");
      out.print(ORSView.WELCOME_CTL);
      out.write("\">Welcome</a> | \r\n");
      out.write("			");

				if (userLoggedIn) {
			
      out.write(" \r\n");
      out.write("			<a href=\" ");
      out.print(ORSView.LOGIN_CTL);
      out.write("?operation=");
      out.print(LoginCtl.OP_LOG_OUT);
      out.write("\">Logout</a>\r\n");
      out.write("			");

				} else {
			
      out.write("\r\n");
      out.write("			 <a href=\"");
      out.print(ORSView.LOGIN_CTL);
      out.write("\">Login</a>\r\n");
      out.write("		    ");

 				}
 			
      out.write("\r\n");
      out.write(" 			</td>\r\n");
      out.write("			<td rowspan=\"2\">\r\n");
      out.write("				<h1 align=\"right\">\r\n");
      out.write("					<img src=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/img/RaysLogo.png\" width=\"140\" height=\"50\">\r\n");
      out.write("				</h1>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th></th>\r\n");
      out.write("			<td>\r\n");
      out.write("				<h3>");
      out.print(welcomeMsg);
      out.write("</h3>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("\r\n");
      out.write("		");

			if (userLoggedIn) {
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th></th>\r\n");
      out.write("			<td colspan=\"2\">\r\n");
      out.write("				<font> \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.MY_PROFILE_CTL);
      out.write("\">MyProfile</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.CHANGE_PASSWORD_CTL);
      out.write("\">Change Password</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.GET_MARKSHEET_CTL);
      out.write("\">Get Marksheet</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\">Marksheet Merit List</a> | \r\n");
      out.write("					\r\n");
      out.write("					");

					if (userBean.getRoleId() == RoleBean.ADMIN) {
					
      out.write(" \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\">Add Marksheet</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\">Marksheet List</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.USER_CTL);
      out.write("\">Add User</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.USER_LIST_CTL);
      out.write("\">User List</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.COLLEGE_CTL);
      out.write("\">Add College</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.ROLE_CTL);
      out.write("\">Add Role</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.ROLE_LIST_CTL);
      out.write("\">Role List</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\">Add Student</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.COURSE_CTL);
      out.write("\">Add Course</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.SUBJECT_CTL);
      out.write("\">Add Subject</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.FACULTY_CTL);
      out.write("\">Add Faculty</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\">Faculty List</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.TIMETABLE_CTL);
      out.write("\">Add Time Table</a> | \r\n");
      out.write("					<a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">Time Table List</a> | \r\n");
      out.write("					\r\n");
      out.write("					<a target=\"blank\" href=\"");
      out.print(ORSView.JAVA_DOC_VIEW);
      out.write("\">Java Doc</a> \r\n");
      out.write("					");

 						}
 					
      out.write(" \r\n");
      out.write(" 					");

 					if (userBean.getRoleId() == RoleBean.STUDENT) {
 					
      out.write(" \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\">Faculty List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">Time Table List</a> |\r\n");
      out.write(" 					");

 						}
 					
      out.write(" \r\n");
      out.write(" 					");

 					if (userBean.getRoleId() == RoleBean.KIOSK) {
 					
      out.write(" \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</b></a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">Time Table List</b></a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</b></a> |\r\n");
      out.write(" 					");

 						}
 					
      out.write("\r\n");
      out.write(" 					");

 					if (userBean.getRoleId() == RoleBean.FACULTY) {
 					
      out.write(" \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\">Add Marksheet</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\">Marksheet List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\">Add Student</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.SUBJECT_CTL);
      out.write("\">Add Subject</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.TIMETABLE_CTL);
      out.write("\">Add Time Table</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">Time Table List</a> |\r\n");
      out.write(" 					");

 						}
 					
      out.write(" \r\n");
      out.write(" 					");

 					if (userBean.getRoleId() == RoleBean.COLLEGE_SCHOOL) {
 					
      out.write(" \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\">Add Marksheet</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\">Marksheet List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\">Add Student</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\">Faculty List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">Time Table List</a> | \r\n");
      out.write(" 					<a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</a> | \r\n");
      out.write(" 					");

 						}
 					
      out.write("\r\n");
      out.write("				</font>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");

			}
		
      out.write("\r\n");
      out.write("	</table>\r\n");
      out.write("	<hr><!-- horizontal rule -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	<div align=\"center\">\r\n");
      out.write("		<h1 align=\"center\" style=\"margin-bottom: -15; color: navy;\">Subject List</h1>\r\n");
      out.write("\r\n");
      out.write("		<div style=\"height: 15px; margin-bottom: 12px\">\r\n");
      out.write("			<h3>\r\n");
      out.write("				<font color=\"red\">\r\n");
      out.write("					");
      out.print(ServletUtility.getErrorMessage(request));
      out.write("\r\n");
      out.write("				</font>\r\n");
      out.write("			</h3>\r\n");
      out.write("			<h3>\r\n");
      out.write("				<font color=\"green\">\r\n");
      out.write("					");
      out.print(ServletUtility.getSuccessMessage(request));
      out.write("\r\n");
      out.write("				</font>\r\n");
      out.write("			</h3>\r\n");
      out.write("		</div>\r\n");
      out.write("		<form action=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("			");

				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;
				int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());

				@SuppressWarnings("unchecked")
				List<CourseBean> clist = (List<CourseBean>) request.getAttribute("courseList");
				@SuppressWarnings("unchecked")
				List<SubjectBean> slist = (List<SubjectBean>) request.getAttribute("subjectList");
				@SuppressWarnings("unchecked")
				List<SubjectBean> list = (List<SubjectBean>) ServletUtility.getList(request);
				Iterator<SubjectBean> it = list.iterator();

				if (list.size() != 0) {
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<input type=\"hidden\" name=\"pageNo\" value=\"");
      out.print(pageNo);
      out.write("\">\r\n");
      out.write("			<input type=\"hidden\" name=\"pageSize\" value=\"");
      out.print(pageSize);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("			<table style=\"width: 100%\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td align=\"center\">\r\n");
      out.write("						<label><b>Subject Name :</b></label> \r\n");
      out.write("						");
      out.print(HTMLUtility.getList("subjectId", String.valueOf(bean.getId()), slist));
      out.write("\r\n");
      out.write("					&emsp;\r\n");
      out.write("					\r\n");
      out.write("						<label><b>Course Name :</b></label> \r\n");
      out.write("						");
      out.print(HTMLUtility.getList("courseId", String.valueOf(bean.getCourseId()), clist));
      out.write("\r\n");
      out.write("					&emsp;\r\n");
      out.write("					\r\n");
      out.write("						<input type=\"submit\" \r\n");
      out.write("								name=\"operation\" \r\n");
      out.write("								value=\"");
      out.print(SubjectListCtl.OP_SEARCH);
      out.write("\">\r\n");
      out.write("					&nbsp; \r\n");
      out.write("						\r\n");
      out.write("						<input type=\"submit\" \r\n");
      out.write("								name=\"operation\" \r\n");
      out.write("								value=\"");
      out.print(SubjectListCtl.OP_RESET);
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("			<br>\r\n");
      out.write("\r\n");
      out.write("			<table border=\"1\" width=\"100%\" align=\"center\" cellpadding=6px cellspacing=\".2\">\r\n");
      out.write("				<tr style=\"background: #0FFAAD;\">\r\n");
      out.write("					<th>\r\n");
      out.write("						<input type=\"checkbox\" \r\n");
      out.write("								id=\"select_all\" \r\n");
      out.write("								name=\"select\"\r\n");
      out.write("								");
if (userBean.getRoleId() == RoleBean.STUDENT) {
      out.write("\r\n");
      out.write("								");
      out.print("disabled");
      out.write(' ');
}
      out.write("> Select All.\r\n");
      out.write("					</th>\r\n");
      out.write("					<th width=\"5%\">S.No</th>\r\n");
      out.write("					<th width=\"30%\">Subject Name</th>\r\n");
      out.write("					<th width=\"15%\">Course Name</th>\r\n");
      out.write("					<th width=\"40%\">Description</th>\r\n");
      out.write("					<th width=\"5%\">Edit</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				");

					while (it.hasNext()) {
							bean = it.next();
				
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"checkbox\" \r\n");
      out.write("							   class=\"checkbox\" \r\n");
      out.write("							   name=\"ids\"\r\n");
      out.write("							   value=\"");
      out.print(bean.getId());
      out.write("\"\r\n");
      out.write("							   ");
if (userBean.getRoleId() == RoleBean.STUDENT) {
      out.write("\r\n");
      out.write("							 ");
      out.print("disabled");
      out.write(' ');
}
      out.write(">\r\n");
      out.write("					</td>\r\n");
      out.write("					<td style=\"text-align: center;\">");
      out.print(index++);
      out.write("</td>\r\n");
      out.write("					<td style=\"text-align: center;\">");
      out.print(bean.getSubjectName());
      out.write("</td>\r\n");
      out.write("					<td style=\"text-align: center;\">");
      out.print(bean.getCourseName());
      out.write("</td>\r\n");
      out.write("					<td style=\"text-align: center;\">");
      out.print(bean.getDescription());
      out.write("</td>\r\n");
      out.write("					<td style=\"text-align: center;\">\r\n");
      out.write("						<a href=\"SubjectCtl?id=");
      out.print(bean.getId());
      out.write("\"\r\n");
      out.write("							");
if (userBean.getRoleId() == RoleBean.STUDENT) {
      out.write("\r\n");
      out.write("							onclick=\"return false;\" ");
}
      out.write(">Edit</a>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");

					}
				
      out.write("\r\n");
      out.write("			</table>\r\n");
      out.write("			<table style=\"width: 100%\">\r\n");
      out.write("				<tr>\r\n");
      out.write("\r\n");
      out.write("					<td style=\"width: 25%\">\r\n");
      out.write("						<input type=\"submit\" \r\n");
      out.write("								name=\"operation\"\r\n");
      out.write("								value=\"");
      out.print(SubjectListCtl.OP_PREVIOUS);
      out.write("\"\r\n");
      out.write("								");
      out.print(pageNo > 1 ? "" : "disabled");
      out.write(">\r\n");
      out.write("					</td>\r\n");
      out.write("\r\n");
      out.write("					<td align=\"center\" style=\"width: 25%\">\r\n");
      out.write("						<input type=\"submit\"\r\n");
      out.write("								name=\"operation\" \r\n");
      out.write("								value=\"");
      out.print(SubjectListCtl.OP_DELETE);
      out.write("\"\r\n");
      out.write("								");
if (userBean.getRoleId() == RoleBean.STUDENT) {
      out.write("\r\n");
      out.write("								");
      out.print("disabled");
      out.write(' ');
}
      out.write(">\r\n");
      out.write("					</td>\r\n");
      out.write("					<td align=\"center\" style=\"width: 25%\">\r\n");
      out.write("						<input type=\"submit\"\r\n");
      out.write("								name=\"operation\" \r\n");
      out.write("								value=\"");
      out.print(SubjectListCtl.OP_NEW);
      out.write("\"\r\n");
      out.write("								");
if (userBean.getRoleId() == RoleBean.STUDENT) {
      out.write("\r\n");
      out.write("								");
      out.print("disabled");
      out.write(' ');
}
      out.write(">\r\n");
      out.write("					</td>\r\n");
      out.write("					<td align=\"right\">\r\n");
      out.write("						<input type=\"submit\" \r\n");
      out.write("								name=\"operation\"\r\n");
      out.write("								value=\"");
      out.print(SubjectListCtl.OP_NEXT);
      out.write("\"\r\n");
      out.write("								");
      out.print((nextPageSize != 0) ? "" : "disabled");
      out.write(">\r\n");
      out.write("					</td>\r\n");
      out.write("\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("			</table>\r\n");
      out.write("			");

				}
				if (list.size() == 0) {
			
      out.write("\r\n");
      out.write("			<table>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td align=\"right\">\r\n");
      out.write("						<input type=\"submit\" \r\n");
      out.write("								name=\"operation\"\r\n");
      out.write("								value=\"");
      out.print(SubjectListCtl.OP_BACK);
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("			");

				}
			
      out.write("\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	</br>\r\n");
      out.write("	</br>\r\n");
      out.write("	</br>\r\n");
      out.write("	</br>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Footer</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write(".footer {\r\n");
      out.write("	position: fixed;\r\n");
      out.write("	left: 0;\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	bottom: 0;\r\n");
      out.write("	background-color: white;\r\n");
      out.write("	color: black;\r\n");
      out.write("	text-align: center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"footer\">\r\n");
      out.write("		<hr>\r\n");
      out.write("		<h3>&copy; Copyrights RAYS Technologies</h3>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
