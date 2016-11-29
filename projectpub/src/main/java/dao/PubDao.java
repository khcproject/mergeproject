package dao;

import java.util.List;

import dto.MemDTO;
import dto.PubDTO;
import dto.PubPageDTO;

public interface PubDao {
	public void save(PubDTO dto);
	public List<PubDTO> get();
	public int count();
	public List<PubDTO> list(PubPageDTO pv);
	public int searcount(String data);
	public List<PubDTO> searchlist(PubPageDTO pv);
	public List<MemDTO> memr();
	public void managero(String id);
	public void managerc(String id);
	public int suprcount();
	public void supo(String id);
	public void supc(String id);
	public List<PubDTO> supr();
	public int memrcount();
	public List<String> date();
	public int supcount();
	public int concount();
	public int pubcount();
	public int memcount();
	public List<String> mwtotal();
	public List<String> birth();
	public List<MemDTO> pubpre(String id);
}// end class
