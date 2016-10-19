package GetRich.models;

public class Island extends Area{
    public Island(String name, int index) {
        super(name, index);
        this.setPurchasable(false);
        this.setType("Island");
    }

    public void missTurn(){
//        TODO: implements miss turn system syncing with Player class
    }
}
