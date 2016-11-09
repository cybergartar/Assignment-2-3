package GetRich.models;

public class Festival extends Area{
    private Land currenFestival = null;
    public Festival() {
        super("Festival", 16);
        this.setPurchasable(false);
        this.setType("Festival");
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

    public void trigger(Player player, int selected) {
        super.trigger(player);
        if(currenFestival != null)
            currenFestival.setOnFestival(false);

        System.out.println(player.getLand().size());

        for (Land i : player.getLand()) {
            System.out.println(i.getName());
        }
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");

        player.getLand().get(selected).setOnFestival(true);
        currenFestival = player.getLand().get(selected);

    }
}
