
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    
    //Servidor asociado con ese cliente
    private MailServer server;
    
    //Direción de correo del usuario
    private String user;

    /**
     * Inicializa indicando el servidor y el usuario por parametros
     */
    public MailClient(String newUser, MailServer nameServer)
    {
        server = nameServer;
        user   = newUser;
    }

    /**
     * Devuelve el siguiente mensaje
     */
    public MailItem getNextMailItem()
    {
          return server.getNextMailItem(user);
    }
    
    /**
     * Recupera del servidor el siguiente correo,  
     * imprime por pantalla los datos de dicho mensaje,
     * si no hay, imprime mensaje de error
     */
    public void printNextMailItem()
    {
        //Primer correo en cola
        MailItem mail = server.getNextMailItem(user);
        
        //No hay correo
        if (mail == null)   
        {
            System.out.println("Error: no hay mas mensajes");
          
        }
        //Hay correo
        else                
        {      
            mail.print();
        }
    }
    
    /**
     * Crea un mail y lo manda al servidor correspondiente
     * pasado por parametros destinatario y mensaje del correo
     */
    public void sendMailItem(String newTo, String newMessage)
    {
        //Nuevo correo
        MailItem newMail;
        newMail = new MailItem(user, newTo, newMessage);
        
        //Mandado del correo creado al servidor
        server.post(newMail);
    }
}
