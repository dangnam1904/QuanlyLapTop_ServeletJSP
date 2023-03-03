package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoaiLaptopDAO;

/**
 * Servlet implementation class LoaiLaptopList
 */
@WebServlet(urlPatterns = "/admin/pages/loailaptop/list")
public class LoaiLaptopList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiLaptopList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			if(session.getAttribute("nhanvien") != null) {
				response.sendRedirect("../home/index");
				session.setAttribute("errorRole", "yes");
			}else {
				response.sendRedirect("../../../login");
			}
		} else {
		request.setAttribute("list", LoaiLaptopDAO.getAllLoaiLaptop("select * from loailaptop"));
		RequestDispatcher dispatcher= request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
