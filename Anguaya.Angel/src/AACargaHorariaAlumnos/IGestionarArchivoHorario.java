package AACargaHorariaAlumnos;

import java.io.IOException;

public interface IGestionarArchivoHorario {
    public void aaReadHorarioAlumnos(String aaDirectorioHorarios);
    public void aaShowAsignatura() throws IOException;
    public void aaShowAlumnos();
}
