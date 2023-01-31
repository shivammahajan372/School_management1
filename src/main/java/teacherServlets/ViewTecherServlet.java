package teacherServlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Teacher;
@WebServlet("/viewteacher")
public class ViewTecherServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("shivam");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		 int id = Integer.parseInt(req.getParameter("id"));
		 System.out.println("hiii"+id);
		et.begin();
		Teacher t =em.find(Teacher.class,id);
		et.commit();
		
		req.setAttribute("data", t);
	  	RequestDispatcher rd = req.getRequestDispatcher("Viewteacher.jsp");
	  	rd.forward(req, resp);
		
	}

}
