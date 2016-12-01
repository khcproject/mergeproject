package service;

import java.util.List;

import dto.CouponDTO;
import dto.MemDTO;
import dto.Pr_replyDTO;
import dto.PubDTO;
import dto.ReservationDTO;
import dto.StarsDTO;

public interface ReservationService {

	public List<PubDTO> reservationListProcess(int p_num);

	public void testinsProcess(MemDTO mdto);

	public void resinsertProcess(ReservationDTO dto);

	public void insertProcess(PubDTO dto);

	public List<Pr_replyDTO> replyInsertListProcess(Pr_replyDTO dto);

	public List<Pr_replyDTO> replyDeleteListProcess(Pr_replyDTO dto);

	public List<Pr_replyDTO> replyUpdateListProcess(Pr_replyDTO dto);

	public StarsDTO pubStarAvgProcess(StarsDTO dto);

	public List<CouponDTO> couponListProcess();

	public StarsDTO starChkProcess(StarsDTO ss);

}
