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
         ln(TEST);
        if (gestion.testConnexionDB()){

         ln("\u001B[32m" +"Felicitation La connexion est possible "+"\u001B[0m");
        }else {
             ln("\u001B[31m" +"Pas de chance  Envoie moi un message..."+"\u001B[0m");

        }


        TEST="Test du top joueurs";
         ln(TEST);
        LinkedList<SumScore> l =gestion.topJoueurs();
        for (SumScore s : l) {
            //  ln(s.toString());
             ln(s.toString());
        }

         ln(TEST+((l.size()==17)?"\u001B[32m" +" OK"+"\u001B[0m":"\u001B[31m" +" PAS_OK"+"\u001B[0m"));
         ln("Fin"+TEST);


        TEST="Test du getScoreOfPlayer";
         ln(TEST);
        LinkedList<Record> la =gestion.getScoresOfPlayer("Alexis");
        for (Record r : la) {
            //  ln(s.toString());
             ln(r.toString());
        }

         ln(TEST+((!(la.isEmpty())?"\u001B[32m" +" OK"+"\u001B[0m":"\u001B[31m" +" PAS_OK"+"\u001B[0m")));
         ln("Fin"+TEST);

        TEST="getNBestRecords";
         ln(TEST);
        LinkedList<Record> lr = gestion.getNBestRecords(33);
        int i = 1;
        for (Record re : lr) {

             ln(i++ +re.toString());
        }
         ln(TEST+((!(lr.isEmpty())?"\u001B[32m" +" OK"+"\u001B[0m":"\u001B[31m" +" PAS_OK"+"\u001B[0m")));
         ln("Fin"+TEST);
         ln("Fin des tests");

    }
}
