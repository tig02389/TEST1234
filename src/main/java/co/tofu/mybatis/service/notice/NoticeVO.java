package co.tofu.mybatis.service.notice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int no,rno;
	private String id,name,title,content,hit,writeDate;
}
