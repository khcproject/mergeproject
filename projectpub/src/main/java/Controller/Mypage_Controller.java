package Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.MemDTO;
import dto.MessagePageDTO;
import dto.PubDTO;
import dto.ReservPageDTO;
import dto.ReservationDTO;
import dto.TalkDTO;
import service.Mypage_Service;

@Controller
public class Mypage_Controller {
	private Mypage_Service mservice;
	private int ReservcurrentPage;
	private ReservPageDTO reservpdto;
	private MessagePageDTO mesgpdto;
	private int respMsgCurrentPage;
	private int searchMsgCurrentPage;
	private int sendMsgCurrentPage;

	public Mypage_Controller() {

	};

	public void setMservice(Mypage_Service mservice) {
		this.mservice = mservice;
	};
	
	
	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public ModelAndView mypageProc(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		if(mem.getUserchk().equals("C")){
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));
		}else if(mem.getUserchk().equals("S")){
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		}
		mav.setViewName("mypage");
		return mav;
	};

	// 구매자 예약정보 삭제
	@RequestMapping("/delcusreserv.do")
	public @ResponseBody void delcusreservMethod(ReservationDTO rdto) {
		mservice.delCusReservProcess(rdto);
	};

	// 판매자 예약정보 수락
	@RequestMapping("/ablereserv.do")
	public @ResponseBody void ablereservMethod(ReservationDTO rdto) {
		mservice.ableReservProcess(rdto);
	};

	// 판매자 예약정보 삭제
	@RequestMapping("/disablereserv.do")
	public @ResponseBody void disablereservMethod(ReservationDTO rdto) {
		mservice.disableReservProcess(rdto);
	};

	// 관리자 : 판매자 신청 수락
	@RequestMapping("/ablesell.do")
	public @ResponseBody void ablesellMethod(MemDTO mdto) {
		mservice.ableSellAllProcess(mdto);
	};

	// 관리자 : 판매자 신청 거부
	@RequestMapping("/disablesell.do")
	public @ResponseBody void disablesellMethod(MemDTO mdto) {
		mservice.disableSellAllProcess(mdto);
	};

	// 회원정보 수정 들어가기
	@RequestMapping(value = "/memberupt.do", method = RequestMethod.GET)
	public ModelAndView memberupdateMethod(MemDTO mdto) {
		ModelAndView mav = new ModelAndView();

		// mav.addObject("mdto", mservice.memuptintProcess(mdto));

		MemDTO memdto = mservice.memuptintProcess(mdto);

		if (memdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(memdto.getId()));
		} else if (memdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(memdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		mav.setViewName("beforemempw");
		return mav;
	};

	// 회원정보 PW 체크
	@RequestMapping(value = "/mempwchk.do", method = RequestMethod.POST)
	public ModelAndView mempwchkMethod(MemDTO mdto) {
		ModelAndView mav = new ModelAndView();
		// mav.addObject("mdto", mservice.memuptintProcess(mdto));

		MemDTO memdto = mservice.memuptintProcess(mdto);

		if (memdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(memdto.getId()));
		} else if (memdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(memdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		mav.setViewName("memberupdate");
		return mav;
	};

	// 회원정보 수정 완료
	@RequestMapping(value = "/memberupdate.do", method = RequestMethod.POST)
	public ModelAndView memberupdateOkMethod(MemDTO mdto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		mservice.memuptokProcess(mdto, req);

		if (mdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mdto.getId()));
		} else if (mdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		mav.setViewName("mypage");
		return mav;
	};

	// 회원탈퇴 들어가기
	@RequestMapping(value = "/leaveready.do", method = RequestMethod.GET)
	public ModelAndView leavereadyMethod(MemDTO mdto) {
		ModelAndView mav = new ModelAndView();
		// mav.addObject("mdto", mservice.memDelListProcess(mdto));

		MemDTO memdto = mservice.memuptintProcess(mdto);

		if (memdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(memdto.getId()));
		} else if (memdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(memdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		mav.setViewName("leaveus");
		return mav;
	};

	// 회원 탈퇴 완료
	@RequestMapping(value = "/leaveus.do", method = RequestMethod.GET)
	public String leaveMethod(MemDTO mdto, HttpServletRequest req) {
		mservice.memDelProcess(mdto, req);
		return "redirect:/index.do";
	};

	// 판매자 신청 들어가기
	@RequestMapping(value = "/joinseller.do", method = RequestMethod.GET)
	public ModelAndView joinsellerMethod(MemDTO mdto) {
		ModelAndView mav = new ModelAndView();
		// mav.addObject("mdto", mservice.memuptintProcess(mdto));

		MemDTO memdto = mservice.memuptintProcess(mdto);

		if (memdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(memdto.getId()));
		} else if (memdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(memdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		mav.setViewName("joinseller");
		return mav;
	};

	// 판매자 신청 완료
	@RequestMapping(value = "/joinseller.do", method = RequestMethod.POST)
	public ModelAndView endjoinsellerMethod(MemDTO mdto) {
		ModelAndView mav = new ModelAndView();
		mservice.joinSellerProcess(mdto);

		MemDTO memdto = mservice.memuptintProcess(mdto);

		if (memdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(memdto.getId()));
		} else if (memdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(memdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		mav.setViewName("mypage");
		return mav;
	};

	// Pub 신청 들어가기
	@RequestMapping(value = "/joinpub.do", method = RequestMethod.GET)
	public ModelAndView joinpubreadyMethod(MemDTO mdto) {
		ModelAndView mav = new ModelAndView();
		// mav.addObject("mdto", mservice.memuptintProcess(mdto));

		MemDTO memdto = mservice.memuptintProcess(mdto);

		if (memdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(memdto.getId()));
		} else if (memdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(memdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(memdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		mav.setViewName("joinpub");
		return mav;
	};

	// pub 등록 신청 완료
	@RequestMapping(value = "/joinpub.do", method = RequestMethod.POST)
	public ModelAndView joinpubokMethod(PubDTO pdto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mservice.pubInsAllProcess(pdto, req);

		MemDTO mdto = mservice.meminfoProcess(pdto.getId());
		// userchk=C일경우
		if (mdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mdto.getId()));

		} else if (mdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		mav.setViewName("mypage");

		return mav;
	};

	// 판매자 : 전체 예약리스트
	@RequestMapping(value = "/sellreservlist.do", method = RequestMethod.GET)
	public ModelAndView reservlistMethod(ReservPageDTO pv, String id) {
		ModelAndView mav = new ModelAndView();
		int totalRecord = mservice.reservListNumProcess(id);
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				ReservcurrentPage = 1;
			else
				ReservcurrentPage = pv.getCurrentPage();

			reservpdto = new ReservPageDTO(ReservcurrentPage, totalRecord);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("pv", reservpdto);

			mav.addObject("pv", reservpdto);
			mav.addObject("sellreserv", mservice.reservAllListProcess(map));
		} else {
			ReservcurrentPage = 1;
			reservpdto = new ReservPageDTO(ReservcurrentPage, totalRecord);
			mav.addObject("pv", reservpdto);
		}

		MemDTO mdto = mservice.meminfoProcess(id);
		if (mdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mdto.getId()));
		} else if (mdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		// mav.addObject("mdto",mdto);
		mav.setViewName("reservlist");

		return mav;
	};

	// PUB 수정 들어가기
	@RequestMapping(value = "/updatepub.do", method = RequestMethod.GET)
	public ModelAndView updatepubMethod(String id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mdto", mservice.updatePubProcess(id));
		mav.setViewName("updatepub");
		return mav;

	};

	// PUB 수정 완료
	@RequestMapping(value = "/updatepub.do", method = RequestMethod.POST)
	public ModelAndView updatepubokMethod(PubDTO pdto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		mservice.updatePubOkProcess(pdto, req);

		MemDTO mdto = mservice.meminfoProcess(pdto.getId());
		// userchk=C일경우
		if (mdto.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mdto.getId()));

		} else if (mdto.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mdto.getId()));
		} else {// userchk=A일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mdto.getId()));
			mav.addObject("adminsellchk", mservice.mypageAdminSellProcess());
			mav.addObject("adminpubchk", mservice.mypageAdminPubProcess());
		}

		mav.setViewName("mypage");
		return mav;
	};

	// 받은 쪽지함
	@RequestMapping(value = "/gotomessage.do", method = RequestMethod.GET)
	public ModelAndView respmsglistMethod(String id, MessagePageDTO pv) {
		ModelAndView mav = new ModelAndView();

		int totalRecord = mservice.respMsgCountProcess(id);

		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				respMsgCurrentPage = 1;
			else
				respMsgCurrentPage = pv.getCurrentPage();

			mesgpdto = new MessagePageDTO(respMsgCurrentPage, totalRecord);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("pv", mesgpdto);

			mav.addObject("memid", id);
			mav.addObject("pv", mesgpdto);
			mav.addObject("respMsg", mservice.respMsgListProcess(map));
		} else {
			respMsgCurrentPage = 1;
			mesgpdto = new MessagePageDTO(respMsgCurrentPage, totalRecord);
			mav.addObject("memid", id);
			mav.addObject("pv", mesgpdto);
		}

		mav.setViewName("message");
		return mav;
	};

	// 받은 쪽지함 삭제
	@RequestMapping(value = "/delmsg.do", method = RequestMethod.GET)
	public @ResponseBody void deletemsgMethod(Integer[] data) {
		mservice.deleteMsgProcess(data);
	};

	// 받은 쪽지함 검색
	@RequestMapping(value = "/searchmsg.do", method = RequestMethod.GET)
	public ModelAndView searchMsgMethod(String searchop, String searchworld, String id, MessagePageDTO pv) {
		ModelAndView mav = new ModelAndView();
		if (searchop.equals("subject")) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("searchworld", searchworld);
			int totalRecord = mservice.searchSubjectCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					searchMsgCurrentPage = 1;
				else
					searchMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", id);
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				mav.addObject("memid", id);
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("respMsg", mservice.searchSubjectListProcess(map2));
			} else {
				searchMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);
				mav.addObject("memid", id);
				mav.addObject("spv", mesgpdto);
			}
		}
		;// end subject

		if (searchop.equals("contents")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("searchworld", searchworld);
			int totalRecord = mservice.searchContentsCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					searchMsgCurrentPage = 1;
				else
					searchMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", id);
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				mav.addObject("memid", id);
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("respMsg", mservice.searchContentsListProcess(map2));
			} else {
				searchMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);
				mav.addObject("memid", id);
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end contents

		if (searchop.equals("subandcon")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("searchworld", searchworld);
			int totalRecord = mservice.searchDoubleCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					searchMsgCurrentPage = 1;
				else
					searchMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", id);
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				mav.addObject("memid", id);
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("respMsg", mservice.searchDoubleListProcess(map2));
			} else {
				searchMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);
				mav.addObject("memid", id);
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end subandcontent

		if (searchop.equals("searchid")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("searchworld", searchworld);
			int totalRecord = mservice.searchIdCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					searchMsgCurrentPage = 1;
				else
					searchMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", id);
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				mav.addObject("memid", id);
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("respMsg", mservice.searchIdListProcess(map2));
			} else {
				searchMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);
				mav.addObject("memid", id);
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end id

		mav.setViewName("message");
		return mav;
	};

	// 보낸 쪽지함
	@RequestMapping(value = "/sendmessage.do", method = RequestMethod.GET)
	public ModelAndView sendmsgMethod(String id, MessagePageDTO pv) {
		ModelAndView mav = new ModelAndView();

		int totalRecord = mservice.sendMsgCountProcess(id);

		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				sendMsgCurrentPage = 1;
			else
				sendMsgCurrentPage = pv.getCurrentPage();

			mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("pv", mesgpdto);

			mav.addObject("memid", id);
			mav.addObject("pv", mesgpdto);
			mav.addObject("sendMsg", mservice.sendMsgListProcess(map));
		} else {
			sendMsgCurrentPage = 1;
			mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
			mav.addObject("memid", id);
			mav.addObject("pv", mesgpdto);
		}

		mav.setViewName("sendmessage");
		return mav;
	};

	// 보낸 쪽지함 삭제
	@RequestMapping(value = "/senddelmsg.do", method = RequestMethod.GET)
	public @ResponseBody void senddeletemsgMethod(Integer[] data) {
		mservice.deleteMsgProcess(data);
	};

	// 보낸 쪽지함 검색
	@RequestMapping(value = "/sendsearchmsg.do", method = RequestMethod.GET)
	public ModelAndView sendsearchMsgMethod(String searchop, String searchworld, String id, MessagePageDTO pv) {
		ModelAndView mav = new ModelAndView();
		if (searchop.equals("subject")) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("searchworld", searchworld);
			int totalRecord = mservice.sendsearchSubjectCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					sendMsgCurrentPage = 1;
				else
					sendMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", id);
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				mav.addObject("memid", id);
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("sendMsg", mservice.sendsearchSubjectListProcess(map2));
			} else {
				sendMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
				mav.addObject("memid", id);
				mav.addObject("spv", mesgpdto);
			}
		}
		;// end subject

		if (searchop.equals("contents")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("searchworld", searchworld);
			int totalRecord = mservice.sendsearchContentsCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					sendMsgCurrentPage = 1;
				else
					sendMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", id);
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				mav.addObject("memid", id);
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("sendMsg", mservice.sendsearchContentsListProcess(map2));
			} else {
				sendMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
				mav.addObject("memid", id);
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end contents

		if (searchop.equals("subandcon")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("searchworld", searchworld);
			int totalRecord = mservice.sendsearchDoubleCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					sendMsgCurrentPage = 1;
				else
					sendMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", id);
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				mav.addObject("memid", id);
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("sendMsg", mservice.sendsearchDoubleListProcess(map2));
			} else {
				sendMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
				mav.addObject("memid", id);
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end subandcontent

		if (searchop.equals("searchid")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("searchworld", searchworld);
			int totalRecord = mservice.sendsearchIdCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					sendMsgCurrentPage = 1;
				else
					sendMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", id);
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				mav.addObject("memid", id);
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("sendMsg", mservice.sendsearchIdListProcess(map2));
			} else {
				sendMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
				mav.addObject("memid", id);
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end id

		mav.setViewName("sendmessage");
		return mav;
	};

	// 쪽지 작성페이지 들어가기
	@RequestMapping(value = "/writemessage.do", method = RequestMethod.GET)
	public ModelAndView writemsgMethod(String id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("memid", id);
		mav.setViewName("writemessage");
		return mav;

	};

	// 쪽지 발송 완료
	@RequestMapping(value = "/writemessage.do", method = RequestMethod.POST)
	public ModelAndView sendwritemsgMethod(TalkDTO tdto) {
		ModelAndView mav = new ModelAndView();

		mservice.insWrtieMsgProcess(tdto);

		mav.addObject("id", tdto.getId());
		mav.setViewName("redirect:/gotomessage.do");
		return mav;
	};

	// 받은 쪽지함 뷰 보기
	@RequestMapping(value = "/viewmsg.do", method = RequestMethod.GET)
	public ModelAndView viewmsgMethod(TalkDTO tdto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("memid", tdto.getId());
		mav.addObject("tdto", mservice.viewMsgProcess(tdto.getT_num()));
		mav.setViewName("viewmessage");
		return mav;
	};

	// 받은 쪽지함 뷰 삭제
	@RequestMapping(value = "/viewmsg.do", method = RequestMethod.POST)
	public ModelAndView delviewmsgMethod(TalkDTO tdto) {
		ModelAndView mav = new ModelAndView();
		mservice.delViewMsgProcess(tdto.getT_num());
		mav.addObject("id", tdto.getId());
		mav.setViewName("redirect:/gotomessage.do");
		return mav;
	};

	// 받은 쪽지함 뷰 답장 쓰기
	@RequestMapping(value = "/reviewmsg.do", method = RequestMethod.GET)
	public ModelAndView reviewmsgMethod(TalkDTO tdto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("memid", tdto.getId());
		mav.addObject("t_resp", tdto.getT_resp());
		mav.setViewName("writemessage");
		return mav;
	};

	// 보낸 쪽지함 뷰 보기
	@RequestMapping(value = "/sendviewmsg.do", method = RequestMethod.GET)
	public ModelAndView sendviewmsgMethod(TalkDTO tdto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("memid", tdto.getId());
		mav.addObject("sendview", "sendview");
		mav.addObject("tdto", mservice.viewMsgProcess(tdto.getT_num()));
		mav.setViewName("viewmessage");
		return mav;
	};

	// 보낸 쪽지함 뷰 삭제
	@RequestMapping(value = "/sendviewmsg.do", method = RequestMethod.POST)
	public ModelAndView senddelviewmsgMethod(TalkDTO tdto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", tdto.getId());
		mav.setViewName("redirect:/sendmessage.do");
		return mav;
	};

};
