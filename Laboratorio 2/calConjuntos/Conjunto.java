import java.util.*;
import javax.swing.JOptionPane;
/**
 * @author ECI, 2018
 *
 */
public class Conjunto{
    
    private ArrayList<String> elementos;
    
    /**
     * Constructor del conjunto
     */
  
    public Conjunto () {
        this.elementos = new ArrayList();
    }

     /**
     * Constructor del conjunto
     * @param elementos
     */
    public Conjunto(String [] elementos){
        this.elementos = new ArrayList<String>();
        for(String i: elementos){
            i = i.replaceAll("\\s{2,}", " ").trim();
            if(!this.elementos.contains(i.toLowerCase())){
                this.elementos.add(i.toLowerCase());
            }
        }
    }
    
    /**
     * Calcula el cardinal del conjunto
     * @return cardinal
     */    
    public int cardinal() {
       return this.getElementos().size();
    }

    /**
     * Verifica si un elemento pertenece al conjunto
     * @param elemento, el elemento a verificar
     * @return pertenece
     */      
    public boolean pertenece(String elemento){
       boolean res = this.getElementos().contains(elemento.toLowerCase().replaceAll("\\s{2,}", " ").trim());
       return res;
    }
    
    /**
     * Compara este conjunto con otro
     * @param c el conjunto a comparar
     * @return igualdad de conjuntos
     */
    private boolean equals (Conjunto c) {
        return this.equals(c);
    }

    /** 
     * Compara si este conjunto es igual a otro (el parametro debe ser un conjunto)
     */
    @Override
    public boolean equals (Object o) {
            return this.equals ((Conjunto) o);
    }
    
    
    /**
     * Conjunto contenido
     * @param conjunto c
     * @return contenido
     */
    public boolean contenido(Conjunto c){
        return false;
    }
    
    /**
     * Une dos conjuntos
     * @param c Conjunto a unir
     * @return Conjunto resultante
     */
    public Conjunto union(Conjunto c){
        for(String i: c.getElementos()){
            if(!this.elementos.contains(i))
                this.elementos.add(i);
        }
        
        return this;
    }
    
    /**
     * Hace interseccion entre dos conjuntos
     * @param Conjunto c
     * @return Conjunto resultante
     */
    public Conjunto interseccion(Conjunto c){
        ArrayList<String> temp = (ArrayList)c.getElementos().clone();
        for(String i: temp){
            if(!this.getElementos().contains(i)){
                c.getElementos().remove(i);
            }
        }
        
        ArrayList<String> temp2 = (ArrayList)this.getElementos().clone();
        for(String i: temp2){
            if(!c.getElementos().contains(i)){
                this.getElementos().remove(i);
            }
        }
        
        return(union(c));
    }
    
    /**
     * Calcula la diferencia entre dos conjuntos
     * @param Conjunto c
     * @return Conjunto resultante
     */
    public Conjunto diferencia(Conjunto c){
        ArrayList<String> temp = (ArrayList)this.getElementos().clone();
        for(String i: temp){
            if(c.getElementos().contains(i)){
                this.getElementos().remove(i);
            }
        }
        
        return this;
    }
    
    /**
     * Diferencia simetrica entre conjuntos
     * @param Conjunto c
     * @return Conjunto resultante
     */
    public Conjunto diferenciaSimetrica(Conjunto c){
       ArrayList removed = new ArrayList<String>();
       ArrayList<String> copy = (ArrayList)this.getElementos().clone();
       for(String i: copy){
            if(c.getElementos().contains(i)){
                this.elementos.remove(i);
                removed.add(i);
            }
       }
       
       for(String i: c.getElementos()){
           if(!this.elementos.contains(i) && !removed.contains(i)){
               this.elementos.add(i);
           }
       }
       
       return this;
    }    
    
    /**
     * Calcula el producto entre dos conjuntos
     * @param Conjunto c
     * @return Conjunto resultante
     */
    public Conjunto producto(Conjunto c){
        String[] elemRes = new String[this.getElementos().size() * c.getElementos().size()];
        int cont = 0;
        for(int i = 0; i<this.elementos.size(); i++){
            for(int j = 0; j<c.getElementos().size(); j++){
                elemRes[cont] = ("(" + this.elementos.get(i) + "," + c.getElementos().get(j) + ")");
                cont+=1;
            }
        }
        return new Conjunto(elemRes);  
    }            
        
    /** 
     * Retorna una cadena que describe este conjunto con los elementos en mayusculas, entre corchetes, ordenados alfabeticamente y separados por coma
     */
    @Override
    public String toString () {
          Collections.sort(this.elementos);
          String s = "{";
          for(int i = 0; i<this.elementos.size(); i++){
              s += this.elementos.get(i).toUpperCase();
              s += i<this.elementos.size() -1 ? ", " : ""; 
          }
          s +="}";
          return s;
    }
    
    /**
     * Devuelve los elementos del conjunto
     * @return Elementos
     */
    public ArrayList<String> getElementos(){
        return this.elementos;
    }
    
}
