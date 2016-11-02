package GetRich.models;

public class Plane extends Area{
    public Plane(String name, int index) {
        super("Plane", 27);
        this.setPurchasable(false);
        this.setType("Plane");
    }

    public void goTo(int index){
//        TODO: implements goTo method syncing with Player class
    }
}
