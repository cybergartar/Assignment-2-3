package GetRich.models;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private String name;
    private Color color;
    private long money, totalAssets;
    private ArrayList<Land> land = new ArrayList<>();
    private int lapPassed, rank;
    private boolean bankrupt = false, ready = false;
    private String avatar;

    public Player(String name, long money, String avatar){
        this.name = name;
        this.money = money;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public long getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(long totalAssets) {
        this.totalAssets = totalAssets;
    }

    public ArrayList<Land> getLand() {
        return land;
    }

    public void addLand(Land land){
        this.land.add(land);
    }

    public void removeLand(Land land) {
        if(this.land.contains(land))
            this.land.remove(land);
    }

    public int getLapPassed() {
        return lapPassed;
    }

    public void increaseLapPassed() {
        this.lapPassed += 1;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
