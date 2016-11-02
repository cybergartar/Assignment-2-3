package GetRich.models;

public class Lucky extends Area{

    public Lucky(int index) {
        super("Lucky", index);
        this.setPurchasable(false);
        this.setType("Lucky");
    }

    @Override
    public void trigger(Player player) {
        super.trigger(player);
    }

    public void randomLucky(Player player){
        final int luckyCount = 10;
        int result = (int)(Math.random()*(luckyCount + 1));
        switch (result){
            case 0: bankrupt(player); break;
        }
    }

    private void bankrupt(Player player){

    }

//    TODO: think more lucky method

}
