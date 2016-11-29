package dto;

public class CouponDTO {

	public CouponDTO() {
	}
	
	private int c_num;
	private String id;
	private String c_contents;
	private String c_coupon;
	private String c_date;
	private String c_use;
	//유종선 조인
	private ReservationDTO reservation;
	
	
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getC_contents() {
		return c_contents;
	}
	public void setC_contents(String c_contents) {
		this.c_contents = c_contents;
	}
	public String getC_coupon() {
		return c_coupon;
	}
	public void setC_coupon(String c_coupon) {
		this.c_coupon = c_coupon;
	}
	public String getC_use() {
		return c_use;
	}
	public void setC_use(String c_use) {
		this.c_use = c_use;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	public ReservationDTO getReservation() {
		return reservation;
	}
	public void setReservation(ReservationDTO reservation) {
		this.reservation = reservation;
	}
	
	
	
	
	
}
