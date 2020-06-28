package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {

    private final List<GildedRoseItem> items;

    public static GildedRose create(Item... items) {
        return new GildedRose(items);
    }

    public GildedRose(Item[] items) {
        this.items = Arrays.stream(items)
                .map(GildedRoseFactory::create)
                .collect(Collectors.toList());
    }

    public void updateQuality() {
        for (GildedRoseItem item : items) {
            item.updateQuality();
        }
    }

}