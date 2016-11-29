package dto;


import org.springframework.web.multipart.MultipartFile;

public class QuestionDTO {

	public QuestionDTO() {
	}
	
	private String id;
	private int q_num;
	private String q_title;
	private String q_contents;
	private int q_viewcnt;
	private String q_upload;
	private String q_date;
	private int qr_num;
	private int qr_step;
	private int qr_level;
	
	private MultipartFile filename;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQ_num() {
		return q_num;
	}

	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_contents() {
		return q_contents;
	}

	public void setQ_contents(String q_contents) {
		this.q_contents = q_contents;
	}

	public int getQ_viewcnt() {
		return q_viewcnt;
	}

	public void setQ_viewcnt(int q_viewcnt) {
		this.q_viewcnt = q_viewcnt;
	}

	public String getQ_upload() {
		return q_upload;
	}

	public void setQ_upload(String q_upload) {
		this.q_upload = q_upload;
	}

	public String getQ_date() {
		return q_date;
	}

	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}

	public int getQr_num() {
		return qr_num;
	}

	public void setQr_num(int qr_num) {
		this.qr_num = qr_num;
	}



	public int getQr_step() {
		return qr_step;
	}

	public void setQr_step(int qr_step) {
		this.qr_step = qr_step;
	}

	public int getQr_level() {
		return qr_level;
	}

	public void setQr_level(int qr_level) {
		this.qr_level = qr_level;
	}

	public MultipartFile getFilename() {
		return filename;
	}

	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}
	
	
	
	
	
	
	
	
	
	
}
