package dao;

import java.util.HashMap;
import java.util.List;

import dto.CouponDTO;
import dto.EventDTO;
import dto.MemDTO;
import dto.NoticeDTO;
import dto.PageDTO;

import dto.QuestionDTO;

public interface NoticeDao {
	public int count();
	public List<NoticeDTO> list(PageDTO pv);
	public void readCount(int num);
	public NoticeDTO content(int num);
	public void reStepCount(NoticeDTO dto);
	public void save(NoticeDTO dto);
	public NoticeDTO updateNum(int num);
	public void update(NoticeDTO dto);
	public void delete(int num);
	
	public String getFile(int num);
	
	/////////////Q&A///////////////
	
	public int counts();
	public List<QuestionDTO> qna(PageDTO pv);
	public List<QuestionDTO> qna2(HashMap<String, Object> map);
	public List<QuestionDTO> qna3(HashMap<String, Object> map);
	public void qnaviewcnt(int num);
	public QuestionDTO qnacontents(int num);
	
	public void qnainsert(QuestionDTO dto);
	public QuestionDTO qnaupdateNum(int num);
	public void qnaupdate(QuestionDTO dto);
	public void qnadelete(int num);
	public void step(QuestionDTO dto);
	public int counts2(String search);
	public int counts3(String search);

	
	/////////////event////////////////
	
	public int counta();
	public List<EventDTO> event(PageDTO pv);
	public void viewcnt(int num);
	public EventDTO contentsa(int num);
	public void insert(EventDTO dto );
	public EventDTO updateNuma(int num);
	public void updatea(EventDTO dto);
	public void deletea(int num);
	
	//////////coupon//////////////////
	
	public void cinsert(CouponDTO cdto);
	public void cinsert2(CouponDTO cdto);
	public void cinsert3(CouponDTO cdto);
	
	public CouponDTO ccontents(int num);
	
	
	
	public MemDTO meminfoMethod(String id);
	
	

}
