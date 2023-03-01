package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BanHangDAO;
import dao.LaptopDAO;
import dao.NhapHangDAO;
import dao.PhuKienDAO;


@WebServlet(name="HomeAdmin", urlPatterns = "/admin/pages/home/index")
public class HomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeAdmin() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		
		if(session.getAttribute("admin")==null) {
			response.sendRedirect("../../../login");
		}else {
			
			request.setAttribute("banhang", BanHangDAO.sumCount());
			request.setAttribute("nhaphang", NhapHangDAO.sumCount());
			request.setAttribute("laptop", LaptopDAO.sumCount());
			request.setAttribute("phukien", PhuKienDAO.sumCount());
			
			LocalDate now = LocalDate.now();
			LocalDate nowPlus= now.plusDays(1);
			
			
			System.out.println(" ngay sau khi cong: "+now.plusDays(1));
			// Lấy ngày cách đây 30 ngày
			LocalDate last30Days = now.minusDays(30);
			System.out.println(last30Days);
			String[] dataChartDoanhThu = BanHangDAO.thongkeDoanhThu30NgayGanNhat(last30Days.toString(), nowPlus.toString());
			
			request.setAttribute("valueNgay", dataChartDoanhThu[0]);
			request.setAttribute("valueTongTien", dataChartDoanhThu[1]);
			String[] dataChartNhapHang= NhapHangDAO.thongkeNhapHangChart(last30Days.toString(), nowPlus.toString());
			request.setAttribute("valueNgayNhap", dataChartNhapHang[0]);
			request.setAttribute("valueTongTienNhap", dataChartNhapHang[1]);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
