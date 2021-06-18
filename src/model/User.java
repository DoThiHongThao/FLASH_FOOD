/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class User {
    private String MaNV;
	private String HoTen;
	private String NgaySinh;
	private String DiaChi;
	
	public User(String MaNV, String HoTen, String NgaySinh, String DiaChi) 
	{
		this.HoTen = HoTen;
		this.MaNV = MaNV;
		this.DiaChi = DiaChi;
		this.NgaySinh = NgaySinh;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
}
