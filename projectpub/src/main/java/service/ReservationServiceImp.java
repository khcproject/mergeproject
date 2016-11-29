package service;

import java.util.List;

import dao.ReservationDao;
import dto.CouponDTO;
import dto.MemDTO;
import dto.Pr_replyDTO;
import dto.PubDTO;
import dto.ReservationDTO;
import dto.StarsDTO;

public class ReservationServiceImp implements ReservationService {

	private ReservationDao dao;

	public ReservationServiceImp() {
	}

	public void setDao(ReservationDao dao) {
		this.dao = dao;
	}

	@Override
	public List<PubDTO> reservationListProcess(int p_num) {

		return dao.reservationListMethod(p_num);

	}

	@Override
	public void testinsProcess(MemDTO mdto) {
		dao.meminsertMethod(mdto);
	}

	@Override
	public void resinsertProcess(ReservationDTO dto) {
		dao.res_insertMethod(dto);
	}

	@Override
	public void insertProcess(PubDTO dto) {
		dao.save(dto);
	}

	@Override
	public List<Pr_replyDTO> replyInsertListProcess(Pr_replyDTO dto) {
		dao.replyInsertMethod(dto);
		return dao.replyListMethod(dto.getP_num());

	}

	@Override
	public List<Pr_replyDTO> replyDeleteListProcess(Pr_replyDTO dto) {
		dao.replyDeleteMethod(dto.getPr_num());
		return dao.replyListMethod(dto.getP_num());

	}

	@Override
	public List<Pr_replyDTO> replyUpdateListProcess(Pr_replyDTO dto) {
		dao.replyUpdateMethod(dto);
		return dao.replyListMethod(dto.getP_num());
	}


	@Override
	public StarsDTO pubStarAvgProcess(StarsDTO dto) {
		dao.pubStarInsertMethod(dto);
		return dao.pubStarAvgMethod(dto.getP_num());
	}

	@Override
	public List<CouponDTO> couponListProcess() {
		return dao.couponListMethod();
	}

}// end class
