package org.example.tableinfo;

public enum columnsTable {

    GASTOS(new String[ ]{"id","nombre_compra", "cantidad", "metodo_pago", "fecha", "hora"});
    private final String[] columns;

    columnsTable(String[] columns){
        this.columns = columns;
    }

    public String[] getColumns(){
        return columns;
    }





}
