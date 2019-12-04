package com.revature.Videoservicespring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "videos")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;
	
	private String videoName;
	private String displayName;
	private String tags;
	private String vimeoVideoUrl;
	private String description;
	private String transcript;
	private int level_id;
	private int category_id;
	private boolean status;
	

}
