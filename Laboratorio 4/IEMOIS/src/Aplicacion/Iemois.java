package Aplicacion;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Clase principal del paquete de aplicacion, que se conecta con el de presentacion
 */
public class Iemois{
    private LinkedList <Mooc> cursos;
    
    /**
     * Constructor de la clase
     */
    public Iemois(){
        cursos = new LinkedList<Mooc>();
    }
    
    /**
     * Adiciona algunos cursos
     */
    public void adicione() throws IEMOISExcepcion{
            Mooc ejemplos[] = {
            new Mooc("Databases","Bases de Datos", 
            "En este curso aprenderá las tecnologías básicas de las bases de datos. Las bases de datos son necesarias en todas las tecnologías usadas por"+
            "la mayoría de las personas todos los dias: sitios web, sistema de comunicaciones, sistemas bancarios, video juegos y cualquier otro software"+
            "o herramienta tecnológica que deba mantener información persistente. Además de la persistencia, las bases de datos ofrecen otras propiedades"+
            "que las hacen excepcionalmente útiles y convenientes: confiabilidad, eficiencia, escalabiliad, control de concurrencia, abstracción de datos"+
            " y lenguajes de alto nivel",
            "Stanford Lagunita", 13),        
            new Mooc("Introduction to Computer Science and Programming Using Python","Programación", 
            "Este curso es el primero de una secuencia de dos cursos: Introduction to Computer Science and Programming Using Python,"+
            " y Introduction to Computational Thinking and Data Science. Ellos fueron diseñado para ayudar a personas con poca experiencia en ciencias de"+
            " la computación y programación a pensar computacionalmente y a escribir programas para abordar problemas útiles",
            "Edx", 9),          
            new Mooc("Introduction to Computational Thinking and Data Science","Ciencia de Datos", 
            "Este curso aprenderá cómo usar la computación para lograr una variedad de objetivos y le brindará una breve introducción a una variedad de"+
            " tópicos en solución computacional de problemas: visualización, programación estocástica, aprendizaje de máquina, etc",
            "Edx", 9),            
            
        };
        for(Mooc informacion : ejemplos) {
            adicione(informacion);
        }
    }
    
   
    
    /**
     * Consulta la información de un curso
     */
    public Mooc getInformacion(String nombre,String distribuidor){
        Mooc c=null;
        for(int i=0;i<cursos.size() && c == null;i++){
            if (cursos.get(i).getNombre().compareToIgnoreCase(nombre)==0 &&
                   (cursos.get(i).getDistribuidor().compareToIgnoreCase(distribuidor)==0)){
                   c=cursos.get(i);
                }
        }
        return c;
    }


    /**
     * Adiciona un nuevo curso
     */
    public void adicione(String nombre, String area,  String objetivo, String  distribuidor, String semanas) throws IEMOISExcepcion{
        for(Mooc c: cursos){
            if(c.getNombre().equals(nombre) && c.getArea().equals(area) && c.getObjetivo().equals(objetivo)
                && c.getDistribuidor().equals(distribuidor) && c.getSemanas() == Integer.parseInt(semanas)){
                    Registro.registre(new IEMOISExcepcion(IEMOISExcepcion.EL_DATO_A_AGREGAR_YA_EXISTE));
                    throw new IEMOISExcepcion(IEMOISExcepcion.EL_DATO_A_AGREGAR_YA_EXISTE);
                }
        }  
        adicione(new Mooc(nombre, area, objetivo, distribuidor, Integer.parseInt(semanas)));
    }

    /**
     * Adiciona un nuevo cursos
     */
    public void adicione(Mooc informacion) throws IEMOISExcepcion{
        int i=0;
        while ((i<cursos.size()) && (cursos.get(i).getNombre().compareToIgnoreCase(informacion.getNombre())<0)){
            i++;
        }
        cursos.add(i,informacion);
    }
    

    
    /**
     * Consulta las cursos que inican con un prefijo
     * @param prefijo El prefijo a buscar
     * @return 
     */
    public ArrayList<Mooc> busque(String prefijo){
        ArrayList<Mooc> resultados = new ArrayList<Mooc>();
        prefijo=prefijo.toUpperCase();
        for(int i=0;i<cursos.size();i++){
            if(cursos.get(i).getNombre().toUpperCase().startsWith(prefijo)){
                if(cursos.get(i) != null)
                    resultados.add(cursos.get(i));
            }   
        }
        return resultados;
    }

    /**
     * Consulta el numero de cursos
     * @return 
     */
    public int numerocursos(){
        return cursos.size();
    }


    /**
     * Consulta todos los cursos
     * @return 
     */
    public String toString(){
    StringBuffer allEntries=new StringBuffer();
        for(Mooc informacion : cursos) {
            allEntries.append(informacion.toString().length()<=150? informacion:informacion.toString().substring(0,199)+"...");
            allEntries.append('\n');
            allEntries.append('\n');
        }
        return allEntries.toString();
    }
}
