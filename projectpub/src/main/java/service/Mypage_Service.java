package service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.MemDTO;
import dto.PubDTO;
import dto.ReservationDTO;
import dto.TalkDTO;

public interface Mypage_Service {
	//insert member
	public void testinsProcess(MemDTO mdto);
	//회원정보와 쿠폰
	public List<MemDTO> mypageCouponProcess(String id);
    //구매자 예약 리스트
	public List<MemDTO> mypageCusReservProcess(String id);
	//판매자 예약 리스트
	public List<MemDTO> mypageSellReservProcess(String id);
	//관리자 : 판매자 신청 현황 리스트
	public List<MemDTO> mypageAdminSellProcess();
	 //관리자 : Pub 신청 현황 리스트
	public List<PubDTO> mypageAdminPubProcess();
	//구매자 예약리스트 삭제
	public void delCusReservProcess(ReservationDTO rdto);
	//판매자 : 예약리스트 수락
    public void ableReservProcess(ReservationDTO rdto);
    //판매자 : 예약리스트 거부
    public void disableReservProcess(ReservationDTO rdto);
    //관리자 : 판매자 신청 수락
    public void ableSellAllProcess(MemDTO mdto);
    //관리자 : 판매자 신청 거부
    public void disableSellAllProcess(MemDTO mdto);
    //회원정보 수정 들어가기
    public MemDTO memuptintProcess(MemDTO mdto);
    //회원정보 수정 OK
    public void memuptokProcess(MemDTO mdto,HttpServletRequest req);
    //회원탈퇴 정보
    public List<MemDTO> memDelListProcess(MemDTO mdto);
    //회원탈퇴
    public void memDelProcess(MemDTO mdto,HttpServletRequest req);
    //판매자 신청
    public void joinSellerProcess(MemDTO mdto);
    // pub등록 신청
    public MemDTO meminfoProcess(String id);
    public void pubInsAllProcess(PubDTO pdto, HttpServletRequest req);
    //판매자 : 총 예약 리스트화면	
    public int reservListNumProcess(String id);
    public List<PubDTO> reservAllListProcess(HashMap<String, Object> map);
    //PUB 수정
    public List<MemDTO> updatePubProcess(String id);
    //PUB 수정 OK
    public void updatePubOkProcess(PubDTO pdto, HttpServletRequest req);
    //받은 쪽지함 
    public int respMsgCountProcess(String id);
    public List<TalkDTO> respMsgListProcess(HashMap<String, Object> map);
    //쪽지 삭제
    public void deleteMsgProcess(Integer[] data);
    //받은 쪽지함 검색
    public int searchSubjectCountProcess(HashMap<String, Object> map);
    public List<TalkDTO> searchSubjectListProcess(HashMap<String, Object> map);
    public int searchContentsCountProcess(HashMap<String, Object> map);
    public List<TalkDTO> searchContentsListProcess(HashMap<String, Object> map);
    public int searchDoubleCountProcess(HashMap<String, Object> map);
    public List<TalkDTO> searchDoubleListProcess(HashMap<String, Object> map);
    public int searchIdCountProcess(HashMap<String, Object> map);
    public List<TalkDTO> searchIdListProcess(HashMap<String, Object> map);
    //보낸 쪽지함
    public int sendMsgCountProcess(String id);
    public List<TalkDTO> sendMsgListProcess(HashMap<String, Object> map);
    //받은 쪽지함 검색
    public int sendsearchSubjectCountProcess(HashMap<String, Object> map);
    public List<TalkDTO> sendsearchSubjectListProcess(HashMap<String, Object> map);
    public int sendsearchContentsCountProcess(HashMap<String, Object> map);
    public List<TalkDTO> sendsearchContentsListProcess(HashMap<String, Object> map);
    public int sendsearchDoubleCountProcess(HashMap<String, Object> map);
    public List<TalkDTO> sendsearchDoubleListProcess(HashMap<String, Object> map);
    public int sendsearchIdCountProcess(HashMap<String, Object> map);
    public List<TalkDTO> sendsearchIdListProcess(HashMap<String, Object> map);
    //쪽지 쓰기
    public void insWrtieMsgProcess(TalkDTO tdto);
    //받은 쪽지함  뷰 보기
    public TalkDTO viewMsgProcess(int num);
    //받은 쪽지함 뷰 삭제
    public void delViewMsgProcess(int num);
    
    
    };
    
    
