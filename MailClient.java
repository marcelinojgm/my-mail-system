
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    
    //servidor asociado con ese cliente
    private MailServer server;
    //representa la dirección de correo del usuario que usa ese cliente
    private String user;

    /**
     * inicializa indicando el servidor y el usuario por parametros
     */
    public MailClient(String newUser, MailServer nameServer)
    {
        server = nameServer;
        user   = newUser;
    }

    /**
     * devuelve el siguiente mensaje
     */
    public MailItem getNextMailItem()
    {
          return server.getNextMailItem(user);
    }
    
    /**
     * recupera del servidor el siguiente correo  
     * imprime por pantalla los datos de dicho mensaje.
     * si no hay imprime mensaje de error
     */
    public void printNextMailItem()
    {
        MailItem mail = server.getNextMailItem(user);
        if (mail == null)
        {
            System.out.println("Error: no tiene mensajes nuevos");
          
        }
        else
        {      
            mail.print();
        }
    }
    
    /**
     * crea un mail y lo manda al servidor correspondiente
     */
    public void sendMailItem(String newTo, String newMessage)
    {
        MailItem newMail;
        newMail = new MailItem(user, newTo, newMessage);
        server.post(newMail);
    }
}
