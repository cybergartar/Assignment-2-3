package GetRich.controller;

import GetRich.models.Area;
import GetRich.models.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gameplay {
    private int roundPlay, roundLimit;
    private ArrayList <Player> players;
    private RankComparator comparator = new RankComparator();
    private ArrayList <Player> rank;
    private ArrayList <GetRich.models.Area> tile;
    private int playerLeft;

    public Gameplay(int roundLimit, ArrayList<Player> players) {
        this.roundLimit = roundLimit;
        this.players = players;
        this.tile = Initializer.createArea();
        this.playerLeft = 4;
        randomOrder(players);
        for (Player i : players) {
            i.setRank(i.getOrder());
        }
    }

    public static void main(String[] argv){

    }

    public int getRoundPlay() {
        return roundPlay;
    }

    public void setRoundPlay(int roundPlay) {
        this.roundPlay = roundPlay;
    }

    public int getRoundLimit() {
        return roundLimit;
    }

    public void setRoundLimit(int roundLimit) {
        this.roundLimit = roundLimit;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getRank() {
        return rank;
    }

    public void setRank(ArrayList<Player> rank) {
        this.rank = rank;
    }

    public ArrayList<Area> getTile() {
        return tile;
    }

    public void setTile(ArrayList<Area> tile) {
        this.tile = tile;
    }

    public int getPlayerLeft() {
        return playerLeft;
    }

    public void decreasePlayerNum() {
        this.playerLeft --;
    }

    private static void randomOrder(ArrayList<Player> players){
        ArrayList<Integer> randOrder = new ArrayList<>();
        randOrder.add(1);
        randOrder.add(2);
        randOrder.add(3);
        randOrder.add(4);

        for(Player i : players){
            int rand = (int)(Math.random()*randOrder.size());
            i.setOrder(randOrder.get(rand));
            randOrder.remove(rand);
        }

        Collections.sort(players, new OrderComparator());

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
