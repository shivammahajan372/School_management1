package studentServlets;

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

import entity.Student;
@WebServlet("/three")
public class AddStudentServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String stream = req.getParameter("stream");
		long fees = Long.parseLong(req.getParameter("fees")); 
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("shivam");
		EntityManager em = emf.createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 
		 Student s = new Student();
		 s.setId(id);
		 s.setName(name);
		 s.setStream(stream);
		 s.setFees(fees);
		 
		 et.begin();
		 em.persist(s);
		 et.commit();
		 
		 System.out.println("Data Saved....");
		 
		 RequestDispatcher rd = req.getRequestDispatcher("Student.html");
		 rd.forward(req, resp);
		 
	}

}
