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
	//����ӿڱ�̣�customerDAO�ǽӿڣ���ͬ��ʵ��ֻ�費ͬ�� new
	//�����ù�����ֻ���ȡ�����ļ�(switch.properties)������ѡ��ͬʵ�ַ�ʽ
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
//		System.out.println(servletPath); //����ǣ�/addCustomer.do
		
		
		//String methodName = servletPath.substring(1);
		String methodName = servletPath.substring(1, servletPath.length() - 3);
		//System.out.println(methodName);	//����ǣ�addCustomer
		
		try {
			//���÷������methodName��Ӧ�ķ����������µ�Method��ֻ�����±���Ӿ���
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//���ö�Ӧ����
			method.invoke(this, req, resp);
		} catch (Exception e) {
			//e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ��������
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		//2.����name�����ݿ��Ƿ��Ѿ�����
		//2.1����CustomerDAO�е�getCountWithName(String name)��ȡ����ֵ
		long count = customerDAO.getCountWithName(name);
		
		//2.1������ֵ����0���������ظ�����newcustomer.jsp������
		//<%= request.getParameter("name") == null ? "" : request.getParameter("name")%>
		//������ʾ(����)
		if(count > 0){
			request.setAttribute("message", "���û�����" + name + " �Ѿ���ʹ�ã����������롣");
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
			return;
		}else {
			
			Customer customer = new Customer(null, name, address, phone);
			
			customerDAO.save(customer);
			
			response.sendRedirect("success.jsp");
		}
		//System.out.println("add");

	}
	
	//��ѯ���ݣ�����ģ����ѯ������SQL�� %***% ģ��ƥ���﷨ʵ��
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
		
		//�������id�Ƿ�����Ĭ��ֵ 0
		int id = 0;
		
		//��ֹid�Ƿ������Ƿ���ֱ������catch
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
		
		//�µ�name��ԭ����name��һ��ʱ����ѯ���ݿ����з��������˷���Ϊͨ�÷�����
		if (!oldName.equalsIgnoreCase(name)) {
			long count = customerDAO.getCountWithName(name);
			
			//����name���ظ����޸�ʧ�ܺ�����ת�����������޸�ʧ�ܵĲ�������
			if (count > 0) {
				request.setAttribute("message", "���û�����" + name + " �Ѿ���ʹ�ã����������롣");
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
		}
		Customer customer = new Customer(Integer.parseInt(id), name, address, phone);
		customerDAO.update(customer);
		
		//�����ض�����Է�ֹ�����ظ��ύ
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
