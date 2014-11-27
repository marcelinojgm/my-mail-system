/**
 * Representa un correo electronico.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    //Emisor del mensaje
    private String from;
    
    //Destinatario del mensaje
    private String to;
    
    //Texto del mensaje
    private String message;
    
    //asunto del mensaje
    private String subject;
   
    /**
     * Constructor que fija por parametros origen, destino y mensaje
     */
    public MailItem(String from, String to, String subject, String message)
    {
        this.from    = from;
        this.to      = to;
        this.subject = subject;
        this.message = message;
    }
    
    /**
     * Devuelve valor de emisor
     */
    public String getFrom()
    {
        return from;
    }
    
    /**
     * Devuelve valor de destinatario
     */
    public String getTo()
    {
        return to;
    }
    
    
    /**
     * devuelve asunto
     */
    public String getSubject()
    {
        return subject;
    }
    /**
     * Devuelve el mensaje
     */
    public String getMassage()
    {
        return message;
    }
    /**
     * Realiza la impresion del mensage
     */
    public void print()
    {
        System.out.println("From: "     + from);
        System.out.println("To: "       + to);
        System.out.println("subject: "  + subject);
        System.out.println(message);
    }
}