package com.gildedrose;

public class GildedRoseItem {

    protected Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    /**
     * NOTE TO EXPLAIN: Strangler pattern
     * The 'correct' implementation would be something like the ConjuredItem class
     */
    public void updateQuality(){
        if (!item.name.equals(ItemType.AGED_BRIE.getName())
                && !item.name.equals(ItemType.BACKSTAGE_PASSES.getName())) {
            if (item.quality > 0) {
                if (!item.name.equals(ItemType.SULFURAS.getName())) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(ItemType.BACKSTAGE_PASSES.getName())) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals(ItemType.SULFURAS.getName())) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(ItemType.AGED_BRIE.getName())) {
                if (!item.name.equals(ItemType.BACKSTAGE_PASSES.getName())) {
                    if (item.quality > 0) {
                        if (!item.name.equals(ItemType.SULFURAS.getName())) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

}
