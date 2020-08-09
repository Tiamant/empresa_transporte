
package TP_JavaMio;

import java.util.Scanner;

public class Vehiculo {
    Scanner entrada = new Scanner(System.in);
        
    // ATRIBUTOS (PROPIEDADES) 
    protected String Color;
    protected String Patente;
    protected int CantidadRuedas;
    protected String NroMotor;
    protected String NroChasis;
    protected float Altura;
    protected float Ancho;
    protected float Largo;
    protected boolean enViaje=false;
    protected boolean enTaller=false;
    //////////////////////////////////////////////////////////////////////////
    //public float espacioDisponible;   
    protected float CapacidadCarga;        // Estaba en Transporte
    protected  char TipoCombustible;        // Estaba en Transporte
    protected float RendimientoCombustible;// Estaba en Transporte
    protected float Kilometraje;;
    protected float KmProximoService;
    protected char TipoVehiculo;
    

    // METODOS (COMPORTAMIENTO)

   
    public boolean NecesitaService() { // Indicar si necesita o no service
        //if (Kilometraje >= KmProximoService)
        //	return true;
        //else
        //	return false;

        return (Kilometraje >= KmProximoService);
    }
    /*
    public void TipoVehiculo(char TipoVehiculo){

        do{System.out.println("Ingrese el tipo de vehiculo:\n Los tipos válidos son:\n"+
"        1 = Motocicleta (50Kg)\n" +
"        2 = Camioneta (1.000Kg) )\n"+
"        3 = Camion (10.000Kg)");
        char TipoVehiculo = Character.toUpperCase(entrada.next().charAt(0));
        switch(TipoVehiculo){
            case '1': setCapacidadCarga(50f); System.out.println("Gracias, usted selecionó Motocicleta\n"); break;
            case '2': setCapacidadCarga(1000f); System.out.println("Gracias, usted selecionó Camioneta\n"); break;
            case '3': setCapacidadCarga(10000f); System.out.println("Gracias, usted selecionó Motocicleta\n"); break;
            default: System.out.println("Valor invalido. Ingrese nuevamente un valor\n");setCapacidadCarga(0f);
                            }
        //}while(getCapacidadCarga()==0f);
    }*/

    public void CalcularKmRecorridos (float distancia){ //la pregunta es muy general, especificar a cuando hace referencia/punto de referencia
        
        return;
    };

    public void setKilometraje(float kilometraje) {
        this.Kilometraje = kilometraje;
    };
    
    public float getKilometraje() {
        return this.Kilometraje;
    };
    
    public String getNroMotor(){
        return this.NroMotor;
    };
    
    public String getNroChasis(){
        return this.NroChasis;
    };

    public boolean EnUso(boolean enViaje){ //confirmar (se podria enviar mensaje de que esta en uso en un string)
        enViaje=true;
        return enViaje;
    };
    
    public boolean enTaller(){ //lo mismo que enUso()
        enTaller=true;
        return true;
    };

    public void Service() {
        if (NecesitaService()) {             
            // HACER SERVICE
            KmProximoService = Kilometraje+10000;
        }
    };

    public float getCapacidadCarga() {
        return CapacidadCarga;
    }

    public char getTipoCombustible() {
        return TipoCombustible;
    }

    public float getRendimientoCombustible() {
        return RendimientoCombustible;
    }

    public float getKmProximoService() {
        return KmProximoService;
    }

    public void setTipoCombustible(char TipoCombustible) {
        this.TipoCombustible = TipoCombustible;
    }

    public void setCapacidadCarga(float CapacidadCarga) {
        this.CapacidadCarga = CapacidadCarga;
    }

    public void setTipoVehiculo(char TipoVehiculo) {
        this.TipoVehiculo=TipoVehiculo;
    }

    

    // CONSTRUCTOR
    
    public Vehiculo(String nroMotor, String nroChasis, char tipoCombustible) {
        this.NroMotor = nroMotor;
        this.NroChasis = nroChasis;
        this.TipoCombustible = tipoCombustible;
        this.RendimientoCombustible = 0;
        this.CapacidadCarga = 0;
    };
    
        //public void rendimientoCombustible(){   
    //}
    
}

