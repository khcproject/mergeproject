package dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MemDTO {
	public MemDTO() {
	}
	
	private String id;
	private String pw;
	private String phone;
	private String email;
	private String email_agree;
	private String sex;
	private String name;
	private String birth;
	private String userchk;
	private String face;
	private String allow_chk;
	private String login_time;
	private String saupja_num;
	private MultipartFile filename;
	//유종선 조인
	private List<CouponDTO> coupon;
	private List<ReservationDTO> reservation;
	private List<PubDTO> pub;
	
	//유종선(회원사진 삭제 조인)
	private PubDTO picpub;
	private List<SocialDTO> picsocial;
	private List<QuestionDTO> picquestion;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_agree() {
		return email_agree;
	}
	public void setEmail_agree(String email_agree) {
		this.email_agree = email_agree;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
		
	}
	public String getUserchk() {
		return userchk;
	}
	public void setUserchk(String userchk) {
		this.userchk = userchk;
	}
	
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	
	public String getSaupja_num() {
		return saupja_num;
	}
	public void setSaupja_num(String saupja_num) {
		this.saupja_num = saupja_num;
	}
	public MultipartFile getFilename() {
		return filename;
	}
	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}
	public String getAllow_chk() {
		return allow_chk;
	}
	public void setAllow_chk(String allow_chk) {
		this.allow_chk = allow_chk;
	}
	
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	public List<CouponDTO> getCoupon() {
		return coupon;
	}
	public void setCoupon(List<CouponDTO> coupon) {
		this.coupon = coupon;
	}
	public List<ReservationDTO> getReservation() {
		return reservation;
	}
	public void setReservation(List<ReservationDTO> reservation) {
		this.reservation = reservation;
	}
	public List<PubDTO> getPub() {
		return pub;
	}
	public void setPub(List<PubDTO> pub) {
		this.pub = pub;
	}
	public PubDTO getPicpub() {
		return picpub;
	}
	public void setPicpub(PubDTO picpub) {
		this.picpub = picpub;
	}
	public List<SocialDTO> getPicsocial() {
		return picsocial;
	}
	public void setPicsocial(List<SocialDTO> picsocial) {
		this.picsocial = picsocial;
	}
	public List<QuestionDTO> getPicquestion() {
		return picquestion;
	}
	public void setPicquestion(List<QuestionDTO> picquestion) {
		this.picquestion = picquestion;
	}
	
	
	
	
	
}
