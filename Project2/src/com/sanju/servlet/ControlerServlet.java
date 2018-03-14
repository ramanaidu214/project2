package com.sanju.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanju.bean.GroupCustomerBean;
import com.sanju.dao.GroupCustomerDaoImpl;

public class ControlerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = res.getWriter();
		String name="index.html";
		res.setContentType("text/html");
		String customerIdParam = req.getParameter("customerId");
		int customerId=Integer.parseInt(customerIdParam);
		GroupCustomerDaoImpl dao = new GroupCustomerDaoImpl();
		List<GroupCustomerBean> list = dao.getCustomerData(customerId);
		pw.println("<table border='1' align='center'><tr><th>groupid</th><th>groupname</th><th>customerid</th><th>customername</th><th>creditamount</th></tr>");
		for (GroupCustomerBean bean : list) {
			pw.println("<tr align='center'><td>"+bean.getGroupId()+"</td><td>"+bean.getGroupName()+"</td><td>"+bean.getCustomerId()+"</td><td>"+bean.getCustomerName()+"</td><td>"+bean.getCreditAmount()+"</td></tr>");
		}
		pw.println("</table");
		pw.println("<h3><a href='index.html'>back</a><h3>");

	}
}
