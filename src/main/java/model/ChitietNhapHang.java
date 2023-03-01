package model;

public class ChitietNhapHang {
	private int idCTNH, idLapTop, soLuongLaptop,giaLaptop;
	private int idPK, soLuongPhuKien, giaPhuKien;
	private int tongtien, idNhapHang;
	
	public int getGiaLaptop() {
		return giaLaptop;
	}
	public void setGiaLaptop(int giaLaptop) {
		this.giaLaptop = giaLaptop;
	}
	public int getGiaPhuKien() {
		return giaPhuKien;
	}
	public void setGiaPhuKien(int giaPhuKien) {
		this.giaPhuKien = giaPhuKien;
	}
	public int getIdCTNH() {
		return idCTNH;
	}
	public void setIdCTNH(int idCTNH) {
		this.idCTNH = idCTNH;
	}
	public int getIdLapTop() {
		return idLapTop;
	}
	public void setIdLapTop(int idLapTop) {
		this.idLapTop = idLapTop;
	}
	public int getSoLuongLaptop() {
		return soLuongLaptop;
	}
	public void setSoLuongLaptop(int soLuongLaptop) {
		this.soLuongLaptop = soLuongLaptop;
	}

	public int getIdPK() {
		return idPK;
	}
	public void setIdPK(int idPK) {
		this.idPK = idPK;
	}
	public int getSoLuongPhuKien() {
		return soLuongPhuKien;
	}
	public void setSoLuongPhuKien(int soLuongPhuKien) {
		this.soLuongPhuKien = soLuongPhuKien;
	}

	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	public int getIdNhapHang() {
		return idNhapHang;
	}
	public void setIdNhapHang(int idNhapHang) {
		this.idNhapHang = idNhapHang;
	}
	
	public ChitietNhapHang(int idCTNH, int idLapTop, int soLuongLaptop, int giaLaptop, int idPK,
			int soLuongPhuKien, int giaPhuKien,  int tongtien, int idNhapHang) {
		
		this.idCTNH = idCTNH;
		this.idLapTop = idLapTop;
		this.soLuongLaptop = soLuongLaptop;
		this.giaLaptop = giaLaptop;
		
		this.idPK = idPK;
		this.soLuongPhuKien = soLuongPhuKien;
		this.giaPhuKien = giaPhuKien;
		
		this.tongtien = tongtien;
		this.idNhapHang = idNhapHang;
	}
	
	public ChitietNhapHang(int idLapTop, int soLuongLaptop, int giaLaptop,  int idPK,
			int soLuongPhuKien, int giaPhuKien, int tongtien, int idNhapHang) {
		
		this.idLapTop = idLapTop;
		this.soLuongLaptop = soLuongLaptop;
		this.giaLaptop = giaLaptop;
		
		this.idPK = idPK;
		this.soLuongPhuKien = soLuongPhuKien;
		this.giaPhuKien = giaPhuKien;
	
		this.tongtien = tongtien;
		this.idNhapHang = idNhapHang;
	}
	public ChitietNhapHang() {
		
	}
	@Override
	public String toString() {
		return "ChitietNhapHang [idCTNH=" + idCTNH + ", idLapTop=" + idLapTop + ", soLuongLaptop=" + soLuongLaptop
				+ ", giaLaptop=" + giaLaptop + ", idPK=" + idPK + ", soLuongPhuKien=" + soLuongPhuKien + ", giaPhuKien="
				+ giaPhuKien + ", tongtien=" + tongtien + ", idNhapHang=" + idNhapHang + "]";
	}

}

