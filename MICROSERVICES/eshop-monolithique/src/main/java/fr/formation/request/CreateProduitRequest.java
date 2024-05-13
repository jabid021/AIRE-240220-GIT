package fr.formation.request;

import java.math.BigDecimal;

public class CreateProduitRequest {
    private String name;
    private BigDecimal price;
    private boolean notable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isNotable() {
        return notable;
    }

    public void setNotable(boolean notable) {
        this.notable = notable;
    }
}
