package Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.Pr_replyDTO;
import dto.ReservationDTO;
import dto.StarsDTO;
import service.ReservationService;

@Controller

public class ReservationController {

	ReservationService service;

	public ReservationController() {
	}

	public void setService(ReservationService service) {
		this.service = service;
	}
 
	// 뷰 불러오기
	@RequestMapping(value = "/pubview.do", method = RequestMethod.GET)
	public ModelAndView viewMethod(int p_num) {
		ModelAndView mav = new ModelAndView();
		System.out.println(p_num);

		String[] pimg = service.reservationListProcess(p_num).get(0).getP_mupload().toString().split("/");

		mav.addObject("coupon", service.couponListProcess());
		mav.addObject("pubimg", pimg);
		mav.addObject("rdto", service.reservationListProcess(p_num));
		mav.setViewName("reservation");
		return mav; 

	}

	// 예약버튼
	@RequestMapping(value = "/pubview.do", method = RequestMethod.POST)
	public ModelAndView reservationInsertMethod(ReservationDTO dto) {
		ModelAndView mav = new ModelAndView();

		 System.out.println(dto.getC_num());
		service.resinsertProcess(dto);

		String[] pimg = service.reservationListProcess(dto.getP_num()).get(0).getP_mupload().toString().split("/");

		mav.addObject("coupon", service.couponListProcess());
		mav.addObject("pubimg", pimg);
		mav.addObject("rdto", service.reservationListProcess(dto.getP_num()));
		mav.setViewName("reservation");
		return mav;
	}

	// 별점 인설트후 평균 호출
	@RequestMapping(value = "/pubStarInsertList.do", method = RequestMethod.POST)
	public @ResponseBody StarsDTO StarInsertMethod(StarsDTO dto) {
		 System.out.println(dto.getP_num());
		 System.out.println(dto.getS_stars());
		 System.out.println(service.pubStarAvgProcess(dto).getS_stars());
		return service.pubStarAvgProcess(dto);
	}

	// 리플 인설트후 리스트
	@RequestMapping(value = "/replyInsertList.do", method = RequestMethod.POST)
	public @ResponseBody List<Pr_replyDTO> replyInsertListMethod(Pr_replyDTO dto) {
		return service.replyInsertListProcess(dto);
	}

	// 리플 삭제후 리스트
	@RequestMapping(value = "/replyDeleteList.do", method = RequestMethod.POST)
	public @ResponseBody List<Pr_replyDTO> replyDeleteListMethod(Pr_replyDTO dto) {
		return service.replyDeleteListProcess(dto);
	}

	// 리플 수정 후 리스트
	@RequestMapping(value = "/replyUpdateList.do", method = RequestMethod.POST)
	public @ResponseBody List<Pr_replyDTO> replyUpdateListMethod(Pr_replyDTO dto) {
		return service.replyUpdateListProcess(dto);
	}

}
