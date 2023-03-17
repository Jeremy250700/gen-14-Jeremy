package com.prodemy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodemy.dao.DataDosenDao;

/**
 * Servlet implementation class DeleteDataDosenController
 */
public class DeleteDataDosenController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kode_dosen = request.getParameter("kode_dosen");
		
		DataDosenDao dao = new DataDosenDao();
		dao.deleteDosen(kode_dosen);
		response.sendRedirect("showDataDosen");
	}
}
