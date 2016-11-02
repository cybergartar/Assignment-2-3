package GetRich;

import GetRich.controller.Gameplay;
import GetRich.controller.Initializer;
import GetRich.models.Player;

import java.util.*;

/**
 * Created by ultimate on 11/1/16.
 */
public class Test {
    public static void main(String[] argv){
        boolean playing = true;
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("A", 100000, "lion"));
        players.add(new Player("B", 100000, "cat"));
        players.add(new Player("C", 100000, "fish"));
        players.add(new Player("D", 100000, "dog"));

        Gameplay game = new Gameplay(50, players, Initializer.createArea());

        Scanner input = new Scanner(System.in);
        String cmd;

        randomOrder(players);

        for (Player i : players){
            i.setTotalAssets(i.getMoney());
            System.out.println(i.getName());
        }

//        for (Area i : game.getTile()){
//            System.out.println(i.getName() + " I: " + i.getIndex() + " T: " +i.getType());
//        }

        while (playing) {
            for (Player pl : players){
                if(!(pl.isBankrupt())){
                    if(pl.getTurnLeftOnIsland() > 0){
                        pl.setTurnLeftOnIsland(pl.getTurnLeftOnIsland() - 1);
                    }
                    else {
                        System.out.println("CMD: " + pl.getName() + " AT: " + pl.getCurrentTile() + " MONEY : " + pl.getMoney() + " ASSETS : " + pl.getTotalAssets());
                        cmd = input.next();
                        int[] dice = tossDice();
                        System.out.println(Arrays.toString(dice));
                        pl.setCurrentTile(pl.getCurrentTile() + dice[0] + dice[1]);
                        if(pl.getCurrentTile() >= 36){
                            pl.increaseLapPassed();
                            pl.setCurrentTile(pl.getCurrentTile() % 36);
                        }

                        game.getTile().get(pl.getCurrentTile()).trigger(pl);

                        System.out.println("NOW AT: " + pl.getCurrentTile() + " LAP: " + pl.getLapPassed() + " MONEY : " + pl.getMoney() + " ASSETS : " + pl.getTotalAssets());
                        System.out.println();


                    }

                    if (pl.getTotalAssets() <= 0) {
                        pl.bankrupt();
                    }

                }

            }
        }
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

    public static int[] tossDice(){
        int x = (int)(Math.random()*6)+1;
        int y = (int)(Math.random()*6)+1;

        return new int[]{x, y};
    }
}

class OrderComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if(o1.getOrder() < o2.getOrder())
            return -1;
        else
            return 1;
    }
}
