package com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DEPT_A")
public class Department {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int deptno;
	private String dname;
	private String loc;
}
