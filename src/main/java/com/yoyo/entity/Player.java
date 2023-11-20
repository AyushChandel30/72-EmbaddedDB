package com.yoyo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name="PlayerInfo")
@Data
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PlayerId")
	private Integer id;
	
	@Column(name="PlayerName")
	private String name;
	
	@Column(name="PlayerAge")
	private Integer age;

}
