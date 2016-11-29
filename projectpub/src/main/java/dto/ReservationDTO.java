package dto;

public class ReservationDTO {

	private int res_num;
	private int p_num;
	private String id;
	private int res_people;
	private String res_date;
	private String res_time;
	private String res_concheck;
	private String res_sellcheck;
	private int c_num;
	
	//유종선 조인
	private MemDTO members;
	private PubDTO pub;
	private CouponDTO coupon;

	public ReservationDTO() {
	}

	public int getRes_num() {
		return res_num;
	}

	public void setRes_num(int res_num) {
		this.res_num = res_num;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRes_people() {
		return res_people;
	}

	public void setRes_people(int res_people) {
		this.res_people = res_people;
	}

	public String getRes_date() {
		return res_date;
	}

	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}

	public String getRes_time() {
		return res_time;
	}

	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}

	public String getRes_concheck() {
		return res_concheck;
	}

	public void setRes_concheck(String res_concheck) {
		this.res_concheck = res_concheck;
	}

	public String getRes_sellcheck() {
		return res_sellcheck;
	}

	public void setRes_sellcheck(String res_sellcheck) {
		this.res_sellcheck = res_sellcheck;
	}

	public MemDTO getMembers() {
		return members;
	}

	public void setMembers(MemDTO members) {
		this.members = members;
	}

	public PubDTO getPub() {
		return pub;
	}

	public void setPub(PubDTO pub) {
		this.pub = pub;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public CouponDTO getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponDTO coupon) {
		this.coupon = coupon;
	}
	
	
	
}
