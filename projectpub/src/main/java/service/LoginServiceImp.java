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

	@Override
	public void emailagreeUpdateProcess(String id) {
		dao.emailagreeUpdateMethod(id);
	}

	@Override
	public MemDTO pwFindProcess(MemDTO dto) {
		return dao.pwFindMethod(dto);
	}

	@Override
	public void logTimeProcess(MemDTO dto) {
		dao.logTimeMethod(dto);
	}

}