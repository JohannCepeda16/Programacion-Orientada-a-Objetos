import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author   ECI
 * @version 2020-2
 */
public class ConjuntoTest
{
 
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        
    }
 
    @Test 
    public void deberiaPasar(){
        assertEquals(1,1);
    }
    
    @Test 
    public void deberiaFallar(){
       fail();
    }
    
    @Test 
    public void deberiaErrar(){
        int[] a =  new int[2];
        a[2] = 0;
        System.out.println(a[3]);
        
    }

    @Test
    public void deberiaCrearConjuntosVacios(){
        String [] dVacio={};
        Conjunto vacio=new Conjunto(new String[]{});
        assertEquals(0,vacio.cardinal());
        vacio=new Conjunto(dVacio);
        assertEquals(0,vacio.cardinal());
    }
    
    @Test
    public void deberiaCrearLosConjuntosDelTama_oIndicado(){
        String[]  dSiglas= {"POOB","MBDA"};
        Conjunto siglas=new Conjunto(dSiglas);
        assertEquals(2,siglas.cardinal());
    }

    @Test
    public void deberiaCrearLosConjuntoConLosElementosDados(){
        String[]  dSiglas={"POOB","MBDA"};
        Conjunto siglas=new Conjunto(dSiglas);
        assertEquals(2,siglas.cardinal());
        assertTrue(siglas.pertenece("POOB"));
        assertTrue(siglas.pertenece("MBDA"));
        assertFalse(siglas.pertenece("AYED"));
    }
    
    @Test
    public void noDeberiaSerSensibleAMayusculas(){
        String [] dSiglas={"POOB","MBDA","poob","Poob"};
        Conjunto siglas=new Conjunto(dSiglas);
        assertEquals(2,siglas.cardinal());
        assertTrue(siglas.pertenece("POOB"));
        assertTrue(siglas.pertenece("poob"));
        assertTrue(siglas.pertenece("PooB"));
    }
    
    
    @Test
    public void deberiaCrearConjuntosQuitandoElementosRepetidos(){
        String [] dSiglas={"TPRO","POOB","MBDA","TPRO"};
        Conjunto siglas=new Conjunto(dSiglas);
        assertEquals(3,siglas.cardinal());    
    }    
    
    @Test
    public void deberiaCrearConjuntosEliminandoEspaciosInnecesarios(){
        String [] dMaterias={"Programacion orientada a objetos","Modelos y bases de datos","Modelos y bases de datos       ","Modelos y                  bases de datos"};
        Conjunto materias=new Conjunto(dMaterias);
        assertEquals(2,materias.cardinal());
        assertTrue(materias.pertenece(dMaterias[0]));
        assertTrue(materias.pertenece(dMaterias[1]));
        assertTrue(materias.pertenece(dMaterias[2]));
    }    
    
    
    
    @Test
    public void deberiaPoderExpresarUnConjuntoComoCadena(){
        String [] dCaso={"uno","dos","Tres","Cuatro"};
        Conjunto caso=new Conjunto(dCaso);
        String resultado="{CUATRO, DOS, TRES, UNO}";
        assertEquals(resultado,caso.toString()); 
    }
       

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
