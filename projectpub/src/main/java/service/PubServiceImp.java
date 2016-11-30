package service;

import java.util.List;

import dao.PubDao;
import dto.MemDTO;
import dto.PubDTO;
import dto.PubPageDTO;
import dto.StarsDTO;

public class PubServiceImp implements PubService {
	private PubDao dao;
	
	public PubServiceImp() {
	}
	
	public void setDao(PubDao dao) {
		this.dao = dao;
	}

	@Override
	public void insertProcess(PubDTO dto) {
		dao.save(dto);
	}

	//랭킹 
	@Override
	public List<PubDTO> getProcess() {
		return dao.get();
	}

	@Override
	public int countProcess() {
		return dao.count();
	}

	@Override
	public List<PubDTO> listProcess(PubPageDTO pv) {
		return dao.list(pv);
	}

	@Override
	public int searcountProcess(String data) {
		return dao.searcount(data);
	}

	@Override
	public List<PubDTO> listsearchProcess(PubPageDTO pv) {

		return dao.searchlist(pv);
	}

	@Override
	public void managero(String id) {
		dao.managero(id);
	}

	@Override
	public void managerc(String id) {
		dao.managerc(id);
	}


	@Override
	public void supo(String id) {
		dao.supo(id);
	}

	@Override
	public void supc(String id) {
		dao.supc(id);
	}

	@Override
	public List<String> date() {
		return dao.date();
	}

	@Override
	public int concount() {
		return dao.concount();
	}

	@Override
	public int supcount() {
		return dao.supcount();
	}

	@Override
	public int pubcount() {
		return dao.pubcount();
	}

	@Override
	public int memrcountProcess() {
		return dao.memrcount();
	}
	
	@Override
	public List<MemDTO> memrProcess() {
		return dao.memr();
	}
	
	@Override
	public int suprcountProcess() {
		return dao.suprcount();
	}

	@Override
	public List<PubDTO> suprProcess() {
		return dao.supr();
	}

	@Override
	public int memcount() {
		return dao.memcount();
	}

	@Override
	public List<String> mwtotal() {
		return dao.mwtotal();
	}

	@Override
	public List<String> birth() {
		return dao.birth();
	}

	@Override
	public List<MemDTO> pubpre(String id) {
		return dao.pubpre(id);
	}

	@Override
	public List<StarsDTO> lid() {
		return dao.lid();
	}
	
}//end class
