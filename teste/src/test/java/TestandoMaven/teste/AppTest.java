package TestandoMaven.teste;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void testeEmail() {
		Properties props = new Properties();
        /** Parâmetros de conexão com servidor Hotmail */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication()
                         {
                               return new PasswordAuthentication("raphapaixjdev@outlook.com", "3h2e9l6i");
                         }
                    });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("raphapaixjdev@outlook.com")); //Remetente

              message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse("raphapaixjdev@gmail.com, raphapaixjdev@outlook.com")); //Destinatário(s)
              message.setSubject("Enviando email com JavaMail");//Assunto
              message.setText("Enviei este email utilizando JavaMail com minha conta Hotmail!");
              /**Método para enviar a mensagem criada*/
              Transport.send(message);

              System.out.println("Feito!!!");

         } catch (MessagingException e) {
              throw new RuntimeException(e);
        }

	}
}
