package model;

public class HoaDonFullBanHang {
private int idCTBH, idLapTop,soLuongLaptop,idPhuKien,soLuongPK, tongTien, idBH, giaLaptop,giaPhuKien;
private String tenLapTop, tenPhuKien;
public int getIdCTBH() {
	return idCTBH;
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

public void setIdCTBH(int idCTBH) {
	this.idCTBH = idCTBH;
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
public int getIdBH() {
	return idBH;
}
public void setIdBH(int idBH) {
	this.idBH = idBH;
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
@Override
public String toString() {
	return "HoaDonFull [idCTBH=" + idCTBH + ", idLapTop=" + idLapTop + ", soLuongLaptop=" + soLuongLaptop
			+ ",  idPhuKien=" + idPhuKien + ", soLuongPK=" + soLuongPK
			+ ", tongTien=" + tongTien + ", idBH=" + idBH + ", tenLapTop=" + tenLapTop
			+ ", tenPhuKien=" + tenPhuKien + "]";
}
public HoaDonFullBanHang(int idCTBH, int idLapTop, String tenLapTop, int soLuongLaptop, int giaLaptop, int idPKien, String tenPhuKien,
		int soLuongPK, int giaPkien, int tongTien, int idBH ) {
	
	this.idCTBH = idCTBH;
	this.idLapTop = idLapTop;
	this.soLuongLaptop = soLuongLaptop;
	this.idPhuKien = idPKien;
	this.soLuongPK = soLuongPK;
	this.tongTien = tongTien;
	this.idBH = idBH;
	this.tenLapTop = tenLapTop;
	this.tenPhuKien = tenPhuKien;
	this.giaLaptop= giaLaptop;
	this.giaPhuKien= giaPkien;
}
public HoaDonFullBanHang() {
	
}

}
