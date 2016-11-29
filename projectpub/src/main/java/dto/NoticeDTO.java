package dto;

public class NoticeDTO {

	private String id;
	private int n_num;
	private String n_title;
	private String n_contents;
	private int n_viewcnt;
	private String n_date;
	
	
	public NoticeDTO() {
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getN_num() {
		return n_num;
	}


	public void setN_num(int n_num) {
		this.n_num = n_num;
	}


	public String getN_title() {
		return n_title;
	}


	public void setN_title(String n_title) {
		this.n_title = n_title;
	}


	public String getN_contents() {
		return n_contents;
	}


	public void setN_contents(String n_contents) {
		this.n_contents = n_contents;
	}


	public int getN_viewcnt() {
		return n_viewcnt;
	}


	public void setN_viewcnt(int n_viewcnt) {
		this.n_viewcnt = n_viewcnt;
	}


	public String getN_date() {
		return n_date;
	}


	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	
	
	
}
