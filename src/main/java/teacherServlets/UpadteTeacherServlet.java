package teacherServlets;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/update")
public class UpadteTeacherServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("shivam");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String sub = req.getParameter("sub");
		double sal = Double.parseDouble(req.getParameter("sal"));
		
		Teacher t = new Teacher();
		t.setId(id);
		t.setName(name);
		t.setSubject(sub);
		t.setSal(sal);
		
		et.begin();
		em.merge(t);
		et.commit();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("Updated Succesfully");
		
		RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");
		rd.include(req, resp);
		
	
	}

}
