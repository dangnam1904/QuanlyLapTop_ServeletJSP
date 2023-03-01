package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Users;

public class UserDAO {
	private static PreparedStatement ps;

	public static Users CheckLogin(String username, String password) {
		Users user = null;
		try {

			ps = ConnectDB.getConnect().prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, EncryptionPassword.encryption(password));
			
			ResultSet s = ps.executeQuery();
			while (s.next()) {

				user = new Users(s.getInt(1), s.getString(2), s.getString(3), s.getString(4), s.getInt(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public static ArrayList<Users> getAllUser(String sql) {
		ArrayList<Users> listUser = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listUser.add(new Users(s.getInt(1), s.getString(2), s.getString(3), s.getString(4), s.getInt(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	public static boolean insertUsers(Users u) {
		boolean sucess = true;
		try {
			String sql = "insert into users values(?,?,?,?)";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getImage());
			ps.setInt(4, u.getIdRole());
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}
	public static boolean ressetPassword(int idUser) {
		boolean sucess = true;
		try {
			String sql = "update users set password=? where idUsers=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			
			ps.setString(1, EncryptionPassword.encryption("123"));
			ps.setInt(2, idUser);
		
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean updateUser(Users u) {
		boolean sucess = true;
		try {
			String sql = "update users set username=?, password=?, anh=?, idrole=? where idUsers=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getPassword());
			ps.setInt(4, u.getIdRole());
			ps.setInt(5, u.getIdUser());
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean deleteUser(int idUser) {
		boolean sucess = true;
		try {
			String sql = "delete from  Users  where idusers=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static Users getAUser(int idUser) {
		Users user= null;
		try {

			ps = ConnectDB.getConnect().prepareStatement("select * from users where idusers=?");
			ps.setInt(1, idUser);
			
			ResultSet s = ps.executeQuery();
			while (s.next()) {

				user = new Users(s.getInt(1), s.getString(2), s.getString(3), s.getString(4), s.getInt(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public static Users checkUserEXISTS (String username) {
		Users user=null;
		try {

			ps = ConnectDB.getConnect().prepareStatement("select * from users where username =? ");
			ps.setString(1, username);
			System.out.println(ps);
			ResultSet s = ps.executeQuery();
			while (s.next()) {

				user= new Users(s.getInt(1), s.getString(2), s.getString(3), s.getString(4), s.getInt(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public static void main(String[] args) {
		System.out.println(UserDAO.checkUserEXISTS("admin"));
	}
}
