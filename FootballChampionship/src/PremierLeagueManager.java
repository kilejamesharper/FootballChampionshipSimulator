import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {

    //text menu here
    //local variable for scanner object
    // Creating scanner to take user input
    Scanner userInput = new Scanner(System.in);
    int choice;

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
            System.out.println("5. Add a Match");
            System.out.println("5. Save League");
            System.out.println("5. Start GUI");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            while (!userInput.hasNextInt() && userInput.hasNext()) {
                invalidInputError();
                userInput.next();
            }

            if (userInput.hasNextInt()){
                choice = userInput.nextInt();
                userInput.nextLine(); // Consume newline
            }
            else{
                invalidInputError();
                choice = userInput.nextInt();
            }

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
                    addMatch();
                    break;
                case 6:
                    saveLeague();
                    break;
                case 7:
                    startGUI();
                    break;
                case 8:
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
        enterClubName();
        String name = userInput.nextLine();

        // Check for empty input
        while (name.isEmpty()) {
            emptyNameError();
            name = userInput.nextLine();
        }

        enterClubLocation();
        String location = userInput.nextLine();

        // Check for empty input
        while (location.isEmpty()) {
            emptyLocationError();
            location = userInput.nextLine();
        }

        FootballClub newClub = new FootballClub();

        newClub.setClubName(name);
        newClub.setClubLocation(location);

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
    @Override
    public void deleteClub() {
        enterClubName();
        String name = userInput.nextLine();

        // Check for empty input
        while (name.isEmpty()) {
            emptyNameError();
            name = userInput.nextLine();
        }

        Iterator<FootballClub> iterator = clubs.iterator();
        boolean clubFound = false;

        while (iterator.hasNext()) {
            FootballClub club = iterator.next(); // Use the current element
            if (club.getClubName().equalsIgnoreCase(name)) {
                iterator.remove(); // Safely removes the club
                System.out.println("Club deleted successfully!");
                clubFound = true;
                break; // Club is deleted, exit loop
            }
        }

        if (!clubFound) {
            System.out.println("Club not found! Try again...");
        } else {
            System.out.println("==========================");
            System.out.println("Current clubs in league: ");
            for (FootballClub remainingClub : clubs) {
                System.out.println(remainingClub); // Print each remaining club
                System.out.println("==========================");
            }
        }
    }

        //display club stats by taking user input for club name
        @Override
        public void clubStats () {
            enterClubName();
            String name = userInput.nextLine();

            // Check for empty input
            while (name.isEmpty()) {
                emptyNameError();
                name = userInput.nextLine();
            }

            for (FootballClub club : clubs) {
                if (club.getClubName().equalsIgnoreCase(name)) {
                    System.out.println(club);
                    break;
                }
            }
            System.out.println("==========================");
        }

        //display league table in correct format
        @Override
        public void displayLeagueTable () {
        }

        //go through array and store two random clubs from league in club1 and club2 variables
        //generate a random number for each club and store use set method to update stats
        //use input validation from other methods
        @Override
        public void addMatch() {

            if (clubs.size() < 2){
                System.out.println("There are not enough clubs to add a match!");
                return;
            }

            System.out.println( "Please enter the name of the first team: ");
            String club1name = userInput.nextLine();

            // Check for empty input
            while (club1name.isEmpty()) {
                emptyNameError();
                club1name = userInput.nextLine();
            }

            boolean clubFound = false;
            for (FootballClub club : clubs) {
                if (club1name.equalsIgnoreCase(club.getClubName())){
                    clubFound = true;
                    break;
                }
            }
            if (!clubFound){
                System.out.println("Club not found! Try again...");
                return;
            }

            System.out.println( "Please enter the name of the second team: ");
            String club2name = userInput.nextLine();

            while (club2name.isEmpty()) {
                emptyNameError();
                club2name = userInput.nextLine();
            }

            if (club1name.equalsIgnoreCase(club2name)){
                System.out.println("You cannot add a match between the same clubs!");
                return;
            }

            clubFound = false;
            for (FootballClub club : clubs) {
                if (club1name.equalsIgnoreCase(club.getClubName())){
                    clubFound = true;
                    break;
                }
            }
            if (!clubFound){
                System.out.println("Club not found! Try again...");
                return;
            }

        }

        @Override
        public void saveLeague() {
        }

        @Override
        public void startGUI() {
        }

        public void enterClubName(){
            System.out.println("==========================");
            System.out.println("Please enter club name: ");
        }

        public void enterClubLocation(){
            System.out.println("==========================");
            System.out.println("Please enter club location: ");
        }

        public void invalidInputError(){
            System.out.println( "Invalid input. Please try again.");
            System.out.println("==========================");
        }

        public void invalidChoiceError(){
            System.out.println( "Invalid choice. Please try again.");
            System.out.println("==========================");
        }

        public void emptyNameError(){
            System.out.println( "Club name cannot be empty. Please try again.");
            System.out.println("==========================");
            System.out.println("Please enter club name: ");
        }

        public void emptyLocationError(){
            System.out.println( "Club location cannot be empty. Please try again.");
            System.out.println("==========================");
            System.out.println("Please enter club location: ");
        }
    }
