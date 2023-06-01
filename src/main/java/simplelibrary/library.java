package simplelibrary;
import java.util.Scanner;

public class library {

		private static final int MAX_BOOKS = 10;
	    private static final int MAX_PATRONS = 10;

	    private static String[] books = new String[MAX_BOOKS];
	    private static String[] authors = new String[MAX_BOOKS];
	    private static String[] patrons = new String[MAX_PATRONS];
	    private static String[] borrowedBooks = new String[MAX_PATRONS];

	    private static int bookCount = 0;
	    private static int patronCount = 0;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        boolean exit = false;

	        while (!exit) {
	            System.out.println("Library Management System");
	            System.out.println("1. Add Book");
	            System.out.println("2. Add Patron");
	            System.out.println("3. Borrow Book");
	            System.out.println("4. Return Book");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    addBook(scanner);
	                    break;
	                case 2:
	                    addPatron(scanner);
	                    break;
	                case 3:
	                    borrowBook(scanner);
	                    break;
	                case 4:
	                    returnBook(scanner);
	                    break;
	                case 5:
	                    exit = true;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    public static void addBook(Scanner scanner) {
	        if (bookCount >= MAX_BOOKS) {
	            System.out.println("Cannot add more books. Maximum limit reached.");
	            return;
	        }

	        System.out.print("Enter the book title: ");
	        scanner.nextLine();
	        String title = scanner.nextLine();
	        System.out.print("Enter the author: ");
	        String author = scanner.nextLine();

	        books[bookCount] = title;
	        authors[bookCount] = author;
	        bookCount++;

	        System.out.println("Book added successfully!\n");
	    }

	    public static void addPatron(Scanner scanner) {
	        if (patronCount >= MAX_PATRONS) {
	            System.out.println("Cannot add more patrons. Maximum limit reached.");
	            return;
	        }

	        System.out.print("Enter the patron name: ");
	        scanner.nextLine();
	        String patronName = scanner.nextLine();
	        patrons[patronCount] = patronName;
	        patronCount++;

	        System.out.println("Patron added successfully!");
	    }
	    
	    public static int findBookIndex(String bookTitle) {
	        for (int i = 0; i < bookCount; i++) {
	            if (books[i] != null && books[i].equalsIgnoreCase(bookTitle)) {
	                return i;
	            }else {
	            	if (borrowedBooks[i] != null && borrowedBooks[i].equalsIgnoreCase(bookTitle)) {
	                    return i;
	                }
	            }
	        }
	        return -1;
	    }

	    public static int findPatronIndex(String patronName) {
	        for (int i = 0; i < patronCount; i++) {
	            if (patrons[i].equalsIgnoreCase(patronName)) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    public static void borrowBook(Scanner scanner) {
	        System.out.println("Enter the patron name: ");
	        scanner.nextLine();
	        String patronName = scanner.nextLine();

	        int patronIndex = findPatronIndex(patronName);

	        if (patronIndex == -1) {
	            System.out.println("Patron not found.");
	            return;
	        }

	        if (borrowedBooks[patronIndex] != null) {
	            System.out.println("Patron already borrowed a book.");
	            return;
	        }

	        System.out.print("Enter the book title: ");
	        String bookTitle = scanner.nextLine();

	        int bookIndex = findBookIndex(bookTitle);

	        if (bookIndex == -1) {
	            System.out.println("Book not found.");
	            return;
	        }

	        if (books[bookIndex] == null) {
	            System.out.println("Book is not available for borrowing.");
	            return;
	        }

	        books[bookIndex] = null;
	        borrowedBooks[patronIndex] = bookTitle;

	        System.out.println("Book borrowed successfully!");
	    }

	    public static void returnBook(Scanner scanner) {
	        System.out.print("Enter the patron name: ");
	        scanner.nextLine();
	        String patronName = scanner.nextLine();

	        int patronIndex = findPatronIndex(patronName);

	        if (patronIndex == -1) {
	            System.out.println("Patron not found.");
	            return;
	        }

	        if (borrowedBooks[patronIndex] == null) {
	            System.out.println("Patron has not borrowed any book.");
	            return;
	        }

	        System.out.print("Enter the book title: ");
	        String bookTitle = scanner.nextLine();

	        int bookIndex = findBookIndex(bookTitle);

	        if (bookIndex == -1) {
	            System.out.println("Book not found.");
	            return;
	        }

	        books[bookIndex] = bookTitle;
	        borrowedBooks[patronIndex] = null;

	        System.out.println("Book returned successfully!");
	    }

	}

	


