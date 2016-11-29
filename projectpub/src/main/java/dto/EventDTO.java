package dto;

import org.springframework.web.multipart.MultipartFile;

public class EventDTO {
	
public EventDTO() {
}

private String id;
private int e_num;
private String e_title;
private String e_contents;
private int e_viewcnt;
private String e_upload;
private String e_uploads;
private String e_date;
private MultipartFile filename;
private MultipartFile filename2;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getE_num() {
	return e_num;
}
public void setE_num(int e_num) {
	this.e_num = e_num;
}
public String getE_title() {
	return e_title;
}
public void setE_title(String e_title) {
	this.e_title = e_title;
}

public String getE_contents() {
	return e_contents;
}
public void setE_contents(String e_contents) {
	this.e_contents = e_contents;
}
public int getE_viewcnt() {
	return e_viewcnt;
}
public void setE_viewcnt(int e_viewcnt) {
	this.e_viewcnt = e_viewcnt;
}
public String getE_upload() {
	return e_upload;
}
public void setE_upload(String e_upload) {
	this.e_upload = e_upload;
}

public String getE_date() {
	return e_date;
}
public void setE_date(String e_date) {
	this.e_date = e_date;
}
public MultipartFile getFilename() {
	return filename;
}
public void setFilename(MultipartFile filename) {
	this.filename = filename;
}
public MultipartFile getFilename2() {
	return filename2;
}
public void setFilename2(MultipartFile filename2) {
	this.filename2 = filename2;
}
public String getE_uploads() {
	return e_uploads;
}
public void setE_uploads(String e_uploads) {
	this.e_uploads = e_uploads;
}
 

}
