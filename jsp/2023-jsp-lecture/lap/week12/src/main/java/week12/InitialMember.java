package week12;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.*;

@WebListener
public class InitialMember implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		ArrayList<Member> datas = new ArrayList<Member>();
		for (int i = 0; i < 8; i++) {
			Member data = new Member("한성대" + i, "test" + i + "@test.net");
			datas.add(data);
		}
		datas.add(new Member("홍길동", null));
		datas.add(new Member("김길동", null));
		context.setAttribute("members", datas);
		context.setAttribute("member", new Member());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
