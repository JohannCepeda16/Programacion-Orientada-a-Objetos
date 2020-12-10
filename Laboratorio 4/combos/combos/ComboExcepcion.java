/**
 * Clase de excepciones para los combos y productos
 * 
 * @autor Maria Jose
 * @author Johann Cepeda
 */
public class ComboExcepcion extends Exception{
    
    public final static String PRODUCTO_DESCONOCIDO = "PRODUCTO DESCONOCIDO";
    public final static String PRECIO_DESCONOCIDO = "PRECIO DESCONOCIDO";
    public final static String COMBO_VACIO = "COMBO VACIO";    
    public final static String COSTO_POR_OMISION = "COSTO POR OMISION";
    
    public ComboExcepcion(String msg){
        super(msg);
    }
}
