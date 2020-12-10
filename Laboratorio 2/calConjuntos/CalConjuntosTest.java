

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalConjuntosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalConjuntosTest
{
    @Test
    public void deberiaCrearLaPilaVacia(){
        CalConjuntos ca = new CalConjuntos();
        ca.setTest();
        assertEquals(0 ,ca.cardinal());
        
    }
    
    @Test
    public void deberiaConsultarVacio(){
        CalConjuntos ca= new CalConjuntos();
        ca.setTest();
        String b = ca.consulte();
        assertEquals(b, "Pila Vacia");
    }

    @Test
    public void deberiaAdicionar(){
        CalConjuntos ca= new CalConjuntos();
        ca.setTest();
        ca.adicione(new String[]{"a"});
        assertTrue(ca.ok());
    }
        
    @Test
    public void deberiaUnirCorrectamente(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"MBDA"});
        ca.adicione(new String[]{"ACSO","POOB"});
        String resultado="{ACSO, MBDA, POOB}";
        ca.opere('U');
        assertEquals(resultado,ca.consulte());
    }
    
    @Test
    public void deberiaUnirSinRepetirElementos(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"POOB","MBDA"});
        ca.adicione(new String[]{"ACSO","POOB"});
        String resultado="{ACSO, MBDA, POOB}";
        ca.opere('U');
        assertEquals(resultado,ca.consulte());
    }
    
    public void noDeberiaAumentarElCardinalAlUnirVacio(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{});
        ca.adicione(new String[]{"ACSO","POOB"});
        ca.opere('U');
        assertEquals(0,ca.cardinal());
    }
    
    @Test
    public void deberiaIntersecarCorrectamente(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"POOB","MBDA"});
        ca.adicione(new String[]{"ACSO","POOB"});
        String resultado="{POOB}";
        ca.opere('I');
        assertEquals(resultado,ca.consulte());
    }
    
    @Test
    public void deberiaIntersecarConjuntoVacio(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"POOB","MBDA"});
        ca.adicione(new String[]{"ACSO"});
        String resultado="{}";
        ca.opere('I');
        assertEquals(resultado,ca.consulte());
    }
    
    @Test
    public void deberiaHacerDiferenciaCorrectamente(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"POOB","MBDA"});
        ca.adicione(new String[]{"ACSO","POOB"});
        String resultado="{ACSO}";
        ca.opere('-');
        assertEquals(resultado,ca.consulte());
    }
    
    @Test
    public void noDeberiaQuitarElementosHaciendoDiferencia(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"POOB","MBDA"});
        ca.adicione(new String[]{"ACSO","TPRO"});
        String resultado="{ACSO, TPRO}";
        ca.opere('-');
        assertEquals(resultado,ca.consulte());
    }
    
    @Test
    public void deberiaDejarVacioConDiferenciaEntreConjuntosIguales(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"POOB","MBDA"});
        ca.adicione(new String[]{"MBDA","POOB"});
        ca.opere('-');
        assertEquals(0,ca.cardinal());
    }
    
    @Test
    public void deberiaHacerDiferenciaSimetricaCorrectamente(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"POOB","MBDA"});
        ca.adicione(new String[]{"ACSO","POOB"});
        String resultado="{ACSO, MBDA}";
        ca.opere('_');
        assertEquals(resultado,ca.consulte());
    }
    
    @Test
    public void deberiaSerLaDiferenciaSimetricaIgualAUnir(){
        CalConjuntos ca1 = new CalConjuntos();
        CalConjuntos ca2 = new CalConjuntos();
        ca1.adicione(new String[]{"POOB","MBDA"});
        ca1.adicione(new String[]{"ACSO","TPRO"});
        ca2.adicione(new String[]{"POOB","MBDA"});
        ca2.adicione(new String[]{"ACSO","TPRO"});
        ca1.opere('_');
        ca2.opere('U');
        assertEquals(ca2.consulte(),ca1.consulte());        
    }
    
    
    @Test
    public void deberiaEliminar(){
        CalConjuntos ca= new CalConjuntos();
        ca.setTest();
        ca.adicione(new String[]{"b"});
        ca.elimine();
        assertEquals(0,ca.cardinal());        
    }
    
    @Test
    public void noDeberiaPoderEliminar(){
        CalConjuntos ca= new CalConjuntos();
        ca.setTest();
        ca.elimine();
        assertFalse(ca.ok());        
    }
    
    @Test
    public void deberíaContinuarUnConjunto(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"ab","Poob"});
        ca.duplique(2);        
        ca.setTest();
        String resultado="{AB, POOB}";
        assertEquals(resultado,ca.consulte());        
    }
    
    @Test
    public void deberiaHacerProducto(){
        CalConjuntos ca= new CalConjuntos();
        ca.adicione(new String[]{"A","B"});
        ca.adicione(new String[]{"C"});
        String resultado="{(C,A), (C,B)}";
        ca.opere('x');
        assertEquals(resultado,ca.consulte());
    }
}
