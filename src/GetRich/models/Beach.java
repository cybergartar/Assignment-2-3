package GetRich.models;

public class Beach extends Land{
    public Beach(String name, int index, long buyPrice, long charge) {
        super(name, index, buyPrice, charge);
        this.setUpgradeable(false);
        this.setType("Beach");
        this.setPurchasable(true);
    }

    @Override
    public void trigger(Player player) {
        super.trigger(player);
        if(this.getOwner() != null)
            this.setPurchasable(false);
    }
}
