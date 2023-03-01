package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Role;

public class RoldDAO {

	private static PreparedStatement ps;

	public static ArrayList<Role> getAllRole(String sql) {
		ArrayList<Role> listRole = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listRole.add(new Role(s.getInt(1),s.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRole;
	}

	public static boolean insertRole(String nameRole) {
		boolean sucess = true;
		try {
			String sql = "insert into roles values(?)";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, nameRole);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean updateRole(Role r) {
		boolean sucess = true;
		try {
			String sql = "update user set namerole=? where idRole=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, r.getNameRole());
			ps.setInt(2, r.getIdRole());
			
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean deleteRole(int idRole) {
		boolean sucess = true;
		try {
			String sql = "delete from  Role  where idRole=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idRole);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static Role getARole(int idRole) {
		Role r= null;
		try {

			ps = ConnectDB.getConnect().prepareStatement("select * from Roles where idRole=?");
			ps.setInt(1, idRole);
			
			ResultSet s = ps.executeQuery();
			while (s.next()) {

				r = new Role(s.getInt(1),s.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
}
