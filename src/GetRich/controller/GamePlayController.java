package GetRich.controller;

import GetRich.Main;
import GetRich.models.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GamePlayController {
    Gameplay gameplay;
    @FXML ImageView dice1, dice2, avtP1, avtP2, avtP3, avtP4, starL1, starL2, starL3, starBeach, landMark;
    @FXML Label mP1, aP1, rP1, mP2, aP2, rP2, mP3, aP3, rP3, mP4, aP4, rP4;
    @FXML GridPane mapGrid;
    @FXML List<Pane> tileList;
    @FXML Label roundLabel, turnLabel, tossLabel;
    @FXML List<ImageView> avatar;
    @FXML List<GridPane> starList;

    int playerIndex = 0;

    public void handleTossButton() {
        int[] tossResult = tossDice();
        Player player = gameplay.getPlayers().get(playerIndex);
        Area tile;
        Stage currentStage = Main.getPrimaryStage();

        Image imgD1 = new Image(getClass().getResourceAsStream("../assets/images/dice/d_" + tossResult[0] + ".jpg"));
        Image imgD2 = new Image(getClass().getResourceAsStream("../assets/images/dice/d_" + tossResult[1] + ".jpg"));
        dice1.setImage(imgD1);
        dice2.setImage(imgD2);
        setLabel(tossLabel, Integer.toString(tossResult[0] + tossResult[1]));

        int sumToss = tossResult[0] + tossResult[1];
//        Media sound = new Media(new File("src/GetRich/assets/sounds/" + sumToss + ".mp3").toURI().toString());
//        MediaPlayer mp = new MediaPlayer(sound);
//        mp.play();
        move(gameplay.getPlayers().get(playerIndex), tossResult[0] + tossResult[1]);

        tile = gameplay.getTile().get(player.getCurrentTile());
        Pane thisTile = tileList.get(tile.getIndex());
        ObservableList<Node> tileChildren = thisTile.getChildren();

        String landName = "Error";

        for (Node i : tileChildren) {
            if(i instanceof VBox) {
                ObservableList<Node> vboxChildren = ((VBox) i).getChildren();
                landName = ((Label) vboxChildren.get(0)).getText();
            }
        }

        if(tile instanceof Land) {
            LandController.onPlayerStepped(currentStage, player, (Land) tile, landName);
            updateTileData((Land) tile, player.getIndex());
        }
        else if (tile instanceof Island){
            tile.trigger(player);
        }
        else if (tile instanceof Festival) {
            if(player.getLand().size() > 0){
                try {
                    Stage dialog = new Stage();
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/FestivalForm.fxml"));
                    Parent root = loader.load();
                    FestivalController controller = loader.getController();
                    controller.initializer(dialog, player, (Festival) tile);

                    dialog.initStyle(StageStyle.UNDECORATED);
                    dialog.initModality(Modality.WINDOW_MODAL);
                    dialog.initOwner(currentStage);
                    dialog.setScene(new Scene(root, 500, 300));
                    dialog.setTitle("FESTIVAL!");
                    dialog.showAndWait();

                    while (dialog.isShowing());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (tile instanceof Plane) {
            try {
                Stage dialog = new Stage();
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/PlaneForm.fxml"));
                Parent root = loader.load();
                PlaneController controller = loader.getController();
                controller.initializer(dialog, player, (Plane) tile, gameplay.getTile());

                dialog.initStyle(StageStyle.UNDECORATED);
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(currentStage);
                dialog.setScene(new Scene(root, 500, 300));
                dialog.setTitle("PLANE!");
                dialog.showAndWait();

                while (dialog.isShowing());
            } catch (IOException e) {
                e.printStackTrace();
            }

            int movePlane;
            if (player.getPlanePoint() < player.getCurrentTile()) {
                movePlane = (31 - player.getCurrentTile() ) + player.getPlanePoint() + 1;
            }
            else {
                movePlane = player.getPlanePoint() - player.getCurrentTile();
            }
            move(player, movePlane);
        }
        else if (tile instanceof Lucky) {
            try {
                Stage dialog = new Stage();
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/LuckyForm.fxml"));
                Parent root = loader.load();
                LuckyController controller = loader.getController();
                controller.initializer(dialog, player, (Lucky) tile);

                dialog.initStyle(StageStyle.UNDECORATED);
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(currentStage);
                dialog.setScene(new Scene(root, 800, 500));
                dialog.setTitle("LUCK!");
                dialog.showAndWait();

                while (dialog.isShowing());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        updateAllPlayersData();

        if (player.isBankrupt()) {
            gameplay.decreasePlayerNum();
            Pane thisPlayerTile;
            for (Land i : player.getLand()) {
                updateTileData(i, -1);
            }

            thisPlayerTile = tileList.get(player.getCurrentTile());
            ObservableList<Node> thisTileChild = thisPlayerTile.getChildren();
            for (Node i : thisTileChild) {
                if(i instanceof VBox) {
                    ObservableList<Node> ii = ((VBox) i).getChildren();
                    for (Node iii : ii) {
                        if (iii instanceof GridPane) {
                            ObservableList<Node> inGrid = ((GridPane) iii).getChildren();
                            inGrid.remove(avatar.get(player.getIndex()));
                        }
                    }
                }
            }


        }

        playerIndex ++;
        if(playerIndex == 4) {
            playerIndex = 0;
            gameplay.setRoundPlay(gameplay.getRoundPlay() + 1);
            setLabel(roundLabel, "Round: " + gameplay.getRoundPlay());
        }

        while (gameplay.getPlayers().get(playerIndex).getTurnLeftOnIsland() > 0 || gameplay.getPlayers().get(playerIndex).isBankrupt()) {
            if (gameplay.getPlayers().get(playerIndex).getTurnLeftOnIsland() > 0 ) {
                gameplay.getPlayers().get(playerIndex).setTurnLeftOnIsland(gameplay.getPlayers().get(playerIndex).getTurnLeftOnIsland() -1);
            }
            playerIndex ++;

            if(playerIndex == 4) {
                playerIndex = 0;
                gameplay.setRoundPlay(gameplay.getRoundPlay() + 1);
                setLabel(roundLabel, "Round: " + gameplay.getRoundPlay());
            }
        }
        setLabel(turnLabel, "Player " + (gameplay.getPlayers().get(playerIndex).getIndex()+1) + "'s Turn");

        if (gameplay.getPlayerLeft() == 1 || gameplay.getRoundPlay() == gameplay.getRoundLimit()) {
            WinGameController.endGame(gameplay.getRank());
        }
    }

    public void move (Player player, int walkPoint) {
        Pane thisTile, toTile;
        thisTile = tileList.get(player.getCurrentTile());

        int walkAmount = player.getCurrentTile() + walkPoint;
        if(walkAmount >= 32) {
            walkAmount %= 32;
            player.increaseLapPassed();
            player.recvMoney(500000);
        }

        toTile = tileList.get(walkAmount);
        player.setCurrentTile(walkAmount);

        System.out.println("PLAYERINDEX: " + player.getIndex() + " NOW AT: " + player.getCurrentTile() + " TO: " + walkAmount);
        ObservableList<Node> thisTileChild = thisTile.getChildren();
        ObservableList<Node> toTileChild = toTile.getChildren();

        for (Node i : thisTileChild) {
            if(i instanceof VBox) {
                ObservableList<Node> ii = ((VBox) i).getChildren();
                for (Node iii : ii) {
                    if (iii instanceof GridPane) {
                        ObservableList<Node> inGrid = ((GridPane) iii).getChildren();
                        inGrid.remove(avatar.get(player.getIndex()));
                    }
                }
            }
        }

        for (Node i :toTileChild) {
            if(i instanceof VBox) {
                ObservableList<Node> ii = ((VBox) i).getChildren();
                for (Node iii : ii ) {
                    if (iii instanceof GridPane) {
                        ObservableList<Node> inGrid = ((GridPane) iii).getChildren();
                        inGrid.add(avatar.get(player.getIndex()));
                    }
                }
            }
        }



    }

    public void createGamePlay(ArrayList<Player> players) {
        this.gameplay = new Gameplay(50, players);
        this.gameplay.setTile(Initializer.createArea());

        for (int i = 0; i < 32; i ++) {
            Pane thisTile = tileList.get(i);
            ObservableList<Node> tileChildren = thisTile.getChildren();
            for (Node ii : tileChildren) {
                if(ii instanceof VBox) {
                    ObservableList<Node> vboxChildren = ((VBox) ii).getChildren();
                    this.gameplay.getTile().get(i).setName(((Label) vboxChildren.get(0)).getText());
                }
            }
        }





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

            setLabel(tempM, "M: " + convertPriceToString(i.getMoney()));
            setLabel(tempA, "A: " + convertPriceToString(i.getTotalAssets()));
            setLabel(tempR, Long.toString(i.getRank()));
        }

        for (Area i : gameplay.getTile()) {
            System.out.println("INDEX: " + i.getIndex() + " TYPE: " + i.getType());
        }

        for (int i = 0; i < tileList.size(); i++) {
            updatePriceTag(i);
        }

        setLabel(turnLabel, "Player " + (gameplay.getPlayers().get(0).getIndex()+1) + "'s Turn");
        setLabel(tossLabel, "0");

        GridPane startPane = starList.get(0);
        ObservableList<Node> inStartPane = startPane.getChildren();
        inStartPane.remove(starL1);
        inStartPane.remove(starL2);
        inStartPane.remove(starL3);
        inStartPane.remove(starBeach);
        inStartPane.remove(landMark);

    }

    public static void setLabel (Label label, String value) {
        label.setText(value);
    }

    public static String convertPriceToString (Long price) {
        String priceString = "";
        if (price > 1000000)
            priceString += (price / 1000000) + "M ";
        if(price % 1000000 != 0)
            priceString += ((price % 1000000) / 1000 ) + "K";
        return priceString;
    }

    public static int[] tossDice(){
        int x = (int)(Math.random()*6)+1;
        int y = (int)(Math.random()*6)+1;

        return new int[]{x, y};
//        return new int[]{4, 4};
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

    public void updateAllPlayersData() {
        ArrayList<Player> rank = new ArrayList<>();
        int rankNum = 1;

        rank.addAll(gameplay.getPlayers());

        Collections.sort(rank, new RankComparator());

        for (Player i : rank) {
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

            setLabel(tempR, Integer.toString(rankNum));
            setLabel(tempM, "M: " + convertPriceToString(i.getMoney()));
            setLabel(tempA, "A: " + convertPriceToString(i.getTotalAssets()));
            rankNum ++;
        }
    }

    public void updateTileData(Land tile, int playerIndex) {
        Pane thisTile = tileList.get(tile.getIndex());
        ObservableList<Node> tileChildren = thisTile.getChildren();
        GridPane thisStarTile = starList.get(tile.getIndex());
        ObservableList<Node> thisStarTileChild = thisStarTile.getChildren();

        for (Node i : tileChildren) {
            if(i instanceof ImageView) {
                if (playerIndex != -1 && tile.getOwner() != null) {
                    Image tileBg = new Image(getClass().getResourceAsStream("../assets/best/slot-ช่องที่ดิน/bg_land" + tile.getOwner().getIndex() + ".png"));
                    ((ImageView) i).setImage(tileBg);
                }
                else{
                    Image tileBg = new Image(getClass().getResourceAsStream("../assets/best/slot-ช่องที่ดิน/void.png"));
                    ((ImageView) i).setImage(tileBg);
                }
                break;
            }
        }

        ImageView newStarBeach, newLandMark;
        ImageView[] newStar = new ImageView[3];

        newStar[0] = cloneImageView(false, "star");
        newStar[1] = cloneImageView(false, "star");
        newStar[2] = cloneImageView(false, "star");

        newStarBeach = cloneImageView(false, "umbrella");

        int[] sequenceArray = new int[]{1, 2, 3};



        if (tile.getIndex() < 8) {
            if (tile instanceof Beach) {
                thisStarTile.add(newStarBeach, 2, 4);
            }
            else {
                for (int i = 1; i <= 3; i++) {
                    if (tile.getLevel() >= i) {
                        thisStarTile.add(newStar[i-1], sequenceArray[i-1], 4);
                    }
                }

                if(tile.getLevel() == 4) {
                    ArrayList<Node> remove = new ArrayList<>();
                    for (Node i : thisStarTileChild) {
                        if(i instanceof ImageView && thisStarTile.getColumnIndex(i) >= 1 && thisStarTile.getColumnIndex(i) <= 3 && thisStarTile.getRowIndex(i) == 4)
                            remove.add(i);
                    }
                    for (Node i : remove) {
                        thisStarTileChild.remove(i);
                    }
                    newLandMark = cloneImageView(true, "landmark");
                    thisStarTile.add(newLandMark, 1, 4, 3, 1);
                }
            }

        }
        else if (tile.getIndex() < 16) {
            if (tile instanceof Beach) {
                thisStarTile.add(newStarBeach, 0, 2);
            }
            else {
                for (int i = 1; i <= 3; i++) {
                    if (tile.getLevel() >= i) {
                        thisStarTile.add(newStar[i-1], 0, sequenceArray[i-1]);
                    }
                }

                if(tile.getLevel() == 4) {
                    ArrayList<Node> remove = new ArrayList<>();
                    for (Node i : thisStarTileChild) {
                        if (i instanceof ImageView && thisStarTile.getRowIndex(i) >= 1 && thisStarTile.getRowIndex(i) <= 3 && thisStarTile.getColumnIndex(i) == 0)
                            remove.add(i);
                    }
                    for (Node i : remove) {
                        thisStarTileChild.remove(i);
                    }
                    newLandMark = cloneImageView(true, "landmark_left");
                    thisStarTile.add(newLandMark, 0, 1, 1, 3);

                }
            }

        }
        else if (tile.getIndex() < 24) {
            if (tile instanceof Beach) {
                thisStarTile.add(newStarBeach, 2, 0);
            }
            else {
                for (int i = 1; i <= 3; i++) {
                    if (tile.getLevel() >= i) {
                        thisStarTile.add(newStar[i-1], sequenceArray[i-1], 0);
                    }
                }

                if(tile.getLevel() == 4) {
                    ArrayList<Node> remove = new ArrayList<>();
                    for (Node i : thisStarTileChild ) {
                        if (i instanceof ImageView && thisStarTile.getColumnIndex(i) >= 1 && thisStarTile.getColumnIndex(i) <= 3 && thisStarTile.getRowIndex(i) == 0)
                            remove.add(i);
                    }
                    for (Node i : remove) {
                        thisStarTileChild.remove(i);
                    }
                    newLandMark = cloneImageView(true, "landmark");
                    thisStarTile.add(newLandMark, 1, 0, 3, 1);
                }
            }

        }
        else {
            if (tile instanceof Beach) {
                thisStarTile.add(newStarBeach, 4, 2);
            }
            else {
                for (int i = 1; i <= 3; i++) {
                    if (tile.getLevel() >= i) {
                        thisStarTile.add(newStar[i-1], 4, sequenceArray[i-1]);
                    }
                }

                if(tile.getLevel() == 4) {
                    ArrayList<Node> remove = new ArrayList<>();
                    for (Node i : thisStarTileChild) {
                        if (i instanceof ImageView && thisStarTile.getRowIndex(i) >= 1 && thisStarTile.getRowIndex(i) <= 3 && thisStarTile.getColumnIndex(i) == 4)
                            remove.add(i);
                    }
                    for (Node i : remove) {
                        thisStarTileChild.remove(i);
                    }
                    newLandMark = cloneImageView(true, "landmark_right");
                    thisStarTile.add(newLandMark, 4, 1, 1, 3);
                }
            }

        }

        for (int i = tileChildren.size()-1; i >= 0; i--) {
            if (tileChildren.get(i) instanceof VBox) {
                ObservableList<Node> vboxChildren = ((VBox) tileChildren.get(i)).getChildren();
                if(tile.isOnFestival()) {
                    setLabel(((Label) vboxChildren.get(2)), convertPriceToString(tile.getRealCharge() * 2));
                }
                else {
                    setLabel(((Label) vboxChildren.get(2)), convertPriceToString(tile.getRealCharge()));
                }

                break;
            }
        }

    }

    public ImageView cloneImageView (boolean isLandmark, String imgName) {
        ImageView newView = new ImageView();
        newView.setImage(new Image(getClass().getResourceAsStream("../assets/images/" + imgName + ".png")));

        if(imgName.equals("landmark_left") || imgName.equals("landmark_right")) {
            newView.setFitWidth(18);
        }
        else {
            newView.setFitHeight(18);
        }
        if (!isLandmark) {
            newView.setFitWidth(23);
        }
        else {
            newView.setPreserveRatio(true);
        }

        return newView;
    }
}


class RankComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if(o1.getTotalAssets() > o2.getTotalAssets())
            return -1;
        else if (o1.getOrder() < o2.getOrder())
            return -1;

        return 1;
    }
}
