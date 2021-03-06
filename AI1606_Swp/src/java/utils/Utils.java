package utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Utils {

    public static final String SUBJECT = "Request to change password";
    public static final String EMAIL = "namnt@gmail.com";
    public static final String PASSWORD = "ThanhNam123";
    public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final StringBuffer CHARACTERS = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");



    public int getDistanceTime(Date timeBegin, Date timeEnd) {
        if (timeEnd == null) {
            timeEnd = new Date();
        }
        long diffInMillies = Math.abs(timeEnd.getTime() - timeBegin.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return (int) diff;
    }
    public static void main(String[] args) {
        Utils u = new Utils();
    }
    public static String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void send(String to, String sub,
            String msg, final String user, final String pass) {
        //create an instance of Properties Class   
        Properties props = new Properties();

        /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host. 
           As shown here in the code. 
           Change accordingly, if your email id is not a gmail id
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {

            /* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html");

            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String sendMessage(String username, String password) {
        String message = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <body>\n"
                + "        <div>\n"
                + "            Hello, " + username + "\n"
                + "            <br>\n"
                + "            <br>\n"
                + "            <i>** This is an automated message -- please do not reply as you will not receive a response. **</i>\n"
                + "            <br>\n"
                + "            This message is in response to your request to reset your account password. Please click the link below and follow the instructions to change your password.\n"
                + "            <br>\n"
                + "            <br>\n"
                + "            Your password is: <i style=\"font-style: italic; color: red;\">" + password + "</i>\n"
                + "            <br>\n"
                + "            <br>\n"
                + "            Thank you.\n"
                + "            <br>\n"
                + "            IMS Team.\n"
                + "\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>";
        return message;
    }

}
