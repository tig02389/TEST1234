package co.tofu.mybatis.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public String run(HttpServletRequest request, HttpServletResponse response);
}
