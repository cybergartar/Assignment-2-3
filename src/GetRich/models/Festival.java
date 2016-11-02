package GetRich.models;

public class Festival extends Area{
    private Land currenFestival = null;
    private long deafultCharge;
    public Festival() {
        super("Festival", 18);
        this.setPurchasable(false);
    }

    public void setFestival(Land target){
        if(currenFestival != null){
            currenFestival.setOnFestival(false);
            currenFestival.setCharge(deafultCharge);
        }

        currenFestival = target;
        deafultCharge = target.getCharge();
        target.setCharge(deafultCharge*2);
        target.setOnFestival(true);
    }
}
