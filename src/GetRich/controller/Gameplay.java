package GetRich.controller;

import GetRich.models.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Gameplay {
    int roundPlay, roundLimit;
    ArrayList <Player> players;
    RankComparator comparator = new RankComparator();
    List<Player> rank = new ArrayList<Player>() {
        public boolean add(Player player){
            super.add(player);
            Collections.sort(rank, new RankComparator());
            return true;
        }
    };

    public Gameplay(int roundPlay, int roundLimit, ArrayList<Player> players, List<Player> rank) {
        this.roundPlay = roundPlay;
        this.roundLimit = roundLimit;
        this.players = players;
        this.rank = rank;
    }

    public static void main(String[] argv){

    }
}

class RankComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if(o1.getTotalAssets() > o2.getTotalAssets())
            return -1;
        else
            return 1;
    }
}
