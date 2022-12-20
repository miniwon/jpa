import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.domain.Board;

public class Main2Parameter {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dJpql");

		try {
			// selectData(emf);
			// deleteData(emf);

			// 7788번 사원의 월급을 2000으로 변경
			updateData(emf);

		} catch (Exception ex) {
			System.out.println("예외 : " + ex.getMessage());
		} finally {
			emf.close();
		} // end of try/catch/finally
	} // end of main

	static void selectData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();

		// [1] 파라미터 바인딩(위치 인자)
		/*
		 * String jpql = "SELECT seq, writer, title FROM Board	" +
		 * "	WHERE seq=?1 AND title=?2"; Query query = em.createQuery(jpql);
		 * query.setParameter(1, 10); query.setParameter(2, "치킨 탕수육"); List<Object[]>
		 * list = query.getResultList();
		 * 
		 * for (Object[] result: list) { System.out.println(">>>>" +
		 * Arrays.toString(result)); }
		 */

		// [2] 파라미터 바인딩(키워드 인자)
		String jpql = "SELECT seq, writer, title FROM Board	" + "	WHERE seq=:seqkw AND title=:titlekw";
		Query query = em.createQuery(jpql);
		query.setParameter("seqkw", 10);
		query.setParameter("titlekw", "치킨 탕수육");

		List<Object[]> list = query.getResultList();
		for (Object[] result : list) {
			System.out.println(">>>>" + Arrays.toString(result));
		}

		List<Object[]> list2 = query.getResultList();
		for (Object[] result : list2) {
			System.out.println(">>>>" + Arrays.toString(result));
		}

		if (list == list2)
			System.out.println("동일 객체");
		else
			System.out.println("다른 객체");

		em.close();
	} // end of selectData

	static void deleteData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();

		// JPQL
		String jpql = "DELETE Employee e WHERE e.empno=:emp_no";

		Query query = em.createQuery(jpql);
		query.setParameter("emp_no", 7934);

		// 실행
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		int result = query.executeUpdate();
		System.out.println(result + "행을 수행");

		tx.commit();
		em.close();

	} // end of deleteData
	
	static void updateData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();

		// JPQL
		String jpql = "UPDATE Employee e SET sal=:sal WHERE e.empno=:emp_no";

		Query query = em.createQuery(jpql);
		query.setParameter("sal", 2000);
		query.setParameter("emp_no", 7788);

		// 실행
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		int result = query.executeUpdate();
		System.out.println(result + "행을 수행");

		tx.commit();
		em.close();

	} // end of deleteData
}
