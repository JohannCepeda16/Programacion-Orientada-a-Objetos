package Pruebas;

import java.util.*;
import Aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IemoisTest.
 *
 * @author Johann Cepeda
 * @author Maria Torres
 * @version 1.0
 */
public class IemoisTest
{
    @Test
    public void deberiaAdicionar() throws IEMOISExcepcion{
        Iemois i = new Iemois();
        i.adicione("React", "Frontend", "Aprendizaje en front", "udemy", "4");
        try{
            i.adicione("React", "Frontend", "Aprendizaje en front", "udemy", "4");
        }catch(IEMOISExcepcion e){
            assertEquals(IEMOISExcepcion.EL_DATO_A_AGREGAR_YA_EXISTE, e.getMessage());
        }   
    }
    
    @Test
    public void NodeberiaAdicionarElementosRepetidos() throws IEMOISExcepcion{
        Iemois i = new Iemois();
        i.adicione("React", "Frontend", "Aprendizaje en front", "React academy", "2");
        try{
            i.adicione("React", "Frontend", "Aprendizaje en front", "React academy", "2");
        }catch(IEMOISExcepcion e){
            assertEquals(IEMOISExcepcion.EL_DATO_A_AGREGAR_YA_EXISTE, e.getMessage());
        }   
    }
    
    @Test
    public void NodeberiaAdicionarElementosSinNombre() throws IEMOISExcepcion{
        try{
            Iemois i = new Iemois();
            i.adicione("React", "Frontend", "Aprendizaje en front", "React academy", "2");
        }catch(IEMOISExcepcion e){
            assertEquals(IEMOISExcepcion.NO_SE_PUEDE_ADICIONAR_UN_MOOC_SIN_NOMBRE, e.getMessage());
        }
    }
    
    @Test
    public void deberiaBuscarAlgoQueExiste(){
        Iemois i = new Iemois();
        boolean found = false;
        try{
            i.adicione("React", "Frontend", "Aprendizaje en front", "React academy", "2");
            ArrayList<Mooc> res = i.busque("React");
            for(Mooc c: res){
                if(c.getNombre().equals("React"))
                    found = true;
            }
        }catch(IEMOISExcepcion e){
            
        }
        finally{
            assertTrue(found);
        }
        
    }
    
    @Test
    public void noDeberiaBuscarAlgoQueNoExiste(){
        Iemois i = new Iemois();
        boolean found = false;
        try{
            i.adicione("React", "Frontend", "Aprendizaje en front", "React academy", "2");
            ArrayList<Mooc> res = i.busque("adfkasdfk");
            for(Mooc c: res){
                if(c.getNombre().equals("React"))
                    found = true;
            }
        }catch(IEMOISExcepcion e){
            
        }
        finally{
            assertFalse(found);
        }
        
    }
}
