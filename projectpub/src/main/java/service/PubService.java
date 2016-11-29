package service;

import java.util.List;

import dto.MemDTO;
import dto.PubDTO;
import dto.PubPageDTO;

public interface PubService {
	
	public void insertProcess(PubDTO dto);
	public List<PubDTO> getProcess();
	public int countProcess();
	public List<PubDTO> listProcess(PubPageDTO pv);
	public int searcountProcess(String data);
	public List<PubDTO> listsearchProcess(PubPageDTO pv);
	
	public List<String> date();
	public List<MemDTO> memrProcess();
	public int memrcountProcess();
	public void managero(String id);
	public void managerc(String id);
	public int suprcountProcess();
	public void supo(String id);
	public void supc(String id);
	public List<PubDTO> suprProcess();
	public int concount();
	public int supcount();
	public int pubcount();
	public int memcount();
	public List<String> mwtotal();
	public List<String> birth();
	public List<MemDTO> pubpre(String id);
}//end interface
