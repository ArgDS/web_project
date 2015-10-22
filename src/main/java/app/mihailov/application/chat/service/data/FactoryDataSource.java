package app.mihailov.application.chat.service.data;



import java.sql.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;


/**
 * Created by Дмитрий
 * Date: 22.10.2015.
 */
public class FactoryDataSource {


    private static String classDriverJDBC;
    private static String protocol;
    private static String host;
    private static String port;
    private static String user;
    private static String password;
    private static String nameDatabase;
    private static String urlConnection;
    private static Connection connection;
    private static final Object instance;
    static {
        instance = new FactoryDataSource();
    }

    private FactoryDataSource(){

    }

    public static void init(String classDriverJDBC, String protocol,String host, String port, String user, String password, String nameDataBase){
        FactoryDataSource.classDriverJDBC = classDriverJDBC;
        FactoryDataSource.protocol = protocol;
        FactoryDataSource.host = host;
        FactoryDataSource.port = port;
        FactoryDataSource.user = user;
        FactoryDataSource.password = password;
        FactoryDataSource.nameDatabase = nameDataBase;

        try {
            ClassLoader.getSystemClassLoader().loadClass(classDriverJDBC);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("\n--- Не найден класс драйвера jdbc ---");
            System.exit(1);
        }

        urlConnection = "jdbc:" + FactoryDataSource.protocol + "://" + FactoryDataSource.host + ":" + FactoryDataSource.port + "/" + FactoryDataSource.nameDatabase;
        try {
            connection = DriverManager.getConnection(urlConnection, FactoryDataSource.user, FactoryDataSource.password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n--- Соединение с базой данных не установлено ---");
            System.exit(1);
        }
    }

    public static void destroy(){
        try {
            FactoryDataSource.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStatement(){
        synchronized (instance) {
            try {
                return connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static PreparedStatement getPraperedStatement(String sqlQuery){
        synchronized (instance){
            try{
                return connection.prepareStatement(sqlQuery);
            }catch(SQLException ex){
                ex.printStackTrace();
                return null;
            }
        }
    }

    public static CallableStatement getCallableStatement(String callQuery){
        synchronized (instance){
            try{
                return connection.prepareCall(callQuery);
            }catch(SQLException ex){
                ex.printStackTrace();
                return null;
            }
        }
    }



}
