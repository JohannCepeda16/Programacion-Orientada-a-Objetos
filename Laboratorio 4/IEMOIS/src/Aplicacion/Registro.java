package Aplicacion;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 * Clase que permite llevar el registro de las excepciones en un arhivo
 */
public class Registro{
    public static String nombre="mooc";
    
    /**
     * Metodo que registra una excepcion en el archivo de texto
     * @param exception e
     */
    public static void registre(Exception e){
        try{
            Logger logger=Logger.getLogger(nombre);
            logger.setUseParentHandlers(false);
            FileHandler file=new FileHandler(nombre+".log",true);
            file.setFormatter(new SimpleFormatter());
            logger.addHandler(file);
            logger.log(Level.SEVERE,e.toString(),e);
            showMessage("Se ha presentado un error:" + e.getMessage());
            file.close();
        }catch (Exception oe){
            oe.printStackTrace();
        }
    }
    
    /**
     * Metodo que permite la comunicacion con el usuario al presentarse un error
     */
    public static void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
}
    
