package org.example;

import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) throws SQLException {
        final Dotenv dotenv = Dotenv.load();

        DAO_Postgresql dao = new DAO_Postgresql("gastos");

        //Crear un nuevo registro
        //dao.create("Paquetaxos", 50, "Efectivo".toUpperCase(), "2023-05-11", "13:10");

        //Leer todos los registros
        dao.read("gastos");

    }

}

