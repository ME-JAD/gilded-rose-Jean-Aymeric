package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private static final int CLASSIC_ITEM_MAX_QUALITY = 50;
    private static final String CLASSIC_ITEM_NAME = "Classic Item";

    private GildedRose gildedRose;
    private List<IItem> items;

    @BeforeEach
    void setUp() {
        this.items = new ArrayList<>();
    }

    @Test
    void updateQualityClassicItemDecreasesQuality() {
        int sellInStart = 10;
        int qualityStart = 20;
        IItem classicItem = new ItemAdapter(GildedRoseTest.CLASSIC_ITEM_NAME, sellInStart, qualityStart);
        this.items.add(classicItem);

        this.gildedRose = new GildedRose(this.getArrayItems());
        for (int day = 0; day < sellInStart; day++) {
            assertEquals(qualityStart - day,
                         classicItem.getQuality(),
                         "Classic item quality should decrease by 1 each day until sellIn reaches 0.");
            this.gildedRose.updateQuality();
        }
    }

    private IItem[] getArrayItems() {
        return this.items.toArray(new IItem[0]);
    }

    @Test
    void updateQualityClassicItemQualityNeverNegative() {
        int sellInStart = 10;
        int qualityStart = 0;
        IItem classicItem = new ItemAdapter(GildedRoseTest.CLASSIC_ITEM_NAME, sellInStart, qualityStart);
        this.items.add(classicItem);

        this.gildedRose = new GildedRose(this.getArrayItems());
        for (int day = 0; day < sellInStart; day++) {
            assertEquals(0, classicItem.getQuality(), "Classic item quality should never go below 0.");
            this.gildedRose.updateQuality();
        }
    }

    @Test
    void updateQualityClassicItemQualityNeverExceedsMax() {
        int sellInStart = 10;
        IItem classicItem = new ItemAdapter(GildedRoseTest.CLASSIC_ITEM_NAME, sellInStart,
                                            GildedRoseTest.CLASSIC_ITEM_MAX_QUALITY + 1);
        this.items.add(classicItem);

        this.gildedRose = new GildedRose(this.getArrayItems());
        for (int day = 0; day < sellInStart; day++) {
            assertEquals(GildedRoseTest.CLASSIC_ITEM_MAX_QUALITY - day, classicItem.getQuality(),
                         "Classic item quality should never exceed " + GildedRoseTest.CLASSIC_ITEM_MAX_QUALITY + ".");
            this.gildedRose.updateQuality();
        }
    }

    @Test
    void updateQualityClassicItemQualityDecreasesTwiceAsFastAfterSellIn() {
        int sellInStart = 0;
        int qualityStart = 19;
        IItem classicItem = new ItemAdapter(GildedRoseTest.CLASSIC_ITEM_NAME, sellInStart, qualityStart);
        this.items.add(classicItem);

        this.gildedRose = new GildedRose(this.getArrayItems());
        for (int day = 0; day < 10; day++) {
            assertEquals(qualityStart - (day * 2), classicItem.getQuality(),
                         "Classic item quality should decrease by 2 each day after sellIn reaches 0.");
            this.gildedRose.updateQuality();
        }
        assertEquals(0, classicItem.getQuality(),
                     "Classic item quality should not go below 0 even after sellIn is negative.");
    }
}