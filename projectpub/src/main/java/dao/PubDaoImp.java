package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.MemDTO;
import dto.PubDTO;
import dto.PubPageDTO;

public class PubDaoImp implements PubDao {
	private SqlSessionTemplate sqlSession;
	
	public PubDaoImp() {
}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	//펍저장
	@Override
	public void save(PubDTO dto) {
		sqlSession.insert("aaa.save",dto);
	}

	//랭킹
	@Override
	public List<PubDTO> get() {
		return sqlSession.selectList("aaa.get");
	}

	//전체 가져오기
	@Override
	public int count() {
		return sqlSession.selectOne("aaa.count");
	}

	//전체 펍 4개씩 가져오기
	@Override
	public List<PubDTO> list(PubPageDTO pv) {
		return sqlSession.selectList("aaa.list",pv);
	}

	//미구현
	@Override
	public int searcount(String data) {
		return sqlSession.selectOne("aaa.search",data);
	}

	@Override
	public List<PubDTO> searchlist(PubPageDTO pv) {

		return sqlSession.selectList("aaa.searchlist",pv);
	}

	@Override
	public void managero(String id) {
		sqlSession.selectOne("aaa.managero",id);
	}

	@Override
	public void managerc(String id) {
		sqlSession.selectOne("aaa.managerc",id);
	}

	@Override
	public void supo(String id) {
		sqlSession.selectOne("aaa.pok",id);
	}

	@Override
	public void supc(String id) {
		sqlSession.selectOne("aaa.pcan",id);
	}

	@Override
	public List<String> date() {
		return sqlSession.selectList("aaa.dates");
	}

	@Override
	public int supcount() {
		return sqlSession.selectOne("aaa.memycount");
	}

	@Override
	public int concount() {
		return sqlSession.selectOne("aaa.concount");
	}

	@Override
	public int pubcount() {
		return sqlSession.selectOne("aaa.count");
	}
	
	@Override
	public int memrcount() {
		return sqlSession.selectOne("aaa.memrcount");
	}
	
	@Override
	public List<MemDTO> memr() {
		return sqlSession.selectList("aaa.memr");
	}
	
	@Override
	public int suprcount() {
		return sqlSession.selectOne("aaa.suprcount");
	}
	
	@Override
	public List<PubDTO> supr() {
		return sqlSession.selectList("aaa.admin_pubjoin");
	}

	@Override
	public int memcount() {
		return sqlSession.selectOne("aaa.memtotal");
	}

	@Override
	public List<String> mwtotal() {
		return sqlSession.selectList("aaa.mwcount");
	}

	@Override
	public List<String> birth() {
		return sqlSession.selectList("aaa.birth");
	}

	@Override
	public List<MemDTO> pubpre(String id) {
		return sqlSession.selectList("aaa.mempubinfo",id);
	}
	
}//end class
