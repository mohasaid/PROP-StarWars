import java.util.Scanner;
  
public class DriverGeneral
{
    private static void opciones()
    {
        // menu telescopic
        System.out.println(
         "OPCIONES \n"
        + " Opcion 0: Salir gestion drivers                                 \n"
        + " Opcion 1: Driver Controlador nave                               \n"
        + " Opcion 2: Driver Nave                                           \n"
        + " Opcion 3: Driver Controlador Galaxia                            \n"
        + " Opcion 4: Driver Galaxia 						\n"
        + " Opcion 5: Driver Controlador Ruta 					\n"
        + " Opcion 6: Driver Ruta			 			\n"
        + " Opcion 7: Driver Controlador Planeta				\n"
        + " Opcion 8: Driver Planeta 						\n"
        + " Opcion 9:  Driver Conexion						\n"
        + " Opcion 10: Driver Entrada 						\n"
        + " Opcion 11: Driver Arco   						\n"
        + " Opcion 12: Driver Salida 						\n"
        + " Opcion 13: Driver Controlador MFP					\n"
        
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
        DriverGalaxia DGalaxia = new DriverGalaxia();*/
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
        Ruta r = new Ruta();
        DriverPlaneta Dp = new DriverPlaneta();
        DriverControladorPlaneta DCP = new DriverControladorPlaneta();
        
         DriverEntrada De = new DriverEntrada();
	Entrada en = new Entrada();
         //Conexion
        DriverConexion Dc = new DriverConexion();
        Conexion c = new Conexion();

        int op= sc.nextInt();
        while (op != 0){
            switch(op)
            {
                case 1: DCNave.Executa(sc,cn,cp); break;  
                case 2: Dnave.Executa(sc); break;
                case 3: DGalaxia.Executa(cn,cp,cr); break;
                case 4: DCGalaxia.Executa(cp, cr, cn); break;
                case 5: DCRuta.Executa(cr, cp); break;
                case 6: DRuta.Executa(r); break;
                case 7:	DCP.Ejecuta(cr);break;
                case 8: Dp.Ejecuta();
                case 9: Dc.Executa(c);break;
                case 10: De.Executa(en, cg, cr, cp);break;
                case 11: Darco.Executa(sc);break;
                case 12: Dsalida.Executa(sc,cr,cg);break;
                case 13: dMFP.Executa(sc,cMFP,cg,cr,cp);break;
                default: System.out.println("Opcion incorrecta");                
            }
            opciones();
            op = sc.nextInt();
        }
    }   
}
