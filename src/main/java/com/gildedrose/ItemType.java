package com.gildedrose;

/**
 * NOTE TO EXPLAIN: the context would determine if an enum is possible
 */
public enum ItemType {

    STANDARD_ITEM ("standard item"),
    AGED_BRIE ("Aged Brie"),
    SULFURAS ("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES ("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED ("Conjured Mana Cake"),
    ;


    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
