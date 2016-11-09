package GetRich.models;

public class Plane extends Area{
    public Plane() {
        super("Plane", 24);
        this.setPurchasable(false);
        this.setType("Plane");
    }

    public void trigger(Player player, int goTo) {
        super.trigger(player);
        player.setPlanePoint(goTo);
    }
}
