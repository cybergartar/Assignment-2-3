package GetRich.models;

public class Lucky extends Area{

    public Lucky(int index) {
        super("Lucky", index);
        this.setPurchasable(false);
        this.setType("Lucky");
    }

    public void trigger(Player player, int randomed) {
        super.trigger(player);
        switch (randomed) {
            case 1: player.payMoney(2000); break;
            case 2: player.payMoney(3000); break;
            case 3: player.payMoney(5000); break;
            case 4: player.payMoney(500); break;
            case 5: player.payMoney(2000); break;
            case 6: player.payMoney(1000); break;
            case 7: player.payMoney(1500); break;
            case 8: player.payMoney(player.getMoney() / 2); break;
            case 9: player.bankrupt();
            case 10: player.recvMoney(2000); break;
            case 11: player.recvMoney(1500); break;
            case 12: player.recvMoney(1000); break;
            case 13: player.recvMoney(2500); break;
            case 14: player.recvMoney(5000); break;
            case 15: player.recvMoney(10000); break;
            case 16: player.recvMoney(500); break;

            //TODO : BANKRUPTTTTTTTT
        }
    }



//    TODO: think more lucky method

}
