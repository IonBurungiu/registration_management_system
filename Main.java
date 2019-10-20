package P1;

import java.util.Scanner;

public class Main {

    public static void printmeniu() {
        {
            System.out.println("\n" +
                    "0 help - Afiseaza aceasta lista de comenzi \n" +
                    "1 add - Adauga o noua persoana (inscriere)\n" +
                    "2 check - Verifica daca o persoana este inscrisa la eveniment\n" +
                    "3 remove - Sterge o persoana existenta din lista\n" +
                    "4 update - Actualizeaza detaliile unei persoane\n" +
                    "5 guests - Lista de persoane care participa la eveniment\n" +
                    "6 waitlist - Persoanele din lista de asteptare\n" +
                    "7 available - Numarul de locuri libere\n" +
                    "8 guests_no - Numarul de persoane care participa la eveniment\n" +
                    "9 waitlist_no - Numarul de persoane din lista de asteptare\n" +
                    "10 subscribe_no - Numarul total de persoane inscrise\n" +
                    "11 search - Cauta toti invitatii conform sirului de caractere introdus\n" +
                    "quit - Inchide aplicatia\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
        int capacity = sc.nextInt();
        GuestsList guestsList = new GuestsList(capacity);
        System.out.println("Asteapta comanda: (0 - Afiseaza lista de comenzi)");
        String meniu = sc.next();

        while (!meniu.equals("quit")) {

            printmeniu();
            meniu = sc.next();
            if (meniu.equals("1")) guestsList.add();
            else if (meniu.equals("2")) guestsList.checkPerson();
            else if (meniu.equals("3")) guestsList.remove();
            else if (meniu.equals("4")) guestsList.update();
            else if (meniu.equals("5")) guestsList.guests();
            else if (meniu.equals("6")) guestsList.waitList();
            else if (meniu.equals("7")) System.out.println(guestsList.available());
            else if (meniu.equals("8")) System.out.println(guestsList.guestsNo());
            else if (meniu.equals("9")) System.out.println(guestsList.waitlistNo());
            else if (meniu.equals("10")) System.out.println(guestsList.subscribeNo());
            else if (meniu.equals("11")) guestsList.search();
        }
        sc.close();
    }
}

