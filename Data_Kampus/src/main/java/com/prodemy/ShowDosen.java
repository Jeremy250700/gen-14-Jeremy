package com.prodemy;
import com.prodemy.model.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodemy.dao.DataDosenDao;

/**
 * Servlet implementation class ShowDosen
 */
public class ShowDosen extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataDosenDao dao = new DataDosenDao();
		ArrayList<Dosen> data_dosen = new ArrayList<Dosen>();
		data_dosen = dao.getDosen();
		
		request.setAttribute("dosens", data_dosen);
		 RequestDispatcher rd = request.getRequestDispatcher("showDosen.jsp");
		 rd.forward(request, response);
	}
}
