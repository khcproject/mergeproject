package dao;

import dto.MemDTO;

public interface LoginDao {

	public void meminsertMethod(MemDTO dto);
	
	public String idchkMethod(MemDTO dto);
	
	public MemDTO loginMethod(MemDTO dto);
}
