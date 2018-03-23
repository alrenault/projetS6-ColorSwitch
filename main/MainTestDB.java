package main;

import DB.GestionDB;
import DB.Record;
import DB.SumScore;

import java.util.LinkedList;

/**
 * Main de Test de connection et utlisation de la base de données
 */
class MainTestDB {
    public static void main(String[] args) {
        GestionDB gestion = new GestionDB();
        String TEST;



        TEST="Connextion";
        System.out.println(TEST);
        if (gestion.testConnexionDB()){

            System.out.println("\u001B[32m" +"Felicitation La connexion est possible "+"\u001B[0m");
        }else {
            System.out.println("\u001B[31m" +"Pas de chance  Envoie moi un message..."+"\u001B[0m");

        }


        TEST="Test du top joueurs";
        System.out.println(TEST);
        LinkedList<SumScore> l =gestion.topJoueurs();
        for (SumScore s : l) {
            //System.err.println(s.toString());
            System.out.println(s.toString());
        }

        System.out.println(TEST+((l.size()==17)?"\u001B[32m" +" OK"+"\u001B[0m":"\u001B[31m" +" PAS_OK"+"\u001B[0m"));
        System.out.println("Fin"+TEST);


        TEST="Test du getScoreOfPlayer";
        System.out.println(TEST);
        LinkedList<Record> la =gestion.getScoresOfPlayer("Alexis");
        for (Record r : la) {
            //System.err.println(s.toString());
            System.out.println(r.toString());
        }

        System.out.println(TEST+((!(la.isEmpty())?"\u001B[32m" +" OK"+"\u001B[0m":"\u001B[31m" +" PAS_OK"+"\u001B[0m")));
        System.out.println("Fin"+TEST);

        TEST="getNBestRecords";
        System.out.println(TEST);
        LinkedList<Record> lr = gestion.getNBestRecords(33);
        int i = 1;
        for (Record re : lr) {

            System.out.println(i++ +re.toString());
        }
        System.out.println(TEST+((!(lr.isEmpty())?"\u001B[32m" +" OK"+"\u001B[0m":"\u001B[31m" +" PAS_OK"+"\u001B[0m")));
        System.out.println("Fin"+TEST);
        System.out.println("Fin des tests");

    }
}