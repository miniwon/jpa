import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.EmpVO;

public class EmpMergeMain {

	public static void main(String[] args) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bContextState");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			EmpVO vo = new EmpVO();
			vo.setEmpno(1999);
			vo.setEname("맹맹이");

			tx.begin();
			em.persist(vo);
			tx.commit();

			
		}catch(Exception ex) {
			System.out.println("예외 : "+ex.getMessage());
		}finally {
			tx.commit();
			em.close();			
		}
	}

}
