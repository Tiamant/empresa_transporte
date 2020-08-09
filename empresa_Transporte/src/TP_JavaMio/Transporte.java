package TP_JavaMio;

import java.util.Scanner;

public class Transporte {
    Scanner entrada = new Scanner(System.in);
    
    // ATRIBUTOS
    
    protected float DistanciaARecorrer;
    protected   int rutas;    
    protected float PrecioCombustible;
    protected float CantidadCombustible;   
    protected float costoTotalCombustible;
    
    protected   int CantidadChoferes;
    protected float salarioTotal;           //salario total segun cantidad de choferes
    
    protected float PrecioKg=50;
    protected float PrecioKgPesoMuerto=10;
    protected float costoTotalCarga=0;
    protected   int cantBultos;              //
    protected   int cantidadBultosCargados;  //acumulador
    protected float PesoBulto;               //peso de cada bulto
    protected float CargaActual;             //acumulador
    protected float pesoMuertoTotal;         //espacio disponible
    protected float pesoTotalCargado; //peso final
    protected float CostoTotalFlete;  //guarda total final
    protected float Descuento;        //guarda descuento segun condicion
    protected  char tipoVehiculo;
    protected final Vehiculo vehiculo;
    protected final Persona chofer;

    
   
    // METODOS
    
    
    public void MostrarResultados(){
            System.out.println("El costo total del flete es de $"+calcularCostoTotalFlete()+"\n"+
                               "El descuento será de $"+CalcularDescuento()+"\n"+
                               "Dando un Total Final de $"+(CostoTotalFlete-Descuento));
    };
    
    public void MostrarSueldos(){
        //calcula cantidad de choferes
            System.out.println("Se necesitara(n) "+CantidadChoferes+" chofer(es) para completar el recorrido"); //♣
        //salario de choferes
            System.out.println("El salario acumulado de los choferes es de $"+salarioTotal);
    }
    
    public void MostrarCCombustible(){
        //calcula gasto total de combustible
        System.out.println("El costo del combustible será de $"+costoTotalCombustible);        //////////////////
        //consumo combustible
        System.out.println("El vehiculo gastará "+CantidadCombustible+" Litros de combustible");//♣
    }
    
    public void MostrarDistancias(float[] a,float sDistanciaPromedio){
        System.out.println("El tramo mas largo es de "+calcularMayor(a));
        System.out.println("El tramo mas corto es de "+calcularMenor(a));
        System.out.println("La distancia promedio entre ciudades es de: "+sDistanciaPromedio+" km.");
    } //muestra detalles de distancias y promedio
    
    public void MostrarPesos(){
        System.out.println("El peso muerto/espacio disponible es de "+pesoMuertoTotal+" Kilogramos");//♣
        System.out.println("El costo total de la carga normal es de $"+CalcularCostoCarga());//♣
        System.out.println("El costo total del peso muerto es de $"+CalcularCostoPesoMuerto());//♣
    }
    
    public void MostrarPaquetes(float[] a){
        System.out.println("El paquete mas pesado fue de "+calcularMayor(a)+"Kg");  //revisar
        System.out.println("El paquete mas liviano fue de "+calcularMenor(a)+"Kg");
        System.out.println("El peso promedio de paquetes es de "+(pesoTotalCargado/cantidadBultosCargados)+"Kg.");
    }
    
    public float calcularMayor(float[] a){    //define el mayor elemento de un array
        float mayor=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > mayor) {
                mayor = a[i];
            } 
        }
        return mayor;
    }  //se usa
    
    public float calcularMenor(float[] b){   //define el menor elemento de un array
        float menor=b[0];
        for (int i = 0; i < b.length; i++) {
            if(b [i] < menor && b [i] >0) {
                menor = b[i];
            } 
        }
        return menor;
    }  //se usa
    
    public float calcularCostoTotalFlete(){
        this.CostoTotalFlete = salarioTotal+costoTotalCarga+costoTotalCombustible;
        return CostoTotalFlete;
    }  //se usa
       
    public float CalcularCantidadCombustible() { //Determina cual va a ser el consumo de litros de acuerdo al viaje
        this.CantidadCombustible = (DistanciaARecorrer/vehiculo.getRendimientoCombustible())*2;
        return CantidadCombustible;
    }; //se usa
    
    public float CalcularCostoCombustible() {
        this.costoTotalCombustible=PrecioCombustible*CantidadCombustible;
        return costoTotalCombustible;
    };   //su
                  
    public int   CalcularCantidadChoferes(){////
        setCantidadRutas();
        // 1 chofer cada 500km o fraccion
        this.CantidadChoferes = (int)this.DistanciaARecorrer / 500;
        // Redondear hacia arriba de acuerdo a la distancia a recorrer
        if ((int)this.DistanciaARecorrer % 500 > 0) {
            this.CantidadChoferes++;
        }
        // Devolver la cantidad de choferes. Si es cero, devolver 1;
        return (this.CantidadChoferes == 0) ? 1 : this.CantidadChoferes;
    };  //su
    
    public void  setCantidadRutas(){ //se guarda la cantida de rutas
        //una ruta cada 1000km
        this.rutas = (int)this.DistanciaARecorrer / 1000;
        if ((int)DistanciaARecorrer % 1000 > 0) {
            rutas++;
        }
    }   //su
    
    public void setCantidadDestinos(int cantDestinos){
     
    }  //crea un array con la cantidad de destinos a visitar manualmente
    
    public float addCarga (float peso, int i){
        
        /*
        if(this.CargaActual+peso<vehiculo.getCapacidadCarga()){
        this.CargaActual += peso;
        this.pesoMuertoTotal=vehiculo.getCapacidadCarga()-CargaActual;
        return this.CargaActual;  
        }else{
          return 0;
        }*/return 0;
    }  //no
    
    public float CalcularSalarioChoferes(){  //se pide salario de clase chofer
        this.salarioTotal = this.rutas * chofer.getSalarioCond() * CantidadChoferes;
        return salarioTotal;
    };  
    
    public float getSalarioTotal() {
        return salarioTotal;
    }
    
    public float CalcularCostoCarga() {
        float costoCarga = PrecioKg*pesoTotalCargado;
        this.costoTotalCarga+=costoCarga;
        return costoCarga;
    }    
    
    public float CalcularCostoPesoMuerto() {
        float costoPMuerto = PrecioKgPesoMuerto*pesoMuertoTotal;
        this.costoTotalCarga+=costoPMuerto;
        return costoPMuerto;
    }
    
    public float CalcularPesoMuerto(){  ////////////////chequear
        this.pesoMuertoTotal=(vehiculo.getCapacidadCarga()-pesoTotalCargado);
        return pesoMuertoTotal;
    }
    
    public float PesoCarga(float carga){
        return cantBultos;
    };
    
    public int condicionalCargaDivDos(){
        int  cargasPosibles= (int)pesoMuertoTotal/(int)Math.floor(CargaActual/2);
        return cargasPosibles;
    }
    
    public int condicionalCargaDivTres(){
        int  cargasPosibles=(int)pesoMuertoTotal/(int)Math.floor(CargaActual/3);  
        return cargasPosibles;
    }
    
    public float CalcularDescuento(){
        if (CostoTotalFlete <= 35000) {
            this.Descuento = CostoTotalFlete * (10.0F / 100.0F); // fCostoTotal * 10%
        } else if (CostoTotalFlete> 35001 && CostoTotalFlete <= 40000) {
            this.Descuento = CostoTotalFlete * (15.0F / 100.0F);
        } else {
            this.Descuento = CostoTotalFlete * (20.0F / 100.0F);
        }
        return Descuento;
    }
    
    public void setTipoVehiculo(char TipoVehiculo){
        vehiculo.setTipoVehiculo(TipoVehiculo);
    }
    
    public float addDistanciaCiudad (float distancia) {
        return (this.DistanciaARecorrer += distancia);
    };

    public void setDistanciaARecorrer(float DistanciaARecorrer) {
        this.DistanciaARecorrer = DistanciaARecorrer;
    }

    public void setPrecioCombustible(float PrecioCombustible) {
        this.PrecioCombustible = PrecioCombustible;
    }

    public void setCantidadChoferes(int CantidadChoferes) {
        this.CantidadChoferes = CantidadChoferes;
    }

    public void setPrecioKg(float precioKg) {
        this.PrecioKg = precioKg;
    }

    public void setPrecioKgPesoMuerto(float PrecioKgPesoMuerto) {
        this.PrecioKgPesoMuerto = PrecioKgPesoMuerto;
    }

    public float getPrecioCombustible() {
        return PrecioCombustible;
    }

    public float getDistanciaARecorrer() {
        return DistanciaARecorrer;
    }

    public int getCantidadChoferes() {
        return CantidadChoferes;
    }

    public int getRutas() {
        return rutas;
    }

    public void setPesoBulto(float PesoBulto) {
        this.PesoBulto = PesoBulto;
    }

    public float CantidadBultos(){
        float bultos = vehiculo.getCapacidadCarga()/PesoBulto;
        return bultos;
    }

    public void setCantBultos(int cantBultos) {
        this.cantBultos = cantBultos;
    }

    public float getPesoBulto() {
        return PesoBulto;
    }
    
    public int getCantBultos() {
        return cantBultos;
    }
    
    public float getCostoTotalCarga() {
        return costoTotalCarga;
    }

    public float getCargaActual() {
        return CargaActual;
    }

    public void setPesoMuertoTotal(float pesoMuertoTotal) {
        this.pesoMuertoTotal = pesoMuertoTotal;
    }
    
    public float getPesoMuertoTotal() {
        return pesoMuertoTotal;
    }

    public float getSalarioChofer(){
        return chofer.getSalarioCond();
    }

    public float getCostoTotalFlete() {
        return CostoTotalFlete;
    }
    
    public float getDescuento() {
        return Descuento;
    }
    
    public float getPesoTotalCargado() {
        return pesoTotalCargado;
    }

    public void setPesoTotalCargado(float pesoTotalCargado) {
        this.pesoTotalCargado += pesoTotalCargado;
    }

    public int getCantidadBultosCargados() {
        return cantidadBultosCargados;
    }

    public void setCantidadBultosCargados(int cantidadBultosCargados) {
        this.cantidadBultosCargados = cantidadBultosCargados;
    }
    
    public float getCapacidadCarga(){
        return vehiculo.getCapacidadCarga();
    }
    

    // CONSTUCTOR
    public Transporte (
            // Para Transporte
            float precioCombustible, 
            float precioKg, 
            float precioKgPesoMuerto, 
            // Para chofer
            float salarioCond,
            // Para vehiculo
            char tipoVehiculo, 
            
            char tipoCombustible        
    ) 
    
    {

        switch(tipoVehiculo){
            case '1': this.vehiculo = new Motocicleta("0000-0000","0000-0000",tipoCombustible);break;
            case '2': this.vehiculo = new Camioneta("0000-0000","0000-0000",tipoCombustible);break;
            default: this.vehiculo = new Camion("0000-0000","0000-0000",tipoCombustible);break;
        }
        
        
        /*this.vehiculo = new Vehiculo(
                "0000-0000",
                "0000-0000",
                TipoCombustible,
                rendimiento,
                tipoVehiculo
            );*/
        
        this.chofer = new Chofer(
                "23684471",
                'B',null,"Martin",salarioCond
        );
        this.PrecioCombustible=precioCombustible;
        this.PrecioKg= precioKg;
        this.PrecioKgPesoMuerto= precioKgPesoMuerto;
    }    
} 