package domain;

public abstract class Entity 
{
	protected int id;
	
	protected EntityState state;
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	public EntityState getState() 
	{
		return state;
	}
	
	public void setState(EntityState state) 
	{
		this.state = state;
	}
}
