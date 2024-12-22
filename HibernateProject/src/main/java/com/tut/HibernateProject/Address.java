package com.tut.HibernateProject;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tbl_mpstrak_student_address")
public class Address {
	@Id
	@Column(name = "address_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	@Column(length = 50, name="street")
	private String street;
	

	private String city;
	@Column(name = "is_open", columnDefinition = "VARCHAR(5)")
	private String isOpen;
	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	@Lob
	private byte[] image;

	public Address() {
		super();
	}

	public Address(Integer addressId, String street, String city, String isOpen, Date addedDate, byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.addedDate = addedDate;
		this.image = image;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String isOpen() {
		return isOpen;
	}

	public void setOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
