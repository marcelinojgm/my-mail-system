/**
 * Write a description of class MailItem here.
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
   
    /**
     * Constructor que fija por parametros origen, destino y mensaje
     */
    public MailItem(String newFrom, String newTo, String newMessage)
    {
        from    = newFrom;
        to      = newTo;
        message = newMessage;
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
        System.out.println("From: " + from);
        System.out.println("To: "   + to);
        System.out.println(message);
    }
}