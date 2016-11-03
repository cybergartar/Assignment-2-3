package GetRich.models;

import java.util.Scanner;

public class Festival extends Area{
    private Land currenFestival = null;
    public Festival() {
        super("Festival", 18);
        this.setPurchasable(false);
    }

//    public void trigger(Land target){
//        if(currenFestival != null){
//            currenFestival.setOnFestival(false);
//            currenFestival.setBaseCharge(deafultCharge);
//        }
//
//        currenFestival = target;
//        deafultCharge = target.getBaseCharge();
//        target.setBaseCharge(deafultCharge*2);
//        target.setOnFestival(true);
//    }

    @Override
    public void trigger(Player player) {
        super.trigger(player);
        Scanner input = new Scanner(System.in);
        int cmd = input.nextInt();
        for (Land i : player.getLand()){
            if(i.getIndex() == cmd) {
                if(currenFestival != null)
                    currenFestival.setOnFestival(false);
                i.setOnFestival(true);
                currenFestival = i;
                break;
            }
        }
    }
}
