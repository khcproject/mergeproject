package dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PubDTO {

	public PubDTO() {
	}
	
	private int p_num;
	private String id;
	private String p_mupload;
	private String p_supload;
	private String p_title;
	private String p_contents;
	private String p_address;
	private int p_maxpeople;
	private MultipartFile[] filename;
	private String p_pub_chk;
	private MultipartFile subfilename;
	private String p_addr_post;
	
	//유종선 조인
	private List<ReservationDTO> reservation;
	private MemDTO members;
	
	//조경호 조인
	private List<Pr_replyDTO> reply;
	private StarsDTO star;
	
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
	public String getP_mupload() {
		return p_mupload;
	}
	public void setP_mupload(String p_mupload) {
		this.p_mupload = p_mupload;
	}
	public String getP_supload() {
		return p_supload;
	}
	public void setP_supload(String p_supload) {
		this.p_supload = p_supload;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public String getP_contents() {
		return p_contents;
	}
	public void setP_contents(String p_contents) {
		this.p_contents = p_contents;
	}
	
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	public int getP_maxpeople() {
		return p_maxpeople;
	}
	public void setP_maxpeople(int p_maxpeople) {
		this.p_maxpeople = p_maxpeople;
	}
	public MultipartFile[] getFilename() {
		return filename;
	}
	public void setFilename(MultipartFile[] filename) {
		this.filename = filename;
	}
	public String getP_pub_chk() {
		return p_pub_chk;
	}
	public void setP_pub_chk(String p_pub_chk) {
		this.p_pub_chk = p_pub_chk;
	}
	public List<ReservationDTO> getReservation() {
		return reservation;
	}
	public void setReservation(List<ReservationDTO> reservation) {
		this.reservation = reservation;
	}
	public MemDTO getMembers() {
		return members;
	}
	public void setMembers(MemDTO members) {
		this.members = members;
	}
	public List<Pr_replyDTO> getReply() {
		return reply;
	}
	public void setReply(List<Pr_replyDTO> reply) {
		this.reply = reply;
	}
	public StarsDTO getStar() {
		return star;
	}
	public void setStar(StarsDTO star) {
		this.star = star;
	}
	public MultipartFile getSubfilename() {
		return subfilename;
	}
	public void setSubfilename(MultipartFile subfilename) {
		this.subfilename = subfilename;
	}
	public String getP_addr_post() {
		return p_addr_post;
	}
	public void setP_addr_post(String p_addr_post) {
		this.p_addr_post = p_addr_post;
	}
	
	
	
	
	
}
