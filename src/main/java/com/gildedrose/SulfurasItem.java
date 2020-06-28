package com.gildedrose;

public class SulfurasItem extends GildedRoseItem {
    public SulfurasItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    }

}
