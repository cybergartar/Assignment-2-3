package GetRich.models;

import java.util.Scanner;

public class Land extends Area{
    private Player owner = null;
    private long buyPrice, sellPrice, baseCharge, realCharge;
    private int level;
    private boolean upgradeable, hasLandmark, onFestival;

    Scanner input = new Scanner(System.in);
    String cmd;

    public boolean isUpgradeable() {
        return upgradeable;
    }

    public void setUpgradeable(boolean upgradeable) {

        this.upgradeable = upgradeable;
    }

    public Land(String name, int index, long buyPrice, long baseCharge){
        super(name, index);
        this.setPurchasable(true);
        this.upgradeable = true;
        this.hasLandmark = false;
        this.onFestival = false;

        this.buyPrice = buyPrice;
        this.level = -1;
        this.baseCharge = baseCharge;
        this.setType("Land");
    }

    public Player getOwner() {
        return owner;
    }

    public void removeOwner() {
        this.owner = null;
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

    public long getBaseCharge() {
        return baseCharge;
    }

    public void setBaseCharge(long baseCharge) {
        this.baseCharge = baseCharge;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
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

    public void setLandmarkStatus (boolean has) {
        hasLandmark = has;
    }

    public boolean isOnFestival() {
        return onFestival;
    }

    public void setOnFestival(boolean onFestival) {
        this.onFestival = onFestival;
    }

    public long getRealCharge() {
        return realCharge;
    }

    public void setRealCharge(long realCharge) {
        this.realCharge = realCharge;
    }

    public void payCharge (Player player) {
        if(this.isOnFestival()){
            player.payMoney(this.getRealCharge() * 2);
            this.getOwner().recvMoney(this.getRealCharge() * 2);
        }
        else {
            player.payMoney(this.getRealCharge());
            this.getOwner().recvMoney(this.getRealCharge());
        }

        if (player.getMoney() <= 0 )
            player.setBankrupt(true);
    }

    public void takeOver (Player player) {
        owner.recvMoney(this.buyPrice);
        owner.removeLand(this);
        player.payMoney(this.buyPrice);

        this.owner = player;
        owner.addLand(this);
    }

    public void purchase (Player player, int levelBuy) {
        long sum = 0;
        if(this instanceof Beach) {
            this.setPurchasable(false);
            sum = Variable.calculatedLandPrice(this.getIndex(), 0);
        }
        else {
            if(this.level == -1) {
                this.owner = player;
                player.addLand(this);
            }
            for (int i = -1; i < levelBuy; i++){
                sum += Variable.calculatedLandPrice(this.getIndex(), i+1);
                this.level = i+1;
            }
        }

        player.payMoney(sum);
        if (this instanceof Beach) {
            this.buyPrice += (2 * Variable.calculatedLandPrice(this.getIndex(), 0));
            this.baseCharge += Variable.calculatedLandPrice(this.getIndex(), 0);
        }
        else {
            this.buyPrice += (2 * Variable.calculatedLandPrice(this.getIndex(), levelBuy));
            this.baseCharge += Variable.calculatedLandPrice(this.getIndex(), levelBuy);
        }

        this.realCharge = ((long) (this.baseCharge * Variable.chargeMultipiler));
        player.setTotalAssets(player.getTotalAssets() + realCharge);
        this.owner = player;



        if (levelBuy == 0) {
            player.addLand(this);
        }

        if (levelBuy == 4)
            this.setPurchasable(false);

    }

    public void clearLand () {
        this.removeOwner();
        this.setLevel(-1);
        this.setBuyPrice(Variable.calculatedLandPrice(this.getIndex(), 0));
        this.setBaseCharge(0);
        this.setRealCharge(0);
        this.setPurchasable(true);
        if(!(this instanceof Beach))
            this.setLandmarkStatus(false);
    }
}
