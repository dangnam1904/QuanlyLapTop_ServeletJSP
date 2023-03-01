package model;

public class HoaDonFullNhapHang {
	private int idCTNH, idLapTop,soLuongLaptop,idPhuKien,soLuongPK, tongTien, idNH, giaLaptop,giaPhuKien;
	private String tenLapTop, tenPhuKien;
	@Override
	public String toString() {
		return "HoaDonFullNhapHang [idCTNH=" + idCTNH + ", idLapTop=" + idLapTop + ", soLuongLaptop=" + soLuongLaptop
				+ ", idPhuKien=" + idPhuKien + ", soLuongPK=" + soLuongPK + ", tongTien=" + tongTien + ", idNH=" + idNH
				+ ", giaLaptop=" + giaLaptop + ", giaPhuKien=" + giaPhuKien + ", tenLapTop=" + tenLapTop
				+ ", tenPhuKien=" + tenPhuKien + "]";
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
	public int getIdPhuKien() {
		return idPhuKien;
	}
	public void setIdPhuKien(int idPhuKien) {
		this.idPhuKien = idPhuKien;
	}
	public int getSoLuongPK() {
		return soLuongPK;
	}
	public void setSoLuongPK(int soLuongPK) {
		this.soLuongPK = soLuongPK;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public int getIdNH() {
		return idNH;
	}
	public void setIdNH(int idNH) {
		this.idNH = idNH;
	}
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
	public String getTenLapTop() {
		return tenLapTop;
	}
	public void setTenLapTop(String tenLapTop) {
		this.tenLapTop = tenLapTop;
	}
	public String getTenPhuKien() {
		return tenPhuKien;
	}
	public void setTenPhuKien(String tenPhuKien) {
		this.tenPhuKien = tenPhuKien;
	}
	public HoaDonFullNhapHang() {
		
	}
	public HoaDonFullNhapHang(int idCTNH, int idLapTop, String tenLapTop, int soLuongLaptop, int giaLaptop, int idPKien, String tenPhuKien,
			int soLuongPK, int giaPkien, int tongTien, int idNH ) {
		
		this.idCTNH = idCTNH;
		this.idLapTop = idLapTop;
		this.soLuongLaptop = soLuongLaptop;
		this.idPhuKien = idPKien;
		this.soLuongPK = soLuongPK;
		this.tongTien = tongTien;
		this.idNH = idNH;
		this.tenLapTop = tenLapTop;
		this.tenPhuKien = tenPhuKien;
		this.giaLaptop= giaLaptop;
		this.giaPhuKien= giaPkien;
	}

}
