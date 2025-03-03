package javademo;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("1) Lisää kirja\n2) Listaa kirjat\n3) Lainaa fiktiokirja\n4) Palauta fiktiokirja\n0) Lopeta ohjelma");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Kiitos ohjelman käytöstä.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");
                    int bookType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Anna kirjan nimi:");
                    String title = scanner.nextLine();
                    System.out.println("Anna kirjailijan nimi:");
                    String author = scanner.nextLine();
                    System.out.println("Anna sivumäärä:");
                    int pages = scanner.nextInt();
                    System.out.println("Anna kirjojen määrä:");
                    int copies = scanner.nextInt();

                    if (bookType == 1) {
                        library.addBook(new FictionBook(title, author, pages, copies));
                    } else if (bookType == 2) {
                        library.addBook(new NonFictionBook(title, author, pages, copies));
                    } else {
                        System.out.println("Virheellinen kirjatyyppi.");
                    }
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:
                    System.out.println("Anna lainattavan kirjan nimi:");
                    String borrowTitle = scanner.nextLine();
                    boolean foundBorrow = false;

                    for (Book book : library.getBooks()) {
                        if (book instanceof FictionBook && book.title.equals(borrowTitle)) {
                            ((FictionBook) book).borrow();
                            foundBorrow = true;
                            break;
                        }
                    }

                    if (!foundBorrow) {
                        System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
                    }
                    break;

                case 4:
                    System.out.println("Anna palautettavan kirjan nimi:");
                    String returnTitle = scanner.nextLine();
                    boolean foundReturn = false;

                    for (Book book : library.getBooks()) {
                        if (book instanceof FictionBook && book.title.equals(returnTitle)) {
                            ((FictionBook) book).returnBook();
                            foundReturn = true;
                            break;
                        }
                    }

                    if (!foundReturn) {
                        System.out.println("Kirjaa ei löytynyt tai sitä ei voi palauttaa.");
                    }
                    break;

                default:
                    System.out.println("Virheellinen valinta.");
                    break;
            }
        }
        scanner.close();
    }
}