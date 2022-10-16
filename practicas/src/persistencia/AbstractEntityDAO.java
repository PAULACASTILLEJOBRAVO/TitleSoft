package persistencia;

public abstract class AbstractEntityDAO {

	private String id;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	/**
	 * 
	 * @param id
	 */
	public E get(String id) {
		// TODO - implement AbstractEntityDAO.get
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param entity
	 */
	public int insert(E entity) {
		// TODO - implement AbstractEntityDAO.insert
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param entity
	 */
	public E update(E entity) {
		// TODO - implement AbstractEntityDAO.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param entity
	 */
	public int delete(E entity) {
		// TODO - implement AbstractEntityDAO.delete
		throw new UnsupportedOperationException();
	}

	public void operation() {
		// TODO - implement AbstractEntityDAO.operation
		throw new UnsupportedOperationException();
	}

}