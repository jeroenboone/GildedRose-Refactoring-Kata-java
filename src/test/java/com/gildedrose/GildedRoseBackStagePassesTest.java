package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseBackStagePassesTest {

    protected Item createItem(int sellIn, int quality) {
        return new Item(ItemType.BACKSTAGE_PASSES.getName(), sellIn, quality);
    }

    @Test
    void updateQuality_default() {
        Item itemToUpdate = createItem(15, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(itemToUpdate.name, itemToUpdate.name);
        assertEquals(14, itemToUpdate.sellIn);
        assertEquals(21, itemToUpdate.quality);
    }

    @Test
    void updateQuality_with_sellIn10_and_Quality49() {
        Item itemToUpdate = createItem(10, 49);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(itemToUpdate.name, itemToUpdate.name);
        assertEquals(9, itemToUpdate.sellIn);
        assertEquals(50, itemToUpdate.quality);
    }

    @Test
    void updateQuality_with_sellIn5_and_Quality49() {
        Item itemToUpdate = createItem(5, 49);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(itemToUpdate.name, itemToUpdate.name);
        assertEquals(4, itemToUpdate.sellIn);
        assertEquals(50, itemToUpdate.quality);
    }

    @Test
    void updateQuality_itemQualityOfAnItemIsNeverMoreThan50() {
        Item itemToUpdate = createItem(2, 50);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(50, itemToUpdate.quality);
    }

    @Test
    void updateQuality_default_degradation_then_sellIn_decreases_and_QualityIncreases() {
        Item itemToUpdate = createItem(15, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(14, itemToUpdate.sellIn);
        assertEquals(21, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenSellDateHasPassed_thenValueDropsToZero() {
        Item itemToUpdate = createItem(0, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(0, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenSellDateHasPassed_andQualityIsZer0_thenDoNotDegradeFurther() {
        Item itemToUpdate = createItem(-1, 0);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(0, itemToUpdate.quality);
    }

    @Test
    void updateQuality_given11SelDaysRemainingOrLess_ThenIncreaseWith1() {
        Item itemToUpdate = createItem(11, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(21, itemToUpdate.quality);
    }

    @Test
    void updateQuality_given10SelDaysRemainingOrLess_ThenIncreaseWith2() {
        Item itemToUpdate = createItem(10, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(22, itemToUpdate.quality);
    }

    @Test
    void updateQuality_given6SelDaysRemainingOrLess_ThenIncreaseWith2() {
        Item itemToUpdate = createItem(6, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(22, itemToUpdate.quality);
    }

    @Test
    void updateQuality_given5SelDaysRemainingOrLess_ThenIncreaseWith3() {
        Item itemToUpdate = createItem(5, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(23, itemToUpdate.quality);
    }

    @Test
    void updateQuality_given1SelDaysRemainingOrLess_ThenIncreaseWith3() {
        Item itemToUpdate = createItem(1, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(23, itemToUpdate.quality);
    }


}
