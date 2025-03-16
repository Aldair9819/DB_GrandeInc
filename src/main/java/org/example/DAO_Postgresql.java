package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.tableinfo.columnsTable;

public class DAO_Postgresql implements DAO{
    private final Dotenv dotenv = Dotenv.load();
    private String name_db = dotenv.get("name_db");
    private final String user = dotenv.get("user");
    private final String password = dotenv.get("password");
    private String table_name = "gastos";
    private String[] columns = columnsTable.GASTOS.getColumns();;

    public DAO_Postgresql(String table_name) {
        /*
        this.table_name = table_name;

        switch(table_name){
            case "gastos":
                columns = columnsTable.GASTOS.getColumns();
                break;
            default:
                columns = new String[]{"id","nombre_compra", "cantidad", "metodo_pago", "fecha", "hora"};
                break;
        }
        */

    }



    @Override
    public Connection makeConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+name_db, user, password);
        return conn;
    }

    @Override
    public void create(String nombre_compra, double cantidad, String metodo_pago, String fecha, String hora) throws SQLException {
        Connection conn = makeConnection();
        Statement st = conn.createStatement();
        st.executeUpdate("INSERT INTO gastos (nombre_compra, cantidad, metodo_pago, fecha, hora) VALUES ('" + nombre_compra + "', " + cantidad + ", '" + metodo_pago + "', '" + fecha + "', '" + hora + "')");
        st.close();
    }

    @Override
    public void read(String table_name)  throws SQLException {
        Connection conn = makeConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM " + table_name);

        while (rs.next()) {
            for(int i = 0; i<rs.getMetaData().getColumnCount(); i++){
                System.out.print(rs.getString(i+1) + " ");
            }
            System.out.println();
        }
        rs.close();
        st.close();

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
