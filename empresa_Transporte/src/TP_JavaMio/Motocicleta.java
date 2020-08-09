package TP_JavaMio;


public class Motocicleta extends Vehiculo{

    
    public Motocicleta(String nroMotor, String nroChasis, char tipoCombustible){
        super(nroMotor,nroChasis,tipoCombustible);
        this.CapacidadCarga=50f;
        this.RendimientoCombustible=11f;
    }
    
    
    @Override
    public float getCapacidadCarga() {
    return this.CapacidadCarga;
    }
    
    @Override
    public float getRendimientoCombustible() {
        return RendimientoCombustible;
    }  
}
