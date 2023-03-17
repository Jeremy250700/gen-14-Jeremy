package com.prodemy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prodemy.dao.DataDosenDao;
import com.prodemy.model.Dosen;

/**
 * Servlet implementation class UpdateDosen
 */
public class UpdateDosen extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kode_dosen = request.getParameter("kode_dosen");
		DataDosenDao dao = new DataDosenDao();
		Dosen d1 = new Dosen();
		
		try {
			d1 = dao.getData(kode_dosen);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		request.setAttribute("dosen", d1);

		RequestDispatcher rd = request.getRequestDispatcher("updateDosen.jsp");
		rd.forward(request, response);
	}
}
