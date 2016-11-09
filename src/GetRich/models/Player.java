package GetRich.models;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private String name;
    private Color color;
    private long money, totalAssets;
    private ArrayList<Land> land;
    private int lapPassed, rank;
    private boolean bankrupt = false, ready = false;
    private int order;
    private int currentTile;
    private int turnLeftOnIsland;
    private boolean onPlane = false;
    private int index;
    private int planePoint;

    public Player(String name, long money, int index){
        this.name = name;
        this.money = money;
        this.totalAssets = money;
        this.index = index;
        this.land = new ArrayList<>();
    }

    public int getPlanePoint() {
        return planePoint;
    }

    public void setPlanePoint(int planePoint) {
        this.planePoint = planePoint;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(int currentTile) {
        this.currentTile = currentTile;
    }

    public int getTurnLeftOnIsland() {
        return turnLeftOnIsland;
    }

    public void setTurnLeftOnIsland(int turnLeftOnIsland) {
        this.turnLeftOnIsland = turnLeftOnIsland;
    }

    public boolean isOnPlane() {
        return onPlane;
    }

    public void setOnPlane(boolean onPlane) {
        this.onPlane = onPlane;
    }

    public void payMoney(long money){
        this.money -= money;
        this.totalAssets -= money;
    }

    public void recvMoney(long money){
        this.money += money;
        this.totalAssets += money;
    }

    public void bankrupt(){
        for(Land i : this.getLand()){
            i.clearLand();
        }

        this.land.clear();
        this.setMoney(0);
        this.setTotalAssets(0);
        this.setBankrupt(true);
    }

    public void removeLand(Land i){
        land.remove(i);
        i.removeOwner();
    }

}

