package info;

import java.util.HashMap;

public class InfoFromApi {
    public static HashMap<String, String> getValueFromCard1() {
        HashMap<String, String> card1 = new HashMap<>();
        card1.put("title", "\uD83D\uDD25 Топ лучших скидок");
        card1.put("productName", "");
        card1.put("price", "от 1154,00 р.");
        card1.put("priceColor", "red");
        card1.put("word 'От' in price", "displayed");
        card1.put("discount", "-10%");
        card1.put("discountColor", "red");
        card1.put("iconInDiscount", "displayed");
        card1.put("sticker: Выбор покупателей", "displayed");
        card1.put("sticker: PRIME", "not displayed");
        card1.put("sticker: Onliner рекомендует", "displayed");
        return card1;
    }
}
