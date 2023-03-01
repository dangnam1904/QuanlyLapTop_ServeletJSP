package model;

public class LoaiLaptop {
  private int idLoai;
  private String tenLoai;
  
  
public LoaiLaptop(String tenLoai) {
	
	this.tenLoai = tenLoai;
}
public int getIdLoai() {
	return idLoai;
}
public void setIdLoai(int idLoai) {
	this.idLoai = idLoai;
}
public String getTenLoai() {
	return tenLoai;
}
public void setTenLoai(String tenLoai) {
	this.tenLoai = tenLoai;
}
public LoaiLaptop(int idLoai, String tenLoai) {

	this.idLoai = idLoai;
	this.tenLoai = tenLoai;
}
public LoaiLaptop() {

}
public LoaiLaptop(int idLoai) {
	
	this.idLoai = idLoai;
}
@Override
public String toString() {
	return "LoaiLaptop [idLoai=" + idLoai + ", tenLoai=" + tenLoai + "]";
}
 
}
