/**
 * @date: 07.jul.2023
 * @author: Angel Manuel Anguaya Otavalo
 * @description: Corrección del examen
 */
import java.io.IOException;
import java.util.Scanner;
import AACargaHorariaAlumnos.Horario;
import AAUtility.AAColor;
import AAUtility.AAUtilitario;

public class App {
    static Horario aaHorario = new Horario();
    private static String aaHorarioRutaDirectorio = ".\\Horarios";
    public static Scanner sc = new Scanner(System.in);

    static int aaCedula = 1005387319;
    static String aaCorreo = "angel.anguaya02@epn.edu.ec";
    static String aaNombre = "Angel Manuel Anguaya Otavalo";


    public static void main(String[] args) throws Exception{
        AAUtilitario.aaClear();
        aaHorario.aaReadHorarioAlumnos(aaHorarioRutaDirectorio);
        System.out.println(AAColor.YELLOW + "- CEDULA: " + aaCedula);
        System.out.println(AAColor.BLUE   + "- CORREO: " + aaCorreo.toUpperCase());
        System.out.println(AAColor.RED    +"- NOMBRE: " + aaNombre.toLowerCase());
        System.out.println(AAColor.BLUE);
        aaLogin();
        
    }

    /**
     * Sistema de logeo para el usuario.
     * @throws IOException
     */
    public static void aaLogin() throws IOException{
        int intentos = 3;
        String aaUsuario   = "profe";
        String aaPassword  = "1234";
        String aaUsuario1  = "angel.anguaya02@epn.edu.ec";
        String aaPassword1 = "1005387319";
        

        Scanner sc = new Scanner(System.in);

        while (intentos > 0) {

            System.out.println("............");
            System.out.print("+ Usuario: ");
            String usuario = sc.nextLine().trim();
            System.out.print("+ Clave: ");
            String password = sc.nextLine().trim();
            System.out.println("............");
            System.out.println();

            

            if (usuario.equals(aaUsuario) && password.equals(aaPassword)||usuario.equals(aaUsuario1) && password.equals(aaPassword1)) {
                System.out.println(":: Bienvenido "+ usuario.toUpperCase());
                AAUtilitario.aaClear();
                aaMenu(usuario);
                
            } else {
                intentos --;
                System.out.println("* Nro de intentos: "+ intentos);
            }
            
        }
        if (intentos == 0) {
            System.out.println("Lo sentimos tu usuario y clave son incorrectos...!");
        }
        sc.close();
    }

    /**
     * Menu que observa el usuario.
     * @param aaUsuario, nombre de la persona que se logeo.
     * @throws IOException
     */
    public static void aaMenu(String aaUsuario) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int aaMenuInicial;

        do {
            System.out.println("--------------------------");
            System.out.println("Carga horaria de alumnos");
            System.out.println("--------------------------");
            System.out.println("Usuario: "+ aaUsuario.toUpperCase());
            System.out.println("");
            System.out.println("1 Visualizar Alumnos");
            System.out.println("2 Visualizar Materia");
            System.out.println("3 Visualizar Horario");
            System.out.println("4 Visualizar Horario de una asignatura");
            System.out.println("0 SALIR");
            
            aaMenuInicial= AAUtilitario.aaGetNumeroPositivo("[<->] Seleccione una opcion: ");
        
            switch (aaMenuInicial) {
                case 1: AAUtilitario.aaClear();
                        System.out.println("[+] Listado de alumnos");
                        System.out.println();
                        aaHorario.aaShowAlumnos();
                break;
                case 2: AAUtilitario.aaClear();
                        System.out.println("[+] Listado de asignaturas de alumnos");
                        System.out.println();
                        aaHorario.aaShowAsignatura();
                    break;
                case 3:
                        aaHorario.aaShowHorario();
                    
                    break;
                case 4:
                        aaHorario.aaBuscar();
                    
                    break;
                    case 0: 
                            System.out.println("Vuelva pronto "+ aaUsuario.toUpperCase());
                            System.exit(aaMenuInicial);
                    break;
            
                default:
                    break;
            }
        } while (aaMenuInicial != 6);
        scanner.close();
        
    }
}
