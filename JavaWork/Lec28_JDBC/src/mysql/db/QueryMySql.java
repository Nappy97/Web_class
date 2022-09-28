package mysql.db;

public interface QueryMySql {
	
	//  1. DB 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보 (MySQL 8 이상)
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	// DB 접속 사용자 계정 정보
	public static final String USER = "myuser609";
	public static final String PASSWD = "1234";
	
	public static final String URL = "jdbc:mysql://localhost:3306/mydb609?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true";
	
	
	// PrepardeStatment 에서 사용할 SQL 문
	public static final String SQL_SELECT_ALL = 
			"SELECT * FROM test_member";
	
	public static final String SQL_SELECT_BY_NAME = 
			"SELECT * FROM test_member WHERE mb_name = ?";
	
	public static final String SQL_INSERT =
			"INSERT INTO test_member VALUES(?, ?, ?)";
	
	public static final String SQL_UPDATE_NO =
			"UPDATE test_member SET mb_no = ? WHERE mb_name = ?";
	
	public static final String SQL_SELECT_ALL2 =
			"SELECT * FROM test_member2 ORDER BY id DESC";
	
	public static final String SQL_INSERT2 =
			"INSERT INTO test_member2 (name) VALUES(?)";

}
