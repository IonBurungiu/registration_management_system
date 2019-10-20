package P1;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestsList {
    private ArrayList<Guest> guestsList;
    private ArrayList<Guest> waitList;
    final private int capacity;
    private int guestNo = 0;
    Scanner sc = new Scanner(System.in);

    public GuestsList(int capacity) {
        this.capacity = capacity;
        this.guestsList = new ArrayList<Guest>(capacity);
        this.waitList = new ArrayList<Guest>(50);
    }

    public int add() {

        Guest newG = new Guest();


        System.out.println("Introduceti numele de familie:");
        newG.setLastName(sc.next());

        System.out.println("Introduceti prenumele:");
        newG.setFirstName(sc.next());

        System.out.println("Introduceti email:");
        newG.setEmail(sc.next());

        System.out.println("Introduceti numar de telefon format \"+40733386463\"");
        newG.setPhoneNumber(sc.next());
        for (int i = 0; i < this.guestsList.size(); i++) {
            if (newG.equals(guestsList.get(i))) return -1;
        }
        if (this.guestsList.size() < capacity) {
            this.guestsList.add(newG);
            System.out.println("[" + newG.getLastName() + " " + newG.getFirstName() + "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            return 0;
        } else {
            waitList.add(newG);
            System.out.println("[" + newG.getLastName() + " " + newG.getFirstName() + "] Te-ai inscris cu succes in lista de asteptare si ai primit numarul " +
                    "de ordine <" + waitList.size() + ">. Te vom notifica daca un loc devine disponibil.");
            return waitList.size();
        }
    }

    public boolean remove() {
        int i = check();
        if (i >= 0) {
            guestsList.remove(i);
            if (waitList.size() > 0) {
                guestsList.add(waitList.get(1));
                System.out.println("S-a eliberat un loc la evenimentul nostru. [" + waitList.get(i).getLastName() +
                        " " + waitList.get(i).getFirstName() + "] Felicitari ai primit posibilitatea de a veni la el");
                waitList.remove(1);
            }
            return true;
        }
        return false;
    }

    public void checkPerson() {
        int i = check();
        if (i > -1) System.out.println(this.guestsList.get(i).toString());
        else System.out.println("Persoana data nu este in lista venimentului");
    }

    public int check() {
        int verif = 0;
        do {
            System.out.println("Alege modul de autentificare, tastand:\n" +
                    "        \"1\" - Nume si prenume\n" +
                    "        \"2\" - Email\n" +
                    "        \"3\" - Numar de telefon (format \"+40733386463\")");
            verif = sc.nextInt();
        }
        while (verif < 1 || verif > 3);

        if (verif == 1) {
            System.out.println("Introduceti numele de familie:");
            String nume = sc.next();
            System.out.println("Introduceti prenumele:");
            String prenume = sc.next();
            for (int i = 0; i < this.guestsList.size(); i++) {
                if (nume.equals(this.guestsList.get(i).getLastName()) && prenume.equals(this.guestsList.get(i).getFirstName()))
                    return i;
            }
        } else if (verif == 2) {
            System.out.println("Introduceti adresa de email:");
            String email = sc.next();
            for (int i = 0; i < this.guestsList.size(); i++) {
                if (email.equals(this.guestsList.get(i).getEmail()))
                    return i;
            }
        } else if (verif == 3) {
            System.out.println("Introduceti numarul de telefon:");
            String tel = sc.next();
            for (int i = 0; i < this.guestsList.size(); i++) {
                if (tel.equals(this.guestsList.get(i).getPhoneNumber()))
                    return i;
            }
        }
        return -1;
    }

    public boolean update() {
        int i = check();
        if (i < 0) {
            System.out.println("Utilizatorul nu a fost identificaat.");
            return false;
        }
        int verif = 0;
        do {
            System.out.println("Alege campul de actualizat, tastand:\n" +
                    "        \"1\" - Nume\n" +
                    "        \"2\" - Prenume\n" +
                    "        \"3\" - Email\n" +
                    "        \"4\" - Numar de telefon (format \"+40733386463\")");

            verif = sc.nextInt();
        }
        while (verif < 1 || verif > 4);

        if (verif == 1) {
            System.out.println("Introduceti numele de familie:");
            guestsList.get(i).setLastName(sc.next());
            return true;
        } else if (verif == 2) {
            System.out.println("Introduceti prenumele:");
            guestsList.get(i).setFirstName(sc.next());
            return true;
        } else if (verif == 3) {
            System.out.println("Introduceti adresa de email:");
            guestsList.get(i).setEmail(sc.next());
            return true;
        } else if (verif == 4) {
            System.out.println("Introduceti numarul de telefon:");
            guestsList.get(i).setPhoneNumber(sc.next());
            return true;
        }

        return false;
    }

    public void guests() {
        boolean vid = true;
        for (int i = 0; i < this.guestsList.size(); i++) {
            if (this.guestsList.get(i) != null) {
                vid = false;
                System.out.println(this.guestsList.get(i).toString());
            }
        }
        if (vid) System.out.println("Niciun participant inscris…");

    }

    public void waitList() {
        boolean vid = true;
        for (int i = 0; i < this.waitList.size(); i++) {
            if (this.waitList.get(i) != null) {
                vid = false;
                System.out.println(this.waitList.get(i).toString());
            }
        }
        if (vid) System.out.println("Niciun participant inscris in lista de asteptare.");

    }

    public int available() {
        return capacity - guestsList.size();
    }

    public int guestsNo() {
        return guestsList.size();
    }

    public int waitlistNo() {
        return waitList.size();
    }

    public int subscribeNo() {
        return waitList.size() + guestsList.size();
    }

    public void search() {
        ArrayList<Guest> search = new ArrayList<>();
        System.out.println("Cauta toti invitatii conform sirului de caractere introdus: ");
        String text = sc.next();
        boolean check = false;
        ;

        for (int i = 0; i < this.guestsList.size(); i++) {
            check = false;
            if (this.guestsList.get(i).getFirstName().toLowerCase().contains(text.toLowerCase())) check = true;
            if (this.guestsList.get(i).getLastName().toLowerCase().contains(text.toLowerCase())) check = true;
            if (this.guestsList.get(i).getEmail().toLowerCase().contains(text.toLowerCase())) check = true;
            if (this.guestsList.get(i).getPhoneNumber().toLowerCase().contains(text.toLowerCase())) check = true;
            if (check) search.add(guestsList.get(i));
        }

        for (int i = 0; i < search.size(); i++) {
            System.out.println(search.get(i).toString());
        }
    }
}
