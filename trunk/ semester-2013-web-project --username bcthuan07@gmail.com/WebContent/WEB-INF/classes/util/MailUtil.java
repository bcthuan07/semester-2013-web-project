/**
 * 
 */
package util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Thuan
 * 
 */
public class MailUtil {

	/**
	 * 
	 * @param username
	 *            : tài khoản gmail người gửi
	 * @param userInfo
	 *            : tên người gửi
	 * @param pass
	 *            :
	 * @param dest
	 *            : tài khoản người nhận
	 * @param destInfo
	 *            : tên người nhận
	 * @param subject
	 *            : tiêu đề email
	 * @param msgBody
	 *            : nội dung
	 */
	public static void send(final String username, String userInfo, final String pass,
			String dest, String destInfo, String subject, String msgBody) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, pass);
					}
				});

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username, userInfo, "utf8"));

			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					dest, destInfo, "utf8"));

			msg.setHeader("Content-Type", "text/plain; charset=UTF-8;");
			msg.setSubject(subject, "UTF-8");
			msg.setText(msgBody, "utf8");

			// msg.writeTo(new FileOutputStream("d:\\msg.txt"));
			Transport.send(msg);

		} catch (AddressException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (UnsupportedEncodingException e2) {
//			e2.printStackTrace();
			System.out.println(e2.getMessage());
		} catch (MessagingException e3) {
//			e3.printStackTrace();
			System.out.println(e3.getMessage());
		}

	}
}
