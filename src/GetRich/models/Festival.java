package GetRich.models;

public class Festival extends Area{
    private Land currentFestival = null;
    public Festival() {
        super("Festival", 16);
        this.setPurchasable(false);
        this.setType("Festival");
    }

    public void trigger(Player player, int selected) {
        super.trigger(player);
        if(currentFestival != null)
            currentFestival.setOnFestival(false);

        player.getLand().get(selected).setOnFestival(true);
        currentFestival = player.getLand().get(selected);

    }
}
