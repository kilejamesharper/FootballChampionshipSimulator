import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {

    //text menu here
    //local variable for scanner object
    // Creating scanner to take user input
    Scanner userInput = new Scanner(System.in);

    //creating array list of clubs
    public ArrayList<FootballClub> clubs = new ArrayList<>();

    // Method to display the menu and handle user input
    public void displayMenu() {
        //while true loop to keep displaying menu until user exits with input 5
        while (true) {
            System.out.println("Premier League Manager Menu:");
            System.out.println("1. Create Club");
            System.out.println("2. Delete Club");
            System.out.println("3. Display Club Stats");
            System.out.println("4. Display League Table");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            //stores users input into choice variable
            int choice = userInput.nextInt();
            userInput.nextLine(); // Consume newline

            //switch case to run method base on int provided
            switch (choice) {
                case 1:
                    createClub();
                    break;
                case 2:
                    deleteClub();
                    break;
                case 3:
                    clubStats();
                    break;
                case 4:
                    displayLeagueTable();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    //add club to array after taking user input
    @Override
    public void createClub() {
        System.out.println("==========================");
        System.out.println("Please enter club name: ");
        String clubName = userInput.nextLine();
        System.out.println("Please enter club location: ");
        String clubLocation = userInput.nextLine();

        FootballClub newClub = new FootballClub();
        newClub.setClubName(clubName);
        newClub.setClubLocation(clubLocation);
        clubs.add(newClub);

        System.out.println("==========================");
        System.out.println("Club added successfully!");
        System.out.println("==========================");
        System.out.println("Current clubs in league: ");
        for (FootballClub club : clubs) {
            System.out.println(club);
        }
        System.out.println("==========================");
    }

    //delete club from array after taking input club name
    //look to remove for loop inside the iterator as the iterator essentially does this functionality so loop is redundant.
    //add else to show club not found on if loop and then change found to true rather than its own if
    @Override
    public void deleteClub() {
        System.out.println("==========================");
        System.out.println("Please enter club name: ");
        String name = userInput.nextLine();
        Boolean found = false;

        Iterator<FootballClub> iterator = clubs.iterator();

        while (iterator.hasNext()) {
            FootballClub club = new FootballClub();
            if (club.getClubName().equalsIgnoreCase(name)) {
                clubs.remove(club);
                System.out.println("Club deleted successfully!");
                System.out.println("==========================");
                System.out.println("Current clubs in league: ");
                for (FootballClub club1 : clubs) {
                    System.out.println(club1);
                    System.out.println("==========================");
                }
                found = true;
                break;
            }
            else {

            }
        }
    }

    /*
    if (club.getClubName().equals(name)) {
        clubs.remove(club);
        System.out.println("Club deleted successfully!")
        System.out.println("==========================");
        System.out.println("Current clubs in league: ");
        for (FootballClub club1 : clubs) {
            System.out.println(club1);
            System.out.println("==========================")
       }
    ;*/

        //display club stats by taking user input for club name
        @Override
        public void clubStats () {
        }

        //display league table in correct format
        @Override
        public void displayLeagueTable () {
        }
    }
