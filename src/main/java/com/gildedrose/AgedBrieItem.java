package com.gildedrose;

public class AgedBrieItem extends GildedRoseItem {
    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.sellIn--;
        int tempQuality = item.quality + getAmountToIncrement();
        item.quality = Math.min(tempQuality, 50);
    }

    private int getAmountToIncrement() {
        if (item.quality >= 50) {
            return 0;
        }
        if (item.sellIn < 0) {
            return 2;
        }
        return 1;
    }

}
