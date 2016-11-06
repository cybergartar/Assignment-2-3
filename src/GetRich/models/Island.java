package GetRich.models;

public class Island extends Area{
    public Island() {
        super("Island", 8);
        this.setPurchasable(false);
        this.setType("Island");
    }

    @Override
    public void trigger(Player player) {
        super.trigger(player);
        player.setTurnLeftOnIsland(3);
    }
}
