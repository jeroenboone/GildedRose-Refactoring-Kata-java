package com.gildedrose;

public class BackStagePassItem extends GildedRoseItem {
    public BackStagePassItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.sellIn--;
        if (concertHasPassed(item.sellIn)) {
            item.quality = 0;
        } else {
            int tempQuality = item.quality + getDegradationAmount();
            item.quality = Math.min(tempQuality, 50);
        }
    }

    private boolean concertHasPassed(int daysToConcert) {
        return daysToConcert < 0;
    }

    private int getDegradationAmount() {
        if (item.quality >= 50) {
            return 0;
        }
        if (item.sellIn < 5) {
            return +3;
        }
        if (item.sellIn < 10) {
            return +2;
        }
        return 1;
    }

}
