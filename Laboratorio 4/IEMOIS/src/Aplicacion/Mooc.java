
package Aplicacion;  
 
/**
 * Clase que describe un curso
 */
public class Mooc{
    private String nombre;
    private String area;   
    private String objetivo;
    private String distribuidor;
    private int semanas;  

 
    /**
     * Constructor de la clase
     * @param nombre
     * @param area
     * @param objetivo
     * @param distribuidor
     * @param semanas
     */
    public Mooc(String nombre, String area,  String objetivo, String  distribuidor, int semanas){
        this.nombre = nombre.trim();
        this.area = area.trim();
        this.objetivo = objetivo.trim();
        this.distribuidor = distribuidor.trim();
        this.semanas = semanas;        
    }
    
    /**
     * @return nombre
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * @return area
     */
    public String getArea(){
        return area;
    }

    /**
     * @return objetivo
     */
    public String getObjetivo(){
        return objetivo;
    }
    
    /**
     * @return distribuidor
     */
    public String getDistribuidor(){
        return distribuidor;
    }    
    
    /**
     * @return semanas
     */
    public int getSemanas(){
        return semanas;
    }
    


    /**
     * @return 
     */
    public String toString(){
        return nombre + "\n" + area + "\n"+ distribuidor + "\nSemanas:" + semanas+"\n" +objetivo ;
    }

}
