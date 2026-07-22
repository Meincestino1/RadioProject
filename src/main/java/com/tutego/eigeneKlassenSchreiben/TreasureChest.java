package com.tutego.eigeneKlassenSchreiben;

public class TreasureChest {

    public final int goldDoubloonWeight;
    public final int gemstonWeight;

    private TreasureChest(int goldDoubloonWeight, int gemstonWeight) {
        if (goldDoubloonWeight < 0 || gemstonWeight < 0) {
            throw new IllegalArgumentException("Weight can't be negative");
        }
        this.goldDoubloonWeight = goldDoubloonWeight;
        this.gemstonWeight = gemstonWeight;
    }

    public static TreasureChest newInstance() {
        return new TreasureChest(0, 0);
    }

    public static TreasureChest newInstanceWithGoldDoubloonWeight(int weight) {
        return new TreasureChest(weight, 0);
    }

    public static TreasureChest newInstanceWithGemstoneWeight(int weight) {
        return new TreasureChest(0, weight);
    }

    public static TreasureChest newInstanceWithGoldDoubloonAndGemstoneWeight(int goldDoubloonWeight, int gemstonWeight) {
        return new TreasureChest(goldDoubloonWeight, gemstonWeight);
    }


}
