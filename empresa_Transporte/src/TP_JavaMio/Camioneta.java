package TP_JavaMio;


public class Camioneta extends Vehiculo{

    
    public Camioneta(String nroMotor, String nroChasis, char tipoCombustible){
        super(nroMotor,nroChasis,tipoCombustible);
        this.CapacidadCarga=1500f;
        this.RendimientoCombustible=7.5f;
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
