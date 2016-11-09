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



//    public void purchase(Player player){
//        if(this.getLevel() == 3 && player.getLapPassed() >= 2 && player.getMoney() >= this.buyPrice) {
//            System.out.println("Set Landmark? : ");
//            // cmd = input.next();
//            cmd = "y";
//            if(cmd.charAt(0) == 'y'){
//                player.payMoney(Variable.calculatedLandPrice(this.getIndex(), 4));
//                this.buyPrice += (2 * Variable.calculatedLandPrice(this.getIndex(), 4));
//                this.baseCharge += Variable.calculatedLandPrice(this.getIndex(), 4);
//                this.realCharge = ((long) (this.baseCharge * Variable.chargeMultipiler));
//                player.setTotalAssets(player.getTotalAssets() + realCharge);
//                this.level++;
//
//                this.setPurchasable(false);
//            }
//        }
//
//        if (this.getLevel() == -1 && player.getMoney() >= this.buyPrice) {
//            System.out.println("buy land? : ");
//            // // cmd = input.next();
//            cmd = "y";
//            if (cmd.charAt(0) == 'y') {
//                this.owner = player;
//                player.addLand(this);
//                player.payMoney(Variable.calculatedLandPrice(this.getIndex(), 0));
//
//                this.level++;
//
//                if(this.getType().equals("Beach"))
//                    this.level = 4;
//
//                this.buyPrice *= 2;
//                this.realCharge = ((long) (baseCharge * Variable.chargeMultipiler));
//                player.setTotalAssets(player.getTotalAssets() + realCharge);
//            }
//        }
//
//        if(this.getLevel() == 0 && player.getMoney() >= this.buyPrice){
//            System.out.println("buy 1? : ");
//            // cmd = input.next();
//            cmd = "y";
//            if(cmd.charAt(0) == 'y'){
//                player.payMoney(Variable.calculatedLandPrice(this.getIndex(), 1));
//                this.buyPrice += (2 * Variable.calculatedLandPrice(this.getIndex(), 1));
//                this.baseCharge += Variable.calculatedLandPrice(this.getIndex(), 1);
//                this.realCharge = ((long) (this.baseCharge * Variable.chargeMultipiler));
//                this.level++;
//
//                player.setTotalAssets(player.getTotalAssets() + realCharge);
//            }
//
//        }
//
//        if(this.getLevel() == 1 && player.getMoney() >= this.buyPrice) {
//            System.out.println("buy 2? : ");
//            // cmd = input.next();
//            cmd = "y";
//            if(cmd.charAt(0) == 'y'){
//                player.payMoney(Variable.calculatedLandPrice(this.getIndex(), 2));
//                this.buyPrice += (2 * Variable.calculatedLandPrice(this.getIndex(), 2));
//                this.baseCharge += Variable.calculatedLandPrice(this.getIndex(), 2);
//                this.realCharge = ((long) (this.baseCharge * Variable.chargeMultipiler));
//                this.level++;
//                player.setTotalAssets(player.getTotalAssets() + realCharge);
//            }
//        }
//        if(this.getLevel() == 2 && player.getLapPassed() >= 1 && player.getMoney() >= this.buyPrice) {
//            System.out.println("buy 3? : ");
//            // cmd = input.next();
//            cmd = "y";
//            if(cmd.charAt(0) == 'y'){
//                player.payMoney(Variable.calculatedLandPrice(this.getIndex(), 3));
//                this.buyPrice += (2 * Variable.calculatedLandPrice(this.getIndex(), 3));
//                this.baseCharge += Variable.calculatedLandPrice(this.getIndex(), 3);
//                this.realCharge = ((long) (this.baseCharge * Variable.chargeMultipiler));
//                this.level++;
//                player.setTotalAssets(player.getTotalAssets() + realCharge);
//            }
//        }
//    }

    @Override
    public void trigger(Player player) {
        super.trigger(player);

//        if(this.getOwner() != null && this.getOwner() != player){
//            if(this.isOnFestival()){
//                player.payMoney(this.getRealCharge() * 2);
//                this.getOwner().recvMoney(this.getRealCharge() * 2);
//            }
//            else {
//                player.payMoney(this.getRealCharge());
//                this.getOwner().recvMoney(this.getRealCharge());
//            }
//
//            //TODO: HANDLE WHEN MONEY IS NOT ENOUGH
//
//            System.out.println(player.getName() + " pay to " + owner.getName() + " amount : " + this.getRealCharge());
//            if(player.getMoney() >= this.getBuyPrice() && this.isPurchasable()){
//                System.out.println("Take over? : ");
//                // cmd = input.next();
//                cmd = "y";
//                if(cmd.charAt(0) == 'y'){
//                    owner.recvMoney(this.buyPrice);
//                    owner.removeLand(this);
//                    player.payMoney(this.buyPrice);
//
//                    this.owner = player;
//                    owner.addLand(this);
//                }
//            }
//        }
//        else if(this.getOwner() == null && player.getMoney() >= this.buyPrice && this.isPurchasable()){
//            System.out.println("PUR NULL OWNER");
//            purchase(player);
//        }
//
//        if(this.getOwner() == player && this.isPurchasable()){
//            System.out.println("PUR OWN");
//            purchase(player);
//        }


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
        System.out.println("PREOWNER: " + owner);
        owner.recvMoney(this.buyPrice);
        owner.removeLand(this);
        player.payMoney(this.buyPrice);

        this.owner = player;
        owner.addLand(this);
        System.out.println("POSTOWNER: " + owner + " LEVEL: " + this.level);

    }

    public void purchase (Player player, int levelBuy) {
        System.out.println("EIEIGUM LEVELBUY: " + levelBuy + " thislevel: " + this.level);

        long sum = 0;
        if(this instanceof Beach) {
            this.setPurchasable(false);
            sum = Variable.calculatedLandPrice(this.getIndex(), 0);
        }
        else {
            if(this.level == -1) {
                this.owner = player;
                player.addLand(this);
                System.out.println("ADDED PLAYER: " + player.getName());
                for (Land i : player.getLand()) {
                    System.out.println(i.getName());
                }
                System.out.println("=============================");
            }
            for (int i = -1; i < levelBuy; i++){
                sum += Variable.calculatedLandPrice(this.getIndex(), i+1);
                this.level = i+1;
                System.out.println("PLUSING: " + this.level);
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
            System.out.println("OWNER NOW: " + this.owner.getName());
        }

        if (levelBuy == 4)
            this.setPurchasable(false);

    }

    public void clearLand () {
        this.removeOwner();
        this.setLevel(-1);
        if(this instanceof Beach){
            System.out.println("REMOVE BEACH LVL: " + this.getLevel());
        }
        this.setBuyPrice(Variable.calculatedLandPrice(this.getIndex(), 0));
        this.setBaseCharge(0);
        this.setRealCharge(0);
        this.setPurchasable(true);
        if(!(this instanceof Beach))
            this.setLandmarkStatus(false);
    }
}
