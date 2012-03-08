package edu.sinclair.ssp.service.reference;

import java.util.List;
import java.util.UUID;

import edu.sinclair.ssp.model.ObjectStatus;
import edu.sinclair.ssp.service.ObjectNotFoundException;

public interface ReferenceService<T> {

	public List<T> getAll(ObjectStatus status);
	
	public T get(UUID id) throws ObjectNotFoundException;
	
	public T create(T obj);
	
	public T save(T obj) throws ObjectNotFoundException;
	
	public void delete(UUID id) throws ObjectNotFoundException;
}
