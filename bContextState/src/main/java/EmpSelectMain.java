import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.EmpVO;

public class EmpSelectMain {

	public static void main(String[] args) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bContextState");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			// Persistence Context에 엔티티(Entity)를 올려놓기
			// 엔티티를 Managed 상태로 만들 것
			EmpVO emp1 = em.find(EmpVO.class, 1299);
			System.out.println("검색 결과 : "+emp1);
			
			// 엔티티 수정
			tx.begin();
			em.remove(emp1);
			tx.commit();
			
			EmpVO emp2 = em.find(EmpVO.class, 1299); // select 문장을 보내지 않음
			System.out.println("검색 결과 : "+emp2);
			
			
		}catch(Exception ex) {
			System.out.println("예외 : "+ex.getMessage());
		}finally {
			tx.commit();
			em.close();			
		}
	}

}
