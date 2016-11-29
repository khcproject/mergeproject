package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.MemDTO;
import dto.PubDTO;
import dto.ReservationDTO;
import dto.TalkDTO;

public class MyPage_DaoImp implements Mypage_Dao{
	
	private SqlSessionTemplate sqlSession;
	
	public MyPage_DaoImp() {
		
};
	
public void setSqlSession(SqlSessionTemplate sqlSession) {
	this.sqlSession = sqlSession;
};
	

@Override
public void testinsMethod(MemDTO mdto) {
		sqlSession.insert("mypage.testins",mdto);
};

@Override
public List<MemDTO> mypageCouponMethod(String id) {
	return sqlSession.selectList("mypage.coupon_view",id);
};

@Override
public List<MemDTO> mypageCusReservMethod(String id) {
	return sqlSession.selectList("mypage.cusreserv",id);
};

@Override
public List<MemDTO> mypageSellReservMethod(String id) {
	return sqlSession.selectList("mypage.sellreserv",id);
};

@Override
public List<MemDTO> mypageAdminSellMethod() {
	return sqlSession.selectList("mypage.admin_selljoin");
};

@Override
public List<PubDTO> mypageAdminPubMethod() {
	return sqlSession.selectList("mypage.admin_pubjoin");
};

@Override
public void delCusReservMethod(ReservationDTO rdto) {
	 sqlSession.delete("mypage.cusdelreserv",rdto);
};

@Override
public void ableReservMethod(ReservationDTO rdto) {
	sqlSession.update("mypage.ablereserv",rdto);
};

@Override
public void ableCouponMethod(ReservationDTO rdto) {
	sqlSession.update("mypage.ablecoupon",rdto);
};

@Override
public void disableReservMethod(ReservationDTO rdto) {
	sqlSession.update("mypage.disablereserv",rdto);
};

@Override
public void ableSellMethod(MemDTO mdto) {
	sqlSession.update("mypage.ablesell",mdto);
};

@Override
public void ableSellTalkMethod(MemDTO mdto) {
	sqlSession.insert("mypage.ableselltalk",mdto);
};

@Override
public void disableSellMethod(MemDTO mdto) {
	sqlSession.update("mypage.disablesell",mdto);
};

@Override
public void disableSellTalkMethod(MemDTO mdto) {
	sqlSession.insert("mypage.disableselltalk",mdto);
};

@Override
public MemDTO memuptintMethod(MemDTO mdto) {
	return sqlSession.selectOne("mypage.memuptint",mdto);
};

@Override
public String memFaceMethod(String id) {
	return sqlSession.selectOne("mypage.memfacechk",id);
};

@Override
public void memUptMethod(MemDTO mdto) {
	sqlSession.update("mypage.memuptok", mdto);
};

@Override
public List<MemDTO> leavememMethod(MemDTO mdto) {
	return sqlSession.selectList("mypage.leavemem",mdto);
};

@Override
public void deletememMethod(MemDTO mdto) {
		sqlSession.delete("mypage.delleavemem",mdto);
};

@Override
public void joinSellerMethod(MemDTO mdto) {
		sqlSession.update("mypage.joinseller",mdto);
};

@Override
public MemDTO meminfoMethod(String id) {
	return sqlSession.selectOne("mypage.pubmemid",id);
}

@Override
public void pubinsMethod(PubDTO pdto) {
		sqlSession.insert("mypage.pubins",pdto);
};

@Override
public int reservListNumMethod(String id) {
	return sqlSession.selectOne("mypage.reservcount",id);
};

@Override
public List<PubDTO> reservAllListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.sellreservalllist",map);
};

@Override
public List<MemDTO> delMemPicMethod(String id) {
	return sqlSession.selectList("mypage.delmemallpic",id);
};

@Override
public List<MemDTO> updatePubMethod(String id) {
	return sqlSession.selectList("mypage.mempubinfo",id);
};

@Override
public void updatePubOkMethod(PubDTO pdto) {
		sqlSession.selectList("mypage.updatepub",pdto);
};

@Override
public String searchPubMImgMethod(String id) {
	return sqlSession.selectOne("mypage.searchpubmimg",id);
};

@Override
public String searchPubSImgMethod(String id) {
	return sqlSession.selectOne("mypage.searchpubsimg",id); 
};

@Override
public int respMsgCountMethod(String id) {
	return sqlSession.selectOne("mypage.resp_mesgcount",id);
};

@Override
public List<TalkDTO> respMsgListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.resp_mesglist",map);
};

@Override
public void deleteMsgMethod(Integer[] data) {
		sqlSession.delete("mypage.multidelmsg",data);
};

@Override
public int searchSubjectCntMethod(HashMap<String, Object> map) {
	return sqlSession.selectOne("mypage.searchsubjectcount",map);
};

@Override
public List<TalkDTO> searchSubjectListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.searchsubject",map);
};

@Override
public int searchContentsCntMethod(HashMap<String, Object> map) {
	return sqlSession.selectOne("mypage.searchcontentcount",map);
};

@Override
public List<TalkDTO> searchContentsListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.searchcontent",map);
};

@Override
public int searchDoubleCntMethod(HashMap<String, Object> map) {
	return sqlSession.selectOne("mypage.searchdoublecount",map);
};

@Override
public List<TalkDTO> searchDoubleListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.searchdouble",map);
};

@Override
public int searchIdCntMethod(HashMap<String, Object> map) {
	return sqlSession.selectOne("mypage.searchidcount",map);
};

@Override
public List<TalkDTO> searchIdListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.searchid",map);
};

@Override
public int sendMsgCountMethod(String id) {
	return sqlSession.selectOne("mypage.send_mesgcount",id);
};

@Override
public List<TalkDTO> sendMsgListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.send_mesglist",map);
};

@Override
public int sendsearchSubjectCntMethod(HashMap<String, Object> map) {
	return sqlSession.selectOne("mypage.sendsearchsubjectcount",map);
};

@Override
public List<TalkDTO> sendsearchSubjectListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.sendsearchsubject",map);
};

@Override
public int sendsearchContentsCntMethod(HashMap<String, Object> map) {
	return sqlSession.selectOne("mypage.sendsearchcontentcount",map);
};

@Override
public List<TalkDTO> sendsearchContentsListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.sendsearchcontent",map);
};

@Override
public int sendsearchDoubleCntMethod(HashMap<String, Object> map) {
	return sqlSession.selectOne("mypage.sendsearchdoublecount",map);
};

@Override
public List<TalkDTO> sendsearchDoubleListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.sendsearchdouble",map);
};

@Override
public int sendsearchIdCntMethod(HashMap<String, Object> map) {
	return sqlSession.selectOne("mypage.sendsearchidcount",map);
};

@Override
public List<TalkDTO> sendsearchIdListMethod(HashMap<String, Object> map) {
	return sqlSession.selectList("mypage.sendsearchid",map);
};

@Override
public void insWrtieMsgMethod(TalkDTO tdto) {
	 sqlSession.insert("mypage.writemesg",tdto);
};

@Override
public TalkDTO viewMsgMethod(int num) {
	return sqlSession.selectOne("mypage.viewmsg",num);
};

@Override
public void delViewMsgMethod(int num) {
	sqlSession.delete("mypage.delviewmsg",num);
};

};
