package TP_JavaMio;

public class Transporte_Prioritario extends Transporte {
    private float recargo;
    private float costoPrioritario;
    
    
    
    ///constructor
    public Transporte_Prioritario(/*float totalComun, */float precioCombustible, float precioKg, float precioKgPesoMuerto, 
            // Para chofer 
            float salarioCond,
            // Para vehiculo
            char tipoVehiculo, char TipoCombustible){
        
    super(precioCombustible,precioKg,precioKgPesoMuerto, 
            // Para chofer
             salarioCond,
            // Para vehiculo
             tipoVehiculo, TipoCombustible);
    }
    
    
    ////////metodos
    public void calcularRecargo(){
        this.recargo = (CostoTotalFlete*30)/100;
        this.costoPrioritario=recargo+CostoTotalFlete;
    }

    public float getRecargo() {
        return recargo;
    }

    public float getCostoPriotitario() {
        return costoPrioritario;
    }
    
    public void MostrarTotalPriotirario(){
        System.out.println("El costo total prioritario agrega un costo del 30% ($"+recargo+") sobre el valor total, quedando en $"+costoPrioritario+" Finales");
    }
    
    @Override
    public void MostrarResultados(){
        System.out.println("El costo total del flete es de $"+calcularCostoTotalFlete()+"\n"+
                            "El descuento será de $"+CalcularDescuento()+"\n"+
                            "Dando un Total de $"+(CostoTotalFlete-Descuento));
                            calcularRecargo();
        System.out.println("El costo total prioritario agrega un costo del 30% ($"+recargo+")"
                        + " sobre el valor total, quedando en $"+costoPrioritario+" Finales");                
    };
    
}
