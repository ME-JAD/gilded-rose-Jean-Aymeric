package com.gildedrose;

class GildedRose {
    IItem[] items;

    public GildedRose(IItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals("Aged Brie")
                    && !items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].getQuality() > 0) {
                    if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].decrementQuality();
                    }
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].incrementQuality();

                    if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].incrementQuality();
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].incrementQuality();
                            }
                        }
                    }
                }
            }

            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                items[i].decrementSellIn();
            }

            if (items[i].getSellIn() < 0) {
                if (!items[i].getName().equals("Aged Brie")) {
                    if (!items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].getQuality() > 0) {
                            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].decrementQuality();
                            }
                        }
                    } else {
                        items[i].resetQualityToZero();
                    }
                } else {
                    if (items[i].getQuality() < 50) {
                        items[i].incrementQuality();
                    }
                }
            }
        }
    }
}