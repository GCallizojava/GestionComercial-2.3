/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;
import dao.EmpleadoDAOImpl;
import modelo.Empleado;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Geovanny_Callizo
 */
public class EmpleadoServicio {

    private final EmpleadoDAOImpl empleadoDAO;

    public EmpleadoServicio() {
        empleadoDAO = new EmpleadoDAOImpl();
    }

    public List<Empleado> listarOrdenados()
            throws SQLException {

        return empleadoDAO.listar();
    }
    public void guardar(Empleado empleado)
        throws SQLException {

    empleadoDAO.insertar(empleado);

}
    public void actualizar(Empleado empleado)
        throws SQLException {

    empleadoDAO.actualizar(empleado);
}
    public void eliminar(int id)
        throws SQLException {

    empleadoDAO.eliminar(id);
}public java.util.Optional<Empleado> buscarPorIdentidad(
        String identidad) throws SQLException {

    return empleadoDAO.buscarPorIdentidad(identidad);
}
}






















