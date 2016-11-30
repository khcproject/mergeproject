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

	// 회원정보 수정 들어가기
	@RequestMapping(value = "/memberupt.do", method = RequestMethod.GET)
	public ModelAndView memberupdateMethod(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		// mav.addObject("mdto", mservice.memuptintProcess(mdto));
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		//MemDTO memdto = mservice.memuptintProcess(mdto);

		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));
		} else if (mem.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		}

		mav.setViewName("beforemempw");
		return mav;
	};

	// 회원정보 PW 체크
	@RequestMapping(value = "/mempwchk.do", method = RequestMethod.POST)
	public ModelAndView mempwchkMethod(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// mav.addObject("mdto", mservice.memuptintProcess(mdto));

		MemDTO mem = (MemDTO)session.getAttribute("mem");
		
		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));
		} else if (mem.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		}
		mav.setViewName("memberupdate");
		return mav;
	};

	// 회원정보 수정 완료
	@RequestMapping(value = "/memberupdate.do", method = RequestMethod.POST)
	public ModelAndView memberupdateOkMethod(MemDTO mdto, HttpServletRequest req,HttpSession session) {
		ModelAndView mav = new ModelAndView();

		mservice.memuptokProcess(mdto, req);
	    session.removeAttribute("mem");
		MemDTO mem = mservice.memuptintProcess(mdto);
		session.setAttribute("mem", mem);  
		
		
		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));
		} else if (mem.getUserchk().equals("S")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		} 

		mav.setViewName("mypage");
		return mav;
	};

	// 회원탈퇴 들어가기
	@RequestMapping(value = "/leaveready.do", method = RequestMethod.GET)
	public ModelAndView leavereadyMethod(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// mav.addObject("mdto", mservice.memDelListProcess(mdto));

		MemDTO mem = (MemDTO)session.getAttribute("mem");
		
		
		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));
		} else if (mem.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		} 
		mav.setViewName("leaveus");
		return mav;
	};

	// 회원 탈퇴 완료
	@RequestMapping(value = "/leaveus.do", method = RequestMethod.GET)
	public String leaveMethod(MemDTO mdto, HttpServletRequest req,HttpSession session) {
		mservice.memDelProcess(mdto, req);
		session.invalidate();
		return "redirect:/index.do";
	};

	// 판매자 신청 들어가기
	@RequestMapping(value = "/joinseller.do", method = RequestMethod.GET)
	public ModelAndView joinsellerMethod(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// mav.addObject("mdto", mservice.memuptintProcess(mdto));

		MemDTO mem = (MemDTO)session.getAttribute("mem");

		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));
		} else if (mem.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		} 

		mav.setViewName("joinseller");
		return mav;
	};

	// 판매자 신청 완료
	@RequestMapping(value = "/joinseller.do", method = RequestMethod.POST)
	public ModelAndView endjoinsellerMethod(MemDTO mdto,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mservice.joinSellerProcess(mdto);

	    session.removeAttribute("mem");
		MemDTO mem = mservice.memuptintProcess(mdto);
		session.setAttribute("mem", mem);

		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));
		} else if (mem.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		}

		mav.setViewName("mypage");
		return mav;
	};

	// Pub 신청 들어가기
	@RequestMapping(value = "/joinpub.do", method = RequestMethod.GET)
	public ModelAndView joinpubreadyMethod(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// mav.addObject("mdto", mservice.memuptintProcess(mdto));

		MemDTO mem = (MemDTO)session.getAttribute("mem");

		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));
		} else if (mem.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		}

		mav.setViewName("joinpub");
		return mav;
	};

	// pub 등록 신청 완료
	@RequestMapping(value = "/joinpub.do", method = RequestMethod.POST)
	public ModelAndView joinpubokMethod(PubDTO pdto, HttpServletRequest req,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mservice.pubInsAllProcess(pdto, req);

		MemDTO mem = (MemDTO)session.getAttribute("mem");
		
		
		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));

		} else if (mem.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		} 

		mav.setViewName("mypage");

		return mav;
	};

	// 판매자 : 전체 예약리스트
	@RequestMapping(value = "/sellreservlist.do", method = RequestMethod.GET)
	public ModelAndView reservlistMethod(ReservPageDTO pv, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		
		int totalRecord = mservice.reservListNumProcess(mem.getId());
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				ReservcurrentPage = 1;
			else
				ReservcurrentPage = pv.getCurrentPage();

			reservpdto = new ReservPageDTO(ReservcurrentPage, totalRecord);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("pv", reservpdto);

			mav.addObject("pv", reservpdto);
			mav.addObject("sellreserv", mservice.reservAllListProcess(map));
		} else {
			ReservcurrentPage = 1;
			reservpdto = new ReservPageDTO(ReservcurrentPage, totalRecord);
			mav.addObject("pv", reservpdto);
		}

		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));
		} else if (mem.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
		} 

		// mav.addObject("mdto",mdto);
		mav.setViewName("reservlist");

		return mav;
	};

	// PUB 수정 들어가기
	@RequestMapping(value = "/updatepub.do", method = RequestMethod.GET)
	public ModelAndView updatepubMethod(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		mav.addObject("mdto", mservice.updatePubProcess(mem.getId()));
		mav.setViewName("updatepub");
		return mav;

	};

	// PUB 수정 완료
	@RequestMapping(value = "/updatepub.do", method = RequestMethod.POST)
	public ModelAndView updatepubokMethod(PubDTO pdto, HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		mservice.updatePubOkProcess(pdto, req);

		MemDTO mem = (MemDTO)session.getAttribute("mem");
		// userchk=C일경우
		if (mem.getUserchk().equals("C")) {
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("cusreserv", mservice.mypageCusReservProcess(mem.getId()));

		} else if (mem.getUserchk().equals("S")) {// usrechk=S일경우
			mav.addObject("mdto", mservice.mypageCouponProcess(mem.getId()));
			mav.addObject("sellreserv", mservice.mypageSellReservProcess(mem.getId()));
		} 

		mav.setViewName("mypage");
		return mav;
	};

	// 받은 쪽지함
	@RequestMapping(value = "/gotomessage.do", method = RequestMethod.GET)
	public ModelAndView respmsglistMethod(HttpSession session, MessagePageDTO pv) {
		ModelAndView mav = new ModelAndView();

		MemDTO mem = (MemDTO)session.getAttribute("mem");
		int totalRecord = mservice.respMsgCountProcess(mem.getId());

		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				respMsgCurrentPage = 1;
			else
				respMsgCurrentPage = pv.getCurrentPage();

			mesgpdto = new MessagePageDTO(respMsgCurrentPage, totalRecord);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("pv", mesgpdto);

			//mav.addObject("memid",mem.getId());
			mav.addObject("pv", mesgpdto);
			mav.addObject("respMsg", mservice.respMsgListProcess(map));
		} else {
			respMsgCurrentPage = 1;
			mesgpdto = new MessagePageDTO(respMsgCurrentPage, totalRecord);
			//mav.addObject("memid", mem.getId());
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
	public ModelAndView searchMsgMethod(String searchop, String searchworld, HttpSession session, MessagePageDTO pv) {
		ModelAndView mav = new ModelAndView();
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		if (searchop.equals("subject")) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("searchworld", searchworld);
			int totalRecord = mservice.searchSubjectCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					searchMsgCurrentPage = 1;
				else
					searchMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", mem.getId());
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				//mav.addObject("memid", mem.getId());
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("respMsg", mservice.searchSubjectListProcess(map2));
			} else {
				searchMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);
				//mav.addObject("memid", mem.getId());
				mav.addObject("spv", mesgpdto);
			}
		}
		;// end subject

		if (searchop.equals("contents")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("searchworld", searchworld);
			int totalRecord = mservice.searchContentsCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					searchMsgCurrentPage = 1;
				else
					searchMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", mem.getId());
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				//mav.addObject("memid", mem.getId());
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("respMsg", mservice.searchContentsListProcess(map2));
			} else {
				searchMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);
				//mav.addObject("memid", mem.getId());
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end contents

		if (searchop.equals("subandcon")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("searchworld", searchworld);
			int totalRecord = mservice.searchDoubleCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					searchMsgCurrentPage = 1;
				else
					searchMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", mem.getId());
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				//mav.addObject("memid", mem.getId());
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("respMsg", mservice.searchDoubleListProcess(map2));
			} else {
				searchMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);
				//mav.addObject("memid", mem.getId());
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end subandcontent

		if (searchop.equals("searchid")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("searchworld", searchworld);
			int totalRecord = mservice.searchIdCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					searchMsgCurrentPage = 1;
				else
					searchMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", mem.getId());
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				//mav.addObject("memid", mem.getId());
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("respMsg", mservice.searchIdListProcess(map2));
			} else {
				searchMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(searchMsgCurrentPage, totalRecord);
				//mav.addObject("memid", mem.getId());
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end id

		mav.setViewName("message");
		return mav;
	};

	// 보낸 쪽지함
	@RequestMapping(value = "/sendmessage.do", method = RequestMethod.GET)
	public ModelAndView sendmsgMethod(HttpSession session, MessagePageDTO pv) {
		ModelAndView mav = new ModelAndView();
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		int totalRecord = mservice.sendMsgCountProcess(mem.getId());

		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				sendMsgCurrentPage = 1;
			else
				sendMsgCurrentPage = pv.getCurrentPage();

			mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("pv", mesgpdto);

			//mav.addObject("memid", mem.getId());
			mav.addObject("pv", mesgpdto);
			mav.addObject("sendMsg", mservice.sendMsgListProcess(map));
		} else {
			sendMsgCurrentPage = 1;
			mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
			//mav.addObject("memid", mem.getId());
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
	public ModelAndView sendsearchMsgMethod(String searchop, String searchworld, HttpSession session, MessagePageDTO pv) {
		ModelAndView mav = new ModelAndView();
				MemDTO mem = (MemDTO)session.getAttribute("mem");
				
		if (searchop.equals("subject")) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("searchworld", searchworld);
			int totalRecord = mservice.sendsearchSubjectCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					sendMsgCurrentPage = 1;
				else
					sendMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", mem.getId());
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				//mav.addObject("memid",mem.getId());
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("sendMsg", mservice.sendsearchSubjectListProcess(map2));
			} else {
				sendMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
				//mav.addObject("memid", mem.getId());
				mav.addObject("spv", mesgpdto);
			}
		}
		;// end subject

		if (searchop.equals("contents")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("searchworld", searchworld);
			int totalRecord = mservice.sendsearchContentsCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					sendMsgCurrentPage = 1;
				else
					sendMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", mem.getId());
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				//mav.addObject("memid", mem.getId());
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("sendMsg", mservice.sendsearchContentsListProcess(map2));
			} else {
				sendMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
				//mav.addObject("memid", mem.getId());
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end contents

		if (searchop.equals("subandcon")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("searchworld", searchworld);
			int totalRecord = mservice.sendsearchDoubleCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					sendMsgCurrentPage = 1;
				else
					sendMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", mem.getId());
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				//mav.addObject("memid", mem.getId());
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("sendMsg", mservice.sendsearchDoubleListProcess(map2));
			} else {
				sendMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
				//mav.addObject("memid",mem.getId());
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end subandcontent

		if (searchop.equals("searchid")) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mem.getId());
			map.put("searchworld", searchworld);
			int totalRecord = mservice.sendsearchIdCountProcess(map);

			if (totalRecord >= 1) {
				if (pv.getCurrentPage() == 0)
					sendMsgCurrentPage = 1;
				else
					sendMsgCurrentPage = pv.getCurrentPage();

				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("id", mem.getId());
				map2.put("searchworld", searchworld);
				map2.put("pv", mesgpdto);

				//mav.addObject("memid", mem.getId());
				mav.addObject("searchop", searchop);
				mav.addObject("searchworld", searchworld);
				mav.addObject("spv", mesgpdto);
				mav.addObject("sendMsg", mservice.sendsearchIdListProcess(map2));
			} else {
				sendMsgCurrentPage = 1;
				mesgpdto = new MessagePageDTO(sendMsgCurrentPage, totalRecord);
				//mav.addObject("memid",mem.getId());
				mav.addObject("spv", mesgpdto);
			}

		}
		;// end id

		mav.setViewName("sendmessage");
		return mav;
	};

	// 쪽지 작성페이지 들어가기
	@RequestMapping(value = "/writemessage.do", method = RequestMethod.GET)
	public ModelAndView writemsgMethod(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		//mav.addObject("memid", mem.getId());
		mav.setViewName("writemessage");
		return mav;

	};

	// 쪽지 발송 완료
	@RequestMapping(value = "/writemessage.do", method = RequestMethod.POST)
	public ModelAndView sendwritemsgMethod(TalkDTO tdto,HttpSession session) {
		ModelAndView mav = new ModelAndView();

		mservice.insWrtieMsgProcess(tdto);
		/*MemDTO mem = (MemDTO)session.getAttribute("mem");
		mav.addObject("id", mem.getId());*/
		mav.setViewName("redirect:/gotomessage.do");
		return mav;
	};

	// 받은 쪽지함 뷰 보기
	@RequestMapping(value = "/viewmsg.do", method = RequestMethod.GET)
	public ModelAndView viewmsgMethod(TalkDTO tdto,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		//mav.addObject("memid", mem.getId());
		mav.addObject("tdto", mservice.viewMsgProcess(tdto.getT_num()));
		mav.setViewName("viewmessage");
		return mav;
	};

	// 받은 쪽지함 뷰 삭제
	@RequestMapping(value = "/viewmsg.do", method = RequestMethod.POST)
	public ModelAndView delviewmsgMethod(TalkDTO tdto) {
		ModelAndView mav = new ModelAndView();
		mservice.delViewMsgProcess(tdto.getT_num());
		/*mav.addObject("id", tdto.getId());*/
		mav.setViewName("redirect:/gotomessage.do");
		return mav;
	};

	// 받은 쪽지함 뷰 답장 쓰기
	@RequestMapping(value = "/reviewmsg.do", method = RequestMethod.GET)
	public ModelAndView reviewmsgMethod(TalkDTO tdto,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		//mav.addObject("memid", mem.getId());
		mav.addObject("t_resp", tdto.getT_resp());
		mav.setViewName("writemessage");
		return mav;
	};

	// 보낸 쪽지함 뷰 보기
	@RequestMapping(value = "/sendviewmsg.do", method = RequestMethod.GET)
	public ModelAndView sendviewmsgMethod(TalkDTO tdto,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemDTO mem = (MemDTO)session.getAttribute("mem");
		//mav.addObject("memid", mem.getId());
		mav.addObject("sendview", "sendview");
		mav.addObject("tdto", mservice.viewMsgProcess(tdto.getT_num()));
		mav.setViewName("viewmessage");
		return mav;
	};

	// 보낸 쪽지함 뷰 삭제
	@RequestMapping(value = "/sendviewmsg.do", method = RequestMethod.POST)
	public ModelAndView senddelviewmsgMethod(TalkDTO tdto) {
		ModelAndView mav = new ModelAndView();
		/*mav.addObject("id", tdto.getId());*/
		mav.setViewName("redirect:/sendmessage.do");
		return mav;
	};

};
