package persistencia;

import java.util.*;

public abstract class AbstractEntityDAO <E> {

	
	private String id;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	/**
	 * 
	 * @param id
	 */
	/**
	 * 
	 * @param entity
	 */
	public abstract int insert(E entity);

	/**
	 * 
	 * @param entity
	 */
	public abstract E update(E entity);

	/**
	 * 
	 * @param entity
	 */
	public abstract void operation();

}
