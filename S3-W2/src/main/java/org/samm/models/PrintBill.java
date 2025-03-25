package org.samm.models;

public class PrintBill(){
    private Bill bill;

    public PrintBill(Bill bill){
        this.bill = bill;
    }

    public void print(){
        System.out.println(bill.quantity + "x " + bill.book.title + " " + bill.book.price + "$");
        System.out.println("Tasa de Descuento: " + bill.discountRate);
        System.out.println("Tasa de Impuesto: " + bill.taxeRate);
        System.out.println("Total: " + bill.total);
    }
}
