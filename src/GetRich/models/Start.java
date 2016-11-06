package GetRich.models;

import java.util.Scanner;

/**
 * Created by ultimate on 11/2/16.
 */
public class Start extends Area {
    public Start() {
        super("Start", 0);
        this.setPurchasable(false);
        this.setType("Start");
    }

    @Override
    public void trigger(Player player) {
        super.trigger(player);
        Scanner input = new Scanner(System.in);
        int cmd = input.nextInt();
        for (Land i : player.getLand()){
            if(i.getIndex() == cmd) {
                i.trigger(player);
                break;
            }
        }

    }
}
