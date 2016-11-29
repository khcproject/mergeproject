package dto;


public class Pr_replyDTO {

	public Pr_replyDTO(){
		
	}
	
	private int pr_num;
	private String id;
	private int p_num;
	private int pr_like;
	private String pr_content;
	
	public int getPr_num() {
		return pr_num;
	}
	public void setPr_num(int pr_num) {
		this.pr_num = pr_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getPr_like() {
		return pr_like;
	}
	public void setPr_like(int pr_like) {
		this.pr_like = pr_like;
	}
	public String getPr_content() {
		return pr_content;
	}
	public void setPr_content(String pr_content) {
		this.pr_content = pr_content;
	}
	
	
}
