package persistencia;

public interface AbstractEntityDAO <E> {
	public abstract E get(String id);
	public abstract int insert(E entity);
	public abstract E update(E entity);
	public abstract int delete(E entity);
}
