package com.hunhun.javaweb.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListAllExamStudentServlet
 */
public class ListAllExamStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO studentDAO = new StudentDAO();
		List<Student> students = studentDAO.getAll();
		
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("/students.jsp").forward(request, response);
		
	}

}
