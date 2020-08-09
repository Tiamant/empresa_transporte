package TP_JavaMio;

import java.time.LocalDate;

public class Persona {
    
    protected int fechaNac;
    protected String DNI;
    protected char Categoria;
    protected LocalDate FechaIngreso;
    protected String Nombre;
    protected float SalarioCond= 2350f;	// cada 1000KM

     
    //constructor
    public Persona (String dni, char categoria, LocalDate fechaIngreso, String nombre, float salario){ //agregar e inicializar el resto de variables de hora desps de consultar
        this.DNI = dni;
        this.Categoria = categoria;
        this.FechaIngreso = fechaIngreso;
        this.Nombre = nombre;
        this.SalarioCond = salario;
    };
    
    
    // METODOS
        
    public void CalcularAntiguedad(){
        //fecha de ingreso-fecha actual
    };
    
    public float CalcularSalarioTotal(int rutas){ // Distancia en KM
        return this.SalarioCond * rutas;
    };
    
    float getSalarioCond() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    

    

}
