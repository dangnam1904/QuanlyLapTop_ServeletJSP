package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.Users;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users user = UserDAO.CheckLogin(request.getParameter("username"), request.getParameter("password"));
		HttpSession session = request.getSession();
		if (user != null) {
			session.setAttribute("admin", user);
			response.sendRedirect("./admin/pages/home/index");
		} else {
			String error = "Sai taì khoản hoặc mật khẩu, vui lòng kiểm tra lại!";
			session.setAttribute("errorlogin", error);
			doGet(request, response);
		}

	}

	public static String encryption(String str) {
		byte[] defaultBytes = str.getBytes();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			str = hexString + "";
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return str;
	}

}
