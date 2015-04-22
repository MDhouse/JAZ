package repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Participant;

public class ParticipantBuilder implements IEntityBuilder<Participant>
{
	public Participant build(ResultSet rs) throws SQLException 
	{
		Participant result = new Participant();
		result.setId(rs.getInt("id"));
		result.setFirstName(rs.getString("firstName"));
		result.setLastName(rs.getString("lastName"));
		result.setEmail(rs.getString("email"));
		result.setEmailAuthenticate(rs.getString("emailAuthenticate"));
		result.setSuperior(rs.getString("superior"));
		result.setInfo(rs.getString("info"));
		result.setText(rs.getString("text"));
		return result;
	}
}