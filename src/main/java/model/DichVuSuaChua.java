package model;

import java.util.Date;

public class DichVuSuaChua {
 private int idDV;
 private String tenKhach,sdtKhach, noiDungSuaChua;
 private int giaTien;
 private Date ngayNhan, ngayTra;
 private String ghiChu;
public int getIdDV() {
	return idDV;
}
public void setIdDV(int idDV) {
	this.idDV = idDV;
}
public String getTenKhach() {
	return tenKhach;
}
public void setTenKhach(String tenKhach) {
	this.tenKhach = tenKhach;
}
public String getSdtKhach() {
	return sdtKhach;
}
public void setSdtKhach(String sdtKhach) {
	this.sdtKhach = sdtKhach;
}
public String getNoiDungSuaChua() {
	return noiDungSuaChua;
}
public void setNoiDungSuaChua(String noiDungSuaChua) {
	this.noiDungSuaChua = noiDungSuaChua;
}
public int getGiaTien() {
	return giaTien;
}
public void setGiaTien(int giaTien) {
	this.giaTien = giaTien;
}

public Date getNgayNhan() {
	return ngayNhan;
}
public void setNgayNhan(Date ngayNhan) {
	this.ngayNhan = ngayNhan;
}
public Date getNgayTra() {
	return ngayTra;
}
public void setNgayTra(Date ngayTra) {
	this.ngayTra = ngayTra;
}
public String getGhiChu() {
	return ghiChu;
}
public void setGhiChu(String ghiChu) {
	this.ghiChu = ghiChu;
}
public DichVuSuaChua() {
	
}
public DichVuSuaChua(int idDV, String tenKhach, String sdtKhach, String noiDungSuaChua, int giaTien, Date ngayNhan,
		Date ngayTra, String ghiChu) {
	
	this.idDV = idDV;
	this.tenKhach = tenKhach;
	this.sdtKhach = sdtKhach;
	this.noiDungSuaChua = noiDungSuaChua;
	this.giaTien = giaTien;
	this.ngayNhan = ngayNhan;
	this.ngayTra = ngayTra;
	this.ghiChu = ghiChu;
}
public DichVuSuaChua(String tenKhach, String sdtKhach, String noiDungSuaChua, int giaTien, Date ngayNhan, Date ngayTra,
		String ghiChu) {
	
	this.tenKhach = tenKhach;
	this.sdtKhach = sdtKhach;
	this.noiDungSuaChua = noiDungSuaChua;
	this.giaTien = giaTien;
	this.ngayNhan = ngayNhan;
	this.ngayTra = ngayTra;
	this.ghiChu = ghiChu;
}
@Override
public String toString() {
	return "DichVuSuaChua [idDV=" + idDV + ", tenKhach=" + tenKhach + ", sdtKhach=" + sdtKhach + ", noiDungSuaChua="
			+ noiDungSuaChua + ", giaTien=" + giaTien + ", ngayNhan=" + ngayNhan + ", ngayTra=" + ngayTra + ", ghiChu="
			+ ghiChu + "]";
}


}
