package co.jin.bootstraptest.Notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NoticeVO {
	// 내가 원하는대로가 아니라 회사가, 팀이 원하는대로 코드를 구현해야함 명령규칙 준수할려고 노력해야함.
	private int id;
	private String writer;
	private String title;
	private String subject;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date wdate;
	private int hit;
	private String fileName;
	private String dirFileName;
}
