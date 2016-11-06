package GetRich.controller;

import GetRich.models.*;

import java.util.*;

public class Initializer {
    public static ArrayList<Player> createPlayer(String... name){
        ArrayList<Player> players = new ArrayList<>();
        int index = 0;

        for (String i : name) {
            players.add(new Player(i, 5000000, index));
            index ++;
        }

        return players;
    }

    public static ArrayList<Area> createArea(){
        ArrayList<Area> tile = new ArrayList<>();
        tile.add(new Start());
        for(int i = 1; i < 32; i++){
           tile.add(new Land(Character.toString((char)(i+64)), i, Variable.calculatedLandPrice(i, 0), Variable.calculatedLandPrice(i, 0)));
        }
        System.out.println("SDSDSDSD: " + tile.size());

        List<Integer> removeList = Arrays.asList(4, 5, 8, 11, 14, 16, 18, 20, 24, 28, 29);
        List<Integer> luckyList = Arrays.asList(5, 11, 20, 29);
        List<Integer> beachList = Arrays.asList(4, 14, 18, 28);

        for (Iterator<Area> it = tile.iterator(); it.hasNext();){
            Area i = it.next();
            if(removeList.contains(i.getIndex()))
                it.remove();
        }

        for(Integer i : luckyList){
            tile.add(new Lucky(i));
        }

        for (Integer i : beachList){
            tile.add(new Beach("BBBBB", i, 74500, 80000));
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
