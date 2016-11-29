package service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.CouponDTO;
import dto.EventDTO;
import dto.MemDTO;
import dto.NoticeDTO;
import dto.PageDTO;
import dto.QuestionDTO;

public interface NoticeService {
public int countProcess();
public List<NoticeDTO> listProcess(PageDTO pv);
public void insertProcess(NoticeDTO dto);
public NoticeDTO contentProcess(int num);

public NoticeDTO updateSelectProcess(int num);
public void updateProcess(NoticeDTO dto);
public void deleteProcess(int num);

///////////////qna///////////////////////////////


public int countsProcess();
public List<QuestionDTO> qnaProcess(PageDTO pv);
public List<QuestionDTO> qnaProcess2(HashMap<String, Object> map);
public List<QuestionDTO> qnaProcess3(HashMap<String, Object> map);
public QuestionDTO qnacontentProcess(int num);
public void qnainsertProcess(QuestionDTO dto);
public QuestionDTO qnaupdateSelectProcess(int num);
public void qnaupdateProcess(QuestionDTO dto,HttpServletRequest request);
public void qnadeleteProcess(int num,HttpServletRequest request);
public void stepProcess(QuestionDTO dto);
public int counts2Process(String search);
public int counts3Process(String search);

//////////////////event/////////////////////////////////

public int countaProcess();
public List<EventDTO> eventProcess(PageDTO pv);
public void insertProcess(EventDTO dto);
public EventDTO contentsaProcess(int num);
public EventDTO updateaSelectProcess(int num);
public void updateaProcess(EventDTO dto);
public void deleteaProcess(int num,HttpServletRequest request);

//////////////coupon/////////////////////////////////////

public void cinsertProcess(CouponDTO cdto);
public void cinsertProcess2(CouponDTO cdto);
public void cinsertProcess3(CouponDTO cdto);

public CouponDTO ccontentsProcess(int num);

public MemDTO meminfoProcess(String id);


}
