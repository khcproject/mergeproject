package service;

import dto.MemDTO;

public interface LoginService {

	public void memberInsertProcess(MemDTO dto);

	public String idchkProcess(MemDTO dto);
	
	public MemDTO loginProcess(MemDTO dto);
}
