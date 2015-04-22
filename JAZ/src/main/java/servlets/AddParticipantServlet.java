package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.impl.ParticipantBuilder;
import repositories.impl.ParticipantRepository;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;
import domain.Participant;

@WebServlet("/AddParticipant")
public class AddParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	ParticipantRepository participantRepository;
	IUnitOfWork uow;
	
	public void init() throws ServletException
	{
		super.init();

		String url			= "jdbc:mysql://localhost";
		String user 		= "root";
		String password 	= "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(url, user, password);
			
			Statement stt = (Statement) connection.createStatement();
			IUnitOfWork uow = new UnitOfWork (connection);
			
			stt.execute("DROP DATABASE IF EXISTS java4us");
			stt.execute("CREATE DATABASE java4us");
			stt.execute("USE java4us");
			
			stt.execute("DROP TABLE IF EXISTS participants");
			stt.execute("CREATE TABLE participants(" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"firstname TEXT," +
					"lastname TEXT," +
					"email TEXT," +
					"emailAutehticate TEXT," +
					"superior TEXT," +
					"info TEXT," +
					"text TEXT," +
					"PRIMARY KEY(id)" +
					");");
			
			participantRepository = new ParticipantRepository(connection, new ParticipantBuilder(), uow);
				
		}
		catch (Exception e)
		{
			e.printStackTrace();	
			
			System.out.println("Blad");
			
		}
	}

	public AddParticipantServlet()
    {
    	        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstName 			= (String) request.getParameter("firstName");
		String lastName 			= (String) request.getParameter("lastName");
		String email				= (String) request.getParameter("email"); 
		String emailAuthenticate	= (String) request.getParameter("emailAuthenticate");
		String superior 			= (String) request.getParameter("superior");
		String info 				= (String) request.getParameter("info");
		String text 				= (String) request.getParameter("text");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("firstName") != null && session.getAttribute("lastName").equals(lastName))
		{
			response.sendRedirect("DoubleRegistered.jsp");
		}
		
		if(lastName != null && !lastName.equals(""))
		{
			List<Participant> participants = participantRepository.getAll();
			int numberOfPeople = participants.size();
			
			session.setAttribute("lastName", lastName);
			session.setAttribute("email", email);
			
			Participant p = new Participant(lastName);
			p.setEmail(email);
		
		
		if(numberOfPeople == 0)
		{
			response.getWriter().println("You are 1 participant<br/>");
			saveParticipant(p);
		}
		else if(numberOfPeople == 5)
		{
			response.sendRedirect("NoRegistered.jsp");
		}
		else
		{
			numberOfPeople += 1;
			response.getWriter().println("You are " + numberOfPeople + " participant<br/>");
			saveParticipant(p);
		}
			
		}
		
		response.getWriter().println("<a href='/com.example/Formularz.jsp'>Go back</a><br/>");
		
	}

	private void saveParticipant(Participant p) 
	{
		participantRepository.save(p);
		uow.commit();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
}