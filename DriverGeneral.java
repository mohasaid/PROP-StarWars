import java.util.Scanner;
  
public class DriverGeneral
{
    private static void opciones()
    {
        // menu telescopic
        System.out.println(
          "OPCIONES \n"
        + " Opcion 0: Salir gestion drivers                 \n"
        + " Opcion 1: Driver Controlador nave               \n"
        + " Opcion 2: Driver Nave                           \n"
        + " Opcion 3: Driver Galaxia                    	\n"
        + " Opcion 4: Driver Controlador Galaxia 			\n"
        + " Opcion 5: Driver Controlador Ruta 				\n"
        + " Opcion 6: Driver Ruta			 			    \n"
        + " Opcion 7: Driver Controlador Planeta			\n"
        + " Opcion 8: Driver Planeta 						\n"
        + " Opcion 9:  Driver Conexion						\n"
        + " Opcion 10: Driver Entrada 						\n"
        + " Opcion 11: Driver Arco   						\n"
        + " Opcion 12: Driver Salida 						\n"
        + " Opcion 13: Driver Controlador MFP				\n"
		);
    }
      
    public static void main(String[] args) throws Exception {
        opciones();
        Scanner sc = new Scanner(System.in);
        //Nave
        DriverControladorNave DCNave = new DriverControladorNave();
        DriverNave Dnave = new DriverNave();
         //Galaxia
        DriverControladorGalaxia DCGalaxia = new DriverControladorGalaxia();
        DriverGalaxia DGalaxia = new DriverGalaxia();
        //Arco
        DriverArco Darco = new DriverArco();
        //Salida
        DriverSalida Dsalida = new DriverSalida();
        //ControladorMFP
        DriverControladorMFP dMFP = new DriverControladorMFP();
        
        ControladorMFP cMFP = new ControladorMFP();
        ControladorNave cn = new ControladorNave();
        ControladorPlaneta cp = new ControladorPlaneta();
        ControladorRuta cr = new ControladorRuta();
        ControladorGalaxia cg = new ControladorGalaxia();
        
       //Ruta (controlador ruta ya esta creado)
        DriverRuta DRuta = new DriverRuta();
        DriverControladorRuta DCRuta = new DriverControladorRuta(); 
        DriverPlaneta Dp = new DriverPlaneta();
        DriverControladorPlaneta DCP = new DriverControladorPlaneta();
        
        //Entrada
        DriverEntrada De = new DriverEntrada();
        Entrada e = null;
        
         //Conexion
        DriverConexion Dc = new DriverConexion();

        int op= sc.nextInt();
        while (op != 0){
            switch(op)
            {
                case 1: DCNave.Executa(sc,cn,cp); break;  
                case 2: Dnave.Executa(sc); break;
                case 3: DGalaxia.Executa(sc); break;
                case 4: DCGalaxia.Executa(sc,cp, cr, cn,cg); break;
                case 5: DCRuta.Executa(cr, cp, sc); break;
                case 6: DRuta.Executa(sc); break;
                case 7:	DCP.Ejecuta(sc,cp,cr,cg);break;
                case 8: Dp.Ejecuta(sc);break;
                case 9: Dc.Executa(sc);break;
                case 10: De.Executa();break;
                case 11: Darco.Executa(sc);break;
                case 12: Dsalida.Executa(sc,cr,cg);break;
                case 13: dMFP.Executa(sc,e,cMFP,cg,cr,cp,cn);break;
                default: System.out.println("Opcion incorrecta");                
            }
            opciones();
            op = sc.nextInt();
        }
    }   
}
