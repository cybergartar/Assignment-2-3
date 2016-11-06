package GetRich;

import GetRich.controller.Gameplay;
import GetRich.models.Beach;
import GetRich.models.Land;
import GetRich.models.Player;

import java.util.*;

/**
 * Created by ultimate on 11/1/16.
 */
public class Test {
    public static void main(String[] argv){
        boolean playing = true;
        ArrayList<Player> players = new ArrayList<>();

//        randomOrder(players);

        Gameplay game = new Gameplay(50, players);

        Scanner input = new Scanner(System.in);
        String cmd;

//        for (Player i : players){
//            i.setTotalAssets(i.getMoney());
//            System.out.println(i.getName());
//        }

//        for (Area i : game.getTile()){
//            System.out.println("Land: " + i.getName() + " I: " + i.getIndex() + " T: " +i.getType());
//            if(i instanceof Land){
//                System.out.println("Buy: " + ((Land) i).getBuyPrice() + " Charge: " + ((Land) i).getBaseCharge());
//            }
//            System.out.println("===============================");
//        }

        while (playing) {
            for (Player pl : players){
                if(!(pl.isBankrupt())){
                    if(pl.getTurnLeftOnIsland() > 0){
                        pl.setTurnLeftOnIsland(pl.getTurnLeftOnIsland() - 1);
                    }
                    else {
                        if(!pl.isOnPlane()){
                            System.out.println("CMD: " + pl.getName() + " AT: " + pl.getCurrentTile() + " MONEY : " + pl.getMoney() + " ASSETS : " + pl.getTotalAssets());
//                        cmd = input.next();
                            int[] dice = tossDice();
                            System.out.println(Arrays.toString(dice));
                            pl.setCurrentTile(pl.getCurrentTile() + dice[0] + dice[1]);
                            if(pl.getCurrentTile() >= 36){
                                pl.increaseLapPassed();
                                pl.setCurrentTile(pl.getCurrentTile() % 36);
                            }
                        }
                        else {
                            cmd = input.next();
                            pl.setCurrentTile(Integer.parseInt(cmd));
                            pl.setOnPlane(false);
                        }

                        System.out.print("AREA TYPE: " + game.getTile().get(pl.getCurrentTile()).getType() + " ");
                        System.out.print("INDEX: " + game.getTile().get(pl.getCurrentTile()).getIndex());
                        System.out.println(" P_ABLE: "+ game.getTile().get(pl.getCurrentTile()).isPurchasable());

                        if (game.getTile().get(pl.getCurrentTile()) instanceof Land){
                            System.out.print("Level: " + ((Land) game.getTile().get(pl.getCurrentTile())).getLevel());
                            System.out.println(" BuyPrice: " + ((Land) game.getTile().get(pl.getCurrentTile())).getBuyPrice());
                            System.out.println("Charge: " + ((Land) game.getTile().get(pl.getCurrentTile())).getRealCharge());
                        }
                        else
                            System.out.println();

                        if(game.getTile().get(pl.getCurrentTile()) instanceof Beach) {
                            System.out.println("PRE OWNER: " + ((Beach) game.getTile().get(pl.getCurrentTile())).getOwner());
                            if(((Beach) game.getTile().get(pl.getCurrentTile())).getOwner() != null)
                                System.out.println("NOW OWNER BANKRUPT?: " + ((Beach) game.getTile().get(pl.getCurrentTile())).getOwner().isBankrupt());
                        }

                        game.getTile().get(pl.getCurrentTile()).trigger(pl);

                        System.out.println("AFTER ACTION");
                        System.out.print("AREA TYPE: " + game.getTile().get(pl.getCurrentTile()).getType() + " ");
                        System.out.print("INDEX: " + game.getTile().get(pl.getCurrentTile()).getIndex());
                        System.out.println(" P_ABLE: "+ game.getTile().get(pl.getCurrentTile()).isPurchasable());

                        if (game.getTile().get(pl.getCurrentTile()) instanceof Land){
                            System.out.print("Level: " + ((Land) game.getTile().get(pl.getCurrentTile())).getLevel());
                            System.out.println(" BuyPrice: " + ((Land) game.getTile().get(pl.getCurrentTile())).getBuyPrice());
                            System.out.println(" Charge: " + ((Land) game.getTile().get(pl.getCurrentTile())).getRealCharge());
                        }
                        else
                            System.out.println();

                        System.out.println("NOW AT: " + pl.getCurrentTile() + " LAP: " + pl.getLapPassed() + " MONEY : " + pl.getMoney() + " ASSETS : " + pl.getTotalAssets());
                        System.out.println("============================================");
                        System.out.println();


                    }

                    if (pl.getTotalAssets() <= 0 || pl.getMoney() <= 0) {
                        pl.bankrupt();
                        game.decreasePlayerNum();
                    }

                    if (pl.getOrder() == 4)
                        game.setRoundPlay(game.getRoundPlay() + 1);

                    if(game.getRoundPlay() == game.getRoundLimit() || game.getPlayerLeft() == 1)
                        playing = false;
                }

            }
        }

        for (Player i : game.getPlayers()){
            if (i.isBankrupt() == false) {
                System.out.println("WIN: " + i.getName());
            }
        }
        System.out.println("ROUND PASSED: " + game.getRoundPlay());
    }

//    private static void randomOrder(ArrayList<Player> players){
//        ArrayList<Integer> randOrder = new ArrayList<>();
//        randOrder.add(1);
//        randOrder.add(2);
//        randOrder.add(3);
//        randOrder.add(4);
//
//        for(Player i : players){
//            int rand = (int)(Math.random()*randOrder.size());
//            i.setOrder(randOrder.get(rand));
//            randOrder.remove(rand);
//        }
//
//        Collections.sort(players, new OrderComparator());
//
//    }

    public static int[] tossDice(){
        int x = (int)(Math.random()*6)+1;
        int y = (int)(Math.random()*6)+1;

        return new int[]{x, y};
    }
}

//class OrderComparator implements Comparator<Player> {
//    @Override
//    public int compare(Player o1, Player o2) {
//        if(o1.getOrder() < o2.getOrder())
//            return -1;
//        else
//            return 1;
//    }
//}
