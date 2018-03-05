package DB;

import game.Score;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

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
        this.connexion();
    }

    private void connexion(){

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
             this.connexion= DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private boolean pseudoInDB(String pseudo){// si le pseudo est dans la db
        System.err.println("pseudo in db :"+pseudo);
        try {
            PreparedStatement stmt = connexion.prepareStatement("SELECT ID_user from user WHERE pseudo_user = ?");
            stmt.setString(1,pseudo);
           ResultSet reponse = stmt.executeQuery();
                boolean r =reponse.next();//on stocke le booleen avac de retouner la valeur pour fermer la connnection,et requete
                connexion.close();
            return r;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
    public void insert(String pseudo, Score scoreToInsrt){

        /*
        * Si le pseudo est dans la db.user :
        *           facile on met une ligne dans partie
        *   Sinon
        *           onrajoute une ligne dans user puis on ajoute une ligne dans partie
        *
        * */
        /*
        java.util.Date dateTime = new java.util.Date();
        SimpleDateFormat patern = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = patern.format(dateTime);
        */
        Date dateTime = new Date();
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime);

        if (!(pseudoInDB(pseudo))){
          //  INSERT INTO `user` (`ID_user`, `pseudo_user`) VALUES (NULL, 'peusdo')
            try {
                PreparedStatement preparedStatement =connexion.prepareStatement("INSERT INTO user (pseudo_user) VALUES (?)");
                preparedStatement.setString(1,pseudo);
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            try {
                PreparedStatement preparedStatement =connexion.prepareStatement("INSERT INTO partie (ID_user, " +
                        "date_heur_partie,nb_portes_traversees_partie," +
                        "nb_etoiles_ramassee_partie,score_partie ) " +
                        "VALUES ((SELECT ID_user from user WHERE pseudo_user = ?),NOW(),?,?,?)");
                preparedStatement.setString(1,pseudo);
                preparedStatement.setInt(2,scoreToInsrt.getNbrObstaclesCrossed());
                preparedStatement.setInt(3,scoreToInsrt.getNbEtoilesRamassees());
                preparedStatement.setInt(4, (int) scoreToInsrt.getScore());
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



    }




}
