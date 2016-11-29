package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.CouponDTO;
import dto.MemDTO;
import dto.Pr_replyDTO;
import dto.PubDTO;
import dto.ReservationDTO;
import dto.StarsDTO;

public class ReservationDaoImp implements ReservationDao {

	SqlSessionTemplate sqlSession;

	public ReservationDaoImp() {
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public String getFile(int p_num) {
		return sqlSession.selectOne("reser.mupload", p_num);
	}

	@Override
	public List<PubDTO> reservationListMethod(int p_num) {
		return sqlSession.selectList("reser.view", p_num);
	}

	@Override
	public void meminsertMethod(MemDTO dto) {
		sqlSession.insert("reser.meminsert", dto);

	}

	@Override
	public void res_insertMethod(ReservationDTO dto) {
		sqlSession.insert("reser.resinsert", dto);
	}

	@Override
	public void save(PubDTO dto) {
		sqlSession.insert("reser.save", dto);
	}

	@Override
	public void replyInsertMethod(Pr_replyDTO dto) {
		sqlSession.insert("reser.replyinsert", dto);
	}

	@Override
	public List<Pr_replyDTO> replyListMethod(int p_num) {
		return sqlSession.selectList("reser.reply_List", p_num);
	}

	@Override
	public void replyDeleteMethod(int pr_num) {
		sqlSession.delete("reser.replyDel", pr_num);
	}

	@Override
	public void replyUpdateMethod(Pr_replyDTO dto) {
		sqlSession.update("reser.replyUpdate", dto);
	}

	@Override
	public void pubStarInsertMethod(StarsDTO dto) {
		sqlSession.insert("reser.pubStarIns", dto);
	}

	@Override
	public StarsDTO pubStarAvgMethod(int p_num) {
		return sqlSession.selectOne("reser.pubStarsSel", p_num);
	}

	@Override// 나중에 ID값을 넘겨줘야됨
	public List<CouponDTO> couponListMethod() {
		return sqlSession.selectList("reser.couponList");
	}

}
