import java.util.*;

// NECESITO 3 FUNCIONES DE PLANETA Y RUTA

public class DriverGalaxia {
     private Galaxia g;
     //private Planeta p;
     //private Ruta r;
     //private Nave n;
     
     public void Executa(ControladorNave cn) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n;
            System.out.print(
            "----------------------------------------------------------------------------------- \n"
            +   "                               DRIVER GALAXIA                                      \n"
            +   "----------------------------------------------------------------------------------- \n"
            + " Opcio 0: Sortir de la gestio del driver \n"
            + "\n CREACIÓN GALAXIA \n\n"
            + " Opcio 1: Crear una galaxia buida -> public Galaxia() \n"
            + " Opcio 2: Crear una galaxia amb nom i limit -> public Galaxia(String nom, int n) \n"       
            + " Opcio 3: Crear una galaxia amb nom, limit, limits imposats per l'usuari i presupost -> public "
            + "Galaxia(String nom, int n, List<Pair<Integer, Integer> > l, int p) \n"      
            + "\n OPERACIONES DE CONSULTA DE GALAXIA \n\n"
            + " Opcio 4: Consultar el nom de l'ultima galaxia creada -> public String consultarNomGalaxia() \n"       
            + " Opcio 5: Consultar el presupost de l'ultima galaxia creada -> public int consultarPresupost() \n"     
            + " Opcio 6: Consultar els planetes de l'ultima galaxia creada -> public ArrayList<String> "
            + "consultarPlanetes() \n"     
            + " Opcio 7: Consultar el numero de planetes que te l'ultima galaxia creada -> "
            + "public int consulta_nombrePlanetes() \n"    
            + " Opcio 8: Consultar el numero de coordenades introduides per l'usuari de la ultima galaxia creada -> "
            + "public int consulta_nombreLimits() \n"      
            + " Opcio 9: Consultar les rutes de la ultima galaxia creada -> public ArrayList<String> consultarRutes() \n"
            + " Opcio 10: Consultar el numero de rutes que te l'ultima galaxia creada -> public int "
            + "consulta_nombreRutes() \n"
            + " Opcio 11: Consultar les naus que conte la ultima galaxia creada -> public "
            + "ArrayList<String> consultarNaus() \n"
            + " Opcio 12: Consultar el numero de naus que te l'ultima galaxia creada -> public int "
            + "consulta_nombreNaus() \n"
            + " Opcio 13: Consultar el limit de la galaxia -> public int consultarLimitGalaxia() \n"
            + " Opcio 14: Indica si existeix un planeta en unes coordenades -> public "
            + "boolean existeixPlanetaCoordenades(int x, int y) \n"
            + " Opcio 15: Consultar un planeta determinat de l'ultima galaxia creada -> public Planeta "
            + "consultarPlaneta(String nomplaneta) \n"
            + " Opcio 16: Indica si existeix un planeta determinat en l'ultima galaxia creada -> public boolean "
            + "existeixPlaneta(String nomplaneta) \n"
            + " Opcio 17: Consultar una ruta determinada de l'ultima galaxia creada -> public "
            + "Ruta consultarRuta(String nomruta) \n"
            + " Opcio 18: Indica si existeix una ruta determinada en la ultima galaxia creada -> public boolean "
            + "existeixRuta(String nomruta) \n"
            + " Opcio 19: Consultar una nau determinada de l'ultima galaxia creada -> public Nau "
            + "consultarNau(String nomnau) \n"
            + " Opcio 20: Indica si existeix una nau determinada en la ultima galaxia creada -> public boolean "
            + "existeixNau(String nomnau) \n"
            + "\n OPERACIONES MODIFICADORES DE GALAXIA \n\n"
            + " Opcio 21: Modificar el nom de l'ultima galaxia creada -> public void modificar_nomGalaxia(String nom) \n"
            + " Opcio 22: Modificar el presupost de l'ultima galaxia creada -> public void modificarPresupost(int p) \n"
            + " Opcio 23: Modificar el limit de l'ultima galaxia creada -> public void modificarN(int n) \n"
            + " Opcio 24: Afegir un planeta en la galaxia -> public void afegirPlaneta(Planeta p) \n"
            + " Opcio 25: Agegir automaticament un planeta en la galaxia -> public void "
            + "afegirPlanetaAutomatic(Planeta p) \n"
            + " Opcio 26: Eliminar un planeta determinat de l'ultima galaxia creada -> public void "
            + "eliminarPLaneta(String nomplaneta) \n"
            + " Opcio 27: Eliminar tots els planetes de la galaxia -> public void eliminarTotsPlanetes() \n"
            + " Opcio 28: Afegir una nau en la galaxia -> public void afegirNau(Nau n) \n"
            + " Opcio 29: Eliminar una nau determinada de la galaxia -> public void eliminarNau(String nomnau) \n"
            + " Opcio 30: Eliminar totes les naus de la galaxia -> public void eliminarTotesNaus() \n"
            + " Opcio 31: Afegir una ruta determinada en la galaxia -> public void afegirRuta(Ruta r) \n"
            + " Opcio 32: Eliminar una ruta determinada de la galaxia -> public void eliminarRuta(String nomruta) \n"
            + " Opcio 33: Eliminar totes les rutes de la galaxia -> public void eliminarTotesRutes() \n"
            + " Opcio 34: Eliminar tot el contingut de la galaxia -> public void eliminarContingutGalaxia() \n"
            + " Opcio 35: Consulta els limits de la galaxia imposats per l'usuari -> List<Pair<Integer, Integer>> consultarValorLimits() \n");
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1: TestCrearGalaxiaBuida();break;
            case 2: TestCrearGalaxia2(cin);break;
            case 3: TestCrearGalaxia3(cin);break;
            case 4: TestConsultarNomGalaxia();break;
            case 5: TestConsultarPresupuesto();break;
            case 6: TestconsultarPlanetes();break;
            case 7: Testconsulta_nombrePlanetes();break;
            case 8: Testconsulta_nombreLimits();break;
            case 9: TestconsultarRutes();break;
            case 10: Testconsulta_nombreRutes();break;
            case 11: TestconsultarNaus();break;
            case 12: Testconsulta_nombreNaus();break;
            case 13: TestconsultarLimitGalaxia();break;
            case 14: TestexisteixPlanetaCoordenades(cin);break;
            case 15: TestconsultarPlaneta(cin);break;
            case 16: TestexisteixPlaneta(cin);break;
            case 17: TestconsultarRuta(cin);break;
            case 18: TestexisteixRuta(cin);break;
            case 19: TestconsultarNau(cin);break;
            case 20: TestexisteixNau(cin);break;
            case 21: Testmodificar_nomGalaxia(cin);break;
            case 22: TestmodificarPresupost(cin);break;
            case 23: TestmodificarN(cin);break;
            //case 24: TestafegirPlaneta(cin,cp);break;
            //case 25: TestafegirPlanetaAutomatic(cin,cp);break;
            // case 26: TesteliminarPLaneta(cin,cp);break;
            case 27: TesteliminarTotsPlanetes();break;
            case 28: TestafegirNau(cin,cn);break;
            case 29: TesteliminarNau(cin,cn);break;
            case 30: TesteliminarTotesNaus();break;
            //case 31: TestafegirRuta(cin,cr);break;
            //case 32: TesteliminarRuta(cin,cr);break;
            case 33: TesteliminarTotesRutes();break;
            case 34: TesteliminarContingutGalaxia();break;
            case 35: TestconsultaLimitsUsuari();break;
            default: System.out.println("Opcio incorrecte");
            }
            n = cin.nextInt();
        }
    }

	public void TestCrearGalaxiaBuida()
    {
        g = new Galaxia();
        System.out.println("Galaxia vacia creada correctamente");
    }
     
    public void TestCrearGalaxia2(Scanner cin) throws Exception
    {
        try{
        	System.out.println("Introduce nombre");
            String n = cin.next();
            System.out.println("Introduce limite");
            int n1 = cin.nextInt();
            g = new Galaxia(n,n1);
            System.out.println("Galaxia creada correctamente");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestCrearGalaxia3(Scanner cin)
    {
        try{
        	System.out.println("Introduce nombre");
            String n = cin.next();
            System.out.println("Introduce limite");
            int n1 = cin.nextInt();
            System.out.println("Introduce presupuesto");
            int p = cin.nextInt();
            List<Pair<Integer, Integer> > pa1 = new ArrayList<Pair<Integer, Integer> >();
            Integer a, b;
            int pa_f, pa_s;
            System.out.println("Introduce primera coordenada");
            pa_f = cin.nextInt();
            System.out.println("Introduce segunda coordenada");
            pa_s = cin.nextInt();
            while(pa_f != -1 && pa_s != -1) { // Si lee -1,-1 de coordenadas deja de leer
            	a = new Integer(pa_f);
            	b = new Integer(pa_s);
            	Pair<Integer, Integer> pa = new Pair<Integer, Integer>(a, b);
            	pa1.add(pa);
            	System.out.println("Introduce primera coordenada");
                pa_f = cin.nextInt();
                System.out.println("Introduce segunda coordenada");
                pa_s = cin.nextInt();	
            }
            g = new Galaxia(n,n1,pa1,p);
            System.out.println("Galaxia creada correctamente");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestConsultarNomGalaxia() 
    {
            String s = g.consultarNomGalaxia();
            System.out.println("El nombre de la galaxia es: " + s);
    }
     
    public void TestConsultarPresupuesto() 
    {
    	try{
            int s = g.consultarPresupost().intValue();
            System.out.println("El presupuesto de la galaxia es: " + s);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestconsultarPlanetes()
    {
        try{
            ArrayList<Integer> ar = g.consultarPlanetes();
            System.out.print("Planetas existentes: ");
            for(Integer pl : ar) {
                System.out.println(pl + ",");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void Testconsulta_nombrePlanetes()
    {
        int p = g.consulta_nombrePlanetes();
        System.out.println("El numero de planetas en la galaxia es: " + p);
    }
     
    public void Testconsulta_nombreLimits()
    {
        int p = g.consulta_nombreLimits();
        System.out.println("Numero de coordenadas introducidas por el usuario: " + p);
    }
     
    public void TestconsultarRutes()
    {
        try{
            ArrayList<Integer> ar = g.consultarRutes();
            System.out.print("Rutas existentes: ");
            for(Integer pl : ar) {
                System.out.println(pl + ",");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void Testconsulta_nombreRutes()
    {
        int p = g.consulta_nombreRutes();
        System.out.println("Numero de rutas en la galaxia es: " + p);
    }
     
    public void TestconsultarNaus()
    {
        try{
            ArrayList<Integer> ar = g.consultarNaus();
            System.out.print("Naves existentes: ");
            for(Integer pl : ar) {
                System.out.println(pl + ",");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void Testconsulta_nombreNaus()
    {
        int p = g.consulta_nombreNaus();
        System.out.println("Numero de naves en la galaxia: " + p);
    }
     
    public void TestconsultarLimitGalaxia()
    {
        int p = g.consultarLimitGalaxia().intValue();
        System.out.println("El limit de la galaxia es: " + p);
    }
     
    public void TestexisteixPlanetaCoordenades(Scanner cin)
    {  
    	try{
    		System.out.println("Introduce primera coordenada");
	    	int cX = cin.nextInt();
	    	System.out.println("Introduce segunda coordenada");
	    	int cY = cin.nextInt();
	    	boolean exist = g.existeixPlanetaCoordenades(cX, cY);
	    	if(exist) System.out.println("Existe un planeta en la galaxia con esas coordenadas");
	    	else System.out.println("No existe ningun planeta en la galaxia con esas coordenadas");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestconsultarPlaneta(Scanner cin)
    {
    	try{
    		System.out.println("Introduce el identificador del planeta");
	    	int idPlaneta = cin.nextInt();
	    	Planeta a = g.consultarPlaneta(idPlaneta);
	    	System.out.println("El planeta con id: " + idPlaneta + "tiene como atributos: "
	    						+ "- Capacidad: " + a.Consultar_Capacidad() + "\n"
	    						+ "- Coste: " + a.Consultar_Coste() + "\n"
	    						+ "- Coordenadas: (" + a.consultar_X() + ", " + a.consultar_Y() + ")\n");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestexisteixPlaneta(Scanner cin)
    {
    	try{
    		System.out.println("Introduce el identificador del planeta");
	    	int idPlaneta = cin.nextInt();
	    	boolean b = g.existeixPlaneta(idPlaneta);
	    	if(b) System.out.println("El planeta con id: " + idPlaneta + " existe en la galaxia");
	    	else System.out.println("El planeta con id: " + idPlaneta + " no existe en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestconsultarRuta(Scanner cin)
    {
    	try {
    		System.out.println("Introduce el identificador de la ruta");
	    	int idRuta = cin.nextInt();
	    	Ruta r = g.consultarRuta(idRuta);
	    	System.out.println("La ruta con id: " + idRuta 
	    						+ "\n tiene como capacidad: " + r.consultar_capacidad()
	    						+ "\n tiene como distancia: " + r.consultar_distancia()
	    						+ "\n conecta los planetas: " + r.consultar_planetaA() + " y " + r.consultar_planetaB());
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestexisteixRuta(Scanner cin)
    {
    	try{
    		System.out.println("Introduce el identificador de la ruta");
	    	int idRuta = cin.nextInt();
	    	boolean b = g.existeixRuta(idRuta);
	    	if(b) System.out.print("La ruta con id: " + idRuta + " existe en la galaxia");
	    	else System.out.print("La ruta con id: " + idRuta + " existe en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestconsultarNau(Scanner cin)
    {
	    try{
	    	System.out.println("Introduce el identificador de la nave");
    		int idNave = cin.nextInt();
	    	Nave n = g.consultarNau(idNave);
	    	System.out.println("La nave con id: " + idNave
	    						+ "\n tiene como Tipo: " + n.consultar_tipo()
	    						+ "\n tiene como destino: " + n.consultar_destino());
	    }
	    catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestexisteixNau(Scanner cin)
    {
    	try{
    		System.out.println("Introduce el identificador de la ruta");
	    	int idNave = cin.nextInt();
	    	boolean b = g.existeixNau(idNave);
	    	if(b) System.out.print("La nave con id: " + idNave + " existe en la galaxia");
	    	else System.out.print("La nave con id: " + idNave + " existe en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void Testmodificar_nomGalaxia(Scanner cin)
    {
    	try{
    		System.out.println("Introduce nombre");
	    	String nouNom = cin.next();
	    	g.modificar_nomGalaxia(nouNom);
	    	System.out.println("El nuevo nombre de galaxia es: " + g.consultarNomGalaxia());
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestmodificarPresupost(Scanner cin)
    {
	    try{
	    	System.out.println("Introduce el valor del presupuesto");
    		int pr = cin.nextInt();
	    	g.modificarPresupost(pr);
	    	System.out.println("El nuevo presupuesto de galaxia es: " + g.consultarPresupost());
	    }
	    catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestmodificarN(Scanner cin)
    {
    	try{
    		System.out.println("Introduce el nuevo limite");
	    	int n1 = cin.nextInt();
	    	g.modificarN(n1);
	    	System.out.println("El nuevo limite de la galaxia es: " + g.consultarLimitGalaxia());
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    /*public void TestafegirPlaneta(Scanner cin, ControladorPlaneta cp) // NECESITO UNAS FUNCIONES
    {
    	try{
    		System.out.print("Introduce el identificador del planeta");
	    	int idPlaneta = cin.nextInt();
	    	int cX, cY, capa, cost;
	    	if(!cp.existeixPlaneta(idPlaneta)) cp.crearPlanetaAuto(idPlaneta); // Si no existe lo creo
	    	p = cp.consultarPlaneta(idPlaneta);
	    	cost = cin.nextInt();
	    	p.Modificar_Coste(cost);
	    	cX = cin.nextInt();
	    	cY = cin.nextInt();
	    	p.modificarCoordenades(cX, cY);
	    	g.afegirPlaneta(p);
	    	System.out.println("El planeta fue añadido correctamente");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestafegirPlanetaAutomatic(Scanner cin, ControladorPlaneta cp)
    {	
    	
    }*/
     
    /*public void TesteliminarPLaneta(Scanner cin, ControladorPlaneta cp)
    {
    	try{
    		System.out.print("Introduce el identificador del planeta a borrar");
	    	int idPlaneta = cin.nextInt();
	    	g.eliminarPLaneta(idPlaneta);
	    	System.out.println("Planeta borrado correctamente");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }*/
     
    public void TesteliminarTotsPlanetes()
    {
    	try{
	    	g.eliminarTotsPlanetes();
	    	System.out.println("Todos los planetas fueron borrados");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestafegirNau(Scanner cin, ControladorNave cn)
    {
    	try{
    		System.out.print("Introduce el identificador de la nave");
	    	int idNave = cin.nextInt();
	    	if(!cn.ExisteNave(idNave)) cn.CrearNaveAuto(idNave);
	    	Nave n = cn.BuscarNave(idNave);
	    	g.afegirNau(n);
	    	System.out.println("La nave fue añadida correctamente");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarNau(Scanner cin, ControladorNave cn)
    {
    	try{
    		System.out.print("Introduce el identificador de la nave a borrar");
	    	int idNave = cin.nextInt();
	    	g.eliminarNau(idNave);
	    	System.out.println("La nave fue borrada correctamente");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarTotesNaus()
    {
    	try{
	    	g.eliminarTotesNaus();
	    	System.out.println("Se borraron todas las naves de la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    /*public void TestafegirRuta(Scanner cin, ControladorRuta cr)
    {
    	try{
    		System.out.print("Introduce el identificador de la ruta");
	    	int idRuta = cin.nextInt();
	    	if(!cr.ExisteRuta(idRuta)) cr.CrearRuta_automatica(idRuta);
	    	r = cr.BuscarRuta(idRuta);
	    	g.afegirRuta(r);
	    	System.out.println("La ruta se ha añadido correctamente");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }*/
     
    /*public void TesteliminarRuta(Scanner cin, ControladorRuta cr)
    {
    	try{
    		System.out.print("Introduce el identificador de la ruta a borrar");
	    	int idRuta = cin.nextInt();
	    	g.eliminarRuta(idRuta);
	    	System.out.println("La ruta fue borrada correctamente");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }*/
     
    public void TesteliminarTotesRutes()
    {
    	try{
	    	g.eliminarTotesRutes();
	    	System.out.println("Se borraron todas las rutas de la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarContingutGalaxia()
    {
    	try{
	    	g.eliminarContingutGalaxia();
	    	System.out.println("Se borro todo el contenido de la galaxia (planetas, rutas y naves)");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void TestconsultaLimitsUsuari() 
    {
    	System.out.println("Coordenadas limite de la galaxia:");
		List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
		for(int i = 0; i < lp.size(); ++i) {
			System.out.println("(" + lp.get(i).getFirst() + ", " + lp.get(i).getSecond() + ")");
		}
	}
   
}
