package dao;

import org.mybatis.spring.SqlSessionTemplate;

import dto.MemDTO;

public class LoginlDaoImp implements LoginDao {

	SqlSessionTemplate sqlSession;

	public LoginlDaoImp() {
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void meminsertMethod(MemDTO dto) {
		sqlSession.insert("login.memInsert", dto);
	}

	@Override
	public String idchkMethod(MemDTO dto) {
		return sqlSession.selectOne("login.idchk", dto);
	}

	@Override
	public MemDTO loginMethod(MemDTO dto) {
		return sqlSession.selectOne("login.log", dto);
	}

}
