package com.CBay.beans;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="IMAGE")
public class Image {

	@Id
	@Column(name="ImageID")
	@SequenceGenerator(sequenceName="IMAGE_ID_SEQ", name="IMAGE_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="IMAGE_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ItemID")
	private Integer ItemId;
	
	@Column(name="Image")
	private byte[] Image;
	
	@Column(name="FileName")
	private String FileName;

	public Image(Integer id, Integer item, byte[] image, String fileName) {
		super();
		this.id = id;
		ItemId = item;
		Image = image;
		FileName = fileName;
	}

	public Image(Integer item, byte[] image, String fileName) {
		super();
		ItemId = item;
		Image = image;
		FileName = fileName;
	}

	public Image(Integer itemId, byte[] image) {
		super();
		ItemId = itemId;
		Image = image;
	}

	public Image(Integer itemId, String fileName) {
		super();
		ItemId = itemId;
		FileName = fileName;
	}

	public Image() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public Integer getItem() {
		return ItemId;
	}

	public void setItem(Integer item) {
		ItemId = item;
	}

	public byte[] getImage() {
		return Image;
	}

	public void setImage(byte[] image) {
		Image = image;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}
	
	
	

}
