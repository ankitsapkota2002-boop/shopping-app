public class Product { 

    private String name; 
    private int stockLevel; 
    private double price; 

    public Product(String name, int stockLevel, double price) { 
        this.name = name; 
        this.stockLevel = stockLevel;
        this.price = price;
    }

    public double buyStock(int amount) { 
        stockLevel = stockLevel + amount; 
        return amount * price; 
    }

    public boolean sell(int amount) { 
        if (amount <= stockLevel) { 
            stockLevel = stockLevel - amount;
            return true;
        }
        return false; 
    }

    public void setPrice(double price) { 
        this.price = price; 
    }

    public String getName() { 
        return name; 
    }

    public int getStockLevel() { 
        return stockLevel; 
    }

    public double getPrice() {
        return price; 
    }
}
