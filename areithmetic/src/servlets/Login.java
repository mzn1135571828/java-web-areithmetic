package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		request.getSession().invalidate();
		User u = new User();
		u.setId(request.getParameter("id"));
		u.setPwd(request.getParameter("pwd"));
		UserDao ud = new UserDao();
		boolean user = ud.checkLogin(u);
		if(user){
			request.getSession().setAttribute("id", u.getId());
			response.sendRedirect("main.jsp");
		}
		else{
//			out.print("登录失败！用户名或密码错误");
//			response.setHeader("refresh", "3;url=http://localhost:8080/middletest/");
			request.setAttribute("info", "用户名或密码错误，请重新输入");
			request.setAttribute("id", request.getParameter("id"));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
