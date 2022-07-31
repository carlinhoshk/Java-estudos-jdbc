import java.sql.*;

public class SchemaInfo {

    public static void main(String[] args)  throws SQLException {

        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = null;
        String columnNamePattern = null;
        String[] types = null;

        Connection myConn = null;
        ResultSet myRs = null;

        try {

            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/demo", "student", "student");

            DatabaseMetaData databaseMetaData = myConn.getMetaData();

            System.out.println("Lista de Tabelas");
            System.out.println("----------------");

            myRs = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern,
                    types);

            while(myRs.next()){
                System.out.println(myRs.getString("TABLE_NAME"));
            }

            System.out.println("\n\nLista de Colunas");
            System.out.println("---------------");

            myRs = databaseMetaData.getColumns(catalog, schemaPattern, "employees", columnNamePattern);

            while (myRs.next()){
                System.out.println(myRs.getString("COLUMN_NAME"));
            }

        }catch (Exception exc){
            exc.printStackTrace();
        } finally {
            close(myConn, myRs);
        }
    }

    private static  void close(Connection myConn, ResultSet myRs){}
}
