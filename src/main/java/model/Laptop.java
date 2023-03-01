package model;

import java.util.Date;

public class Laptop  extends LoaiLaptop{
 private int idLaptop;
 private String tenLaptop;
 private String thongSo;
 private int giaNhap, giaBan, soLuong;
 private Date ngayTao, ngaySua;
 private String anh;
public int getIdLaptop() {
	return idLaptop;
}
public void setIdLaptop(int idLaptop) {
	this.idLaptop = idLaptop;
}
public String getTenLaptop() {
	return tenLaptop;
}
public void setTenLaptop(String tenLaptop) {
	this.tenLaptop = tenLaptop;
}
public String getThongSo() {
	return thongSo;
}
public void setThongSo(String thongSo) {
	this.thongSo = thongSo;
}
public int getGiaNhap() {
	return giaNhap;
}
public void setGiaNhap(int giaNhap) {
	this.giaNhap = giaNhap;
}
public int getGiaBan() {
	return giaBan;
}
public void setGiaBan(int giaBan) {
	this.giaBan = giaBan;
}
public Date getNgayTao() {
	return ngayTao;
}
public void setNgayTao(Date ngayTao) {
	this.ngayTao = ngayTao;
}
public Date getNgaySua() {
	return ngaySua;
}
public void setNgaySua(Date ngaySua) {
	this.ngaySua = ngaySua;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}
public Laptop(int idLaptop, String tenLaptop, String thongSo,int soluong, int giaNhap, int giaBan, Date ngayTao,
		Date ngaySua, String anh,int idLoai) {
	super(idLoai);
	this.idLaptop = idLaptop;
	this.soLuong=soluong;
	this.tenLaptop = tenLaptop;
	this.thongSo = thongSo;
	this.giaNhap = giaNhap;
	this.giaBan = giaBan;
	this.ngayTao = ngayTao;
	this.ngaySua = ngaySua;
	this.anh = anh;
}

public Laptop( String tenLaptop, String thongSo, int giaNhap, int giaBan, Date ngayTao, Date ngaySua,
		String anh,int idLoai) {
	super(idLoai);
	this.tenLaptop = tenLaptop;
	this.thongSo = thongSo;
	this.giaNhap = giaNhap;
	this.giaBan = giaBan;
	this.ngayTao = ngayTao;
	this.ngaySua = ngaySua;
	this.anh = anh;
}
@Override
public String toString() {
	return "Laptop [idLaptop=" + idLaptop + ", tenLaptop=" + tenLaptop + ", thongSo=" + thongSo + ", giaNhap=" + giaNhap
			+ ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", anh="
			+ anh + " + idloai="+ this.getIdLaptop()+"]";
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}

public Laptop() {}
}
