package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import unitofwork.IUnitOfWork;
import unitofwork.IUnitOfWorkRepository;
import domain.Entity;

public abstract class Repository <TEntity extends Entity> 
implements IRepository<TEntity>, IUnitOfWorkRepository
{
	protected Connection connection;
	protected IEntityBuilder<TEntity> builder;
	protected IUnitOfWork uow;
	protected PreparedStatement insert;
	protected PreparedStatement update;
	
	protected Repository(Connection connection, IEntityBuilder<TEntity> builder, IUnitOfWork uow)
	{
		this.connection = connection;
		this.builder = builder;
			
		try 
		{
			insert = connection.prepareStatement(getInsert());
			update = connection.prepareStatement(getUpdate());
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}

	public void save(TEntity entity) 
	{
		uow.markAsNew(entity, this);
	}

	public void delete(TEntity entity) 
	{
		uow.markAsDelete(entity, this);
	}

	public void update(TEntity entity) 
	{
		uow.markAsDirty(entity, this);
	}

	public void persistSave(Entity entity) 
	{
		try
		{		
			setUpInsert((TEntity)entity);
			insert.execute();
		}	
		catch(Exception e) 
		{
			e.printStackTrace();	
			System.out.println("Blad dodawania");
		}
		
	}


	public void persistUpdate(Entity entity) 
	{
		try
		{
			setUpUpdate((TEntity)entity);
			update.execute();
		}	
		catch(Exception e) 
		{
			e.printStackTrace();	
		}
	}

	public void persistDelete(Entity entity) 
	{
	try 
	{
		PreparedStatement stt = connection.prepareStatement("DELETE FROM "+ getTableName() +" WHERE id=?;");
		stt.setInt(1, entity.getId());
		stt.execute();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	}

	public TEntity get(int id) 
	{

		try {
			PreparedStatement stt = connection.prepareStatement("SELECT * FROM "+ getTableName() +" WHERE id=?;");
			stt.setInt(1, id);
			ResultSet rs = stt.executeQuery();
			while(rs.next())
			{
				return builder.build(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<TEntity> getAll() 
	{
		List<TEntity> result = new ArrayList<TEntity>();
		
		try 
		{	PreparedStatement stt = connection.prepareStatement("SELECT * FROM "+ getTableName() +";");
			ResultSet rs= stt.executeQuery();
			while(rs.next())
			{
				result.add(builder.build(rs));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return result;
	}
	protected abstract void setUpUpdate(TEntity entity) throws Exception;
	protected abstract void setUpInsert(TEntity entity) throws Exception;
	protected abstract String getTableName();
	protected abstract String getUpdate();
	protected abstract String getInsert();

	
	
}
