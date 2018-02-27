package DB;

import java.sql.*;

/**
 * @autor Vincent
 * @date 26/02/2018
 */
public class GestionDB {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_NAME="ColorSwitch";
    private static final String DB_URL = "jdbc:mysql://localhost:8889/"+DB_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    private Connection connexion;


    public GestionDB() {
       this.connexion= connexion();
    }

    private static Connection connexion(){
        Connection c =null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
             c = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return c;

    }
    private boolean pseudoInDB(String pseudo){// si le pseudo est dans la db
        System.err.println("pseudo in db :"+pseudo);
        try {
            PreparedStatement stmt = connexion.prepareStatement("SELECT ID_user from user WHERE pseudo_user = ?");
            stmt.setString(1,pseudo);
           ResultSet reponse = stmt.executeQuery();

            connexion.close();
            return reponse.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
    public void insert(String pseudo,double score){
        /*
        * Si le pseudo est dans la db.user :
        *           facile on met une ligne dans partie
        *   Sinon
        *           onrajoute une ligne dans user puis on ajoute une ligne dans partie
        *
        * */

    }




}
