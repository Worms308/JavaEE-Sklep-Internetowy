package utilities;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dao.InitDB;
import dao.UserDAO;
import entities.User;


@WebFilter("/*")
public class LoginFilter implements Filter {


    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		req.setCharacterEncoding("UTF-8");
		String login = req.getRemoteUser();
		if (login != null) {
			User user = (User)req.getSession().getAttribute("user");
			if (user == null) {
				UserDAO dao = InitDB.getUserDAO();
				user = dao.getUserByLogin(login);
				req.getSession().setAttribute("user", user);
			}
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
