package main;
/*
*@autor Vincent
@date 16/03/2018*/

import DB.GestionDB;
import DB.Record;
import DB.SumScore;

import java.util.LinkedList;

public class MainTestDB {
    public static void main(String[] args) {
        GestionDB gestion =new GestionDB();
        LinkedList<SumScore> l =gestion.topJoueurs();
        System.out.println("Test du top joueurs");
        for (SumScore s : l) {
            //System.err.println(s.toString());
            System.out.println(s.toString());
        }
        System.out.println("FinTest du top joueurs");


        System.out.println("Test du getScoreOfPlayer");
        LinkedList<Record> la =gestion.getScoresOfPlayer("Alexis");
        for (Record r : la) {
            //System.err.println(s.toString());
            System.out.println(r.toString());
        }
        System.out.println("FinTest du getScoreOfPlayer");


        System.out.println("Test du getNBestRecords");
        LinkedList<Record> lr = gestion.getNBestRecords(33);
        int i = 1;
        for (Record re : lr) {

            //System.err.println(s.toString());
            System.out.println(i++ +re.toString());
        }

        System.out.println("FinTest du getNBestRecords");

    }
}
