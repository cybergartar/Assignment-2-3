package GetRich.controller;

import GetRich.models.Area;
import GetRich.models.Land;
import GetRich.models.Player;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class GamePlayController {
    Gameplay gameplay;
    @FXML ImageView cardOpen, dice1, dice2;
    @FXML Label mP1, aP1, rP1, mP2, aP2, rP2, mP3, aP3, rP3, mP4, aP4, rP4;
    @FXML GridPane mapGrid;
    @FXML List<Pane> tileList;
    @FXML Label roundLabel;


    public void handleTossButton() {
        int[] tossResult = tossDice();
//            System.out.println("assets/images/dice/d_" + tossResult[0] + ".png");
        System.out.println(getClass().getClassLoader());
        Image imgD1 = new Image(getClass().getResourceAsStream("../assets/images/dice/d_" + tossResult[0] + ".jpg"));
        Image imgD2 = new Image(getClass().getResourceAsStream("../assets/images/dice/d_" + tossResult[1] + ".jpg"));
        dice1.setImage(imgD1);
        dice2.setImage(imgD2);
        //TODO : MOVE THAT DAMN AVATAR
    }

    public void createGamePlay(ArrayList<Player> players) {
        this.gameplay = new Gameplay(50, players);
        this.gameplay.setTile(Initializer.createArea());
        cardOpen.setVisible(false);

        for (Player i : players) {
            Label tempM = null, tempA = null, tempR = null;
            if (i.getIndex() == 0) {
                tempM = mP1;    tempA = aP1;    tempR = rP1;
            }
            if (i.getIndex() == 1) {
                tempM = mP2;    tempA = aP2;    tempR = rP2;
            }
            if (i.getIndex() == 2) {
                tempM = mP3;    tempA = aP3;    tempR = rP3;
            }
            if (i.getIndex() == 3) {
                tempM = mP4;    tempA = aP4;    tempR = rP4;
            }

            setLabel(tempM, "Money: " + Long.toString(i.getMoney() / 1000000) + "M " + Long.toString((i.getMoney() % 1000000) / 1000) + "K");
            setLabel(tempA, "Assets: " + Long.toString(i.getTotalAssets() / 1000000) + "M " + Long.toString((i.getTotalAssets() % 1000000) / 1000) + "K");
            setLabel(tempR, Long.toString(i.getRank()));
        }

        for (Area i : gameplay.getTile()) {
            System.out.println("INDEX: " + i.getIndex() + " TYPE: " + i.getType());
        }

        for (int i = 0; i < tileList.size(); i++) {
            updatePriceTag(i);
        }


    }

    public void setLabel (Label label, String value) {
        label.setText(value);
    }

    public static int[] tossDice(){
        int x = (int)(Math.random()*6)+1;
        int y = (int)(Math.random()*6)+1;

        return new int[]{x, y};
    }

    public void updatePriceTag (int i) {

            String type = gameplay.getTile().get(i).getType();
            if(type == null )
                type = "";
            if (type.equals("Land") || type.equals("Beach")) {
                ObservableList<Node> ii = tileList.get(i).getChildren();
                for (Node aa : ii) {
                    if (aa instanceof VBox) {
                        ObservableList<Node> jj = ((VBox) aa).getChildren();
                        for (int q = jj.size()-1; q >= 0 ; q--) {
                            if (jj.get(q) instanceof Label) {
                                Long price = ((Land)gameplay.getTile().get(i)).getBuyPrice();
                                String priceText = "";
                                if(price >= 1000000)
                                    priceText = (price/1000000) + "M ";
                                if(price%1000000 != 0)
                                    priceText += ((price%1000000)/1000 + "K");
                                ((Label) jj.get(q)).setText(priceText);
                                break;
                            }
                        }
                    }
                }
            }
    }
}
