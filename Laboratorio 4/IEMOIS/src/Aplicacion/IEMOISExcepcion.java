package Aplicacion;

public class IEMOISExcepcion extends Exception
{
    public static final String NO_SE_PUEDE_ADICIONAR_UN_MOOC_SIN_NOMBRE = "No se puede adicionar un MOOC sin nombre";
    public static final String EL_NUMERO_DE_SEMANAS_DEBE_SER_UN_VALOR_NUMERICO = "El numero de semanas debe ser un valor numerico de maximo 4 digitos";
    public static final String EL_DATO_A_AGREGAR_YA_EXISTE = "El dato a agregar ya existe"; 
    
    public IEMOISExcepcion(String msg)
    {
        super(msg);        
    }

}
