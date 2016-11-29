package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import dao.NoticeDao;
import dto.CouponDTO;
import dto.EventDTO;
import dto.MemDTO;
import dto.NoticeDTO;
import dto.PageDTO;

import dto.QuestionDTO;

public class NoticeServiceImp implements NoticeService{

	private NoticeDao dao;
	
	public NoticeServiceImp() {
	}

	public void setDao(NoticeDao dao) {
		this.dao = dao;
	}

	@Override
	public int countProcess() {
		
		return dao.count();
	}

	@Override
	public List<NoticeDTO> listProcess(PageDTO pv) {
	
		return dao.list(pv);
	}

	@Override
	public void insertProcess(NoticeDTO dto) {
		dao.save(dto);
		
	}

	@Override
	public NoticeDTO contentProcess(int num) {
		dao.readCount(num);
		return dao.content(num);
	}

	

	@Override
	public NoticeDTO updateSelectProcess(int num) {
	
		return dao.updateNum(num);
	}

	@Override
	public void updateProcess(NoticeDTO dto) {
		dao.content(dto.getN_num());
		dao.update(dto);
		
	}

	@Override
	public void deleteProcess(int num) {
		dao.delete(num);
		
	}
///////////////qna//////////////////////////
	
	@Override
	public int countsProcess() {
		
		return dao.counts();
	}

	@Override
	public List<QuestionDTO> qnaProcess(PageDTO pv) {
		return dao.qna(pv);
	}

	@Override
	public QuestionDTO qnacontentProcess(int num) {
		dao.qnaviewcnt(num);
		return dao.qnacontents(num);
	}

	@Override
	public void qnainsertProcess(QuestionDTO dto) {
		dao.qnainsert(dto);
		
	}

	@Override
	public QuestionDTO qnaupdateSelectProcess(int num) {
		
		return dao.qnaupdateNum(num);
	}

	@Override
	public void qnaupdateProcess(QuestionDTO dto, HttpServletRequest request) {
		String filename= dao.getFile(dto.getQ_num());
		String root= request.getSession().getServletContext().getRealPath("/");
		String saveDirectory = root + "temp" + File.separator;
		
		MultipartFile file = dto.getFilename();
		//수정할 첨부파일이 있으면..
		if(!file.isEmpty()){
			
			UUID random =UUID.randomUUID();
			
			if(filename != null){
				File fe= new File(saveDirectory,filename);
				fe.delete();
			}
			String fileName =file.getOriginalFilename();
			dto.setQ_upload(random+ "_"+fileName);
			
			File ff= new File(saveDirectory,random+"_"+fileName);
			
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		dao.qnaupdate(dto);
	}

	@Override
	public void qnadeleteProcess(int num, HttpServletRequest request) {
		String upload = dao.getFile(num);
		if(upload!=null){
			String root= request.getSession().getServletContext().getRealPath("/");
			String saveDirectory = root + "temp" + File.separator;
			File fe= new File(saveDirectory,upload);
			fe.delete();
		}
		dao.qnadelete(num);
		
	}
	
	@Override
	public void stepProcess(QuestionDTO dto) {
		dao.step(dto);
		dto.setQr_step(dto.getQr_step()+1);
		dto.setQr_level(dto.getQr_level()+1);
		dao.qnainsert(dto);
		
	}
	
	@Override
	public List<QuestionDTO> qnaProcess2(HashMap<String, Object> map) {
		
		return dao.qna2(map);
	}
	
	@Override
	public int counts2Process(String search) {
		
		return dao.counts2(search);
	}

	
	@Override
	public List<QuestionDTO> qnaProcess3(HashMap<String, Object> map) {
		
		return dao.qna3(map);
	}

	@Override
	public int counts3Process(String search) {
		
		return dao.counts3(search);
	}


	
	
	//////////////////event////////////////////////////////////////////////////////////

	@Override
	public int countaProcess() {
		
		return dao.counta();
	}

	@Override
	public List<EventDTO> eventProcess(PageDTO pv) {
		return dao.event(pv);
	}

	@Override
	public void insertProcess(EventDTO dto ) {
		dao.insert(dto);
	}

	@Override
	public EventDTO contentsaProcess(int num) {
		dao.viewcnt(num);
		return dao.contentsa(num);
	}

	@Override
	public EventDTO updateaSelectProcess(int num) {
		
		return dao.contentsa(num);
	}

	@Override
	public void updateaProcess(EventDTO dto) {
		dao.updatea(dto);
	}

	@Override
	public void deleteaProcess(int num,HttpServletRequest request) {
		String upload = dao.getFile(num);
		if(upload!=null){
			String root= request.getSession().getServletContext().getRealPath("/");
			String saveDirectory = root + "temp" + File.separator;
			File fe= new File(saveDirectory,upload);
			fe.delete();
		}
		
		dao.deletea(num);
	}
	
	/////////////////////coupon/////////////////////////////

	@Override
	public void cinsertProcess(CouponDTO cdto) {
		
		
		int couponSize =1;
		final char[] aa={'1','2','3','4','5','6','7','8','9','0',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
				'O','P','Q','R','S','T','U','V','W','X','Y','Z'
		};
		final int aacount=aa.length;
		String[] arr=new String[couponSize];
		Random rnd=new Random();
		int index=0;
		int i=0;
		while(index<couponSize){
			StringBuffer buf =new StringBuffer(16);
			for(i=10;i>0;i--){
				buf.append(aa[rnd.nextInt(aacount)]);
			}
			String nums=buf.toString();
			System.out.println("coupon50%:"+nums);
			arr[index]=nums;
			index++;			
		}
		
			cdto.setC_coupon(arr[0]);			
		
	
		dao.cinsert(cdto);
		
	}

	
	@Override
	public void cinsertProcess2(CouponDTO cdto) {
		
		int couponSize =1;
		final char[] aa={'1','2','3','4','5','6','7','8','9','0',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
				'O','P','Q','R','S','T','U','V','W','X','Y','Z'
		};
		final int aacount=aa.length;
		String[] arr=new String[couponSize];
		Random rnd=new Random();
		int index=0;
		int i=0;
		while(index<couponSize){
			StringBuffer buf =new StringBuffer(16);
			for(i=10;i>0;i--){
				buf.append(aa[rnd.nextInt(aacount)]);
			}
			String nums=buf.toString();
			System.out.println("coupon30%:"+nums);
			arr[index]=nums;
			index++;			
		}
		
			cdto.setC_coupon(arr[0]);			
		
	
		dao.cinsert2(cdto);
	}

	@Override
	public void cinsertProcess3(CouponDTO cdto) {
		int couponSize =1;
		final char[] aa={'1','2','3','4','5','6','7','8','9','0',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
				'O','P','Q','R','S','T','U','V','W','X','Y','Z'
		};
		final int aacount=aa.length;
		String[] arr=new String[couponSize];
		Random rnd=new Random();
		int index=0;
		int i=0;
		while(index<couponSize){
			StringBuffer buf =new StringBuffer(16);
			for(i=10;i>0;i--){
				buf.append(aa[rnd.nextInt(aacount)]);
			}
			String nums=buf.toString();
			System.out.println("coupon10%:"+nums);
			arr[index]=nums;
			index++;			
		}
		
			cdto.setC_coupon(arr[0]);			
		
	
		dao.cinsert3(cdto);
		
	}

	
	
	
	
	
	@Override
	public CouponDTO ccontentsProcess(int num) {
		
		return dao.ccontents(num);
	}

	
	@Override
	public MemDTO meminfoProcess(String id) {
		return dao.meminfoMethod(id);
	}

	
	

	

	
	
}
