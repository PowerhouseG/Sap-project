/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneyLogic;

/**
 *
 * @author x
 */
public class Money {

    private final int leva;
    private final int stotinki;

    public Money(int leva, int stotinki) {

        if (stotinki > 99) {
            leva += stotinki / 100;
            stotinki %= 100;
        }

        this.leva = leva;
        this.stotinki = stotinki;
    }

    public int leva() {
        return leva;
    }

    public int stotinki() {
        return stotinki;
    }

    @Override
    public String toString() {
        String zero = "";
        if (stotinki < 10) {
            zero = "0";
        }

        return leva + ":" + zero + stotinki + "lv";
    }

    public Money plus(Money added) {
        int levaSum = leva + added.leva();
        int stotinkiSum = stotinki + added.stotinki();

        if (stotinkiSum > 99) {
            stotinkiSum -= 100;
            levaSum++;
        }

        return new Money(levaSum, stotinkiSum);
    }

    public boolean less(Money compared) {
        return (100 * leva + stotinki) < (100 * compared.leva() + compared.stotinki());
    }

    public Money minus(Money decremented) {
        int levaDifference = leva - decremented.leva();
        int stotinkiDifference = stotinki - decremented.stotinki();

        if (stotinkiDifference < 0) {
            stotinkiDifference += 100;
            levaDifference--;
        }

        if (levaDifference < 0) {
            return new Money(0, 0);
        }

        return new Money(levaDifference, stotinkiDifference);
    }

    public static Money toMoney(String money) {
        money = money.replace("lv", "");
        String[] monmon = money.split(":");
        return new Money(Integer.parseInt(monmon[0]), Integer.parseInt(monmon[1]));
    }
}
