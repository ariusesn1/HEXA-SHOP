package com.fpltn.entities;
// Generated Apr 4, 2023, 8:26:35 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Danhmuc generated by hbm2java
 */
@Entity
@Table(name = "danhmuc", catalog = "lab1")
public class Danhmuc implements java.io.Serializable {

	private Integer id;
	private String tendanhmuc;
	private String mota;

	public Danhmuc() {
	}

	public Danhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	public Danhmuc(String tendanhmuc, String mota) {
		this.tendanhmuc = tendanhmuc;
		this.mota = mota;
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

	@Column(name = "tendanhmuc", nullable = false, length = 45)
	public String getTendanhmuc() {
		return this.tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	@Column(name = "mota", length = 150)
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

}
