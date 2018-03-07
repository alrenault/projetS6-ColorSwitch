package DB;

import game.Score;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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

    /**
     * Doit etre uniquement utilisée dans et par cette classe
     * Effectue la connexion sql
     */
    private void connexion(){
        try {
            if (connexion==null||connexion.isClosed()) {
                Class.forName(JDBC_DRIVER);
                connexion = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
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
     *Teste l'existence d'un pseudo dans la base
     * @param pseudo le pseudo à rechercher
     * @return true si pseudo present
     */
    private boolean pseudoInDB(String pseudo){// si le pseudo est dans la db
        assert(pseudo.length()>2);
        assert(pseudo.length()<25);
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
    public void record(String pseudo, Score scoreToInsrt){
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

    /**
     * Sort tout les scores de joueur de la base
     * @param pseudoJoueur le pseudo du joueur à rechercher
     * @return une liste (chainee) conenant tout les scores de joueur
     */
    public List<Record> getScoresOfPlayer(String pseudoJoueur){

        if (!(pseudoInDB(pseudoJoueur)))return null;

        List<Record> ret=new LinkedList<>();
        connexion();
        PreparedStatement stmt = null;
        try {
            stmt = connexion.prepareStatement("SELECT date_heur_partie,nb_portes_traversees_partie," +
                    " nb_etoiles_ramassee_partie,score_partie from partie NATURAL JOIN user WHERE pseudo_user = ?",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);

            stmt.setString(1,pseudoJoueur);

            ResultSet reponse = stmt.executeQuery();
            while (reponse.next()) {

                SimpleDateFormat patern = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = patern.format(reponse.getTimestamp("date_heur_partie"));

                ret.add(new Record(pseudoJoueur,
                        new Score(reponse.getInt("nb_portes_traversees_partie"),
                                reponse.getInt("nb_etoiles_ramassee_partie"),
                                reponse.getInt("score_partie")),
                        date));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
    public List<Record> getNBestRecords(int limit){
    assert(limit>0);

        List<Record> ret=new LinkedList<>();
        connexion();
        PreparedStatement stmt = null;
        try {
            stmt = connexion.prepareStatement("SELECT pseudo_user,date_heur_partie,nb_portes_traversees_partie," +
                    " nb_etoiles_ramassee_partie,score_partie from partie NATURAL JOIN user ORDER BY score_partie LIMIT ?",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);

            stmt.setInt(1,limit);
            ResultSet reponse = stmt.executeQuery();
            while (reponse.next()) {

                SimpleDateFormat patern = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = patern.format(reponse.getTimestamp("date_heur_partie"));

                ret.add(new Record(reponse.getString("pseudo_user"),
                        new Score(reponse.getInt("nb_portes_traversees_partie"),
                                reponse.getInt("nb_etoiles_ramassee_partie"),
                                reponse.getInt("score_partie")),
                        date));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Insert des Scores dans la base
     * ne peut inserer 2 fois
     */
    public void populateDB(){
        if (getScoresOfPlayer("Vincent")==null) {

            for (int i = 0; i < 15; i++) {
                record("Vincent", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Quentin", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Alexis", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Yohan", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Anthony", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Pierrick", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Romain", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Jules", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Thomas", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Thomas2", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Jack", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Pierre", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Firmin", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Louis", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Richard", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Henry", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
                record("Edward", new Score(new Random().nextInt(1000), new Random().nextInt(5000), new Random().nextInt(1000000)));
            }
        }
    }







}

