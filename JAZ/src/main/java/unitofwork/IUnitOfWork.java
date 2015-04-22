package unitofwork;

import domain.Entity;

public interface IUnitOfWork 
{
	public void commit();
	public void rollback();
	public void markAsNew(Entity entity, IUnitOfWorkRepository repository);
	public void markAsDirty(Entity entity, IUnitOfWorkRepository repository);
	public void markAsDelete(Entity entity, IUnitOfWorkRepository repository);
}