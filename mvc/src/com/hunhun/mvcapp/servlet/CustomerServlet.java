package com.hunhun.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hunhun.mvcapp.dao.CriteriaCustomer;
import com.hunhun.mvcapp.dao.CustomerDAO;
import com.hunhun.mvcapp.dao.factory.CustomerDAOFactory;
import com.hunhun.mvcapp.domain.Customer;




public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	//面向接口编程，customerDAO是接口，不同的实现只需不同的 new
	//而利用工厂，只需读取配置文件(switch.properties)，即可选择不同实现方式
	private CustomerDAO customerDAO = CustomerDAOFactory.getInstance().getCustomerDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		String method = request.getParameter("method");
//
//		switch (method) {
//			case "add":		add(request, response);break;
//			case "query": 	query(request, response); break;
//			case "delete":	delete(request, response); break;
//			case "update":	update(request, response); break;
//		}
//
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
//		System.out.println(servletPath); //结果是：/addCustomer.do
		
		
		//String methodName = servletPath.substring(1);
		String methodName = servletPath.substring(1, servletPath.length() - 3);
		//System.out.println(methodName);	//结果是：addCustomer
		
		try {
			//利用反射调用methodName对应的方法，若有新的Method，只需在下边添加就行
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//调用对应方法
			method.invoke(this, req, resp);
		} catch (Exception e) {
			//e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取表单参数：
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		//2.检验name在数据库是否已经存在
		//2.1调用CustomerDAO中的getCountWithName(String name)获取返回值
		long count = customerDAO.getCountWithName(name);
		
		//2.1若返回值大于0，则名字重复，在newcustomer.jsp中利用
		//<%= request.getParameter("name") == null ? "" : request.getParameter("name")%>
		//反馈显示(回显)
		if(count > 0){
			request.setAttribute("message", "该用户名：" + name + " 已经被使用，请重新输入。");
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
			return;
		}else {
			
			Customer customer = new Customer(null, name, address, phone);
			
			customerDAO.save(customer);
			
			response.sendRedirect("success.jsp");
		}
		//System.out.println("add");

	}
	
	//查询数据，包括模糊查询，利用SQL中 %***% 模糊匹配语法实现
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		
		//List<Customer> customers = customerDAO.getAll();
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		
		request.setAttribute("customers", customers);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		//System.out.println("query");
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		
		//若传入的id非法则用默认值 0
		int id = 0;
		
		//防止id非法，若非法则直接跳到catch
		try {
			id = Integer.parseInt(idStr);
			customerDAO.delete(id);
		} catch (Exception e) {}
			
		response.sendRedirect("query.do");
		
		
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String oldName = request.getParameter("oldName");
		
		//新的name和原来的name不一样时，查询数据库是有否重名（此方法为通用方法）
		if (!oldName.equalsIgnoreCase(name)) {
			long count = customerDAO.getCountWithName(name);
			
			//发现name有重复，修改失败后，请求转发，并带上修改失败的参数回显
			if (count > 0) {
				request.setAttribute("message", "该用户名：" + name + " 已经被使用，请重新输入。");
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
		}
		Customer customer = new Customer(Integer.parseInt(id), name, address, phone);
		customerDAO.update(customer);
		
		//请求重定向可以防止表单的重复提交
		response.sendRedirect("query.do");
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forwordPath = "/error.jsp";
		
		String idStr = request.getParameter("id");
		
		try {
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			if (customer != null) {
				forwordPath = "/updatecustomer.jsp";
				request.setAttribute("customer", customer);
				
			}
		} catch (NumberFormatException e) {	}
		
		request.getRequestDispatcher(forwordPath).forward(request, response);
	}

}
