import java.util.Scanner;
  
public class DriverGeneral
{
    private static void opciones()
    {
        // menu telescopic
        System.out.println(
         "OPCIONES \n"
        + " Opcio 0: Sortir                                                \n"
        + " Opcio 1: Driver Controlador nave                               \n"
        + " Opcio 2: Driver Nave                                           \n"
        + " Opcio 3: Driver Galaxia                                        \n");
    }
      
    public static void main(String[] args) {
        opciones();
        Scanner sc = new Scanner(System.in);
        DriverControladorNave DCNave = new DriverControladorNave();
        DriverNave Dnave = new DriverNave();
        DriverGalaxia DGalaxia = new DriverGalaxia();
       ControladorNave cn = new ControladorNave();
       ControladorPlaneta cp = new ControladorPlaneta();
       ControladorRuta cr = new ControladorRuta();
          
          
          
        int op= sc.nextInt();
        while (op != 0){
            switch(op)
            {
                case 1: DCNave.Executa(cn,cp); break;  
                case 2: Dnave.Executa(); break;
                case 3: DGalaxia.Executa(cp,cr,cn); break;
                default: System.out.println("Opción incorrecta");                
            }
            opciones();
            op = sc.nextInt();
        }
    }   
}
