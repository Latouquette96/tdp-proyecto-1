package launcher;

import javax.swing.JFrame;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
            	//Estudiante con datos personales.
            	Student student = new Student(
            		118801, 
            		"Latouquette", 
            		"David Emanuel", 
            		"davidemanuel96@outlook.com", 
            		"https://github.com/Latouquette96", 
            		"@images/tdp.png"
            	);
            	//Creo una instancia de la pantalla de presentación con el estudiante.
            	JFrame jframe = new SimplePresentationScreen(student);
            	//Muestra el frame.
            	jframe.setVisible(true);
            }
        });
    }
}