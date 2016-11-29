package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.CouponDTO;
import dto.EventDTO;
import dto.NoticeDTO;
import dto.PageDTO;
import dto.QuestionDTO;
import service.NoticeService;


@Controller
public class NoticeController {

	private NoticeService service;
	private int currentPage;
	private int seachcurrentPage;
	private PageDTO pdto;
	
	public NoticeController() {
	}

	public void setService(NoticeService service) {
		this.service = service;
	}


	@RequestMapping("/notice.do")
	public ModelAndView noticeMethod(PageDTO pv) {
		ModelAndView mav = new ModelAndView();
		int totalRecord = service.countProcess();

		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				currentPage = 1;
			else
				currentPage = pv.getCurrentPage();
			pdto = new PageDTO(currentPage, totalRecord);

			mav.addObject("pv", pdto);
			mav.addObject("aList", service.listProcess(pdto));
		}
		mav.setViewName("notice");

		return mav;
	}// end noticeMethod()

	@RequestMapping("/noview.do")
	public ModelAndView viewMethod(int currentPage, int num) {

		ModelAndView mav = new ModelAndView();

		NoticeDTO dto = service.contentProcess(num);

		mav.addObject("dto", dto);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("noview");

		return mav;
	}

	@RequestMapping(value = "/nowrite.do", method = RequestMethod.GET)
	public ModelAndView writeMethod(PageDTO pv, NoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		if (dto.getN_num() != 0) {
			mav.addObject("dto", dto);
			mav.addObject("currentPage", pv.getCurrentPage());
		}
		mav.setViewName("nowrite");
		return mav;
	}

	@RequestMapping(value = "/nowrite.do", method = RequestMethod.POST)
	public String writeProMethod(NoticeDTO dto) {

		service.insertProcess(dto);

		return "redirect:/notice.do";
	}

	@RequestMapping(value = "/noupdate.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int num, int currentPage) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.updateSelectProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("noupdate");
		return mav;
	}

	@RequestMapping(value = "/noupdate.do", method = RequestMethod.POST)
	public ModelAndView updateProc(NoticeDTO dto, int currentPage) {
		ModelAndView mav = new ModelAndView();
		service.updateProcess(dto);

		mav.addObject("currentPage", currentPage);
		mav.setViewName("redirect:/notice.do");

		return mav;
	}

	@RequestMapping("/nodelete.do")
	public ModelAndView delMethod(int num, int currentPage) {
		ModelAndView mav = new ModelAndView();
		service.deleteProcess(num);

		PageDTO pv = new PageDTO(service.countProcess());

		if (pv.getTotalPage() < currentPage) {
			mav.addObject("currentPage", pv.getTotalPage());
		} else {
			mav.addObject("currentPage", currentPage);
		}
		mav.setViewName("redirect:/notice.do");

		return mav;
	}

	

	//////////////////////// Q&A Page///////////////////////////////////

	@RequestMapping("/qna.do")
	public ModelAndView qnaMethod(PageDTO pv) {
		ModelAndView mav = new ModelAndView();
		
		int totalRecord = service.countsProcess();
		

		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				currentPage = 1;
			else
				currentPage = pv.getCurrentPage();
			pdto = new PageDTO(currentPage, totalRecord);

			mav.addObject("pv", pdto);
		
			mav.addObject("aList", service.qnaProcess(pdto));
			
				
		}
		mav.setViewName("qna");

		return mav;
	}// end qnaMethod()
	
	@RequestMapping("/qna2.do")
	public ModelAndView qnaMethod2(PageDTO pv,String search, String word ) {
		ModelAndView mav = new ModelAndView();
		System.out.println(word);
		
		
		if(word.equals("titlecontents")){
			
			int totalRecord = service.counts2Process(search);
		
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				seachcurrentPage = 1;
			else
				seachcurrentPage = pv.getCurrentPage();
			pdto = new PageDTO(seachcurrentPage, totalRecord);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("pv",pdto);
			map.put("search", search);
			
			
			mav.addObject("word",word);
			mav.addObject("search",search);
			
			mav.addObject("spv",pdto);
			mav.addObject("aList", service.qnaProcess2(map));
			
		}else{
			seachcurrentPage=1;
			pdto = new PageDTO(seachcurrentPage, totalRecord);
			mav.addObject("spv", pdto);
			
		}
		
		};
		
if(word.equals("searchid")){
			
			int totalRecord = service.counts3Process(search);
		System.out.println(totalRecord);
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				seachcurrentPage = 1;
			else
				seachcurrentPage = pv.getCurrentPage();
			pdto = new PageDTO(seachcurrentPage, totalRecord);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("pv",pdto);
			map.put("search", search);
			
			mav.addObject("word",word);
			mav.addObject("search",search);

			mav.addObject("spv",pdto);
			mav.addObject("aList", service.qnaProcess3(map));
			
		}else{
			seachcurrentPage=1;
			pdto = new PageDTO(seachcurrentPage, totalRecord);
			mav.addObject("spv", pdto);
			
		}
		
		};
	
		
		mav.setViewName("qna");

		return mav;
	}// end qnaMethod2()
	
	

	@RequestMapping("/qnaview.do")
	public ModelAndView qnaviewMethod(int currentPage, int num) {

		ModelAndView mav = new ModelAndView();

		QuestionDTO dto = service.qnacontentProcess(num);
		
		mav.addObject("dto", dto);
		mav.addObject("currentPage", currentPage);
		
		
		
		mav.setViewName("qnaview");

		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/qnawrite.do", method = RequestMethod.GET)
	public ModelAndView writesMethod(PageDTO pv, QuestionDTO dto) {
		ModelAndView mav = new ModelAndView();
		if (dto.getQr_num() != 0) {
			mav.addObject("dto", dto);
			mav.addObject("currentPage", pv.getCurrentPage());
		}
		mav.setViewName("qnawrite");
		return mav;
	}

	@RequestMapping(value = "/qnawrite.do", method = RequestMethod.POST)
	public String writesProMethod(QuestionDTO dto,HttpServletRequest request) {

		MultipartFile file = dto.getFilename();
		
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename();
			
			//중복파일명을 처리하기 위해 난수 발생
			UUID random=UUID.randomUUID();
			String root=request.getSession().getServletContext().getRealPath("/");
			//root+"temp/"
			String saveDirectory=root+"temp"+File.separator;
			File fe=new File(saveDirectory);
			if(!fe.exists())
				fe.mkdir();
			
			File ff=new File(saveDirectory,random+"_"+fileName);
						
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));

			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
					dto.setQ_upload(random+"_"+fileName);

		}
		if(dto.getQr_num()!=0){
			service.stepProcess(dto);
		}else{
			service.qnainsertProcess(dto);			
		}
		
	
		return "redirect:/qna.do";
	}
	
	@RequestMapping(value = "/qnaupdate.do", method = RequestMethod.GET)
	public ModelAndView updatesForm(int num,int currentPage){
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.qnaupdateSelectProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("qnaupdate");
		return mav;
		
	}
	
	@RequestMapping(value = "/qnaupdate.do", method = RequestMethod.POST)

	public ModelAndView updateProc(QuestionDTO dto,int currentPage ,HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		service.qnaupdateProcess(dto, request);
		
		mav.addObject("currentPage", currentPage);
		mav.setViewName("redirect:/qna.do");
		return mav;
	}
	
	@RequestMapping("/qnadelete.do")
	public ModelAndView deletesMethod(int num,int currentPage,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		service.qnadeleteProcess(num, request);
		
		PageDTO pv=new PageDTO(service.countsProcess());
		
		if(pv.getTotalPage() < currentPage){
			mav.addObject("currentPage", pv.getTotalPage());
		}else{
			mav.addObject("currentPage", currentPage);
		}
		mav.setViewName("redirect:/qna.do");
		
		return mav;
	}
	
	////////////////////////   event  //////////////////////////////////////////////////////////////
	
	
	@RequestMapping("/event.do")
	public ModelAndView eventMethod(PageDTO pv) {
		ModelAndView mav = new ModelAndView();
		int totalRecord = service.countaProcess();

		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				currentPage = 1;
			else
				currentPage = pv.getCurrentPage();
			pdto = new PageDTO(currentPage, totalRecord);

			mav.addObject("pv", pdto);
			mav.addObject("aList", service.eventProcess(pdto));
		}
		
		mav.addObject("mdto",service.meminfoProcess("jang"));
		mav.setViewName("event");
		
		return mav;
	}// end eventMethod()
	
	@RequestMapping("/eview.do")
	public ModelAndView eviewMethod(int currentPage, int num, String id) {
		ModelAndView mav = new ModelAndView();
		
		
		EventDTO dto = service.contentsaProcess(num);
		
	
		mav.addObject("dto", dto);
		mav.addObject("mdtoid",id);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("eview");
		
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/ewrite.do", method = RequestMethod.GET)
	public ModelAndView ewriteMethod(PageDTO pv, EventDTO dto) {
		ModelAndView mav = new ModelAndView();
		if (dto.getE_num() != 0) {
			mav.addObject("dto", dto);
			
			mav.addObject("currentPage", pv.getCurrentPage());
		}
		mav.setViewName("ewrite");
		return mav;
	}

	@RequestMapping(value = "/ewrite.do", method = RequestMethod.POST)
	public String ewriteProMethod(EventDTO dto ,HttpServletRequest request){

		
		MultipartFile file = dto.getFilename();
		MultipartFile file2= dto.getFilename2();
		
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename();
			
			//중복파일명을 처리하기 위해 난수 발생
			UUID random=UUID.randomUUID();
			String root=request.getSession().getServletContext().getRealPath("/");
			//root+"temp/"
			String saveDirectory=root+"temp"+File.separator;
			File fe=new File(saveDirectory);
			if(!fe.exists())
				fe.mkdir();
			
			File ff=new File(saveDirectory,random+"_"+fileName);
						
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));

			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
					dto.setE_upload(random+"_"+fileName);
		}
		
		if(!file2.isEmpty()){
			String fileName2=file2.getOriginalFilename();
			
			//중복파일명을 처리하기 위해 난수 발생
			UUID random2=UUID.randomUUID();
			String root2=request.getSession().getServletContext().getRealPath("/");
			//root+"temp/"
			String saveDirectory2=root2+"temp"+File.separator;
			File fe2=new File(saveDirectory2);
			if(!fe2.exists())
				fe2.mkdir();
			
			File ff2=new File(saveDirectory2,random2+"_"+fileName2);
						
			try {
				FileCopyUtils.copy(file2.getInputStream(), new FileOutputStream(ff2));

			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
					dto.setE_uploads(random2+"_"+fileName2);

		}
		
		service.insertProcess(dto);
		
		return "redirect:/event.do";
	}

	
	@RequestMapping(value="/eupdate.do", method=RequestMethod.GET)
	public ModelAndView eupdateForm(int num, int currentPage) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.updateaSelectProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("eupdate");
		return mav;
	}

	@RequestMapping(value="/eupdate.do", method=RequestMethod.POST)
	public ModelAndView eupdateProc(EventDTO dto, int currentPage) {
		ModelAndView mav = new ModelAndView();
		service.updateaProcess(dto);

		mav.addObject("currentPage", currentPage);
		mav.setViewName("redirect:/event.do");

		return mav;
	}

	@RequestMapping("/edelete.do")
	public ModelAndView edelMethod(int num, int currentPage,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		service.deleteaProcess(num, request);

		PageDTO pv = new PageDTO(service.countaProcess());

		if (pv.getTotalPage() < currentPage) {
			mav.addObject("currentPage", pv.getTotalPage());
		} else {
			mav.addObject("currentPage", currentPage);
		}
		mav.setViewName("redirect:/event.do");

		return mav;
	}
	
	
	
	//////////쿠폰/////////////

	
	
	@RequestMapping(value = "/coupon.do", method = RequestMethod.POST)	
	public ModelAndView cwriteMethod(CouponDTO cdto) {
		ModelAndView mvc=new ModelAndView();
		 service.cinsertProcess(cdto); 
		 mvc.setViewName("redirect:/event.do");
		 return mvc;
	}
	
	@RequestMapping(value = "/coupon2.do", method = RequestMethod.POST)	
	public ModelAndView cwriteMethod2(CouponDTO cdto) {
		ModelAndView mvc=new ModelAndView();
		 service.cinsertProcess2(cdto); 
		 mvc.setViewName("redirect:/event.do");
		 return mvc;
	}
	@RequestMapping(value = "/coupon3.do", method = RequestMethod.POST)	
	public ModelAndView cwriteMethod3(CouponDTO cdto) {
		ModelAndView mvc=new ModelAndView();
		 service.cinsertProcess3(cdto); 
		 mvc.setViewName("redirect:/event.do");
		 return mvc;
	}
	
	
	
	
	/////////쿠폰 끝////////////////////////
	
	
	
	

}// end class
