package GetRich.models;

public class Land extends Area{
    private Player owner = null;
    private long buyPrice, sellPrice, charge;
    private int level;
    private boolean upgradeable, hasLandmark, onFestival;

    public boolean isUpgradeable() {
        return upgradeable;
    }

    public void setUpgradeable(boolean upgradeable) {

        this.upgradeable = upgradeable;
    }

    public Land(String name, int index, long buyPrice, long sellPrice, long charge){
        super(name, index);
        this.setPurchasable(true);
        this.upgradeable = true;
        this.hasLandmark = false;
        this.onFestival = false;

        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.level = 0;
        this.charge = charge;
        this.setType("Land");
    }

    public Player getOwner() {
        return owner;
    }

    public void removeOwner() {
        this.owner = null;
        this.level = 0;
        this.hasLandmark = false;
        this.setPurchasable(true);
        if(!(this.getType().equals("Beach")))
            this.upgradeable = true;
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(long buyPrice) {
        this.buyPrice = buyPrice;
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public long getCharge() {
        return charge;
    }

    public void setCharge(long charge) {
        this.charge = charge;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        if(this.upgradeable)
            this.level = level;

    }

    public boolean hasLandmark() {
        return hasLandmark;
    }

    public void placeLandmark() {
        if(!(this.hasLandmark) && this.level == 3) {
            this.hasLandmark = true;
            this.setPurchasable(false);
            this.upgradeable = false;
            this.setLevel(this.level + 1);
        }
    }

    public boolean isOnFestival() {
        return onFestival;
    }

    public void setOnFestival(boolean onFestival) {
        this.onFestival = onFestival;
    }

    public void purchase(Player owner){
        if(this.isPurchasable())
            this.owner = owner;
    }
}
