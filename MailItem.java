
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    //de quien viene el mensaje
    private String from;
    //para quien va dirigido el mensaje
    private String to;
    //texto del mensaje
    private String message;
    /**
     * constructor que fija por parametros origen destino y mensaje
     */
    public MailItem(String newFrom, String newTo, String newMessage)
    {
        from    = newFrom;
        to      = newTo;
        message = newMessage;
    }
    
    /**
     * devuelve valor de from
     */
    public String getFrom()
    {
        return from;
    }
    /**
     * devuelve valor de to
     */
    public String getTo()
    {
        return to;
    }
    
    /**
     * devuelve valor de to
     */
    public String getMassage()
    {
        return message;
    }
    
    /**
     * realiza la impresion del mensage
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: "   + to);
        System.out.println(message);
    }
}
