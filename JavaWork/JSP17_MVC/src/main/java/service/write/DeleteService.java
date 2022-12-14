package service.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.WriteDAO;
import service.Service;
import sqlmapper.SqlSessionManager;

public class DeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		// ※ 이 단계에서 parameter 검증 해야 한다.
		
		SqlSession sqlSession = null;
		WriteDAO dao = null;		
		
		int cnt = 0;
		
		try {
			sqlSession = SqlSessionManager.getInstance().openSession();
			dao = sqlSession.getMapper(WriteDAO.class);
			
			cnt = dao.deleteById(id);
			
			sqlSession.commit();
		} catch (SQLException e) {  
			e.printStackTrace();
		} finally {
			if(sqlSession!= null) sqlSession.close();
		}
		
		request.setAttribute("result", cnt);

	}

}
