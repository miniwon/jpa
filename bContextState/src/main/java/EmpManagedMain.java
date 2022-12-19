import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.EmpVO;

public class EmpManagedMain {
	public static void main(String[] args) {
		// 1. 엔티티매니저팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aBasic");
		
		// 2. 엔티티매니저
		EntityManager em = emf.createEntityManager();
		
		// 4. 엔티티트랜잭션 (커밋)
		EntityTransaction tx = em.getTransaction();
		
		/* 
		EmpVO emp = new EmpVO();
		emp.setEmpno(1299);
		emp.setEname("홍길숙");
		
		em.persist(emp);
		*/
		
		EmpVO emp1 = em.find(EmpVO.class, 1299);
		System.out.println("검색 결과: " + emp1);
		
		EmpVO emp2 = em.find(EmpVO.class, 1297);
		System.out.println("검색 결과: " + emp2);
		
		if( emp1 == emp2 ) System.out.println("동일 객체");
		else System.out.println("다른 객체");
		

	}
}
