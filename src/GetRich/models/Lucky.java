package GetRich.models;

public class Lucky extends Area{

    public Lucky(String name, int index) {
        super(name, index);
        this.setPurchasable(false);
    }

    public void randomLucky(Player player){
        final int luckyCount = 10;
        int result = (int)(Math.random()*(luckyCount + 1));
        switch (result){
            case 0: bankrupt(player); break;
        }
    }

    private void bankrupt(Player player){
        for(Land i : player.getLand()){
            i.removeOwner();
        }
        player.setBankrupt(true);
    }

//    TODO: think more lucky method

}
