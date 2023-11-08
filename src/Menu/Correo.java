/*
Proposito:
Clase en la cual se enviara un correo al docente
Autores:
Angie Natalia Cobo Vasquez
Juan Diego Rodriguez Ortiz
Sebastian Henao Gamboa
Santiago Ospina Gonzalez

Version:
2.0
Fecha ultima actualizacion:
08/11/2023
Version JDK:
 */
package Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class Correo {

    String nombre;
    String correo;
    String codigo;
    int respuestasCorrectas;

    public void leerDatos() {
        // Variables para almacenar los datos

        try {
            // Leer los datos de "Datos.csv" para obtener el nombre, código y correo de la última persona
            BufferedReader datos = new BufferedReader(new FileReader("Datos.csv"));//se lee el archivo datos.csv
            String linea;
            while ((linea = datos.readLine()) != null) {
                String[] campos = linea.split(";");
                if (campos.length >= 4) {
                    nombre = campos[0]; //se guarda el ultimo registro guardadado de nombre, codigo y correo
                    codigo = campos[1];
                    correo = campos[2];
                }
            }
            datos.close(); //se cierra el archivo

            // Leer los datos de "Puntajes.csv" para obtener la cantidad de respuestas correctas de la última persona
            BufferedReader puntajes = new BufferedReader(new FileReader("Puntajes.csv"));
            String ultimaLinea = null;
            while ((linea = puntajes.readLine()) != null) {
                ultimaLinea = linea;
            }
            puntajes.close();

            if (ultimaLinea != null) {
                String[] puntajesCampos = ultimaLinea.split(";");
                if (puntajesCampos.length >= 2) {
                    respuestasCorrectas = Integer.parseInt(puntajesCampos[0]); //se convierte la variable de correctas de un entero a string
                }
            }

            // Almacenar los datos en un arreglo o estructura de datos
            // Ahora puedes usar estos datos como necesites
            // Mostrar los datos para verificar
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviar(String parametros[]) {
        try {
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress(parametros[1], // correoRemitente
                    parametros[0]));    // remitente
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(parametros[3])); // correoDestinatario

            mm.setSubject(parametros[4]); // asunto

            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[5], // texto del mensage
                    "text/html");   // tipo de codificacion del mensage

            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mime_mensage); // adicionar el texto  

            mm.setContent(mp); // adicionar la informacion del objeto Multipart al mensaje

            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(parametros[1], // correoRemitente
                    parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();

        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public void enviar(String parametros[], String correosDestinatarios[]) {
        try {
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress(parametros[1], // correoRemitente
                    parametros[0]));    // remitente

            InternetAddress toList[] = new InternetAddress[correosDestinatarios.length];
            for (int i = 0; i < correosDestinatarios.length; i++) { // recorrer el arreglo correosDestinatarios
                toList[i] = new InternetAddress(correosDestinatarios[i]);
            }
            mm.addRecipients(Message.RecipientType.TO, toList); // adicionar la lista de correosDestinatarios

            mm.setSubject(parametros[3]); // asunto

            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[4], // texto del mensage
                    "text/html");   // tipo de codificacion del mensage

            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mime_mensage); // adicionar el texto  

            mm.setContent(mp); // adicionar la informacion del objeto Multipart al mensaje

            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(parametros[1], // correoRemitente
                    parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();

        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public void enviar(String[] parametros, String[] correosDestinatarios, String[] archivos) {

        /*String nombre = datos[0];
        String codigo = datos[1];
        String correo = datos[2];
        int respuestasCorrectas = Integer.parseInt(datos[3]);*/
        try {
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress(parametros[1], // correoRemitente
                    parametros[0]));    // remitente

            InternetAddress toList[] = new InternetAddress[correosDestinatarios.length];
            for (int i = 0; i < correosDestinatarios.length; i++) { // recorrer el arreglo correosDestinatarios
                toList[i] = new InternetAddress(correosDestinatarios[i]);
            }
            mm.addRecipients(Message.RecipientType.TO, toList); // adicionar la lista de correosDestinatarios

            mm.setSubject(parametros[3]); // asunto

            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[4], // texto del mensage
                    "text/html");   // tipo de codificacion del mensage

            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mime_mensage); // adicionar el texto  

            for (String nf : archivos) {
                MimeBodyPart attach = new MimeBodyPart();
                attach.attachFile(nf);
                mp.addBodyPart(attach); // adicionar el archivo 
            }

            mm.setContent(mp);// adicionar la informacion del objeto Multipart al mensaje

            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(parametros[1], // correoRemitente
                    parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();

        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public void test3() { // enviar correo a varios destinatarios con archivos adjuntos
        /*LeerDatos l = new LeerDatos();
         l.main(null);*/

        leerDatos();
        String parametros[] = {"SEBASTIAN HENAO", // remitente
            "henaogamboasebastian@gmail.com", // correoRemitente
            "noub cwpd rlev nfpr", // contrasena de aplicaciones de Gmail
            "Encuesta-humanidades y Analisis de la matriz de Vester-Seminario universidad y region", // asunto
            "Buenas tardes<br>Se realiza el envio de la encuesta en el area de humanidades, adicional se agrega informacion para el area de seminario universidad y region pertinente a cada uno de los temas vistos en clase<br><br>El estudiante: " + nombre + " con codigo: " + codigo + " y correo: " + correo + " obtuvo: " + respuestasCorrectas + " respuestas correctas en la encuesta realizada" // mensaje
    };

        String correosDestinatarios[] = {"sebastian.henao03@uceva.edu.co"};

        String archivos[] = {"MATRIZ VESTER .xlsx", "ANÁLISIS DE LA MATRIZ DE VESTER .docx"};

        enviar(parametros, correosDestinatarios, archivos);

        StringBuilder confirmacion = new StringBuilder("Correo enviado con exito a: ");
        for (String destinatario : correosDestinatarios) {
            confirmacion.append(destinatario).append("\n");
        }

        JOptionPane.showMessageDialog(null, confirmacion.toString(), "CONFIRMACION", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        Correo obj = new Correo();
        obj.test3(); // enviar correo a varios destinatarios con archivos adjuntos
    }
}
