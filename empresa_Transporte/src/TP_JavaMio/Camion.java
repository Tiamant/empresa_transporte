package TP_JavaMio;


public class Camion extends Vehiculo{
    
    
    public Camion(String nroMotor, String nroChasis, char tipoCombustible){
    super(nroMotor,nroChasis,tipoCombustible);
    this.CapacidadCarga=10000f;
    this.RendimientoCombustible=3.3f;
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
