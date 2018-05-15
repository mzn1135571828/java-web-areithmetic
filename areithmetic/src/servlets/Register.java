package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

import dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		User u = new User();
		u.setId(request.getParameter("username"));
		UserDao ud = new UserDao();
		Boolean id = ud.register(u);
		if(id){
			if(Pattern.matches("[\\w\u4E00-\u9FA5]{2,}", username)){
				String pwd1 = request.getParameter("pwd1");
				String pwd2 = request.getParameter("pwd2");
				if(pwd1==""){
					out.print("����Ϊ�գ�");
				}else{
					if(pwd1.equals(pwd2)){
						if(Pattern.matches("\\w{6,10}", pwd1)){
							u.setPwd(request.getParameter("pwd1"));
							if(ud.insert(u)){
								out.print("ע��ɹ���");
							}
							else{
								out.print("ע��ʧ�ܣ�");
							}
						}else{
							out.print("�����ʽ��������������");
						}
					}else{
						out.print("�����������벻һ�£�����������");
					}
				}
			}
			else{
				out.print("�û�����ʽ��������������");
			}
		}else{
			out.print("�û����ظ�������������");
		}
	}

}
