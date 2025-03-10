package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @Column(name = "code", length = 3, nullable = false)
    private String code; // Currency code (e.g., "USD", "EUR")

    @Column(name = "name", nullable = false)
    private String name; // Currency name (e.g., "US Dollar", "Euro")

    @Column(name = "symbol", nullable = false)
    private String symbol; // Currency symbol (e.g., "$", "€")

    @Column(name = "exchange_rate", nullable = false)
    private double exchangeRate; // Exchange rate against a base currency (e.g., USD)

    // Default constructor (required by JPA)
    public Currency() {}

    // Parameterized constructor
    public Currency(String code, String name, String symbol, double exchangeRate) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
        this.exchangeRate = exchangeRate;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}