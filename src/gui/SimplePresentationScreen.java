package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	
	private JPanel paneImage;
	private JTextField txtLU, txtLastName, txtName, txtEmail, txtGithub;
	private JLabel labelLU, labelName, labelLastName, labelEmail, labelGithub, labelDate;

	public SimplePresentationScreen(Student studentData) {
		/*INICIO - Código dado por la cátedra*/
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		/*FIN - Código dado por la cátedra*/
		
		//Recupera la ruta del icono tdp.png, crea una imagen de icono y lo establece como icono de jframe.
		URL pathIcon = getClass().getResource("/images/tdp.png");
		Image imageIcon = new ImageIcon(pathIcon).getImage();
		this.setIconImage(imageIcon);
		
		/*INICIO - Código dado por la cátedra*/
		init();
		/*Fin - Código dado por la cátedra*/
	}
	
	private void init() {
		contentPane.setLayout(new MigLayout("", "[grow,fill][][150px:150px:150px,grow,fill]", "[grow,fill][150px:150px:150px,grow,fill][20px:20px:20px,grow,fill]"));
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		labelLU = new JLabel("LU");
		labelLU.setHorizontalAlignment(SwingConstants.RIGHT);
		
		labelLastName = new JLabel("Apellido");
		labelLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		tabInformation.setLayout(new MigLayout("", "[70px:70px:70px,grow,left][5px:n:5px][grow,fill]", "[8.00][20px:20px:20px,grow,fill][20px:20px:20px,grow,fill][20px:n:20px,grow,fill][20px:n:20px,grow,fill][20px:n:20px,grow,fill][]"));
		tabInformation.add(labelLU, "cell 0 1,alignx left,growy");
		
		txtLU = new JTextField(String.valueOf(studentData.getId()));
		txtLU.setBackground(Color.WHITE);
		txtLU.setEditable(false);
		tabInformation.add(txtLU, "cell 2 1,grow");
		txtLU.setColumns(10);
		tabInformation.add(labelLastName, "cell 0 2,alignx left,growy");
		
		txtLastName = new JTextField(studentData.getLastName());
		tabInformation.add(txtLastName, "cell 2 2,grow");
		txtLastName.setColumns(10);
		txtLastName.setBackground(Color.WHITE);
		txtLastName.setEditable(false);
		
		labelName = new JLabel("Nombre");
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		tabInformation.add(labelName, "cell 0 3,alignx left,growy");
		
		txtName = new JTextField(studentData.getFirstName());
		tabInformation.add(txtName, "cell 2 3,grow");
		txtName.setColumns(10);
		txtName.setBackground(Color.WHITE);
		txtName.setEditable(false);
		
		labelEmail = new JLabel("E-mail");
		labelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		tabInformation.add(labelEmail, "cell 0 4,alignx left,growy");
		
		txtEmail = new JTextField(studentData.getMail());
		tabInformation.add(txtEmail, "cell 2 4,grow");
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setEditable(false);
		
		labelGithub = new JLabel("Github URL");
		labelGithub.setHorizontalAlignment(SwingConstants.RIGHT);
		tabInformation.add(labelGithub, "cell 0 5,alignx left,growy");
		
		txtGithub = new JTextField(studentData.getGithubURL());
		tabInformation.add(txtGithub, "cell 2 5,grow");
		txtGithub.setColumns(10);
		txtGithub.setBackground(Color.WHITE);
		txtGithub.setEditable(false);
		contentPane.add(tabbedPane, "cell 0 0 1 2,grow");
		
		paneImage = new JPanel();
		paneImage.setBorder(null);
		paneImage.setSize(150, 150);
		contentPane.add(paneImage, "cell 2 1,grow");
		
		labelDate = new JLabel(getDateExecution());
		contentPane.add(labelDate, "cell 0 2 3 1,alignx left,aligny top");
	}
	
	
	public void paint(Graphics grafico) {
		//Recupero la imagen del paquete images.
		ImageIcon Img = new ImageIcon(getClass().getResource("/images/photo.jpg")); 
		//Dibuja la imagen de acuerdo a las dimensiones del panel imagen.
		grafico.drawImage(Img.getImage(), paneImage.getX(), paneImage.getY()+25, paneImage.getWidth(), paneImage.getHeight(), null);
		//Pinta el grafico sobre el panel imagen.
		paneImage.paintComponents(grafico);
	}

	/*
	 *Devuelve una cadena con la fecha y hora de ejecucion del programa. 
	 */
	private String getDateExecution() {
		//Recupera la fecha local actual.
		LocalDate localDate = LocalDate.now();
		//Recupera el tiempo local actual.
		LocalTime localTime = LocalTime.now();
		
		//Tratamiento de las variables siguientes: 
		//	Si el número es mayor a 9, entonces tiene dos dígitos y no es necesario ningún tratamiento.
		//	Si el número es menor o igual a 9, entonces se agrega un 0 para que tenga dos dígitos.
		
		String day = (localDate.getDayOfMonth()>9) ? String.valueOf(localDate.getDayOfMonth()) : "0"+String.valueOf(localDate.getDayOfMonth());
		String month = (localDate.getMonthValue()>9) ? String.valueOf(localDate.getMonthValue()) : "0"+String.valueOf(localDate.getMonthValue());
		
		String hour = (localTime.getHour()>9) ? String.valueOf(localTime.getHour()) : "0"+String.valueOf(localTime.getHour());
		String minute = (localTime.getMinute()>9) ? String.valueOf(localTime.getMinute()) : "0"+String.valueOf(localTime.getMinute());
		String second = (localTime.getSecond()>9) ? String.valueOf(localTime.getSecond()) : "0"+String.valueOf(localTime.getSecond());
		
		//Genera una cadena que respeta el formato dd/mm/yyyy hh:mm:ss.
		String date = "Esta ventana fue generada el " + day + "/" + month + "/" + localDate.getYear() + " a las " + hour + ":" + minute + ":" + second;
		
		return date;
	}
}
