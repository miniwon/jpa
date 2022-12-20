package com.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Board")
public class Board {
	// 멤버변수 작성
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int		seq;
	
	private String	title;
	private String	writer;
	private String	content;
	private Date	regdate;
	private int		cnt;
}
