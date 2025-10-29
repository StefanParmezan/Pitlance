package com.example.Pitlance.Models.OrderModelAndDTO;

public record ItemTPINamePrice(String taxPayerId, String itemName, Integer price) {
    @Override
    public String toString() {
        return "ItemTPINamePrice{" +
                "taxPayerId='" + taxPayerId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
