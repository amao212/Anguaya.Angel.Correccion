package AACargaHorariaAlumnos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Horario extends HorarioBase implements IGestionarArchivoHorario{
    public static Scanner sc = new Scanner(System.in);

    @Override
    public void aaReadHorarioAlumnos(String aaDirectorioHorarios) {
        
    }

    /**
     * Muestra el codigo, el paralelo y la materia de los alumnos.
     */
    @Override
    public void aaShowAsignatura() {
        String aaArchivo= ".\\Horarios";
        File aaCarpeta = new File(aaArchivo);
        File[] aaFiles = aaCarpeta.listFiles((aaDirectorio,aaNombre)->aaNombre.endsWith(".csv"));

        if (aaFiles != null) {
            for (File aaFile : aaFiles) {
                try (BufferedReader aaRead = new BufferedReader(new FileReader(aaFile))){
                    String aaLinea;
                    while ((aaLinea = aaRead.readLine()) != null) {
                        HorarioFormato hf = new HorarioFormato();
                        String[] aaDatos = aaLinea.split(";");
                        hf.aaCodigo     = aaDatos[1];
                        hf.aaMateria    = aaDatos[2];
                        hf.aaParelelo   = aaDatos[3];
                        hf.aaAula       = aaDatos[4];
                        hf.aaCreditos   = aaDatos[5];
                        System.out.println("-"+hf.aaCodigo+"-"+ hf.aaParelelo+" "+hf.aaMateria);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }

    }

    /**
     * Muestra los nombres de los alumnos.
     */
    @Override
    public void aaShowAlumnos() {

        String aaRutaCarpeta = ".\\Horarios";
        File aaCarpeta = new File(aaRutaCarpeta);
        if (aaCarpeta.exists() && aaCarpeta.isDirectory()) {
            File[] aaArchivos = aaCarpeta.listFiles();
            if (aaArchivos != null) {
                for (File aaFile : aaArchivos) {
                    if (aaFile.isFile()) {
                        String aaNombreArchivo = aaFile.getName();
                        String aaAlumos = aaNombreArchivo.substring(0,aaNombreArchivo.length()-4);
                        System.out.println("-"+ aaAlumos);
                    }
                }
                
            }
        }


    }
    
    /**
     * Muestra el horario de cada alumno.
     */
    public void aaShowHorario(){
        String aaArchivo= ".\\Horarios";
        File aaCarpeta = new File(aaArchivo);
        File[] aaFiles = aaCarpeta.listFiles((aaDirectorio,aaNombre)->aaNombre.endsWith(".csv"));

        if (aaFiles != null) {
            for (File aaFile : aaFiles) {
                try (BufferedReader aaRead = new BufferedReader(new FileReader(aaFile))){
                    String aaLinea;
                    System.out.println("Archivo: "+ aaFile);
                    while ((aaLinea = aaRead.readLine()) != null) {
                        HorarioFormato hf = new HorarioFormato();
                        String[] aaDatos = aaLinea.split(";");
                        hf.aaHoraLunes      = aaDatos[6];
                        hf.aaHoraMartes     = aaDatos[7];
                        hf.aaHoraMiercoles  = aaDatos[8];
                        hf.aaHoraJueves     = aaDatos[9];
                        hf.aaHoraViernes    = aaDatos[10];
                        hf.aaHoraSabado     = aaDatos[11];
                        
                        System.out.println(hf.aaHoraLunes+"\t"+ hf.aaHoraMartes+"\t"+hf.aaHoraMiercoles+"\t"+hf.aaHoraJueves+"\t"+hf.aaHoraViernes+"\t"+hf.aaHoraSabado);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }

    /**
     * Ayuda a buscar mediante el código las asignaturas.
     */    
    public void aaBuscar(){
        String aaDirectorio = ".\\Horarios";
        System.out.print("[+] Ingresa el codigo a buscar: ");
        String aaBuscar = sc.nextLine().trim();
        System.out.println(">>> Codigo: "+ aaBuscar);
        File aaCarpeta = new File(aaDirectorio);
        File[] aaFiles = aaCarpeta.listFiles();
        if (aaFiles != null) {
            for (File aaFile : aaFiles) {
                if (aaFile.isFile() && aaFile.getName().endsWith(".csv")) {
                    System.out.println("Archivo: "+ aaFile.getName());
                    try (BufferedReader aa = new BufferedReader(new FileReader(aaFile))){
                        String aaLinea;
                        while ((aaLinea = aa.readLine()) != null) {
                            if (aaLinea.contains(aaBuscar)) {
                                aaLinea = aaLinea.replace(";", " ");
                                System.out.println(aaLinea);
                            }
                        }
                        System.out.println();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            
        }

    }
}
