package DB;

import view.game.Score;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Random;

/**
 * Gestion des entrées - sorties de la base de données
 */
public class GestionDB {
    /**
     * Numero de port de MySql
     */
    private static Integer NoPORT = 8889;
    /**
     * Addresse du driver de MySql
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    /**
     * Nom de la base de données
     */
    private static final String DB_NAME = "ColorSwitch";
    /**
     * Addresse de la base de données
     */
    private static final String DB_URL = "jdbc:mysql://localhost:"+NoPORT+"/" + DB_NAME;
    /**
     * Nom de l'utilisateur de la base de données
     */
    private static  String DB_USERNAME = "root";
    /**
     * Mot de passe associé à DB_USERNAME de la base de données
     */
    private static  String DB_PASSWORD = "root";

    /**
     * Connection sur laquelle se fera toutes les interractions
     */
    private Connection connexion;

    /**
     * Constucteur de Gestion DB
     */
    public GestionDB() {

        if (this.connexion())
            this.populateDB();
    }
    /**
     * Constucteur de Gestion DB
     */
    public GestionDB(String user,String password,Integer nPorts) {

        if (this.connexion(user, password, nPorts))
            this.populateDB();
    }

    /**
     * Doit etre uniquement utilisée dans et par cette classe
     * Effectue la connexion sql
     */
    private boolean connexion() {
        try {
            if (connexion == null || connexion.isClosed()) {
                Class.forName(JDBC_DRIVER);
                connexion = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
        return true;
    }
    /**
     * Doit etre uniquement utilisée dans et par cette classe
     * Effectue la connexion sql
     */
    private boolean connexion(String user,String password,Integer nPorts ) {
        try {
            if (connexion == null || connexion.isClosed()) {
                Class.forName(JDBC_DRIVER);
                DB_USERNAME=user;
                DB_PASSWORD=password;
                NoPORT=nPorts;
                connexion = DriverManager.getConnection(DB_URL, user, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
        return true;
    }
    /**
     * Teste l'existence d'un pseudo dans la base
     *
     * @param pseudo le pseudo à rechercher
     * @return true si pseudo present
     */
    private boolean pseudoInDB(String pseudo) {// si le pseudo est dans la db
        assert (pseudo.length() > 2);
        assert (pseudo.length() < 25);
        try {
            connexion();
            PreparedStatement stmt = connexion.prepareStatement("SELECT ID_user FROM user WHERE pseudo_user = ?");
            stmt.setString(1, pseudo);
            ResultSet reponse = stmt.executeQuery();
            boolean r = reponse.next();//on stocke le booleen avac de retouner la valeur pour fermer la connnection,et requete
            connexion.close();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Insertion dans la base du Score du joueur
     *
     * @param pseudo       le nom du joueur
     * @param scoreToInsrt le score du joueur à entrer
     */
    public void record(String pseudo, Score scoreToInsrt) {
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
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO partie (ID_user, " +
                    "date_heur_partie,nb_portes_traversees_partie," +
                    "nb_etoiles_ramassee_partie,score_partie ) " +
                    "VALUES ((SELECT ID_user FROM user WHERE pseudo_user = ?),NOW(),?,?,?)");
            preparedStatement.setString(1, pseudo);
            preparedStatement.setInt(2, scoreToInsrt.getNbrObstaclesCrossed());
            preparedStatement.setInt(3, scoreToInsrt.getNbEtoilesRamassees());
            preparedStatement.setInt(4, scoreToInsrt.getScore());
            preparedStatement.executeUpdate();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sort tout les scores de joueur de la base
     *
     * @param pseudoJoueur le pseudo du joueur à rechercher
     * @return une liste (chainée) contenant tout les scores de joueur ou null si pseudo inexistant
     */
    public LinkedList<Record> getScoresOfPlayer(String pseudoJoueur) {
        if (!(pseudoInDB(pseudoJoueur))) return null;
        LinkedList<Record> ret = new LinkedList<>();
        connexion();
        PreparedStatement stmt;
        try {
            stmt = connexion.prepareStatement("SELECT date_heur_partie,nb_portes_traversees_partie," +
                    " nb_etoiles_ramassee_partie,score_partie FROM partie NATURAL JOIN user WHERE pseudo_user = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            stmt.setString(1, pseudoJoueur);

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


    /**
     * Genère les n premiers meilleurs scores de la base
     *
     * @param limite le nombre de records à obtenir (limit == return.size )
     * @return une liste (chainée) contenant les [limite] meilleurs scores tout joueur confondus
     */
    public LinkedList<Record> getNBestRecords(int limite) {
        assert (limite > 0);

        LinkedList<Record> ret = new LinkedList<>();
        connexion();
        PreparedStatement stmt;
        try {
            stmt = connexion.prepareStatement("SELECT pseudo_user,date_heur_partie,nb_portes_traversees_partie," +
                    " nb_etoiles_ramassee_partie,score_partie FROM partie NATURAL JOIN user ORDER BY score_partie DESC LIMIT ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            stmt.setInt(1, limite);
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
     * Genère les n derniers scores de la base
     *
     * @param limite le nombre de records à obtenir (limit == return.size )
     * @return une liste (chainée) contenant les [limite] derniers scores tout joueur confondus (en terme de date)
     */
    public LinkedList<Record> getLastRecords(int limite) {
        assert (limite > 0);

        LinkedList<Record> ret = new LinkedList<>();
        connexion();
        PreparedStatement stmt;
        try {
            stmt = connexion.prepareStatement("SELECT pseudo_user,date_heur_partie,nb_portes_traversees_partie," +
                    " nb_etoiles_ramassee_partie,score_partie FROM partie NATURAL JOIN user ORDER BY date_heur_partie DESC LIMIT ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            stmt.setInt(1, limite);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                SimpleDateFormat patern = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = patern.format(resultSet.getTimestamp("date_heur_partie"));
                ret.add(new Record(resultSet.getString("pseudo_user"),
                        new Score(resultSet.getInt("nb_portes_traversees_partie"),
                                resultSet.getInt("nb_etoiles_ramassee_partie"),
                                resultSet.getInt("score_partie")),
                        date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Sort le classement des joueurs selon leur somme de scores
     *
     * @return une liste (chainée) contenant des Triplets (classement ,joueur,scoreTotal) triée par ordre decroissant
     */
    public LinkedList<SumScore> topJoueurs() {

        LinkedList<SumScore> ret = new LinkedList<>();
        connexion();
        PreparedStatement stmt;
        try {
            stmt = connexion.prepareStatement("SELECT pseudo_user,SUM(score_partie) AS score_total FROM partie NATURAL JOIN user GROUP BY pseudo_user ORDER BY score_total DESC ", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            ResultSet reponse = stmt.executeQuery();
            int position = 0;
            while (reponse.next()) {
                position++;

                ret.add(new SumScore(position, reponse.getString("pseudo_user"), reponse.getInt("score_total")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Methode de test de la connexion à la BD
     *
     * @return true si aucun probleme materiel ,SQL ou autre Exeption est levée
     */
    public boolean testConnexionDB() {
        return this.connexion();
    }

    /**
     * Insert des Scores dans la base
     * ne peut inserer 2 fois
     */
    private void populateDB() {
        if (getScoresOfPlayer("Vincent") == null) {

            int boundPortes = 500;
            int boundEtoiles = 2500;

            for (int i = 0; i < 15; i++) {
                record("Vincent", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Quentin", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Alexis", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Yohan", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Anthony", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Pierrick", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Romain", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Jules", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Thomas", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Thomas2", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Jack", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Pierre", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Firmin", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Louis", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Richard", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Henry", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
                record("Edward", new Score(new Random().nextInt(boundPortes), new Random().nextInt(boundEtoiles)));
            }
        }
    }
}

