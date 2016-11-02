package GetRich.controller;

import GetRich.models.*;

import java.util.*;

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
        tile.add(new Start());
        for(int i = 1; i <= 35; i++){
           tile.add(new Land(Character.toString((char)(i+64)), i, 1000*i, 500*i, 1100*i));
        }

        List<Integer> removeList = Arrays.asList(3, 4, 7, 9, 10, 11, 15, 18, 21, 23, 27, 30, 31, 34);
        List<Integer> luckyList = Arrays.asList(3, 7, 11, 15, 21, 30, 34);
        List<Integer> beachList = Arrays.asList(4, 10, 23, 31);

        for (Iterator<Area> it = tile.iterator(); it.hasNext();){
            Area i = it.next();
            if(removeList.contains(i.getIndex()))
                it.remove();
        }

        for(Integer i : luckyList){
            tile.add(new Lucky(i));
        }

        for (Integer i : beachList){
            tile.add(new Beach("BBBBB", i, 1000, 500, 700));
        }

        tile.add(new Island());
        tile.add(new Festival());
        tile.add(new Plane());

        Collections.sort(tile, new TileIndexComparator());
        return tile;
    }


}

class TileIndexComparator implements Comparator<Area> {
    @Override
    public int compare(Area o1, Area o2) {
        if(o1.getIndex() < o2.getIndex())
            return -1;
        else
            return 1;
    }
}
