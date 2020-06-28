package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseSulfurasTest {

    @Test
    void updateQuality_sulfurasNeverChanges() {
        Item itemToUpdate = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(itemToUpdate.name, itemToUpdate.name);
        assertEquals(0, itemToUpdate.sellIn);
        assertEquals(80, itemToUpdate.quality);
    }

    @Test
    void updateQuality_sulfurasNeverChanges_withSellInMin1() {
        Item itemToUpdate = new Item("Sulfuras, Hand of Ragnaros", -1, 80);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(-1, itemToUpdate.sellIn);
        assertEquals(80, itemToUpdate.quality);
    }

}
