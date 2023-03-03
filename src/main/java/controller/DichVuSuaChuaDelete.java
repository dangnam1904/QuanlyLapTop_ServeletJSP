package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DichVuSuaChuaDAO;

@WebServlet(name = "/DichVuSuaChuaDelete", urlPatterns = "/admin/pages/dichvusuachua/delete")
public class DichVuSuaChuaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DichVuSuaChuaDelete() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null && session.getAttribute("nhanvien") ==null) {
			response.sendRedirect("../../../login");
		} else {
			if (DichVuSuaChuaDAO.deleteDV(id)) {
				
				session.setAttribute("Delete", "Success");
				session.setMaxInactiveInterval(15);
				response.sendRedirect("listdichvusuachua");
			} else {

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
