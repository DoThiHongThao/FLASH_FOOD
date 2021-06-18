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
public class DonHang {
    private String MaHoaDon;
	private String MaNV;
	private String TenKhachHang;
	private String NgayDat;
	private String DiaChiGiaoHang;
	private String SDT;
	private String GhiChu;
	
	public DonHang(
			String MaHoaDon,
			String MaNV,
			String TenKhachHang,
			String NgayDat,
			String DiaChiGiaoHang,
			String SDT,
			String GhiChu
	) {
		this.MaHoaDon = MaHoaDon;
		this.MaNV = MaNV;
		this.TenKhachHang = TenKhachHang;
		this.NgayDat = NgayDat;
		this.DiaChiGiaoHang = DiaChiGiaoHang;
		this.SDT = SDT;
		this.GhiChu = GhiChu;
	}

	public String getMaHoaDon() {
		return MaHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getTenKhachHang() {
		return TenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}

	public String getNgayDat() {
		return NgayDat;
	}

	public void setNgayDat(String ngayDat) {
		NgayDat = ngayDat;
	}

	public String getDiaChiGiaoHang() {
		return DiaChiGiaoHang;
	}

	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		DiaChiGiaoHang = diaChiGiaoHang;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
}
