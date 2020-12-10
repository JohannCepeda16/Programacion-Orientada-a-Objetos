import java.util.Stack;
import javax.swing.JOptionPane;

/** Calculadora.java
 * Representa una calculadora de conjuntos
 * @author ESCUELA 2020-2
 */
    
public class CalConjuntos{

    private Stack<Conjunto> operandos;
    private boolean ok = false;
    private boolean test = false;
   
    /**
     * Constructor de la clase
     */
    public CalConjuntos(){
        operandos = new Stack<Conjunto>();
        test = true;
    }
    
    /**
     * Adicionar un conjunto a la pila
     * @param dConjunto Conjunto a adicionar
     */
    public void adicione(String [] dConjunto){
        operandos.push(new Conjunto(dConjunto));
        ok = true;
    }
    
    /**
     * Eliminar un conjunto de la Pila de acuerdo a su estructra LIFO
     */
    public void elimine(){
        if(operandos.size() > 0)
            operandos.pop();
        else
            showMessage("No hay nada que eliminar");
    }
    
    /**
     * Duplica el ultimo elemento el numero de veces indicada
     * @param times Numero de veces a duplicar
     */
    public void duplique(int times){
        if(operandos.size() > 0){
            Conjunto c = operandos.peek();
            for(int i = 0; i<times; i++){
                this.operandos.push(c);
            }
        }
        else{
            showMessage("No hay nada que duplicar");            
        }
    }
    
    /**
     * Retorna el cardinal dle conjunto
     */
    public int cardinal(){
        int res = operandos.size() > 0 ? operandos.peek().cardinal() : 0;
        if(res == 0) {showMessage("La pila esta vacia");}
        return res;
    }
  
    /**
     * Retorna la representacion como cadena del conjunto del tope de la pila
     * return Cadena de texto representando el conjunto
     */
    public String consulte(){
        String res = "Pila Vacia";
        if(this.operandos.size() == 0){
            showMessage("La pila esta vacia");
            ok = false;
        }
        else{
            ok = true;
            res = this.operandos.peek().toString(); 
        }
        
        return res;
    }

    /**
     * Operacion: U (union), I (Interseccion), - (Diferencia), _ (Diferencia simétrica), x (Producto)
     * @param oepracion Caracter de la oepracion a realizar
     */
    public void opere(char operacion){
        Conjunto c1 = null;
        Conjunto c2 = null;
        
        if(operandos.size() >= 2){
            c1 = operandos.pop();
            c2 = operandos.pop();
            
            if(operacion == 'U'){
                Conjunto res = c1.union(c2);
                this.operandos.push(res);
            }
            else if(operacion == 'I'){
                Conjunto res = c1.interseccion(c2);
                this.operandos.push(res);
            }
            else if(operacion == '-'){
                Conjunto res = c1.diferencia(c2);
                this.operandos.push(res);
            }
            else if(operacion == '_'){
                Conjunto res = c1.diferenciaSimetrica(c2);
                this.operandos.push(res);
            }
            else if(operacion == 'x'){
                Conjunto res = c1.producto(c2);
                this.operandos.push(res);
            }
            
            ok = true;
        }
        else{
            ok = false;
            showMessage("Necesitas mas de dos operandos para realizar una operacion");
        }
    }
    
    
    public boolean ok(){
        return this.ok;
    }
    
    /**
     * Evita que los mensajes a los usuarios se muestren mientras se hacen las pruebas
     */
    public void setTest(){
        test = false;
    }
    
    /**
     * Mostrar mensaje al usuario
     * @param msg Mensaje
     */
    private void showMessage(String msg){
        if(!test){
            JOptionPane.showMessageDialog(null, msg);
        }
    }
}
    



