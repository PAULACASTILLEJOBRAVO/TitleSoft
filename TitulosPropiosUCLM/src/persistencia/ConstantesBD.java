package persistencia;

public class ConstantesBD {
	
	private ConstantesBD() {
		throw new IllegalStateException("Utility class");
	}
	
	static final String DRIVER ="jdbc:derby";
	static final String CONNECTION_STRING ="jdbc:derby:BaseDeDatos;create=true";
	static final String DBNAME ="BaseDeDatos";
	static final String DBUSER ="admin";
	static final String DBPASS ="admin";
}
