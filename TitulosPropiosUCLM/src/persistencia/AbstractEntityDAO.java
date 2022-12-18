package persistencia;

public abstract class AbstractEntityDAO <E> {
	public abstract E get(String id) throws Exception ;
	public abstract int insert(E entity) throws Exception;
	public abstract E update(E entity) throws Exception;
	public abstract int delete(E entity) throws Exception;
}
