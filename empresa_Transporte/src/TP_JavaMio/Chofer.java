package TP_JavaMio;

     
import java.time.LocalDate;

// Agregado para poder utilizar el tipo Date

public class Chofer extends Persona{
    
    // ATRIBUTOS
    protected LocalDate FechaIngreso;
    protected float SalarioCond= 2350f;	// cada 1000KM se pagan (2350f)
    protected int HorasConduciendo;
    protected int HorasDescanso;
    protected int HoraUltimaJornada; //agregado pedir fecha, cambiar a formato fecha.
    protected int HoraActual; //pasar a formato fecha cuando se sepa como.
    
    
    // METODOS

    public boolean NecesitaDescanso(float HorasConduciendo){
        return (HorasConduciendo>=4.30) ? true: false;
    };
    
    public String HorasDescanso(){
        HorasDescanso=HoraUltimaJornada-HoraActual;
        return "El chofer lleva"+HorasDescanso+" Horas de descanso acumuladas";
    };
    
    public boolean PuedeConducir(int HorasDescanso){ 
    if(HorasDescanso>=11){
        return true;
    }else{
        return false;
    }
    };
    
    public void setConduciendo(int horas){ //preguntar
        
    };
    
    public void setDescansando(int horas){ //preguntar
        
    };
    
    public void Descansado(){ //preguntar (redundante)
        
    };
    
    public void setSalario(float salario){
        this.SalarioCond = salario;
    };

    @Override
    public float getSalarioCond() {
        return SalarioCond;
    }
    
    // CONSTRUCTOR
    
    public Chofer (String dni, char categoria, LocalDate fechaIngreso, String nombre, float salario){ //agregar e inicializar el resto de variables de hora desps de consultar
        super(dni,categoria,fechaIngreso,nombre,salario);
    };
}
