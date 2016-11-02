package GetRich.models;

public class Plane extends Area{
    public Plane() {
        super("Plane", 27);
        this.setPurchasable(false);
        this.setType("Plane");
    }

    @Override
    public void trigger(Player player) {
        super.trigger(player);
    }
}
