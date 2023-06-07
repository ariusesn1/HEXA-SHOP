package com.fpltn.entities;
// Generated Apr 4, 2023, 8:26:35 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sanpham generated by hbm2java
 */
@Entity
@Table(name = "sanpham", catalog = "lab1")
public class Sanpham implements java.io.Serializable {

	private Integer id;
	private String masp;
	private String tensp;
	private Double giaban;
	private String motangan;
	private String chitiet;
	private String hinhanh;
	private Integer iddanhmuc;

	public Sanpham() {
	}

	public Sanpham(String masp) {
		this.masp = masp;
	}

	public Sanpham(String masp, String tensp, Double giaban, String motangan, String chitiet, String hinhanh,
			Boolean trangthai, Integer iddanhmuc) {
		this.masp = masp;
		this.tensp = tensp;
		this.giaban = giaban;
		this.motangan = motangan;
		this.chitiet = chitiet;
		this.hinhanh = hinhanh;
		this.iddanhmuc = iddanhmuc;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "masp", nullable = false, length = 45)
	public String getMasp() {
		return this.masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	@Column(name = "tensp", length = 45)
	public String getTensp() {
		return this.tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	@Column(name = "giaban", precision = 22, scale = 0)
	public Double getGiaban() {
		return this.giaban;
	}

	public void setGiaban(Double giaban) {
		this.giaban = giaban;
	}

	@Column(name = "motangan", length = 45)
	public String getMotangan() {
		return this.motangan;
	}

	public void setMotangan(String motangan) {
		this.motangan = motangan;
	}

	@Column(name = "chitiet")
	public String getChitiet() {
		return this.chitiet;
	}

	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}

	@Column(name = "hinhanh")
	public String getHinhanh() {
		return this.hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	@Column(name = "iddanhmuc")
	public Integer getIddanhmuc() {
		return this.iddanhmuc;
	}

	public void setIddanhmuc(Integer iddanhmuc) {
		this.iddanhmuc = iddanhmuc;
	}


}
