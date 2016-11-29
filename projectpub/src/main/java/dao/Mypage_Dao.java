package dao;

import java.util.HashMap;
import java.util.List;

import dto.MemDTO;
import dto.PubDTO;
import dto.ReservationDTO;
import dto.TalkDTO;

public interface Mypage_Dao {
	//insert member
    public void testinsMethod(MemDTO mdto);
    //회원정보와 쿠폰
    public List<MemDTO> mypageCouponMethod(String id);
    //구매자 예약 리스트
    public List<MemDTO> mypageCusReservMethod(String id);
    //판매자 예약 리스트
    public List<MemDTO> mypageSellReservMethod(String id);
    //관리자 : 판매자 신청 현황 리스트
    public List<MemDTO> mypageAdminSellMethod();
    //관리자 : Pub 신청 현황 리스트
    public List<PubDTO> mypageAdminPubMethod();
    //구매자 : 예약리스트 삭제
    public void delCusReservMethod(ReservationDTO rdto);
    //판매자 : 예약리스트 수락
    public void ableReservMethod(ReservationDTO rdto);
    public void ableCouponMethod(ReservationDTO rdto);
    //판매자 : 예약리스트 거부
    public void disableReservMethod(ReservationDTO rdto);
    //관리자 : 판매자 신청 수락
    public void ableSellMethod(MemDTO mdto);
    public void ableSellTalkMethod(MemDTO mdto);
    //관리자 : 판매자 신청 거부
    public void disableSellMethod(MemDTO mdto);
    public void disableSellTalkMethod(MemDTO mdto);
    //회원정보 수정 들어가기
    public MemDTO memuptintMethod(MemDTO mdto);
    //회원정보 수정 OK
    public String memFaceMethod(String id);
    public void memUptMethod(MemDTO mdto);
    //회원탈퇴 
    public List<MemDTO> leavememMethod(MemDTO mdto);
    public void deletememMethod(MemDTO mdto);
    //판매자 신청
    public void joinSellerMethod(MemDTO mdto);
    // pub등록 신청
    public MemDTO meminfoMethod(String id);
    public void pubinsMethod(PubDTO pdto);
    //판매자 : 총 예약 리스트화면	
    public int reservListNumMethod(String id);
    public List<PubDTO> reservAllListMethod(HashMap<String, Object> map);
    //회원탈퇴 사진 리스트
    public List<MemDTO> delMemPicMethod(String id);
    //PUB 수정 
    public List<MemDTO> updatePubMethod(String id);
    //PUB 수정 OK
    public String searchPubMImgMethod(String id);
    public String searchPubSImgMethod(String id);
    public void updatePubOkMethod(PubDTO pdto);
    //받은 쪽지함 
    public int respMsgCountMethod(String id);
    public List<TalkDTO> respMsgListMethod(HashMap<String, Object> map);
    //쪽지 삭제
    public void deleteMsgMethod(Integer[] data);
    //받은 쪽지함 검색
    public int searchSubjectCntMethod(HashMap<String, Object> map);
    public List<TalkDTO> searchSubjectListMethod(HashMap<String, Object> map);
    public int searchContentsCntMethod(HashMap<String, Object> map);
    public List<TalkDTO> searchContentsListMethod(HashMap<String, Object> map);
    public int searchDoubleCntMethod(HashMap<String, Object> map);
    public List<TalkDTO> searchDoubleListMethod(HashMap<String, Object> map);
    public int searchIdCntMethod(HashMap<String, Object> map);
    public List<TalkDTO> searchIdListMethod(HashMap<String, Object> map);
    //보낸 쪽지함
    public int sendMsgCountMethod(String id);
    public List<TalkDTO> sendMsgListMethod(HashMap<String, Object> map);
    //보낸 쪽지함 검색
    public int sendsearchSubjectCntMethod(HashMap<String, Object> map);
    public List<TalkDTO> sendsearchSubjectListMethod(HashMap<String, Object> map);
    public int sendsearchContentsCntMethod(HashMap<String, Object> map);
    public List<TalkDTO> sendsearchContentsListMethod(HashMap<String, Object> map);
    public int sendsearchDoubleCntMethod(HashMap<String, Object> map);
    public List<TalkDTO> sendsearchDoubleListMethod(HashMap<String, Object> map);
    public int sendsearchIdCntMethod(HashMap<String, Object> map);
    public List<TalkDTO> sendsearchIdListMethod(HashMap<String, Object> map);
    //쪽지 쓰기
    public void insWrtieMsgMethod(TalkDTO tdto);
    //받은 쪽지함  뷰 보기
    public TalkDTO viewMsgMethod(int num);
    //받은 쪽지함 뷰 삭제
    public void delViewMsgMethod(int num);
    
};
