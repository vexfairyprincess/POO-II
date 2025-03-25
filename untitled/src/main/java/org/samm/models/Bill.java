package org.samm.models;

import org.samm.models.Book;

public class Bill {
    Book book;
    int quantity;
    double discountRate;
    double taxeRate;
    double total;

    public Bill(Book book, int quantity, double discountRate, double taxeRate, double total) {
        this.book = book;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.taxeRate = taxeRate;
        this.total = total;
    }

    public double calculateTotal(){
        double price = ((book.price - book.price) * discountRate) * this.quantity));
        double priceWithTaxe = price * (1 + taxeRate);

        return priceWithTaxe;
    }
    public void saveFile(String fileName){
        // Create a file with the name fileName and write the bill information
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bill{");
        sb.append("book=").append(book);
        sb.append(", quantity=").append(quantity);
        sb.append(", discountRate=").append(discountRate);
        sb.append(", taxeRate=").append(taxeRate);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
}
