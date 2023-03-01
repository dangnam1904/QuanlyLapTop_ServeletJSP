package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.PhuKien;

public class PhuKienDAO {
	public static PreparedStatement ps;

	public static ArrayList<PhuKien> getAllPhuKien(String sql) {
		ArrayList<PhuKien> listPK = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listPK.add(new PhuKien(s.getInt(1),s.getString(2) ,s.getInt(3), s.getInt(4), s.getInt(5), s.getDate(6),s.getDate(7),s.getString(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPK;
	}
	
	public static int sumCount() {
		int sumRow= 0;
		try {
			ps = ConnectDB.getConnect().prepareStatement("select count(*) from phukien ");
		
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				sumRow= s.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sumRow;
	}
	
	public static ArrayList<PhuKien> findAllPhuKienByName(String name) {
		ArrayList<PhuKien> listPK = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement("select * from phukien where tenphukien like '%"+name.trim()+"%'");
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listPK.add(new PhuKien(s.getInt(1),s.getString(2) ,s.getInt(3), s.getInt(4), s.getInt(5), s.getDate(6),s.getDate(7),s.getString(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPK;
	}
	
	public static PhuKien getAPhuKien(int idPhuKien) {
		PhuKien pk = null;
		try {
			ps = ConnectDB.getConnect().prepareStatement("select * from phukien where idPkien=?");
			ps.setInt(1, idPhuKien);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				pk=new PhuKien(s.getInt(1),s.getString(2) ,s.getInt(3), s.getInt(4), s.getInt(5), s.getDate(6),s.getDate(7),s.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}

	public static boolean insertPhuKien(PhuKien pk) {
		boolean sucess = true;
		try {
			String sql = "insert into phukien values(?,?,?,?,?,?,?)";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setString(1, pk.getTenPK());
			ps.setInt(2, pk.getSoLuong());
			ps.setInt(3, pk.getGiaBan());
			ps.setInt(4, pk.getGiaNhap());
			ps.setDate(5, (Date) pk.getNgayTao());
			ps.setDate(6, (Date) pk.getNgaySua());
			ps.setString(7, pk.getAnh());
			
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean updatePhuKien(PhuKien pk) {
		boolean sucess = true;
		try {
			String sql = "update phukien set tenphukien=?, soluong=?, giaban=?, gianhap=?, ngaysua=?, anh=? where idpkien=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setString(1, pk.getTenPK());
			ps.setInt(2, pk.getSoLuong());
			ps.setInt(3, pk.getGiaBan());
			ps.setInt(4, pk.getGiaNhap());
			ps.setDate(5, (Date) pk.getNgaySua());
			ps.setString(6, pk.getAnh());
			ps.setInt(7, pk.getIdPhuKien());
			
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean updateSoluongPhuKien(int soluong, int idphukien) {
		boolean sucess = true;
		try {
			String sql = "update phukien set soluong=? where idpkien=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setInt(1, soluong);
			ps.setInt(2, idphukien);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}
	public static boolean deletePkien(int idpk) {
		boolean sucess = true;
		try {
			String sql = "delete from  phukien  where idpkien=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idpk);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

}
