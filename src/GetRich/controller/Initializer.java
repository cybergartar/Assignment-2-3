package GetRich.controller;

import GetRich.models.Player;

import java.awt.geom.Area;
import java.util.ArrayList;

/**
 * Created by ultimate on 10/19/16.
 */
public class Initializer {
    public static void createPlayer(ArrayList<Player> players, String name, long startMoney, String avatar){
        players.add(new Player(name, startMoney, avatar));
        // use as loop through text field; edit too
    }

    public static ArrayList<Area> createArea(){
        ArrayList<Area> tile = new ArrayList<>();


        return tile;
    }


}
