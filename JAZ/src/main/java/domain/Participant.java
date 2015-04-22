package domain;

import java.util.ArrayList;
import java.util.List;

public class Participant extends Entity
{
	
	private String firstName;
	private String lastName;
	private String email;
	private String emailAuthenticate;
	private String superior;
	private String info;
	private String text;
	private List<Participant> participants;
	
	public Participant()
	{
		this.setParticipants(new ArrayList<Participant>());
	}
	public Participant(String lastName)
	{
		super();
		this.lastName=lastName;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getEmailAuthenticate() 
	{
		return emailAuthenticate;
	}
	public void setEmailAuthenticate(String emailAuthenticate) 
	{
		this.emailAuthenticate = emailAuthenticate;
	}
	public String getSuperior() 
	{
		return superior;
	}
	public void setSuperior(String superior) 
	{
		this.superior = superior;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) 
	{
		this.info = info;
	}
	public String getText() 
	{
		return text;
	}
	public void setText(String text) 
	{
		this.text = text;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

}
