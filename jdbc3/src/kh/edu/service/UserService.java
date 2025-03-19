package kh.edu.service;

import java.sql.Connection;

import kh.edu.common.JDBCTemlate;
import kh.edu.dao.UserDAO;
import kh.edu.dto.User;

public class UserService {
	
	private UserDAO dao = new UserDAO();

	public int insertUser(User user) throws Exception {
		Connection conn = JDBCTemlate.getConnection();
		
		int result = dao.insertUser(conn, user);
		
		if(result > 0) {
			JDBCTemlate.commit(conn);
		} else {
			JDBCTemlate.rollback(conn);
		}
		
		return result;
	}

}
