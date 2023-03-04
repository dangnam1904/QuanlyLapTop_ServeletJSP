package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DichVuSuaChuaDAO;
import model.DichVuSuaChua;

/**
 * Servlet implementation class ThongKeSuaChua
 */
@WebServlet("/admin/pages/thongke/suachua")
public class ThongKeSuaChua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongKeSuaChua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null && session.getAttribute("nhanvien") ==null) {
			response.sendRedirect("../../../login");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("suachua.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String tungay = request.getParameter("tungay");
		String denngay = request.getParameter("denngay");
		ArrayList<DichVuSuaChua> list = DichVuSuaChuaDAO.thongkeNhapHang(tungay, denngay);
		System.out.println(list.toString());
		request.setAttribute("list", list);

		String[] dataChart = DichVuSuaChuaDAO.thongkeSuaChuaChart(tungay, denngay);
		System.out.println(dataChart);
		request.setAttribute("valueNgay", dataChart[0]);
		request.setAttribute("valueTongTien", dataChart[1]);

		RequestDispatcher dispatcher = request.getRequestDispatcher("suachua.jsp");
		dispatcher.forward(request, response);
	}

}
