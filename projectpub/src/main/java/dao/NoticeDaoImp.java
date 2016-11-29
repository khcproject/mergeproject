package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.CouponDTO;
import dto.EventDTO;
import dto.MemDTO;
import dto.NoticeDTO;
import dto.PageDTO;

import dto.QuestionDTO;

public class NoticeDaoImp implements NoticeDao{
private SqlSessionTemplate sqlSession;

public NoticeDaoImp(){
	
}
public void setSqlSession(SqlSessionTemplate sqlSession) {
	this.sqlSession = sqlSession;
}
@Override
public int count() {
	
	return sqlSession.selectOne("no.count") ;
}
@Override
public List<NoticeDTO> list(PageDTO pv) {
	
	return sqlSession.selectList("no.list",pv);
}
@Override
public void readCount(int num) {
	sqlSession.update("no.viewcnt",num);
	
}
@Override
public NoticeDTO content(int num) {
	
	return sqlSession.selectOne("no.content",num);
}
@Override
public void reStepCount(NoticeDTO dto) {
	// TODO Auto-generated method stub
	
}
@Override
public void save(NoticeDTO dto) {
	sqlSession.insert("no.save",dto);
	
}
@Override
public NoticeDTO updateNum(int num) {
	
	return sqlSession.selectOne("no.content", num);
}
@Override
public void update(NoticeDTO dto) {
	
	sqlSession.update("no.update",dto);
	
}
@Override
public void delete(int num) {
	sqlSession.delete("no.delete", num);
	
}


////////////////Q&A/////////////////////////////

@Override
public int counts() {
	
	return sqlSession.selectOne("qna.count");
}
@Override
public List<QuestionDTO> qna(PageDTO pv) {
	return sqlSession.selectList("qna.list", pv);
}
@Override
public void qnaviewcnt(int num) {
	sqlSession.update("qna.viewcnt",num);
	
}
@Override
public QuestionDTO qnacontents(int num) {
	return sqlSession.selectOne("qna.content", num);
}
@Override
public void qnainsert(QuestionDTO dto) {
	sqlSession.insert("qna.insert", dto);
	
}
@Override
public QuestionDTO qnaupdateNum(int num) {
	
	return sqlSession.selectOne("qna.content", num);
}
@Override
public void qnaupdate(QuestionDTO dto) {
	sqlSession.update("qna.update", dto);
	
}
@Override
public void qnadelete(int num) {

	sqlSession.delete("qna.delete", num);
}
@Override
public void step(QuestionDTO dto) {
	
	sqlSession.update("qna.stepcount", dto);
	
}

@Override
public int counts2(String search) {
	
	return sqlSession.selectOne("qna.count2",search);
}

@Override
public int counts3(String search) {
	
	return sqlSession.selectOne("qna.count3", search);
}

@Override
public List<QuestionDTO> qna2(HashMap<String, Object> map) {
	
	return sqlSession.selectList("qna.searchlist", map);
}

@Override
public List<QuestionDTO> qna3(HashMap<String, Object> map) {
	
	return sqlSession.selectList("qna.searchlist2",map);
}


/////////////event////////////////////////////////
@Override
public int counta() {
	
	return sqlSession.selectOne("event.count");
}
@Override
public List<EventDTO> event(PageDTO pv) {
	return sqlSession.selectList("event.evn", pv);
}
@Override
public void viewcnt(int num) {
	sqlSession.update("event.viewcnt", num);
}
@Override
public EventDTO contentsa(int num) {
	
	return sqlSession.selectOne("event.contents", num);
}
@Override
public void insert(EventDTO dto) {
	sqlSession.insert("event.insert", dto);
	
}
@Override
public EventDTO updateNuma(int num) {
	
	return sqlSession.selectOne("event.contents", num);
}
@Override
public void updatea(EventDTO dto) {
	
	sqlSession.update("event.update", dto);
	
}
@Override
public void deletea(int num) {
	sqlSession.delete("event.delete",num);
}


//////////coupon/////////////////////////////////

@Override
public void cinsert(CouponDTO cdto) {
	sqlSession.insert("event.coupon", cdto);
}

@Override
public void cinsert2(CouponDTO cdto) {
	sqlSession.insert("event.coupon2", cdto);
	
}
@Override
public void cinsert3(CouponDTO cdto) {
	sqlSession.insert("event.coupon3", cdto);
	
}


@Override
public CouponDTO ccontents(int num) {
	
	return sqlSession.selectOne("event.ccontents", num);
}
@Override
public String getFile(int num) {
	// TODO Auto-generated method stub
	return null;
}


@Override
	public MemDTO meminfoMethod(String id) {
		return sqlSession.selectOne("event.meminfo",id);
	}






	
}
