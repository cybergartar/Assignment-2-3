package GetRich.models;

public class Beach extends Land{
    public Beach(String name, int index, long buyPrice, long sellPrice, long charge) {
        super(name, index, buyPrice, sellPrice, charge);
        this.setUpgradeable(false);
        this.setType("Beach");
    }

    public void purchase(Player owner) {
        super.purchase(owner);
        this.setPurchasable(false);
    }

    @Override
    public void trigger(Player player) {
        super.trigger(player);
    }
}
