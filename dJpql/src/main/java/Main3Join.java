import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.domain.Board;

public class Main3Join {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dJpql");

		try {
			selectData(emf);

		} catch (Exception ex) {
			System.out.println("예외 : " + ex.getMessage());
		} finally {
			emf.close();
		} // end of try/catch/finally
	} // end of main

	static void selectData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();

		// [1] 묵시적인 조인
		// String jpql = "SELECT e, e.dept FROM Employee e";

		// [2] 명시적인 조인(조건을 따로 기술하지 않아도 된다)
		String jpql = "SELECT e, d FROM Employee e INNER JOIN e.dept d";
		Query query = em.createQuery(jpql);

		// [3] 페이징 처리
		int pageNumber = 2;
		int pageSize = 3;
		int startNum = pageNumber * pageSize - pageSize;
		query.setFirstResult(startNum);
		query.setMaxResults(pageSize);

		List<Object[]> list = query.getResultList();
		for (Object[] result : list) {
			System.out.println(">>>>" + result[0]);
			System.out.println(">>>>" + result[1]);
		}

		em.close();
	} // end of selectData
}
