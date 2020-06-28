package com.gildedrose;

public class ConjuredItem extends GildedRoseItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.sellIn--;
        item.quality = Math.max(item.quality - getDegradationAmount(), 0);
    }

    private int getDegradationAmount() {
        if (item.quality <= 0) {
            return 0;
        }
        if (item.sellIn >= 0) {
            return 2;
        }
        return 4;
    }

}
