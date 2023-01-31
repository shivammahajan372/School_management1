package servlet;
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

import entity.Principal;
@WebServlet("/register")
public class PrincipalRegServlet extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String name=req.getParameter("name");
	int age = Integer.parseInt(req.getParameter("age"));
	long mobno = Long.parseLong(req.getParameter("mobno"));
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	
	Principal p = new Principal();
	
	p.setName(name);
	p.setAge(age);
	p.setEmail(email);
	p.setPassword(password);
	p.setMobno(mobno);
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("shivam");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	et.begin();
	em.persist(p);
	et.commit();
	
	RequestDispatcher rd = req.getRequestDispatcher("Login.html");
	rd.forward(req, resp);
	
}
}
