/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Model.Expense;
import Controllers.ExpensesController;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author i101068
 */
public class ExpensesUI {

    Expense exp;
    BigDecimal amount;
    String description;

    public ExpensesUI() {
    }

    public void mainLoop() {

        int option = 0;

        do {

            System.out.println("===================");
            System.out.println("  LIST EXPENSES  ");
            System.out.println("===================\n");

            System.out.println("1. Last Month Expenses");
            System.out.println("2. All Expenses");
            System.out.println("0. Exit\n\n");
            option = Console.readInteger("Please choose a option");

            switch (option) {
                case 0:

                    return;
                case 1:
                    lastMonthExpensesLoop();
                    break;
                case 2:
                    ListExpenditures();
                    break;
            }
        } while (option != 0);


    }

    public void lastMonthExpensesLoop() {


        ExpensesController controller = new ExpensesController();
        List<Expense> l = controller.getLastMonthExpenses();

        System.out.println("* * *  Show Last Month Expense  * * *\n");

        for (int i = 0; i < l.size(); i++) {
            l.get(i).expenseToString();

        }
        System.out.println("Press Enter to continue.");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();


    }

    public void ListExpenditures() {
        System.out.println("* * *  SHOW LIST EXPENDITURES  * * *\n");

        ExpensesController expcont = new ExpensesController();

        List<Expense> aExp = expcont.getListExpenditures();

        for (int i = 0; i < aExp.size(); i++) {

            System.out.println("<--- " + (i + 1) + "º Expense --->");
            System.out.println("Amount : " + aExp.get(i).getAmount().doubleValue() + "");
            System.out.println("Description : " + aExp.get(i).getDescription() + "\n");
        }
        
        System.out.println("Press Enter to continue.");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

    }
}
