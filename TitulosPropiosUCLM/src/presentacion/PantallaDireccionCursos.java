package presentacion;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class PantallaDireccionCursos extends JFrame {
	private JTextField textFieldUsuario= new JTextField();;
	private JTextField textFieldPassword= new JTextField();
	private JPanel contentPane;
	public void altaCurso() {
		throw new UnsupportedOperationException();
		setTitle("Sesion:Direccion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void edicionCurso() {
		throw new UnsupportedOperationException();
	}

}