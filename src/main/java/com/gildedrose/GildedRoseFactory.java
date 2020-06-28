package com.gildedrose;

public class GildedRoseFactory {

    public static GildedRoseItem create(Item item) {
        if (ItemType.AGED_BRIE.getName().equals(item.name)) {
            return new AgedBrieItem(item);
        }
        if (ItemType.BACKSTAGE_PASSES.getName().equals(item.name)) {
            return new BackStagePassItem(item);
        }
        if (ItemType.SULFURAS.getName().equals(item.name)) {
            if (item.quality != 80) {
                throw new RuntimeException("Sulfuras quality is 80 and it never alters");
            }
            return new SulfurasItem(item);
        }
        if (ItemType.CONJURED.getName().equals(item.name)) {
            return new ConjuredItem(item);
        }
        return new GildedRoseItem(item);
    }

}
