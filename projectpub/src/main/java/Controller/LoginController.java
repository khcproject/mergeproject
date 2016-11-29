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

			session.setMaxInactiveInterval(30 * 60); // 30분
			session.setAttribute("mem", mm);
			map.put("href", "mainview.do");
		}
		return map;
		
	}

	// 회원가입
	@RequestMapping(value = "/memInsert.do", method = RequestMethod.POST)
	public ModelAndView memberInsertMethod(MemDTO dto) {
		ModelAndView mav = new ModelAndView();

		service.memberInsertProcess(dto);

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

}// end class
