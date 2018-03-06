package DB;

import game.Score;

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
        this.connexion();
    }


    private void connexion(){
        try {
            if (this.connexion==null||this.connexion.isClosed()) {
                    Class.forName(JDBC_DRIVER);
                    this.connexion = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param pseudo
     * @return
     */
    private boolean pseudoInDB(String pseudo){// si le pseudo est dans la db
        System.err.println("pseudo in db : "+pseudo);
        try {
            connexion();
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

    /**
     *
     * @param pseudo
     * @param scoreToInsrt
     */
    public void insert(String pseudo, Score scoreToInsrt){



        if (!(pseudoInDB(pseudo))) {
            try {
                connexion();
                PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO user (pseudo_user) VALUES (?)");
                preparedStatement.setString(1, pseudo);
                preparedStatement.executeUpdate();
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            try {
                connexion();
                PreparedStatement preparedStatement =connexion.prepareStatement("INSERT INTO partie (ID_user, " +
                        "date_heur_partie,nb_portes_traversees_partie," +
                        "nb_etoiles_ramassee_partie,score_partie ) " +
                        "VALUES ((SELECT ID_user from user WHERE pseudo_user = ?),NOW(),?,?,?)");
                preparedStatement.setString(1,pseudo);
                preparedStatement.setInt(2,scoreToInsrt.getNbrObstaclesCrossed());
                preparedStatement.setInt(3,scoreToInsrt.getNbEtoilesRamassees());
                preparedStatement.setInt(4, (int) scoreToInsrt.getScore());
                preparedStatement.executeUpdate();
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

