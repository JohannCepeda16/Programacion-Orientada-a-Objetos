import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ComboTest{
   
    
    public ComboTest(){
    }


    @Before
    public void setUp(){
        
    }

    @After
    public void tearDown(){
    }
    
    @Test
    public void deberiaCalcularElCostoDeUnCombo(){
        Combo c = new Combo("Rapido", 10);
        c.adProducto(new Producto("Coca Cola", 1000));
        c.adProducto(new Producto("Hamburguesa",8000));
        c.adProducto(new Producto("Papas", 1000));
        try {
           assertEquals(9000,c.precio());
        } catch (ComboExcepcion e){
            fail("Lanzó excepcion");
        }    
    }    
    
    @Test
    public void deberiaLanzarExcepcionSiElComboNoTieneProductos(){
        Combo c = new Combo("Rapido", 10);
        try { 
           int precio=c.precio();
           fail("No lanzó excepcion");
        } catch (ComboExcepcion e) {
            assertEquals(ComboExcepcion.COMBO_VACIO,e.getMessage());
        }    
    }    
    
    
   @Test
    public void deberiaLanzarExcepcionSiNoSeConoceElPrecioDeUnProducto(){
        Combo c = new Combo("Rapido", 10);
        c.adProducto(new Producto("Coca Cola", 1000));
        c.adProducto(new Producto("Hamburguesa",8000));
        c.adProducto(new Producto("Papas", -1000));
        try { 
           int precio=c.precio();
           fail("No lanza la excepcion");
        } catch (ComboExcepcion e) {
            assertEquals(ComboExcepcion.PRECIO_DESCONOCIDO,e.getMessage());
        }    
    }     
    
   @Test
    public void deberiaLanzarExcepcionSiNoSeConoceUnProducto(){
        Combo c = new Combo("Rapido", 10);
        c.adProducto(new Producto("Coca Cola", 1000));
        c.adProducto(new Producto(null,8000));
        c.adProducto(new Producto("Papas", -1000));
        try { 
           int precio=c.precio();
           fail("No lanza la excepcion");
        } catch (ComboExcepcion e) {
            assertEquals(ComboExcepcion.PRODUCTO_DESCONOCIDO,e.getMessage());
        }    
    }  
    
   @Test
   public void deberiaDarElCostoPorOmisionDeUnCombo(){
        Combo c = new Combo("Rapido", 0);
        c.adProducto(new Producto("Coca Cola", 1000));
        c.adProducto(new Producto(null,8000));
        c.adProducto(new Producto("Papas", -1000));
        try{
            int precio=c.precioOmision();            
            assertEquals(21000, precio);
        }catch(ComboExcepcion e){
            assertEquals(ComboExcepcion.PRODUCTO_DESCONOCIDO,e.getMessage());
        }
   } 
}
