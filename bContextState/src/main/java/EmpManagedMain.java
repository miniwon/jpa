import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.EmpVO;

public class EmpManagedMain {

	public static void main(String[] args) {

		// 1299 사번의 정보로 홍길숙님 정보 입력
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bContextState");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			/*
			 * EmpVO vo = new EmpVO(); vo.setEmpno(1234); vo.setEname("홍이삼");
			 * em.persist(vo);
			 */

			EmpVO emp1 = em.find(EmpVO.class, 1297);
			System.out.println("검색결과 : " + emp1);

			EmpVO emp2 = em.find(EmpVO.class, 1297);
			System.out.println("검색결과 : " + emp2);

			if (emp1 == emp2)
				System.out.println("동일객체");
			else
				System.out.println("다른객체");

		} catch (Exception ex) {
			System.out.println("실패 : " + ex.getMessage());

		} finally {
			tx.commit();
			em.close();
		}

	}

}
