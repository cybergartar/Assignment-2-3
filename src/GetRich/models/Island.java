package GetRich.models;

public class Island extends Area{
    public Island() {
        super("Island", 9);
        this.setPurchasable(false);
        this.setType("Island");
    }

    public void missTurn(){
//        TODO: implements miss turn system syncing with Player class
    }
}
