package dao;

import java.util.List;

import dto.CouponDTO;
import dto.MemDTO;
import dto.Pr_replyDTO;
import dto.PubDTO;
import dto.ReservationDTO;
import dto.StarsDTO;

public interface ReservationDao {

	public String getFile(int p_num);

	public List<PubDTO> reservationListMethod(int p_num);

	public void meminsertMethod(MemDTO dto);

	public void res_insertMethod(ReservationDTO dto);

	public void save(PubDTO dto);

	public void replyInsertMethod(Pr_replyDTO dto);

	public List<Pr_replyDTO> replyListMethod(int p_num);

	public void replyDeleteMethod(int pr_num);

	public void replyUpdateMethod(Pr_replyDTO dto);

	public void pubStarInsertMethod(StarsDTO dto);

	public StarsDTO pubStarAvgMethod(int p_num);

	public List<CouponDTO> couponListMethod();

	public StarsDTO chkstarMethod(StarsDTO ss);
}
