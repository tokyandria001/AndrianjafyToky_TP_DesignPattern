package Singleton;

import java.util.ArrayList;
import java.util.List;

class FootballTeam {
    private static FootballTeam instance;
    private List<String> joueurs;
    private String coach;

    private FootballTeam() {
        joueurs = new ArrayList<>();
        coach= "Inconnu";
    }

    public static FootballTeam getInstance(){
        if(instance == null) {
            instance = new FootballTeam();
        }
        return instance;
    }

    public void setCoach(String coach){
        this.coach = coach;
    }

    public String getCoach(){
        return coach;
    }

    public void addJoueur(String joueur){
        joueurs.add(joueur);
    }

    public List<String> getJoueurs(){
        return joueurs;
    }
}

public class SingletonExample {
    public static void main(String[] args){
        FootballTeam team1 = FootballTeam.getInstance();
        FootballTeam team2 = FootballTeam.getInstance();

        team1.addJoueur("Messi");
        team1.addJoueur("Ronaldo");

        team2.addJoueur(("Neymar"));
        team2.setCoach("Guardiola");

        System.out.println("Coach: "+team1.getCoach());
        System.out.println("Coach: "+team2.getJoueurs());
    }
}