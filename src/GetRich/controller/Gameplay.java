package GetRich.controller;

import GetRich.models.Player;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Comparator;

public class Gameplay {
    int roundPlay, roundLimit;
    ArrayList <Player> players;
    RankComparator comparator = new RankComparator();
    ArrayList <Player> rank;
    ArrayList <Area> tile;

    public Gameplay(int roundLimit, ArrayList<Player> players, ArrayList <Area> tile) {
        this.roundLimit = roundLimit;
        this.players = players;
        this.tile = Initializer.createArea();
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
