package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_default_test() {
        Item itemToUpdate = new Item("Elixir of the Mongoose", 5, 7);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals("Elixir of the Mongoose", itemToUpdate.name);
        assertEquals(4, itemToUpdate.sellIn);
        assertEquals(6, itemToUpdate.quality);
    }

    @Test
    void updateQuality_default_degradation_then_sellIn_decreases_and_QualityDecreases() {
        Item itemToUpdate = new Item("+5 Dexterity Vest", 10, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals("+5 Dexterity Vest", itemToUpdate.name);
        assertEquals(9, itemToUpdate.sellIn);
        assertEquals(19, itemToUpdate.quality);
    }

    @Test
    void updateQuality_itemQualityOfAnItemIsNeverMoreThan50() {
        Item itemToUpdate = new Item(ItemType.STANDARD_ITEM.getName(), 2, 50);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(49, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenHasAlmostPassed_thenDegradeNormally() {
        Item itemToUpdate = new Item(ItemType.STANDARD_ITEM.getName(), 1, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(19, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenSellDateHasPassed_thenDegradeTwiceAsFast() {
        Item itemToUpdate = new Item(ItemType.STANDARD_ITEM.getName(), 0, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(-1, itemToUpdate.sellIn);
        assertEquals(18, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenSellDateHasPassed_andQualityIsZere_thenDoNotDegradeFurther() {
        Item itemToUpdate = new Item(ItemType.STANDARD_ITEM.getName(), -1, 0);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(0, itemToUpdate.quality);
    }


}
