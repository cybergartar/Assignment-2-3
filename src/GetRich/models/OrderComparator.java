package GetRich.models;

import java.util.Comparator;

public class OrderComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if(o1.getOrder() < o2.getOrder())
            return -1;
        else
            return 1;
    }
}
