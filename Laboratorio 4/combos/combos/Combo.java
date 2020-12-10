import java.util.ArrayList;

public class Combo{
    public final static int COSTO_POR_OMISION=10000;
    
    private String nombre;
    private int descuento;
    private ArrayList<Producto> productos;
    
    public Combo(String nombre, int descuento){
        this.nombre=nombre;
        this.descuento=descuento;
        productos= new ArrayList<Producto>();
    }

    public void adProducto(Producto p){
        productos.add(p);
    }
    
    /**
     * Calcula el precio de un combo
     * @return el precio del combo
     * @throws ComboExcepcion COMBO_VACIO, si no tiene productos; PRODUCTO_DESCONOCIDO, si hay un producto sin nombre; 
     * y PRECIO_DESCONOCIDO si un producto tiene error en el precio 
     */
    public int precio() throws ComboExcepcion{
        int precio = 0;
        if(productos.size() <= 0) throw new ComboExcepcion(ComboExcepcion.COMBO_VACIO);
        
        for(Producto p: productos){
            precio += p.precio();
        }
        
        return precio - calcularDesc(precio);
    }
    
    /**
     * Calcula el precio por omision
     * Para los productos con problemas se asume COSTO_POR_OMISION
     * @return el costo de un combo
     * @throws ComboExcepcion COMBO_VACIO, si no tiene productos
     */
    public int precioOmision() throws ComboExcepcion{
        if(productos.size() <= 0) throw new ComboExcepcion(ComboExcepcion.COMBO_VACIO);
        
        int precio = 0;
        for(Producto p: productos){
                try{
                    precio += p.precio();
                }catch(ComboExcepcion e){
                    precio += COSTO_POR_OMISION;
                }
            }
        
        return precio - calcularDesc(precio);
    }   
    
    /**
     * Calcula el precio asumido
     * Se asume que el precio de los productos desconocidos es el del primer producto conocido
     * Se asume que el precio de los productos sin precio es el del ultimo producto 
     * Si el combo esta vacio el precio asumido es cero
     * @return el precio asumido de un prodcto
     */
    public int precioAsumido() throws ComboExcepcion{
        int pConocido = 0;
        int uConocido = 0;
        int precio = 0;
        if(productos.size()>0){
            for(Producto p: productos){
                try{
                    precio += p.precio();
                    pConocido = pConocido != 0 ? precio : 0;
                    uConocido = precio;
                }catch(ComboExcepcion e){
                    if(e.getMessage() == ComboExcepcion.PRODUCTO_DESCONOCIDO){
                        precio += pConocido;
                    }
                    else if(e.getMessage() == ComboExcepcion.PRECIO_DESCONOCIDO){
                        precio += uConocido;
                    }
                }
            }
        }
        return precio - calcularDesc(precio);
    }
    
    private int calcularDesc(int precio){
        return (precio * descuento)/100;
    }
}
