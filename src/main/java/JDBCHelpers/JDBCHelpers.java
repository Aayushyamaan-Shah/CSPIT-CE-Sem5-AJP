import com.sun.istack.internal.Nullable;

import java.sql.*;

public class JDBCHelpers {

    @SuppressWarnings(Unused)
    public Connection getConnection(String url, String username, String password, @Nullable String database) {
        try{
            if(database != null) return DriverManager.getConnection(url+"/"+database, username, password);
            else return DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            System.out.println("ERROR: Cannot create connection object.");
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection(String url, String username, String password) {
        return getConnection(url, username, password, null);
    }

    public static ResultSet getScrollableResultSet(Connection connection){
        try{
            return (ResultSet) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch (SQLException e){
            System.out.println("ERROR: Cannot create scrollable result set.");
            e.printStackTrace();
        }
        return null;
    }

    public static int getRowCount(ResultSet resultSet){
        int toReturn = -1;
        try{
            System.out.println("Original position: "+resultSet.getRow());
            int currentPosition = resultSet.getRow();
            resultSet.last();
            toReturn = resultSet.getRow();
            resultSet.absolute(currentPosition);
            System.out.println("New position: "+resultSet.getRow());
        }catch (SQLException e){
            System.out.println("The result set either forward only or some other error occurred.");
            e.printStackTrace();
        }
        return toReturn;
    }

    public static void printResultSetData(ResultSet resultSet){
        try{
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if(columnCount > 0){
                for(int i = 0; i < columnCount; i++){
                    System.out.print(metaData.getColumnLabel(i)+"\t");
                }
                System.out.println();
                while(resultSet.next()){
                    for(int i =0; i < columnCount; i++){
                        System.out.print(resultSet.getString(i));
                    }
                    System.out.println();
                }
            }
        }catch (SQLException e){
            System.out.println("Some error occurred while printing.");
            e.printStackTrace();
        }
    }
}
