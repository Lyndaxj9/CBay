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
	@SequenceGenerator(sequenceName="IMAGE_ID_SEQ", name="IMAGE_ID_SEQ")
	@GeneratedValue(generator="IMAGE_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer ID;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ItemID")
	private Item item;
	
	@Column
	private Blob Image;
	
	@Column
	private String FileName;

	public Image(Integer iD, Item item, Blob image, String fileName) {
		super();
		ID = iD;
		this.item = item;
		Image = image;
		FileName = fileName;
	}

	public Image(Item item, Blob image, String fileName) {
		super();
		this.item = item;
		Image = image;
		FileName = fileName;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Blob getImage() {
		return Image;
	}

	public void setImage(Blob image) {
		Image = image;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}
	
	
	

}
