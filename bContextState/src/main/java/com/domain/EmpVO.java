package com.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
//**********
@Entity
@Table(name="EMP_C") // 오라클 외의 다른 DB는 대소문자 구분
public class EmpVO {
	
	@Id
	private int empno; // primary key 지정
	
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	
	private int sal;
	private int comm;
	private int deptno;
	
}
