import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.EmpVO;

public class EmpRemoveMain {

	public static void main(String[] args) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bContextState");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			// [1] find()
			EmpVO emp1 = em.find(EmpVO.class, 1297);
			System.out.println("검색 결과 : "+emp1);
			
			// [2] getReference()
			EmpVO emp2 = em.getReference(EmpVO.class, 1298);
			System.out.println("검색 결과2: " + emp2);
			
			// [3] JPQL (Java Persistence Query Language)
			// createQuery()
			// => 테이블명이 아니라 엔티티명이다(대소문자 구별)
			String jpql = "SELECT e FROM EmpVO e ORDER BY e.empno DESC";
			List<EmpVO> list = em.createQuery(jpql, EmpVO.class).getResultList();
			for (EmpVO vo: list) {
				System.out.println(">>>>" + vo);
			}
			
		}catch(Exception ex) {
			System.out.println("예외 : "+ex.getMessage());
		}finally {
			tx.commit();
			em.close();			
		}
	}

}
