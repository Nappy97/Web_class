package service.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.WriteDAO;
import domain.WriteDTO;
import service.Service;
import sqlmapper.SqlSessionManager;

public class WriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 입력한 값을 받아오기
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// ※ 이 단계에서 parameter 검증 해야 한다.
		
		// 위 값들을 DTO에 담기
		WriteDTO dto = new WriteDTO();
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		
		int cnt = 0;
		
		SqlSession sqlSession = null;  // 트랜잭션을 위한 객체
		WriteDAO dao = null;
				
		try {
			sqlSession = SqlSessionManager.getInstance().openSession();
			dao = sqlSession.getMapper(WriteDAO.class); // MyBatis 가 생성한 DAO
			
			cnt = dao.insert(dto);  // 글 작성하고 auto-generated된 id값을 dto 에 받아옴
			System.out.println("글작성 성공 " + cnt + " : " + dto.getId());
			
			sqlSession.commit();  // 트랜잭션 커밋. commit() 이 실행되지 않으면. 아래 close() 시 rollback 된다.
		} catch (SQLException e) {
			e.printStackTrace();  // 예외 발생되면 rollback 된다.
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		request.setAttribute("result", cnt);
		request.setAttribute("dto", dto);  // auto-generated key(id)

	} // end execute()

} // end Command
















