package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List list = new List();
        Scanner sc = new Scanner(System.in);
        String argument, number;
        int numberInt;

        while (true) {
            System.out.println("Wybierz operację, którą chcesz przeprowadzić na liście dwukierunkowej: "
                    + "Wybierz operację: \n" +
                    "    ADD_FIRST,\n" +
                    "    ADD_LAST,\n" +
                    "    POLL_FIRST,\n" +
                    "    POLL_LAST,\n" +
                    "    PEEK_FIRST,\n" +
                    "    PEEK_LAST,\n" +
                    "    SHOW,\n" +
                    "    SHOW_REVERSE,\n" +
                    "    IS_EMPTY,\n" +
                    "lub QUIT, aby wyjść");
            argument = sc.next();

            if (argument.equals("QUIT")){
                break;
            }

            switch (Operation.valueOf(argument)) {
                case ADD_FIRST:
                    System.out.println("Podaj liczbę całkowitą, którą chcesz dodać na początek: ");
                    try {
                        number = sc.next();
                        numberInt = Integer.parseInt(number);
                        list.addFirst(numberInt);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case ADD_LAST:
                    System.out.println("Podaj liczbę całkowitą, którą chcesz dodać na koniec: ");
                    try {
                        number = sc.next();
                        numberInt = Integer.parseInt(number);
                        list.addLast(numberInt);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case POLL_FIRST:
                    System.out.println("Zdejmij liczbę na początku: ");
                    try {
                        System.out.println("Ta liczba, to: " + list.pollFirst());
                    } catch (ListEmptyException e) {
                    }
                    break;
                case POLL_LAST:
                    System.out.println("Zdejmij liczbę na końcu: ");
                    try {
                        System.out.println("Ta liczba, to: " + list.pollLast());
                    } catch (ListEmptyException e) {
                    }
                    break;
                case PEEK_FIRST:
                    System.out.println("Podejrzyj liczbę na początku: ");
                    try {
                        System.out.println("Ta liczba, to: " + list.peekFirst());
                    } catch (ListEmptyException e) {
                    }
                    break;
                case PEEK_LAST:
                    System.out.println("Podejrzyj liczbę na końcu: ");
                    try {
                        System.out.println("Ta liczba, to: " + list.peekLast());
                    } catch (ListEmptyException e) {
                    }
                    break;
                case SHOW:
                    System.out.println("Tadam!");
                    list.show();
                    break;
                case SHOW_REVERSE:
                    System.out.println("Tadam");
                    list.showReverse();
                    break;
                case IS_EMPTY:
                    System.out.println("Lista pusta TRUE/FALSE: " + list.isEmpty());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + Operation.valueOf(argument));
            }
        }
    }
}
