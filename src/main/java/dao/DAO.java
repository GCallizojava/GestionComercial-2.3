/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import java.util.Optional;
import java.sql.SQLException;
public interface DAO<T, ID> {

    void insertar(T objeto) throws SQLException;

void actualizar(T objeto) throws SQLException;

void eliminar(ID id) throws SQLException;

Optional<T> buscarPorId(ID id) throws SQLException;

Optional<T> buscarPorIdentidad(String identidad)
        throws SQLException;

List<T> listar() throws SQLException;
}
