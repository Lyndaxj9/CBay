package com.CBay.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column
	private Integer ItemID;
	
	
	@Column
	private Blob Image;
	
	@Column
	private String FileName;
	
	
	public Image(Integer iD, Integer itemID, Blob image, String fileName) {
		super();
		ID = iD;
		ItemID = itemID;
		Image = image;
		FileName = fileName;
	}

	public Image(Integer itemID, Blob image, String fileName) {
		super();
		ItemID = itemID;
		Image = image;
		FileName = fileName;
	}



	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getItemID() {
		return ItemID;
	}

	public void setItemID(Integer itemID) {
		ItemID = itemID;
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
