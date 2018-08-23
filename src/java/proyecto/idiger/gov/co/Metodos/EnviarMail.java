package proyecto.idiger.gov.co.Metodos;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Luis Fernando Sanchez G
 *
 */
public class EnviarMail {

	/**
	 * Metodo para enviar un correo una vez realizado el registro en el aplicativo de Primer Respondiente. 
	 * @param nombre
	 * @param correo
	 * @param pass
	 * @param usuario
	 */
	public static void EnviarMail(String nombre, String correo, String pass, String usuario, String mailAplicativo){
				
		System.out.println("metodo enviarCorreo");
		String mensajes = "";
		
		mensajes = mensajes +"<h2>"+nombre+"<h2><br> ";
		mensajes = mensajes +"<h3>Bienvenido al curso virtual Primer Respondiente ¡Gente que Ayuda!<h3>";
		mensajes = mensajes +"<h3>Recuerde sus datos de ingreso son:</h3><br> ";
		mensajes = mensajes + "<h2><b>USUARIO: "+usuario+"</b></h2>";
		mensajes = mensajes + "<h2><b>CONTRASE�A: "+pass+"</b></h2><br><br><br>";
		mensajes = mensajes + "<p style='font-size:12px;'>Le recordamos que esta dirección de e-mail es utilizada solamente para envíos de información. Por favor <b>no responda</b> con consultas ya que no podrán ser atendidas.<p><br><br>";
		mensajes = mensajes + "Instituto Distrital de Gestión de Riesgos y Cambio Climatico<br>";
	    mensajes = mensajes + "Diag 47 No 77B- 09 Int.. 11<br>";
	    mensajes = mensajes + "Tel (571)4 29 28 00<br>";
	    mensajes = mensajes + "Bogota-Colombia<br>";
	    mensajes = mensajes + "www.idiger.gov.co<br>";
	    mensajes = mensajes + "www.sire.gov.co<br>";
	    
		// La dirección de envío (to)
	    String emailSitio = correo;	    
	    // La dirección de la cuenta de envío (from)
	    String de = mailAplicativo;

	    // El servidor (host). En este caso usamos localhost
	    String host = "172.16.24.197";

	    // Obtenemos las propiedades del sistema
	    Properties propiedades = System.getProperties();

	    // Configuramos el servidor de correo
	    propiedades.setProperty("mail.smtp.host", host);

	    // Obtenemos la sesión por defecto
	    Session sesion = Session.getDefaultInstance(propiedades);
	    
	    try{
	    	java.sql.Date fecha = null;
	      // Creamos un objeto mensaje tipo MimeMessage por defecto.
	      MimeMessage mensaje = new MimeMessage(sesion);

	      // Asignamos el de o from al header del correo.
	      mensaje.setFrom(new InternetAddress(de));

	      // Asignamos el para o to al header del correo.
	      mensaje.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailSitio));
	      //mensaje.addRecipients(Message.RecipientType.CC, InternetAddress.parse(correoSTV));
	      //mensaje.addRecipients(Message.RecipientType.CC, InternetAddress.parse(emailEvaluador));

	      // Asignamos el asunto
	      mensaje.setSubject("Bienvenido al curso virtual Primer Respondiente !Gente que Ayuda!");
	      fecha = new java.sql.Date(System.currentTimeMillis());		     
	      // Asignamos el contenido HTML, tan grande como nosotros queramos
	      
	      mensaje.setContent(mensajes,"text/html; charset=utf-8" );

	      // Enviamos el correo
	      Transport.send(mensaje);
	      System.out.println("Mensaje enviado");
	    } catch (MessagingException e) {
	      e.printStackTrace();
	    }
	    System.out.println("Fin metodo enviarCorreo");
	}	
	
	
	public static void EnviarMail(Exception e2){
		
		System.out.println("metodo enviarCorreo");
		String mensajes = "";
		
		
		mensajes = mensajes +"<h3>Error de conexión a la base de datos <h3>";
		mensajes = mensajes + e2 +"<br>"; 
		mensajes = mensajes + "<p style='font-size:12px;'>Le recordamos que esta direcci�n de e-mail es utilizada solamente para envíos de informaci�n. Por favor <b>no responda</b> con consultas ya que no podrán ser atendidas.<p><br><br>";
		mensajes = mensajes + "Instituto Distrital de Gestión de Riesgos y Cambio Climatico<br>";
	    mensajes = mensajes + "Diag 47 No 77B- 09 Int.. 11<br>";
	    mensajes = mensajes + "Tel (571)4 29 28 00<br>";
	    mensajes = mensajes + "Bogota-Colombia<br>";
	    mensajes = mensajes + "www.idiger.gov.co<br>";
	    mensajes = mensajes + "www.sire.gov.co<br>";
	    
		// La dirección de envío (to)
	    String emailSitio = "moortiz@idiger.gov.co";	    
	    // La dirección de la cuenta de envío (from)
	    String de = "moortiz@idiger.gov.co";

	    // El servidor (host). En este caso usamos localhost
	    String host = "172.16.24.197";

	    // Obtenemos las propiedades del sistema
	    Properties propiedades = System.getProperties();

	    // Configuramos el servidor de correo
	    propiedades.setProperty("mail.smtp.host", host);

	    // Obtenemos la sesión por defecto
	    Session sesion = Session.getDefaultInstance(propiedades);
	    
	    try{
	    	java.sql.Date fecha = null;
	      // Creamos un objeto mensaje tipo MimeMessage por defecto.
	      MimeMessage mensaje = new MimeMessage(sesion);

	      // Asignamos el de o from� al header del correo.
	      mensaje.setFrom(new InternetAddress(de));

	      // Asignamos el para o to al header del correo.
	      mensaje.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailSitio));
	      //mensaje.addRecipients(Message.RecipientType.CC, InternetAddress.parse(correoSTV));
	      //mensaje.addRecipients(Message.RecipientType.CC, InternetAddress.parse(emailEvaluador));

	      // Asignamos el asunto
	      mensaje.setSubject("Error de conexión a la base de datos Primer Respondiente");
	      fecha = new java.sql.Date(System.currentTimeMillis());		     
	      // Asignamos el contenido HTML, tan grande como nosotros queramos
	      
	      mensajes = mensajes + "<br> fecha envío "+fecha;
	      
	      mensaje.setContent(mensajes,"text/html; charset=utf-8" );

	      // Enviamos el correo
	      Transport.send(mensaje);
	      System.out.println("Mensaje enviado");
	    } catch (MessagingException e) {
	      e.printStackTrace();
	    }
	    System.out.println("Fin metodo enviarCorreo");
	}	
	
	
	public static void EnviarMail(String numero){
		
		System.out.println("metodo enviarCorreo");
		String mensajes = "Cantidad de Aprobados: "+numero;
		
		
	    
		// La dirección de envío (to)
	    String emailSitio = "moortiz@idiger.gov.co";	    
	    // La direcci�n de la cuenta de env�o (from)
	    String de = "moortiz@idiger.gov.co";

	    // El servidor (host). En este caso usamos localhost
	    String host = "172.16.24.197";

	    // Obtenemos las propiedades del sistema
	    Properties propiedades = System.getProperties();

	    // Configuramos el servidor de correo
	    propiedades.setProperty("mail.smtp.host", host);

	    // Obtenemos la sesión por defecto
	    Session sesion = Session.getDefaultInstance(propiedades);
	    
	    try{
	    	java.sql.Date fecha = null;
	      // Creamos un objeto mensaje tipo MimeMessage por defecto.
	      MimeMessage mensaje = new MimeMessage(sesion);

	      // Asignamos el de o from al header del correo.
	      mensaje.setFrom(new InternetAddress(de));

	      // Asignamos el para o to al header del correo.
	      mensaje.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailSitio));
	      //mensaje.addRecipients(Message.RecipientType.CC, InternetAddress.parse(correoSTV));
	      //mensaje.addRecipients(Message.RecipientType.CC, InternetAddress.parse(emailEvaluador));

	      // Asignamos el asunto
	      mensaje.setSubject("Cantidad de Aprobados Primer Respondiente !Gente que Ayuda!");
	      fecha = new java.sql.Date(System.currentTimeMillis());		     
	      // Asignamos el contenido HTML, tan grande como nosotros queramos
	      mensajes += "<br>Fecha: "+fecha;
	      mensaje.setContent(mensajes,"text/html; charset=utf-8" );

	      // Enviamos el correo
	      Transport.send(mensaje);
	      System.out.println("Mensaje enviado");
	    } catch (MessagingException e) {
	      e.printStackTrace();
	    }
	    System.out.println("Fin metodo enviarCorreo");
	}
}
