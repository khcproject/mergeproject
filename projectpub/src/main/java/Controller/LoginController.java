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
import dto.StarsDTO;
import service.LoginService;

@Controller
public class LoginController {

	LoginService service;

	public LoginController() {
	}

	public void setService(LoginService service) {
		this.service = service;
	}

	// 뷰불러오기
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView loginviewMethod() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("login");
		return mav;
	}

	// 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, String> loginMethod(MemDTO dto, HttpSession session) {
		MemDTO mm = service.loginProcess(dto);

		HashMap<String, String> map = new HashMap<String, String>();

		if (mm == null) {
			map.put("chk", "아이디 비밀번호를 확인하세요.");
		} else {
			if (mm.getEmail_agree().equals("Y")) {
				session.setMaxInactiveInterval(30 * 60); // 30분
				session.setAttribute("mem", mm);
				service.logTimeProcess(dto);
				map.put("href", "mainview.do");
			} else {
				map.put("chk", "이메일인증을 해주세요.");
			}
		}
		return map;

	}

	// 회원가입
	@RequestMapping(value = "/memInsert.do", method = RequestMethod.POST)
	public ModelAndView memberInsertMethod(MemDTO dto) {
		ModelAndView mav = new ModelAndView();

		service.memberInsertProcess(dto);
		MailSend mailSend = new MailSend(dto);

		mav.setViewName("login");
		return mav;
	}

	// 아이디 중복체크
	@RequestMapping(value = "/idchk.do", method = RequestMethod.POST)
	public @ResponseBody String StarInsertMethod(MemDTO dto) {
		String value = "";
		// System.out.println(dto.getId());
		value = service.idchkProcess(dto);
		if (value == null) {
			value = "false";
			return value;
		} else {
			return value;
		}
		// System.out.println(value);
	}

	// 인증화면
	@RequestMapping(value = "/loginchk.do", method = RequestMethod.GET)
	public String loginchkMethod() {

		return "loginchk";
	}

	// 인증버튼
	@RequestMapping(value = "/loginchk.do", method = RequestMethod.POST)
	public String loginchkUpdateMethod(String id) {
		service.emailagreeUpdateProcess(id);

		return "main";
	}

	// 로그인
	@RequestMapping(value = "/pwfind.do", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, String> pwFindMethod(MemDTO dto, HttpSession session) {
		MemDTO mm = service.pwFindProcess(dto);

		HashMap<String, String> map = new HashMap<String, String>();

		if (mm == null) {
			map.put("no", "아이디와 이메일을 확인해주세요.");
		} else {
			// 이메일 발송!!!
			PwMailSend pw = new PwMailSend(service.pwFindProcess(dto));
			map.put("ok", "비밀번호가 이메일로 발송되었습니다.");
			map.put("href", "login.do");
		}
		return map;

	}

}// end class
