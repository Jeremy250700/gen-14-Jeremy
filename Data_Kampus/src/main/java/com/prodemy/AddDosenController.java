package com.prodemy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodemy.dao.DataDosenDao;
import com.prodemy.model.Dosen;


/**
 * Servlet implementation class AddDosenController
 */
public class AddDosenController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kode_dosen = request.getParameter("kode_dosen");
		String nama_dosen = request.getParameter("nama_dosen");
		 DataDosenDao dao = new DataDosenDao();
		 Dosen d1 = dao.addDosen(kode_dosen, nama_dosen);
		 ArrayList<Dosen> data_dosen = new ArrayList<Dosen>();
		data_dosen = dao.getDosen();
			
		request.setAttribute("dosens", data_dosen);
		RequestDispatcher rd = request.getRequestDispatcher("showDosen.jsp");
		rd.forward(request, response);
	}

}
