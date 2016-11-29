package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import dao.Mypage_Dao;
import dto.MemDTO;
import dto.PubDTO;
import dto.ReservationDTO;
import dto.TalkDTO;

public class Mypage_ServiceImp implements Mypage_Service {

	private Mypage_Dao mdao;

	public Mypage_ServiceImp() {

	};

	public void setMdao(Mypage_Dao mdao) {
		this.mdao = mdao;
	};

	@Override
	public void testinsProcess(MemDTO mdto) {

		mdao.testinsMethod(mdto);

	};

	@Override
	public List<MemDTO> mypageCouponProcess(String id) {
		return mdao.mypageCouponMethod(id);
	};

	@Override
	public List<MemDTO> mypageCusReservProcess(String id) {
		return mdao.mypageCusReservMethod(id);
	};

	@Override
	public List<MemDTO> mypageSellReservProcess(String id) {
		return mdao.mypageSellReservMethod(id);
	};

	@Override
	public List<MemDTO> mypageAdminSellProcess() {
		return mdao.mypageAdminSellMethod();
	};

	@Override
	public List<PubDTO> mypageAdminPubProcess() {
		return mdao.mypageAdminPubMethod();
	};

	@Override
	public void delCusReservProcess(ReservationDTO rdto) {
		mdao.delCusReservMethod(rdto);
	};

	@Override
	public void ableReservProcess(ReservationDTO rdto) {
		mdao.ableReservMethod(rdto);
		mdao.ableCouponMethod(rdto);
	};

	@Override
	public void disableReservProcess(ReservationDTO rdto) {
		mdao.disableReservMethod(rdto);
	};

	@Override
	public void ableSellAllProcess(MemDTO mdto) {
		mdao.ableSellMethod(mdto);
		mdao.ableSellTalkMethod(mdto);
	};

	@Override
	public void disableSellAllProcess(MemDTO mdto) {
		mdao.disableSellMethod(mdto);
		mdao.disableSellTalkMethod(mdto);
	};

	@Override
	public MemDTO memuptintProcess(MemDTO mdto) {
		return mdao.memuptintMethod(mdto);
	};

	@Override
	public void memuptokProcess(MemDTO mdto, HttpServletRequest req) {

		if (mdto.getFilename() != null) {

			// 기존 첨부파일명
			String filename = mdao.memFaceMethod(mdto.getId());

			String root = req.getSession().getServletContext().getRealPath("/");
			String saveDirectory = root + "temp" + File.separator;

			MultipartFile file = mdto.getFilename();
			// 수정할 첨부파일이 있으면
			if (!file.isEmpty()) {
				
				File fe = new File(saveDirectory);
				if (!fe.exists())
					fe.mkdir();
				
				// 중복파일명을 처리하기 위해서 난수발생
				UUID random = UUID.randomUUID();
				
				// 기존 첨부파일이 있으면...
				if (filename != null) {
					File ft = new File(saveDirectory, filename);
					ft.delete();
				};
				
				String fileName = file.getOriginalFilename();
				
				mdto.setFace(random + "_" + fileName);

				File ff = new File(saveDirectory, random + "_" + fileName);

				try {
					FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		mdao.memUptMethod(mdto);

	};

	@Override
	public List<MemDTO> memDelListProcess(MemDTO mdto) {
		return mdao.leavememMethod(mdto);
	};

	@Override
	public void memDelProcess(MemDTO mdto, HttpServletRequest req) {
		
		List<MemDTO> mal =mdao.delMemPicMethod(mdto.getId());
		for(int i=0;i<mal.size();i++){
			String root = req.getSession().getServletContext().getRealPath("/");
			String saveDirectory = root + "temp" + File.separator;
			
			String face=mal.get(i).getFace();
			if (face != null) {
				File fe = new File(saveDirectory, face);
				fe.delete();
			};
			
			String mupload =  mal.get(i).getPicpub().getP_mupload();
			String[] img = mupload.split("/");
			
			for(int c=0;c<img.length;c++){
				if (img[c]!= null) {
					File fe = new File(saveDirectory, img[c]);
					fe.delete();
				};
			};
			 
			 String supload=mal.get(i).getPicpub().getP_supload();
			 
				if (supload != null) {
					File fe = new File(saveDirectory, supload);
					fe.delete();
				};
			
			for(int a=0;a<mal.get(i).getPicquestion().size();a++){
				String question =mal.get(i).getPicquestion().get(a).getQ_upload();
				if (question != null) {
					File fe = new File(saveDirectory, question);
					fe.delete();
					question=" ";
				};
			};
			for(int b=0;b<mal.get(i).getPicsocial().size();b++){
				String social=mal.get(i).getPicsocial().get(b).getS_upload();
				if (social != null) {
					File fe = new File(saveDirectory, social);
					fe.delete();
					social=" ";
				};
			};
		};
		
		mdao.deletememMethod(mdto);
	};

	@Override
	public void joinSellerProcess(MemDTO mdto) {
		mdao.joinSellerMethod(mdto);
	};

	@Override
	public MemDTO meminfoProcess(String id) {
		return mdao.meminfoMethod(id);
	};
	
	@Override
	public void pubInsAllProcess(PubDTO pdto, HttpServletRequest req) {
		
		String mup = "";
		
		if(pdto.getFilename()!=null){
	
		MultipartFile[] file = pdto.getFilename();
		for (int i = 0; i < pdto.getFilename().length; i++) {
			if (file.length != 0) {
				String filename = file[i].getOriginalFilename();

				UUID random = UUID.randomUUID();
				String root = req.getSession().getServletContext().getRealPath("/");

				String saveDirectory = root + "temp" + File.separator;
				File fe = new File(saveDirectory);
				if (!fe.exists())
					fe.mkdir();

				File ff = new File(saveDirectory, random + "_" + filename);

				try {
					FileCopyUtils.copy(file[i].getInputStream(), new FileOutputStream(ff));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (i == 0) {
					mup += random + "_" + filename;
				} else {
					mup += "/" + random + "_" + filename;
				}

			};
		};
		
		};
		pdto.setP_mupload(mup);
		
		
		if (pdto.getSubfilename() != null) {

			String root = req.getSession().getServletContext().getRealPath("/");
			String saveDirectory = root + "temp" + File.separator;

			MultipartFile file2 = pdto.getSubfilename();
			// 수정할 첨부파일이 있으면
			if (!file2.isEmpty()) {
				UUID random = UUID.randomUUID();

				String fileName = file2.getOriginalFilename();
				pdto.setP_supload(random + "_" + fileName);
				File ff = new File(saveDirectory, random + "_" + fileName);

				try {
					FileCopyUtils.copy(file2.getInputStream(), new FileOutputStream(ff));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		
		mdao.pubinsMethod(pdto);
	};
	
	@Override
	public int reservListNumProcess(String id) {
		return mdao.reservListNumMethod(id);
	};
	
	@Override
	public List<PubDTO> reservAllListProcess(HashMap<String, Object> map) {
		return mdao.reservAllListMethod(map);
	};
	
	@Override
	public List<MemDTO> updatePubProcess(String id) {
		return mdao.updatePubMethod(id);
	};
	
	@Override
	public void updatePubOkProcess(PubDTO pdto, HttpServletRequest req) {
		//DB수정전 이전 이미지 파일 삭제 필요
		//우편번호 컬럼 필요
		
		
		
		String mup = "";
		String root = req.getSession().getServletContext().getRealPath("/");
		String saveDirectory = root + "temp" + File.separator;
		String mupload = mdao.searchPubMImgMethod(pdto.getId());
		String supload = mdao.searchPubSImgMethod(pdto.getId());
		
		
		
		if(pdto.getFilename()!=null){
			
			if(mupload!=null){
				String[] mupImg = mupload.split("/");
				
				for(int i = 0; i<mupImg.length;i++){
					
					if (mupImg[i] != null) {
						File fe = new File(saveDirectory, mupImg[i]);
						fe.delete();
					};
				};
			};
				
		MultipartFile[] file = pdto.getFilename();
		for (int i = 0; i < pdto.getFilename().length; i++) {
			if (file.length != 0) {
				String filename = file[i].getOriginalFilename();

				UUID random = UUID.randomUUID();
				File ff = new File(saveDirectory, random + "_" + filename);

				try {
					FileCopyUtils.copy(file[i].getInputStream(), new FileOutputStream(ff));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (i == 0) {
					mup += random + "_" + filename;
				} else {
					mup += "/" + random + "_" + filename;
				}

			};
		};
		pdto.setP_mupload(mup);
		};
	
		
		if (pdto.getSubfilename().getOriginalFilename() != "") {
			if(supload!=null){
				File fe = new File(saveDirectory, supload);
				fe.delete();
			};

			MultipartFile file2 = pdto.getSubfilename();
			if (!file2.isEmpty()) {
				UUID random = UUID.randomUUID();

				String fileName = file2.getOriginalFilename();
				pdto.setP_supload(random + "_" + fileName);
				File ff = new File(saveDirectory, random + "_" + fileName);

				try {
					FileCopyUtils.copy(file2.getInputStream(), new FileOutputStream(ff));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		
		mdao.updatePubOkMethod(pdto);
		
	};
	
	@Override
	public int respMsgCountProcess(String id) {
		return mdao.respMsgCountMethod(id);
	};
	
	@Override
	public List<TalkDTO> respMsgListProcess(HashMap<String, Object> map) {
		return mdao.respMsgListMethod(map);
	};
	
	@Override
	public void deleteMsgProcess(Integer[] data) {
			mdao.deleteMsgMethod(data);
	};
	
	@Override
	public int searchSubjectCountProcess(HashMap<String, Object> map) {
		return mdao.searchSubjectCntMethod(map);
	};
	
	@Override
	public List<TalkDTO> searchSubjectListProcess(HashMap<String, Object> map) {
		return mdao.searchSubjectListMethod(map);
	};
	
	@Override
	public int searchContentsCountProcess(HashMap<String, Object> map) {
		return mdao.searchContentsCntMethod(map);
	};
	
	@Override
	public List<TalkDTO> searchContentsListProcess(HashMap<String, Object> map) {
		return mdao.searchContentsListMethod(map);
	};
	
	@Override
	public int searchDoubleCountProcess(HashMap<String, Object> map) {
		return mdao.searchDoubleCntMethod(map);
	};
	
	@Override
	public List<TalkDTO> searchDoubleListProcess(HashMap<String, Object> map) {
		return mdao.searchDoubleListMethod(map);
	};
	
	@Override
	public int searchIdCountProcess(HashMap<String, Object> map) {
		return mdao.searchIdCntMethod(map);
	};
	
	@Override
	public List<TalkDTO> searchIdListProcess(HashMap<String, Object> map) {
		return mdao.searchIdListMethod(map);
	};
	
	@Override
	public int sendMsgCountProcess(String id) {
		return mdao.sendMsgCountMethod(id);
	};
	
	@Override
	public List<TalkDTO> sendMsgListProcess(HashMap<String, Object> map) {
		return mdao.sendMsgListMethod(map);
	};
	
	@Override
	public int sendsearchSubjectCountProcess(HashMap<String, Object> map) {
		return mdao.sendsearchSubjectCntMethod(map);
	};
	
	@Override
	public List<TalkDTO> sendsearchSubjectListProcess(HashMap<String, Object> map) {
		return mdao.sendsearchSubjectListMethod(map);
	};
	
	@Override
	public int sendsearchContentsCountProcess(HashMap<String, Object> map) {
		return mdao.sendsearchContentsCntMethod(map);
	};
	
	@Override
	public List<TalkDTO> sendsearchContentsListProcess(HashMap<String, Object> map) {
		return mdao.sendsearchContentsListMethod(map);
	};
	
	@Override
	public int sendsearchDoubleCountProcess(HashMap<String, Object> map) {
		return mdao.sendsearchDoubleCntMethod(map);
	};
	
	@Override
	public List<TalkDTO> sendsearchDoubleListProcess(HashMap<String, Object> map) {
		return mdao.sendsearchDoubleListMethod(map);
	};
	
	@Override
	public int sendsearchIdCountProcess(HashMap<String, Object> map) {
		return mdao.sendsearchIdCntMethod(map);
	};
	
	@Override
	public List<TalkDTO> sendsearchIdListProcess(HashMap<String, Object> map) {
		return mdao.sendsearchIdListMethod(map);
	};
	
	@Override
	public void insWrtieMsgProcess(TalkDTO tdto) {
		mdao.insWrtieMsgMethod(tdto);
	};
	
	@Override
	public TalkDTO viewMsgProcess(int num) {
		return mdao.viewMsgMethod(num);
	};
	
	@Override
	public void delViewMsgProcess(int num) {
		mdao.delViewMsgMethod(num);
	};	
};
