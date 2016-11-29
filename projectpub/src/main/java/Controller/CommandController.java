package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.MemDTO;

@Controller
public class CommandController {


	public CommandController() {
	}

	
	//시작 페이지
		@RequestMapping("/mainview.do")
		public String mainviewMethod(){
			return "main";
		};
		
		//소셜 페이지
		@RequestMapping("/social.do")
		public String socialviewMethod(){
			return "social";
		};
		
		//로그아웃
		@RequestMapping("/logout.do")
		public String logoutMethod(HttpServletRequest req, HttpSession session){
			
			      MemDTO dto = (MemDTO)	req.getSession().getAttribute("mem");            
			      if(dto != null) {                     
			         session.removeAttribute("mem");            
			         session.invalidate();            
			      };
			      
			return "redirect:/mainview.do";
		};
		

}// end class
