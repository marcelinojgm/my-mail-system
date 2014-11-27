import java.util.Scanner;
/**
 * Representa un cliente/usuario de correo de un server
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
    
    //activa/desactiva autocontestar
    private boolean onOffAutoReply;
    private String textAutoReply;
    
    /**
     * Inicializa indicando el servidor y el usuario por parametros
     */
    public MailClient(String user, MailServer server)
    {
        //configuracion cuenta nombre de usuario y servidor al que pertenece
        this.server = server;
        this.user   = user;
        
        //autorespuesta desactivada por defecto
        this.onOffAutoReply = false;
        this.textAutoReply  = "";
    }

    /**
     * Devuelve el siguiente mensaje
     */
    public MailItem getNextMailItem()
    {
          return server.getNextMailItem(user);
    }
         
     /**
      * cambia la opcion de realizar mandar o un correo de respuesta automatica
      */
    public void setOnOffAutoReply()
    {
        if(onOffAutoReply)
        {
          //desactivacion autorespuesta
          onOffAutoReply = false;
          System.out.println("The autoresponder to been disabled");
        }
        else
        {
           //activacion de autorespuesta
           onOffAutoReply  = true;
           System.out.println("The autoresponder to been activated");
           
           //si el mensaje de respuesta esta vacio pide un testo apara mandar
           if(textAutoReply == "")
           {
              setTextAutoReply();
           }
        }
    } 
    
    /**
     * selecciona el contenido del mensaje de respuesta automatica
     */
    public void setTextAutoReply()
    {
        //texto de la autorespuesta
        String text; 
        
        //peticion de inserccion de texto para el mensaje de autorespuesta
        System.out.println("Insert text for auto reply:");
        
        // Creacion de un objeto Scanner para pedir texto por teclado
        Scanner textScan = new Scanner (System.in); 
        text = textScan.nextLine(); 
        this.textAutoReply = text;
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
    public void sendMailItem(String to, String subject, String message)
    {
        //Nuevo correo
        MailItem newMail;
        newMail = new MailItem(user, to, subject, message);
        
        //Mandado del correo creado al servidor
        server.post(newMail);
    }
    
    /**
     * retorna con el numero de correos que hay almacenados en el servidor del cliente
     */
    
    public int howManyMailItems()
    {
        return server.howManyMailItems(user);
    }
    
    /**
     * responde automaticamente a un mensaje 
     */
    private void sendMailAutorespond(MailItem mail)
    {
        //mail respuesta
        MailItem mailReply;
            
        //destinatario
        String from = mail.getFrom();
        String message = mail.getMassage();
        String subject = mail.getSubject();
       
        //creacion del mensaje de respuesta y envio al emisor del mesaje recibido
        mailReply = new MailItem(user, from , "Auto reply", this.textAutoReply  + "\n" + //texto del mensaje automatico
                                                            "RE: "              + "\n" +             
                                                            "From: "  + from    + "\n" + //persona a la que contesta automaticamente
                                                            "Subject: " + subject + "\n" + //asunto del mensaje al que se contesta
                                                            message);                    //texto del mensaje al que se contesta   
        server.post(mailReply);
    }
    
    /*
     * obtiene el siguiente mensaje del servidor 
     * y envia automaticamente un mensaje de respuesta 
     * si esta activada esta opcion si no solo recibe el mail
     */
    public MailItem getNextMailItemAndAutorespond()
    {
        //mensaje recivido
        MailItem mail = server.getNextMailItem(user);
        
        //si hay mensaje
        if(mail != null)
        {
            //si la opcion respuesta automatica esta activada
            if(onOffAutoReply)
            {
                //contesta automaticamente
                sendMailAutorespond(mail);
            }
            //la opcion de respuesta automatica no esta activada
            else
            {
                //informa que la opcion esta desactivada y la activa
                System.out.println("The auto reply is disabled");
                System.out.println("The auto reply option is automatically activated");
                setOnOffAutoReply();
                
                //contesta automaticamente
                sendMailAutorespond(mail);
            }
        }
        //si no hay mensajes
        else
        {
          System.out.println("error: no se han encontrado nuevos mensajes");
        }
        
        return mail;
    }
    
}

