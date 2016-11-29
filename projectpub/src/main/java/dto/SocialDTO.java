package dto;

import org.springframework.web.multipart.MultipartFile;

public class SocialDTO {

	private int s_num;
	private String id;
	private String s_upload;
	private String s_content;
	private int s_like;
	private String s_date;
	private MultipartFile filename;
	
	public SocialDTO() {
	}

	public int getS_num() {
		return s_num;
	}

	public void setS_num(int s_num) {
		this.s_num = s_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getS_upload() {
		return s_upload;
	}

	public void setS_upload(String s_upload) {
		this.s_upload = s_upload;
	}

	public String getS_content() {
		return s_content;
	}

	public void setS_content(String s_content) {
		this.s_content = s_content;
	}

	public int getS_like() {
		return s_like;
	}

	public void setS_like(int s_like) {
		this.s_like = s_like;
	}


	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public MultipartFile getFilename() {
		return filename;
	}

	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}
	
	
	
	
}
