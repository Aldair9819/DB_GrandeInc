package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAO {
    Connection makeConnection() throws SQLException;
    //CRUD
    void create(String nombre_compra, double cantidad, String metodo_pago, String fecha, String hora) throws SQLException;
    void read(String table_name) throws SQLException;
    void update();
    void delete();
}
