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
	public abstract E get(String id) throws Exception ;

	/**
	 * 
	 * @param entity
	 * @throws Exception 
	 */
	public abstract int insert(E entity) throws Exception;

	/**
	 * 
	 * @param entity
	 */
	public abstract E update(E entity) throws Exception;

	/**
	 * 
	 * @param entity
	 */
	public abstract int delete(E entity) throws Exception;


}
