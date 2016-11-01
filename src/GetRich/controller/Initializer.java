package GetRich.controller;

import GetRich.models.Player;

/**
 * Created by ultimate on 10/19/16.
 */
public class Initializer {
    public static void createPlayer(Gameplay game, String name, long startMoney, String avatar){
        game.players.add(new Player(name, startMoney, avatar));
    }

    public static void createArea(int index, String name){

    }


}
