package GetRich.models;

public class Plane extends Area{
    public Plane(String name, int index) {
        super(name, index);
        this.setPurchasable(false);
    }

    public void goTo(int index){
//        TODO: implements goTo method syncing with Player class
    }
}
