package unitofwork;

import domain.Entity;

public interface IUnitOfWorkRepository 
{
	public void persistSave(Entity entity);
	public void persistUpdate(Entity entity);
	public void persistDelete(Entity entity);
}