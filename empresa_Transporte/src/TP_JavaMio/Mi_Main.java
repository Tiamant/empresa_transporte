package TP_JavaMio;

import java.util.Scanner;

public class Mi_Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        //para transporte
        float iPesoCaja=0;
        float precioCombustible=10;
        float precioKg=50f;
        float precioKgPesoMuerto=10f; 
        // Para chofer
        float salarioCond=2350f;
        // Para vehiculo
        //float capacidadCarga;
        //float rendimiento; 
        char tipoCombustible; //se des-inicializa
        char tipoVehiculo;
        boolean bandera;
        int destinos=0;
        float fD=0;
        int CantBultos=0;

        Transporte transporte1;

        System.out.println("Bienvenidos a nuestra compañía de transporte");
  
        //selecciona tipo combustible   ///////////////      Setea TIPO COMBUSTIBLE Y PRECIO    ///////////////
            do{bandera=false;
                System.out.println("Ingrese el tipo de combustible:\n Los tipos válidos son:\n" +
                                    " S = Nafta super (precio 53.47)\n" +
                                    " P = Nafta premium (precio 61.69)\n" +
                                    " G = Gasoil (precio 52.19)");
                tipoCombustible = Character.toUpperCase(entrada.next().charAt(0));
                switch(tipoCombustible) {
                    case 'S' : precioCombustible= 53.47F; System.out.println("Gracias, usted selecionó Nafta Super!\n"); break; //11,5kml
                    case 'P' : precioCombustible= 61.69F; System.out.println("Gracias, usted selecionó Nafta Premium!\n"); break; //11,5kml
                    case 'G' : precioCombustible= 52.19F; System.out.println("Gracias, usted selecionó Gasoil!\n");break;////3.3kml
                    default  : System.out.println("Valor invalido. Ingrese un valor\n");bandera=true;
                }
                //transporte1.SelecTipoCombust(TipoCombustible);
            } while(bandera!=false);

   
        //selecciona el tipo de vehiculo ///////////////       Setea CAPACIDAD CARGA MAXIMA     ///////////////
            do{bandera=false;
                System.out.println("Ingrese el tipo de vehiculo:\n Los tipos válidos son:\n"+
                                    " 1 = Motocicleta (50Kg)/ Rendimiento:11.5 km/l\n" +
                                    " 2 = Camioneta (1.500Kg)/ Rendimiento:7.5 km/l\n"+
                                    " 3 = Camion (10.000Kg)/ Rendimiento:3.3 km/l");
                tipoVehiculo = Character.toUpperCase(entrada.next().charAt(0));     
                switch(tipoVehiculo){
                    case '1': /*capacidadCarga=50f; rendimiento=11.5f;*/ System.out.println("Gracias, usted selecionó Motocicleta\n"); break;
                    case '2': /*capacidadCarga=1500f; rendimiento=7.5f;*/ System.out.println("Gracias, usted selecionó Camioneta\n"); break;
                    case '3': /*capacidadCarga=10000f; rendimiento=3.3f;*/ System.out.println("Gracias, usted selecionó Camion\n"); break;
                    default: System.out.println("Valor invalido. Ingrese nuevamente un valor\n");bandera=true;
                }
            }while(bandera!=false);


                                             ////////////////Se Instancia OBJETO\\\\\\\\\\\\\\\\\            
        System.out.println("Si Desea elegir un transporte prioritario presione 'S' de lo contrario presione cualquier tecla");
        char prioritario = Character.toUpperCase(entrada.next().charAt(0));
        if(prioritario=='S'){
        transporte1 = new Transporte_Prioritario(precioCombustible,precioKg,precioKgPesoMuerto,salarioCond,tipoVehiculo,tipoCombustible);
        }else{
        transporte1 = new Transporte(precioCombustible,precioKg,precioKgPesoMuerto,salarioCond,tipoVehiculo,tipoCombustible);
        }
                                              ////////////////Se Instancia OBJETO\\\\\\\\\\\\\\\\\       
                           
                                              
        //se setea el tipo de vehiculo
        transporte1.setTipoVehiculo(tipoVehiculo);
                                                                ////////////////////
        //Distancia a recorrer    ////////////////////////////  CANTIDAD DE DESTINOS ///////////////////////////////////////////
                                                                ////////////////////       
        
        System.out.println("Por favor ingrese cuantos destinos quiere visitar (Máximo 10)");
        
         do{
            try{bandera=false;
                destinos= entrada.nextInt();  
                while(destinos<=0 || destinos >10){          
                        System.out.println("Valor invalido, por favor ingrese cuantos destinos visitará (del 1 al 10)");
                        destinos= entrada.nextInt();
                     } 
                }catch(Exception e){System.out.println("Valor invalido, ingrese un numero del 1 al 10");bandera=true;entrada.nextLine();}
            }while(bandera!=false);
                
                transporte1.setCantidadDestinos(destinos);
            System.out.println("Gracias, Ud ha elegido un maximo de "+destinos+" destinos");
                float [] CDestinos= new float [destinos];
                float fDistancia = 0f;
                transporte1.setDistanciaARecorrer(fDistancia);
                

                for (int i=0; i<CDestinos.length; i++) {
                        System.out.println("Ingrese la distancia del destino "+(i+1)+"/"+destinos);           
                    do{
                        try{bandera=false;
                            fD= entrada.nextFloat();
                        }catch(Exception e){System.out.println("Valor invalido, ingrese un numero del 1 al 10");bandera=true;entrada.nextLine();}

                        if(fD<=0){System.out.println("Ingrese un valor numerico válido");}
                    }while(bandera!=false || fD<0);         
                        
                        
                CDestinos[i]=fD;
                transporte1.addDistanciaCiudad(CDestinos[i]);
                fDistancia += fD;
                }
                transporte1.setDistanciaARecorrer(fDistancia);
                //transporte1.getDistanciaARecorrer();
                float fDistanciaPromedio = fDistancia / CDestinos.length;
                //String sDistanciaPromedio = String.format("%.2f", fDistanciaPromedio);
                transporte1.CalcularCantidadCombustible();
                transporte1.CalcularCostoCombustible();
                transporte1.CalcularCantidadChoferes();
                transporte1.CalcularSalarioChoferes();

                                                //////////////////////  CAJAS A CARGAR ///////////////////////
                                                    
            System.out.println("Ingrese cuantas cajas desea cargar, puede cargar hasta 20");   
            
            
            do{
            try{bandera=false;
            CantBultos = entrada.nextInt();
            }catch(Exception e){System.out.println("Valor invalido, ingrese un numero del 1 al 20");bandera=true;entrada.nextLine();}

            if(CantBultos<=0|| CantBultos >20){System.out.println("El valor ingresado no es correcto, Ingrese un valor válido del 1 al 20");bandera=true;}
            }while(bandera!=false);

            float [] paquetes= new float[CantBultos];
            //transporte1.setPesoBulto(1);  (si algo falla descomentar)
            //boolean continuar=true;
            transporte1.setPesoTotalCargado(0f); //(!)
            // mientras haya espacio disponible carga
            
  
        
        for (int i = 0; i < paquetes.length; i++) {
            int a;
            a=transporte1.getCantidadBultosCargados();
            if(a==0){
                System.out.println("Entró al menú de seleccion de cargas.  Ingrese '0' (Cero) para terminar.");  //hace que solo se indique una vez, en la primera carga
            }
 
                transporte1.CalcularPesoMuerto(); //se establece peso muerto total
                String sCapacidadRestante = String.format("%.2f",transporte1.getPesoMuertoTotal());//Se convierte el peso restante a String para imprimirlo
            System.out.println ("Capacidad restante : "+sCapacidadRestante+" Kilos.");
            System.out.println ("Bultos cargados hasta el momento: "+transporte1.getCantidadBultosCargados()+"\n");
            System.out.print   ("Ingrese el peso del bulto nº"+(transporte1.getCantidadBultosCargados()+1)+" de "+paquetes.length+" :");
            
            
            do{
               try{bandera=false;
                iPesoCaja = entrada.nextInt();   
                    while(iPesoCaja<0){
                        System.out.println("No puede ingresar un valor negativo, ingrese el valor nuevamente");
                        iPesoCaja = entrada.nextInt();
                    } 
                }catch(Exception e){System.out.println("Valor invalido, ingrese nuevamente el peso MENOR a "+transporte1.getPesoMuertoTotal()+"Kg.");bandera=true;entrada.nextLine();}
                if(iPesoCaja > transporte1.getPesoMuertoTotal()){ 
                    System.out.println("Valor invalido, ingrese nuevamente el peso MENOR a "+transporte1.getPesoMuertoTotal()+"Kg.");entrada.nextLine();
                    bandera=true;
                }
                        //if(fD<=0){System.out.println("Ingrese un valor numerico válido");}
            }while(bandera!=false);   
                    
            if(iPesoCaja==0){  //si el peso de la caja es 0 (porque no quiere seguir cargando peso), se llena el resto del array con 0.
                    i++;
                    for (int j = i; j < paquetes.length; j++) {
                    paquetes[j]=0;
                    //continuar=false;
                    }break;
                }
            //pregunto si hay espacio para la caja.
            if (iPesoCaja <= transporte1.getPesoMuertoTotal()){
                transporte1.setPesoTotalCargado(iPesoCaja);          ////////------------- suma el peso de la carga a lo que se va cargando
                transporte1.CalcularPesoMuerto();//  calcula peso muerto restante   
                transporte1.setCantidadBultosCargados(transporte1.getCantidadBultosCargados()+1); // se suma un bulto
                paquetes[a]=iPesoCaja;
                System.out.println("El bulto ha sido cargado"+"\n");
            }else if(transporte1.getCantidadBultosCargados()==paquetes.length){
                        System.out.println("Todos los paquetes fueron cargados!");
                        //continuar=false;
                        break;
            }
                
            /*else{System.out.println ("El peso del bulto supera la capacidad maxima";
                for (int j = i; j < paquetes.length; j++) {
                paquetes[j]=0;
                }break;
            }*/
        
        }
        transporte1.MostrarPaquetes(paquetes);  //muestra detalles de paquetes          
          
                                                                    // MOSTRAR CARGAS
         transporte1.MostrarPesos();                                                           
            
        //si existe peso muerto podria caber tantas veces
        /*if(transporte1.getPesoMuertoTotal()!=0){
            System.out.println("En el peso muerto restante podría(n) caber :"+transporte1.condicionalCargaDivDos()+" bultos de la mitad del peso"+"\n"
                    + "y "+transporte1.condicionalCargaDivTres()+"Bultos de un tercio del peso");}*/
             
                                                                        //MOSTRAR Distancias    
        transporte1.MostrarDistancias(CDestinos, fDistanciaPromedio);
                                                                        //Mostrar consumos COMBUSTIBLE
        transporte1.MostrarCCombustible();        
                                                                        //SUELDO CHOFERES
        transporte1.MostrarSueldos();
                                                                        //Muestra Totales
        transporte1.MostrarResultados();
        
        /*System.out.println("Si Desea elegir un transporte prioritario presione 'S' de lo contrario presione cualquier tecla");
        char prioritario = Character.toUpperCase(entrada.next().charAt(0));
        if(prioritario=='S'){
            Transporte_Prioritario TP = new Transporte_Prioritario(transporte1.getCostoTotalFlete(),precioCombustible,precioKg,precioKgPesoMuerto,salarioCond,capacidadCarga,rendimiento,tipoCombustible);
            TP.calcularRecargo();
            TP.MostrarTotalPriotirario();
        }*/
        //calcula el costo total del flete////
        System.out.println(" GRACIAS POR USAR NUESTRO SERVICIO DE TRANSPORTE!");
    }
}
