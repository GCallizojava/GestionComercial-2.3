/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Geovanny_Callizo
 */
package dao;

import conexion.ConexionBD;
import modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoDAOImpl implements DAO<Empleado, Integer> {
  public void insertar(Empleado empleado) throws SQLException {
try (Connection con = ConexionBD.getConnection()) {

    con.setAutoCommit(false);
    try{
String sqlPersona = """
    INSERT INTO personas
    (identidad, nombre, apellido, telefono,
     correo, fecha_nacimiento)
    VALUES (?, ?, ?, ?, ?, ?)
    """;
PreparedStatement psPersona =
    con.prepareStatement(
        sqlPersona,
        Statement.RETURN_GENERATED_KEYS
    );
psPersona.setString(1, empleado.getIdentidad());
psPersona.setString(2, empleado.getNombre());
psPersona.setString(3, empleado.getApellido());
psPersona.setString(4, empleado.getTelefono());
psPersona.setString(5, empleado.getCorreo());
psPersona.setString(6, empleado.getFechaNacimiento());
psPersona.executeUpdate();
int personaId;

try (ResultSet rs = psPersona.getGeneratedKeys()) {
    if (rs.next()) {
        personaId = rs.getInt(1);
    } else {
        throw new SQLException(
            "No se pudo obtener el ID de la persona"
        );
    }
}
String sqlEmpleado = """
    INSERT INTO empleados
    (persona_id, codigo, puesto, salario, fecha_ingreso)
    VALUES (?, ?, ?, ?, ?)
    """;
PreparedStatement psEmpleado =
    con.prepareStatement(sqlEmpleado);
psEmpleado.setInt(1, personaId);
psEmpleado.setString(2, empleado.getCodigo());
psEmpleado.setString(3, empleado.getPuesto());
psEmpleado.setDouble(4, empleado.getSalario());
psEmpleado.setString(5, empleado.getFechaIngreso());

psEmpleado.executeUpdate();
con.commit();


}catch (SQLException e){
    con.rollback();
    throw e ;
    }
   }  
  }

    @Override
    public void actualizar(Empleado objeto) throws SQLException {
     try (Connection con = ConexionBD.getConnection()) {

    con.setAutoCommit(false);
try {
    String sqlPersona = """
        UPDATE personas
        SET identidad = ?,
            nombre = ?,
            apellido = ?,
            telefono = ?,
            correo = ?,
            fecha_nacimiento = ?
        WHERE id = ?
        """;
    PreparedStatement psPersona =
        con.prepareStatement(sqlPersona);

psPersona.setString(1, objeto.getIdentidad());
psPersona.setString(2, objeto.getNombre());
psPersona.setString(3, objeto.getApellido());
psPersona.setString(4, objeto.getTelefono());
psPersona.setString(5, objeto.getCorreo());
psPersona.setString(6, objeto.getFechaNacimiento());
psPersona.setInt(7, objeto.getId());

int filasPersona = psPersona.executeUpdate();

if (filasPersona != 1) {
    throw new SQLException("No se encontró la persona");
}
String sqlEmpleado = """
    UPDATE empleados
    SET codigo = ?,
        puesto = ?,
        salario = ?,
        fecha_ingreso = ?
    WHERE persona_id = ?
    """;

PreparedStatement psEmpleado =
        con.prepareStatement(sqlEmpleado);

psEmpleado.setString(1, objeto.getCodigo());
psEmpleado.setString(2, objeto.getPuesto());
psEmpleado.setDouble(3, objeto.getSalario());
psEmpleado.setString(4, objeto.getFechaIngreso());
psEmpleado.setInt(5, objeto.getId());

int filasEmpleado = psEmpleado.executeUpdate();

if (filasEmpleado != 1) {
    throw new SQLException("No se encontró el empleado");
}
con.commit();

} catch (SQLException e) {
    con.rollback();
    throw e;
}
}    
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
      try (Connection con = ConexionBD.getConnection()) {

    con.setAutoCommit(false);
try {
    String sqlEmpleado =
        "DELETE FROM empleados WHERE persona_id = ?";

    PreparedStatement psEmpleado =
        con.prepareStatement(sqlEmpleado);

    psEmpleado.setInt(1, id);

    int filasEmpleado = psEmpleado.executeUpdate();
    if (filasEmpleado != 1) {
    throw new SQLException("No se encontró el empleado");
}
    String sqlPersona =
    "DELETE FROM personas WHERE id = ?";

PreparedStatement psPersona =
    con.prepareStatement(sqlPersona);

psPersona.setInt(1, id);

int filasPersona = psPersona.executeUpdate();
if (filasPersona != 1) {
    throw new SQLException("No se encontró la persona");
}
con.commit();
} catch (SQLException e) {
    con.rollback();
    throw e;
}
      }
    }

    @Override
    public Optional<Empleado> buscarPorId(Integer id) throws SQLException {
         String sql = """
    SELECT p.id, p.identidad, p.nombre, p.apellido,
           p.telefono, p.correo, p.fecha_nacimiento,
           e.codigo, e.puesto, e.salario, e.fecha_ingreso
    FROM personas p
    INNER JOIN empleados e ON p.id = e.persona_id
    WHERE p.id = ?
    """;
         
         try (Connection con = ConexionBD.getConnection();
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setInt(1, id);
try (ResultSet rs = ps.executeQuery()) {

    if (rs.next()) {
        Empleado empleado = new Empleado(
    rs.getInt("id"),
    rs.getString("identidad"),
    rs.getString("nombre"),
    rs.getString("apellido"),
    rs.getString("telefono"),
    rs.getString("correo"),
    rs.getString("fecha_nacimiento"),
    rs.getString("codigo"),
    rs.getString("puesto"),
    rs.getDouble("salario"),
    rs.getString("fecha_ingreso")
     );
        return Optional.of(empleado);
    }
    }
 
        return Optional.empty();
        
    }

  }

    

    @Override
    public Optional<Empleado> buscarPorIdentidad(String identidad) throws SQLException {
         String sql = "SELECT p.id FROM personas p "
           + "INNER JOIN empleados e ON p.id = e.persona_id "
           + "WHERE p.identidad = ?";

try (Connection con = ConexionBD.getConnection();
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setString(1, identidad);

    try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
            return buscarPorId(rs.getInt("id"));
        }
    }
}

return Optional.empty();
    }

    @Override
    public List<Empleado> listar() throws SQLException {
       List<Empleado> empleados = new ArrayList<>();

String sql = "SELECT p.id FROM personas p "
           + "INNER JOIN empleados e ON p.id = e.persona_id "
           + "ORDER BY p.id";

try (Connection con = ConexionBD.getConnection();
     PreparedStatement ps = con.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {

    while (rs.next()) {
        Optional<Empleado> empleado =
                buscarPorId(rs.getInt("id"));

        if (empleado.isPresent()) {
            empleados.add(empleado.get());
        }
    }
}

return empleados;
    }
}