package repositories.impl;

import java.sql.ResultSet;

import domain.Entity;

public interface IEntityBuilder<TEntity extends Entity> 
{
	public TEntity build(ResultSet rs) throws Exception;
	
}
