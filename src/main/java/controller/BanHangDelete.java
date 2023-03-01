package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BanHangDAO;
import dao.ChiTietBanHangDAO;

/**
 * Servlet implementation class BanHangDelete
 */
@WebServlet(urlPatterns = "/admin/pages/banhang/delete")
public class BanHangDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanHangDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			response.sendRedirect("../../../login");
		} else {
			if(request.getParameter("id")!=null && request.getParameter("id")!="") {
				ChiTietBanHangDAO.deleteCTBHByIDBH(Integer.valueOf(request.getParameter("id")));
				BanHangDAO.deleteBH(Integer.valueOf( request.getParameter("id")));
				
				session.setAttribute("Delete", "Success");
				session.setMaxInactiveInterval(15);
				response.sendRedirect("list");
			}else {
				session.setAttribute("Delete", "Faill");
				session.setMaxInactiveInterval(15);
				response.sendRedirect("list");
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
