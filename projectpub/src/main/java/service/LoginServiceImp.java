package service;

import dao.LoginDao;
import dto.MemDTO;

public class LoginServiceImp implements LoginService {

	private LoginDao dao;

	public LoginServiceImp() {
	}

	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	@Override
	public void memberInsertProcess(MemDTO dto) {

		dao.meminsertMethod(dto);
	}

	@Override
	public String idchkProcess(MemDTO dto) {
		return dao.idchkMethod(dto);
	}

	@Override
	public MemDTO loginProcess(MemDTO dto) {
		return dao.loginMethod(dto);
	}

}// end class
