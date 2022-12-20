import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.domain.Employee;

public class Main9NativeQuery {

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
		
		// *******************
		// 기존의 SQL문 사용(jpql 아님)
		String sql = "SELECT * FROM EMP_A WHERE deptno=:dept_no";
		Query query = em.createNativeQuery(sql, Employee.class);
		query.setParameter("dept_no", 20);
		List<Employee> list = query.getResultList();

		for (Employee result : list) {
			System.out.println(">>>>" + result);
		}
		em.close();
	} // end of selectData
}
