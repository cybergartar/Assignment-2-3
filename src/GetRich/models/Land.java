package GetRich.models;

import java.util.Scanner;

public class Land extends Area{
    private Player owner = null;
    private long buyPrice, sellPrice, charge;
    int level;
    private boolean upgradeable, hasLandmark, onFestival;

    Scanner input = new Scanner(System.in);
    String cmd;

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

    public void purchase(Player player){
        if(this.getLevel() == 4 && player.getLapPassed() >= 2 && player.getMoney() >= this.buyPrice) {
            System.out.println("Set Landmark? : ");
            cmd = input.next();
            if(cmd.charAt(0) == 'y'){
                this.level++;
                this.hasLandmark = true;
                this.setPurchasable(false);
                this.charge += 500;
                player.payMoney(500);
                player.setTotalAssets(player.getTotalAssets() + 500);
            }
        }
        if(this.getLevel() == 0 && player.getMoney() >= this.buyPrice){
            System.out.println("buy 1? : ");
            cmd = input.next();
            if(cmd.charAt(0) == 'y'){
                this.owner = player;
                this.level++;
                this.charge += 100;
                this.buyPrice += 100;
                player.payMoney(this.buyPrice);
                player.setTotalAssets(player.getTotalAssets() + this.buyPrice);
            }

        }
        if(this.getLevel() == 1 && player.getLapPassed() >= 1 && player.getMoney() >= this.buyPrice) {
            System.out.println("buy 2? : ");
            cmd = input.next();
            if(cmd.charAt(0) == 'y'){
                this.level++;
                this.charge += 100;
                this.buyPrice += 100;
                player.payMoney(100);
                player.setTotalAssets(player.getTotalAssets() + 100);
            }
        }
        if(this.getLevel() == 2 && player.getLapPassed() >= 1 && player.getMoney() >= this.buyPrice) {
            System.out.println("buy 3? : ");
            cmd = input.next();
            if(cmd.charAt(0) == 'y'){
                this.level++;
                this.charge += 100;
                this.buyPrice += 100;
                player.payMoney(100);
                player.setTotalAssets(player.getTotalAssets() + 100);
            }
        }
    }

    @Override
    public void trigger(Player player) {
        super.trigger(player);

        if(this.getOwner() != null && this.getOwner() != player){
            player.setTotalAssets(player.getMoney() - this.getCharge());
            this.getOwner().recvMoney(this.getCharge());

            System.out.println(player.getName() + " pay to " + owner.getName() + " amount : " + this.getCharge());
            if(player.getMoney() >= this.getBuyPrice()){
                System.out.println("Take over? : ");
                cmd = input.next();
                if(cmd.charAt(0) == 'y'){
                    player.payMoney(this.buyPrice);
                    owner.recvMoney(this.buyPrice);
                    owner.setTotalAssets(owner.getTotalAssets() - this.buyPrice);
                    this.owner = player;
                    this.owner.setTotalAssets(this.owner.getTotalAssets() + this.buyPrice);
                }
            }
        }
        else if(this.getOwner() == null && player.getMoney() >= this.buyPrice){
            System.out.println("Buy Land? : ");
            cmd = input.next();
            if(cmd.charAt(0) == 'y'){
                this.purchase(player);
                this.buyPrice += 100;
                this.charge += 100;
            }
        }

        if(this.getOwner() == player && this.isPurchasable()){
            purchase(player);
        }


    }
}
