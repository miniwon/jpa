package com.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApp {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cReference");
		
		try {
			
			// [1] 연관관계를 이용한 데이타 검색
			// selectData(emf);
			
			// [2] 연관관계를 이용한 데이타 입력
			// insertData(emf);
			
			// [3] 연관관계를 이용한 데이터 수정
			// updateData(emf);
			
			// [4] 연관관계를 이용한 데이터 삭제
			deleteData(emf);
			
		}catch(Exception ex) {
			System.out.println("예외 : "+ex.getMessage());
		}finally {
			emf.close();
		}//end of try/catch/finally
		
	}//main 끝
	
	// [1] 연관관계를 이용한 데이타 검색
	static void selectData(EntityManagerFactory emf) {
		
		EntityManager em  = emf.createEntityManager();
		Employee e1 = em.find(Employee.class, 7788); // select 문장 넣어서 해당하는 것 반환함
		System.out.println(e1.getEname()+"님 정보");
		System.out.println("부서 : "+e1.getDept().getDname());
		
		em.close();
	}//selectData 끝
	
	// [2] 연관관계를 이용한 데이타 입력
	static void insertData(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Employee emp1 = new Employee();
		emp1.setEname("쟁3");
		
		//Department dept = em.find(Department.class, 40);
		Department dept = new Department();
		dept.setDeptno(60);
		dept.setDname("IT");
		dept.setLoc("서울");
		em.persist(dept);
		
		emp1.setDept(dept);
		
		em.persist(emp1);
		
		tx.commit();
		em.close();
		
	}//insertData 끝
	
	// [3] 연관관계를 이용한 데이터 수정
	static void updateData(EntityManagerFactory emf) {
		// 사번이 '7369'인 사원의 부서를 40번 부서로 변경
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// 사원의 정보를 찾아 Employee 클래스에 저장하고
		Employee emp = em.find(Employee.class, 7369); // select 문장 넣어서 해당하는 것 반환함
		
		// 사번의 정보를 찾아 Department 클래스에 저장
		Department dept = em.find(Department.class, 40);
		
		emp.setDept(dept);
		
		tx.commit();
		em.close();
	}	// end of updateData()
	
	// [4] 연관관계를 이용한 데이터 삭제
	static void deleteData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// 40번 부서를 삭제
		Department dept = em.find(Department.class, 40);
		// System.out.println(dept);
		em.remove(dept);
		
		// [해결1] 사원 테이블에서 40번 부서의 내용을 null 수정
		// [해결2] 40번 부서의 사원 정보를 먼저 삭제
		
		tx.commit();
		em.close();
		
	}
	
}
