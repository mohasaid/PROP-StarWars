import java.util.Scanner;
  
public class DriverGeneral
{
    private static void opciones()
    {
        // menu telescopic
        System.out.println(
         "OPCIONES \n"
        + " Opcion 0:  Salir gestion drivers                                \n"
        + " Opcion 1:  Driver Controlador nave                              \n"
        + " Opcion 2:  Driver Nave                                          \n"
        + " Opcion 3:  Driver Controlador Galaxia                           \n"
        + " Opcion 4:  Driver Galaxia 										\n"
        + " Opcion 5:  Driver Controlador Ruta 								\n"
        + " Opcion 6:  Driver Ruta			 								\n"
        + " Opcion 7:  Driver Controlador Planeta							\n"
        + " Opcion 8:  Driver Planeta 										\n"
        + " Opcion 9:  Driver Conexion										\n"
        + " Opcion 10: Driver Entrada 										\n"
		);
    }
      
    public static void main(String[] args) throws Exception {
        opciones();
        Scanner sc = new Scanner(System.in);
        
        DriverControladorNave DCNave = new DriverControladorNave();
        DriverNave Dnave = new DriverNave();
        // Galaxia
        DriverControladorGalaxia DCGalaxia = new DriverControladorGalaxia();
        DriverGalaxia DGalaxia = new DriverGalaxia();
        
        ControladorNave cn = new ControladorNave();
        ControladorPlaneta cp = new ControladorPlaneta();
        ControladorRuta cr = new ControladorRuta();
        
        //Ruta (controlador ruta ya esta creado)
        DriverRuta DRuta = new DriverRuta();
        DriverControladorRuta DCRuta = new DriverControladorRuta(); 
        Ruta r = new Ruta();
        
        DriverPlaneta Dp = new DriverPlaneta();
        DriverControladorPlaneta DCP = new DriverControladorPlaneta();
        
        DriverEntrada De = new DriverEntrada();
        Entrada en = new Entrada();
        ControladorGalaxia cg = new ControladorGalaxia();
        
        DriverConexion Dc = new DriverConexion();
        Conexion c = new Conexion();
        
        int op= sc.nextInt();
        while (op != 0){
            switch(op)
            {
                //case 1: DCNave.Executa(sc,cn,cp); break;  
                case 2: Dnave.Executa(sc); break;
                
                case 3: DGalaxia.Executa(cn,cp,cr); break;
                case 4: DCGalaxia.Executa(cp, cr, cn); break;
                
                case 5: DCRuta.Executa(cr, cp); break;
                case 6: DRuta.Executa(r); break;
                
                case 7:	DCP.Ejecuta(cr);break;
                case 8: Dp.Ejecuta();break;
                
                case 9: De.Executa(en, cg, cr, cp);break;
                
                case 10: Dc.Executa(c);break;
                
                default: System.out.println("Opcion incorrecta");                
            }
            opciones();
            op = sc.nextInt();
        }
    }   
}
