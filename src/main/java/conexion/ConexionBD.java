/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL =
            "jdbc:sqlite:gestion.db";

    public static Connection getConnection()
            throws SQLException {
       Connection con = DriverManager.getConnection(URL);

try (Statement stmt = con.createStatement()) {
    stmt.execute("PRAGMA foreign_keys = ON");
}

return con;
    }

    public static void inicializar()
            throws SQLException {

        String sql = """
            CREATE TABLE IF NOT EXISTS personas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                identidad TEXT NOT NULL UNIQUE,
                nombre TEXT NOT NULL,
                apellido TEXT NOT NULL,
                telefono TEXT,
                correo TEXT,
                fecha_nacimiento TEXT
            )
            """;

        try (Connection con = getConnection();
             Statement stmt =
                     con.createStatement()) {

            stmt.execute(sql);
            String sqlEmpleados = """
    CREATE TABLE IF NOT EXISTS empleados (
        persona_id INTEGER PRIMARY KEY
            REFERENCES personas(id) ON DELETE CASCADE,
        codigo TEXT NOT NULL UNIQUE,
        puesto TEXT NOT NULL,
        salario REAL NOT NULL CHECK(salario > 0),
        fecha_ingreso TEXT NOT NULL
    )
    """;

stmt.execute(sqlEmpleados);
            System.out.println(
                "Base de datos inicializada correctamente"
            );
        }
    }
}
