import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.domain.Board;

public class Main1Basic {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dJpql");
		
		try {
			
			// board 테이블에서 3번 레코드를 화면에 출력
			selectData(emf);
			
		}catch(Exception ex) {
			System.out.println("예외 : "+ex.getMessage());
		}finally {
			emf.close();
		}//end of try/catch/finally
	}	// end of main

	static void selectData(EntityManagerFactory emf) {
		EntityManager em  = emf.createEntityManager();
		
		// ************ JPQL
		// [1] 검색 결과를 특정할 수 있는 경우: TypedQuery
		// from 뒤에 들어가는 건 클래스명(대소문자 구분)
		/*
		 * String jpql = "SELECT b FROM Board AS b"; TypedQuery<Board> query =
		 * em.createQuery(jpql, Board.class); List<Board> list = query.getResultList();
		 * 
		 * for (Board result: list) { System.out.println(">>>>" + result); }
		 */
		
		// [2] 검색 결과를 특정할 수 없는 경우: Query
		 String jpql = "SELECT seq, writer, title FROM Board";
		 Query query = em.createQuery(jpql);
		 List<Object[]> list = query.getResultList();
		 
		 for (Object[] result: list) { System.out.println(">>>>" + Arrays.toString(result)); }
		
		/*
		 * Board board = em.find(Board.class, 3); // select 문장 넣어서 해당하는 것 반환함
		 * System.out.println(board.getSeq()+"번 글 정보"); System.out.println("제목: " +
		 * board.getTitle()); System.out.println("작성자: " + board.getWriter());
		 * System.out.println("내용: " + board.getContent()); System.out.println("작성일: " +
		 * board.getRegdate());
		 */
		
		em.close();
	}	// end of selectData
}
