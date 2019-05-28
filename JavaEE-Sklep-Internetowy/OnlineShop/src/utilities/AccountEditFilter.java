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

/**
 * Servlet Filter implementation class AccountEditFilter
 */
@WebFilter({ "/account/edit/address_change", "/account/edit/personal_change" })
public class AccountEditFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AccountEditFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		req.setCharacterEncoding("UTF-8");
		String login = req.getRemoteUser();
		if (login != null) {
			User user = (User)req.getSession().getAttribute("user");

			UserDAO dao = InitDB.getUserDAO();
			user = dao.getUserByLogin(login);
			req.getSession().setAttribute("user", user);
			
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
