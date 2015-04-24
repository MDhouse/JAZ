package repositories.impl;

import java.sql.Connection;

import unitofwork.IUnitOfWork;
import domain.Participant;

public class ParticipantRepository extends Repository<Participant> //implements IParticipantRepository 
{
	public ParticipantRepository(Connection connection, IEntityBuilder<Participant> builder, IUnitOfWork uow) 
	{
		super(connection,builder, uow);
	}

	protected String getTableName() 
	{
		return "participants";
	}

	protected String getUpdate() 
	{
		return "UPDATE participants SET (firstname, lastname, email, emailAutehticate, superior, info, text)=(?,?,?,?,?,?,?) WHERE id=?;";
	}

	protected String getInsert() 
	{
		//System.out.println("Blad dodania do bazy");
		return "INSERT INTO participants VALUES(NULL,'?','?','?','?','?','?','?');";
	}

	
	
	
	@Override
	protected void setUpUpdate(Participant entity) throws Exception 
	{
		update.setString(1, entity.getFirstName());
		update.setString(2, entity.getLastName());
		update.setString(3, entity.getEmail());
		update.setString(4, entity.getEmailAuthenticate());
		update.setString(5, entity.getSuperior());
		update.setString(6, entity.getInfo());
		update.setString(7, entity.getText());
		update.setInt(8, entity.getId());	
	}

	@Override
	protected void setUpInsert(Participant entity) throws Exception 
	{
		insert.setString(1, entity.getFirstName());
		insert.setString(2, entity.getLastName());
		insert.setString(3, entity.getEmail());
		insert.setString(4, entity.getEmailAuthenticate());
		insert.setString(5, entity.getSuperior());
		insert.setString(6, entity.getInfo());
		insert.setString(7, entity.getText());	
	}
}