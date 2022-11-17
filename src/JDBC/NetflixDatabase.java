import java.sql.*;
import java.util.Scanner;

/** This is an exercise in JDBC, accessing a mock Netflix Database
 *
 * @author Akeem Olass & Jacob Shade
 * date 11/24/2020
 * course CS450
 */

public class NetflixDatabase {

    private final String username;
    private final String password;

    /**
     * Default constructor
     */
    public NetflixDatabase(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** Method to get the connection for the database
     * @return java.sql.Connection object
     */
    private Connection getConnection() {
        final String driver = "oracle.jdbc.driver.OracleDriver";
        final String jdbc_url = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
        // register the JDBC driver
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // create a connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection (jdbc_url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //**********************************Menus**************************************//

    /** Helper function to display main menu */
    private void displayMainMenu() {
        System.out.println("Menu Options");
        System.out.println("Enter 1 to view table content");
        System.out.println("Enter 2 to insert a new record");
        System.out.println("Enter 3 to update a record");
        System.out.println("Enter 4 to search movies");
        System.out.println("Enter 5 to member's profile information");
        System.out.println("Enter 6 to exit");
    }

    /** Main menu used to select options and run functions the user requests */
    public void mainMenu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice !=6) {
            displayMainMenu();
            choice = input.nextInt();
            switch (choice){
                case 1:
                    viewTableContent();
                    break;
                case 2:
                    insertRecordMenu();
                    break;
                case 3:
                    updateMenu();
                    break;
                case 4:
                    searchMenu();
                    break;
                case 5:
                    showProfileInfo();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Please select a valid menu option");
            }
        }
    }

    /** Helper function used to display options for tables to display */
    private void viewTableContentMenu() {
        System.out.println("Enter 1 for Members table");
        System.out.println("Enter 2 for Credit_Card table");
        System.out.println("Enter 3 for Profiles table");
        System.out.println("Enter 4 for Genre table");
        System.out.println("Enter 5 for Movie table");
        System.out.println("Enter 6 for Actor_Actress table");
        System.out.println("Enter 7 for Has_Movie_Genre table");
        System.out.println("Enter 8 for Has_Favorite table");
        System.out.println("Enter 9 for Viewing_History table");
        System.out.println("Enter 10 for Movie_Cast table");
        System.out.println("Enter 11 to go back to previous menu");
    }

    /** Allows user to select which table they want to view */
    private void viewTableContent() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 11) {
            System.out.println("Choose a table to view");
            viewTableContentMenu();
            choice = input.nextInt();
            switch (choice){
                case 1:
                    selectFromTable("Members");
                    break;
                case 2:
                    selectFromTable("Credit_Card");
                    break;
                case 3:
                    selectFromTable("Profiles");
                    break;
                case 4:
                    selectFromTable("Genre");
                    break;
                case 5:
                    selectFromTable("Movie");
                    break;
                case 6:
                    selectFromTable("Actor_Actress");
                    break;
                case 7:
                    selectFromTable("Has_Movie_Genre");
                    break;
                case 8:
                    selectFromTable("Has_Favorite");
                    break;
                case 9:
                    selectFromTable("Viewing_History");
                    break;
                case 10:
                    selectFromTable("Movie_Cast");
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Please select a valid table option");
            }
        }
    }

    /** Menu to insert a record into the chosen table */
    private void insertRecordMenu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 11) {
            System.out.println("Choose a table to insert into");
            viewTableContentMenu();
            choice = input.nextInt();
            switch (choice){
                case 1:
                    insertMembers();
                    break;
                case 2:
                    insertCreditCard();
                    break;
                case 3:
                    insertProfiles();
                    break;
                case 4:
                    insertGenre();
                    break;
                case 5:
                    insertMovie();
                    break;
                case 6:
                    insertActorActress();
                    break;
                case 7:
                    insertHasMovieGenre();
                    break;
                case 8:
                    insertHasFavorite();
                    break;
                case 9:
                    insertViewingHistory();
                    break;
                case 10:
                    insertMovieCast();
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Please select a valid table option");
            }
        }
    }

    /** Allows user to choose what kind of update they want to perform */
    private void updateMenu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Enter 1 to update");
            System.out.println("Enter 2 to delete");
            System.out.println("Enter 3 to go back");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    updateRecordMenu();
                    break;
                case 2:
                    deleteRecordMenu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please select a valid table option");
            }
        }
    }

    /** Helper function used to display options for tables to update */
    private void viewUpdateMenu() {
        System.out.println("Enter 1 for Members table");
        System.out.println("Enter 2 for Credit_Card table");
        System.out.println("Enter 3 for Genre table");
        System.out.println("Enter 4 for Movie table");
        System.out.println("Enter 5 for Actor_Actress table");
        System.out.println("Enter 6 for Viewing_History table");
        System.out.println("Enter 7 to go back to previous menu");
    }

    /** Menu to update a record into the chosen table */
    private void updateRecordMenu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 7) {
            System.out.println("Choose a table to update");
            viewUpdateMenu();
            choice = input.nextInt();
            switch (choice){
                case 1:
                    updateMembers();
                    break;
                case 2:
                    updateCreditCard();
                    break;
                case 3:
                    updateGenre();
                    break;
                case 4:
                    updateMovie();
                    break;
                case 5:
                    updateActorActress();
                    break;
                case 6:
                    updateViewingHistory();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Please select a valid table option");
            }
        }
    }

    /** Menu to delete a record from the chosen table */
    private void deleteRecordMenu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 11) {
            System.out.println("Choose a table to delete from");
            viewTableContentMenu();
            choice = input.nextInt();
            switch (choice){
                case 1:
                    deleteFromMembers();
                    break;
                case 2:
                    deleteFromCreditCard();
                    break;
                case 3:
                    deleteFromProfiles();
                    break;
                case 4:
                    deleteFromGenre();
                    break;
                case 5:
                    deleteFromMovie();
                    break;
                case 6:
                    deleteFromActorActress();
                    break;
                case 7:
                    deleteFromHasMovieGenre();
                    break;
                case 8:
                    deleteFromHasFavorite();
                    break;
                case 9:
                    deleteFromViewingHistory();
                    break;
                case 10:
                    deleteFromMovieCast();
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Please select a valid table option");
            }
        }
    }

    /** Allows user to choose what kind of search they want to perform */
    private void searchMenu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Enter 1 to search by movie name");
            System.out.println("Enter 2 to search by actor/actress name");
            System.out.println("Enter 3 to go back");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    searchMovieByName();
                    break;
                case 2:
                    searchMovieByActor();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please select a valid table option");
            }
        }
    }

    //*************************JDBC Operation Methods***********************//

    //*************************Select***********************//
    /** Selects and Prints out a given sql table
     * @param table the sql table to be selected from
     */
    private void selectFromTable(String table) {
        Connection conn = getConnection();
        StringBuilder sbSelect = new StringBuilder();
        sbSelect.append("SELECT * FROM ");
        sbSelect.append(table);
        Statement stmt;
        ResultSet rs;
        int columnCount;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sbSelect.toString()); // Execute the query
            System.out.println("Printing " + table + " Table:");
            columnCount = rs.getMetaData().getColumnCount();
            printColumnNames(rs);
            while(rs.next()) {
                for(int i=0; i < columnCount; i++) {
                    System.out.print(rs.getString(i+1) + " ");
                }
                System.out.println();
            }
            rs.close() ;
            stmt.close() ;
            conn.close() ;
        }
        catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //*************************Insert***********************//

    private void insertMembers() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Members VALUES(?,?,?)";
        String Member_ID, first_name, last_name;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Member id:\t\n");
            Member_ID = scan.nextLine();
            System.out.println("Please enter first name:\t\n");
            first_name = scan.nextLine();
            System.out.println("Please enter last name:\t\n");
            last_name = scan.nextLine();
            pStmt.clearParameters();
            pStmt.setString(1, Member_ID);
            pStmt.setString(2, first_name);
            pStmt.setString(3, last_name);
            pStmt.executeQuery();
            pStmt.close();
            conn.close();
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void insertCreditCard() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Credit_Card VALUES(?,?,?,?,?)";
        String Member_ID, cardnum, cardmonth,cardyear,ccv;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Member id:\t\n");
            Member_ID= scan.nextLine();
            System.out.println("Please enter Card Number:\t\n");
            cardnum= scan.nextLine();
            System.out.println("Please enter Card Month:\t\n");
            cardmonth= scan.nextLine();
            System.out.println("Please enter Card Year:\t\n");
            cardyear= scan.nextLine();
            System.out.println("Please enter CCV:\t\n");
            ccv= scan.nextLine();
            pStmt.clearParameters();
            pStmt.setString(1, Member_ID);
            pStmt.setString(2, cardnum);
            pStmt.setString(3, cardmonth);
            pStmt.setString(2, cardyear);
            pStmt.setString(3, ccv);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void insertProfiles() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Credit_Card VALUES(?,?)";
        String Member_ID, profilename;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Member id:\t\n");
            Member_ID= scan.nextLine();
            System.out.println("Please enter Profile name:\t\n");
            profilename= scan.nextLine();

            pStmt.clearParameters();
            pStmt.setString(1, Member_ID);
            pStmt.setString(2, profilename);

            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private void insertGenre() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Credit_Card VALUES(?,?)";
        String Genre_ID, genrename;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Genre id:\t\n");
            Genre_ID= scan.nextLine();
            System.out.println("Please enter Genre name:\t\n");
            genrename= scan.nextLine();

            pStmt.clearParameters();
            pStmt.setString(1, Genre_ID);
            pStmt.setString(2, genrename);

            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private void insertMovie() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Movie VALUES(?,?,?,?,?)";
        String movie_ID, title, yrproduced,producer,avg_rating;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Movie id:\t\n");
            movie_ID= scan.nextLine();
            System.out.println("Please enter Title of movie:\t\n");
            title= scan.nextLine();
            System.out.println("Please enter Year Produced:\t\n");
            yrproduced= scan.nextLine();
            System.out.println("Please enter Producer:\t\n");
            producer= scan.nextLine();
            System.out.println("Please enter Average rating:\t\n");
            avg_rating= scan.nextLine();
            pStmt.clearParameters();
            pStmt.setString(1, movie_ID);
            pStmt.setString(2, title);
            pStmt.setString(3, yrproduced);
            pStmt.setString(2, producer);
            pStmt.setString(3, avg_rating);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void insertActorActress() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Actor_Actress VALUES(?,?,?)";
        String actor_actress, first_name, last_name;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Actor/Actress id:\t\n");
            actor_actress = scan.nextLine();
            System.out.println("Please enter first name:\t\n");
            first_name= scan.nextLine();
            System.out.println("Please enter last name:\t\n");
            last_name= scan.nextLine();
            pStmt.clearParameters();
            pStmt.setString(1, actor_actress);
            pStmt.setString(2, first_name);
            pStmt.setString(3, last_name);
            pStmt.executeQuery();
            pStmt.close();
            conn.close();
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void insertHasMovieGenre() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Has_Movie_Genres VALUES(?,?)";
        String movie_id, genre_id;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter movie id:\t\n");
            movie_id = scan.nextLine();
            System.out.println("Please enter genre id:\t\n");
            genre_id = scan.nextLine();
            pStmt.clearParameters();
            pStmt.setString(1, movie_id);
            pStmt.setString(2, genre_id);
            pStmt.executeQuery();
            pStmt.close();
            conn.close();
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void insertHasFavorite() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Has_Favorite VALUES(?,?,?)";
        String Member_ID, Profile_name, Genre_Id;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Member id:\t\n");
            Member_ID = scan.nextLine();
            System.out.println("Please enter profile name:\t\n");
            Profile_name = scan.nextLine();
            System.out.println("Please enter genre id:\t\n");
            Genre_Id = scan.nextLine();
            pStmt.clearParameters();
            pStmt.setString(1, Member_ID);
            pStmt.setString(2, Profile_name);
            pStmt.setString(3, Genre_Id);
            pStmt.executeQuery();
            pStmt.close();
            conn.close();
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void insertViewingHistory() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Viewing_History VALUES(?,?,?,?)";
        String Member_ID, Movie_ID, Profile_Name, rating;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Member id:\t\n");
            Member_ID = scan.nextLine();
            System.out.println("Please enter Movie id:\t\n");
            Movie_ID = scan.nextLine();
            System.out.println("Please enter Profile name:\t\n");
            Profile_Name = scan.nextLine();
            System.out.println("Please enter Rating:\t\n");
            rating = scan.nextLine();
            pStmt.clearParameters();
            pStmt.setString(1, Member_ID);
            pStmt.setString(2, Movie_ID);
            pStmt.setString(3, Profile_Name);
            pStmt.setString(4, rating);
            pStmt.executeQuery();
            pStmt.close();
            conn.close();
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void insertMovieCast() {
        Connection conn = getConnection();
        String sql = "INSERT INTO Movie_Cast VALUES(?,?,?,?)";
        String Movie_ID, Actor_Actress_ID;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Movie id:\t\n");
            Movie_ID = scan.nextLine();
            System.out.println("Please enter Actor_Actress name:\t\n");
            Actor_Actress_ID = scan.nextLine();
            pStmt.clearParameters();
            pStmt.setString(1, Movie_ID);
            pStmt.setString(3, Actor_Actress_ID);
            pStmt.executeQuery();
            pStmt.close();
            conn.close();
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //*************************Update********************************//

    private void updateMembers() {
        Connection conn = getConnection();
        String sql = "UPDATE Members SET first_name = ?, last_name = ? WHERE Member_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What member id would you like to update?: ");
        String memberID = scan.nextLine();
        System.out.println("First name: ");
        String firstName = scan.nextLine();
        System.out.println("Last name: ");
        String lastName = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, firstName);
            pStmt.setString(2, lastName);
            pStmt.setString(3, memberID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCreditCard() {
        Connection conn = getConnection();
        String sql = "UPDATE Credit_Card SET Card_Month = ?, Card_Year = ?, CCV = ?, Card_Type = ? WHERE Member_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What member id would you like to update?: ");
        String memberID = scan.nextLine();
        System.out.println("Card month: ");
        String cardMonth = scan.nextLine();
        System.out.println("Card_Year: ");
        String cardYear = scan.nextLine();
        System.out.println("CCV: ");
        String ccv = scan.nextLine();
        System.out.println("Card_Type: ");
        String cardType = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, cardMonth);
            pStmt.setString(2, cardYear);
            pStmt.setString(3, ccv);
            pStmt.setString(4, cardType);
            pStmt.setString(5, memberID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void updateGenre() {
        Connection conn = getConnection();
        String sql = "UPDATE Genre SET Genre_Name = ? WHERE Genre_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What genre id would you like to update?: ");
        String genreID = scan.nextLine();
        System.out.println("Genre name: ");
        String genreName = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, genreName);
            pStmt.setString(2, genreID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void updateMovie() {
        Connection conn = getConnection();
        String sql = "UPDATE Movie SET Title = ?, Year_Produced = ?, Producer = ?, Average_rating = ? WHERE Movie_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What movie id would you like to update?: ");
        String movieID = scan.nextLine();
        System.out.println("Movie title: ");
        String title = scan.nextLine();
        System.out.println("Year produced: ");
        String yearProduced = scan.nextLine();
        System.out.println("Producer: ");
        String producer = scan.nextLine();
        System.out.println("Average rating: ");
        String averageRating = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, title);
            pStmt.setString(2, yearProduced);
            pStmt.setString(3, producer);
            pStmt.setString(4, averageRating);
            pStmt.setString(5, movieID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void updateActorActress() {
        Connection conn = getConnection();
        String sql = "UPDATE Actor_Actress SET first_name = ?, last_name = ? WHERE Actor_Actress_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What Actor/Actress id would you like to update?: ");
        String actorActressID = scan.nextLine();
        System.out.println("First name: ");
        String firstName = scan.nextLine();
        System.out.println("Last name: ");
        String lastName = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, firstName);
            pStmt.setString(2, lastName);
            pStmt.setString(3, actorActressID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void updateViewingHistory() {
        Connection conn = getConnection();
        String sql = "UPDATE Movie SET Rating = ? WHERE Member_ID = ? and Movie_ID = ? and Profile_Name = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What viewing history would you like to update?: ");
        System.out.println("Member id: ");
        String memberID = scan.nextLine();
        System.out.println("Movie id: ");
        String movieID = scan.nextLine();
        System.out.println("Profile name: ");
        String profileName = scan.nextLine();
        System.out.println("New Rating: ");
        String rating = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, rating);
            pStmt.setString(2, memberID);
            pStmt.setString(3, movieID);
            pStmt.setString(4, profileName);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //*************************Delete********************************//

    private void deleteFromMembers() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Members WHERE Member_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What member id would you like to delete?: ");
        String memberID = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, memberID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFromCreditCard() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Credit_Card WHERE Member_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What member id would you like to delete?: ");
        String memberID = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, memberID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFromProfiles() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Profiles WHERE Member_ID = ? and Profile_Name = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What member id would you like to delete?: ");
        String memberID = scan.nextLine();
        System.out.println("Profile name: ");
        String profileName = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, memberID);
            pStmt.setString(2, profileName);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFromGenre() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Genre WHERE Genre_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What genre id would you like to delete?: ");
        String genreID = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, genreID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFromMovie() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Movie WHERE Movie_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What movie id would you like to delete?: ");
        String movieID = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, movieID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFromActorActress() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Actor_Actress WHERE Actor_Actress_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What actor/actress id would you like to delete?: ");
        String actorActressID = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, actorActressID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFromHasMovieGenre() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Has_Movie_Genre WHERE Movie_ID = ? and Genre_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What has movie genre would you like to delete?: ");
        System.out.println("Movie id: ");
        String movieID = scan.nextLine();
        System.out.println("Genre id: ");
        String genreID = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, movieID);
            pStmt.setString(2, genreID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFromHasFavorite() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Has_Favorite WHERE Member_ID = ? and Profile_Name = ? and Genre_ID";
        Scanner scan = new Scanner(System.in);
        System.out.println("What has movie genre would you like to delete?: ");
        System.out.println("Member id: ");
        String memberID = scan.nextLine();
        System.out.println("Profile name: ");
        String profileName = scan.nextLine();
        System.out.println("Genre id: ");
        String genreID = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, memberID);
            pStmt.setString(2, profileName);
            pStmt.setString(3, genreID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFromViewingHistory() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Viewing_History WHERE Member_ID = ? and Profile_Name = ? and Movie_ID = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What viewing history would you like to delete?: ");
        System.out.println("Member id: ");
        String memberID = scan.nextLine();
        System.out.println("Profile name: ");
        String profileName = scan.nextLine();
        System.out.println("Movie id: ");
        String movieID = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, memberID);
            pStmt.setString(2, profileName);
            pStmt.setString(3, movieID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFromMovieCast() {
        Connection conn = getConnection();
        String sql = "DELETE FROM Movie_Cast WHERE Movie_ID = ? and Actor_Actress = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What movie cast would you like to delete?: ");
        System.out.println("Movie id: ");
        String movieID = scan.nextLine();
        System.out.println("Actor/Actress id: ");
        String actorActressID = scan.nextLine();
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, movieID);
            pStmt.setString(2, actorActressID);
            pStmt.executeQuery();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //*************************Search***********************//

    private void searchMovieByName(){
        Connection conn = getConnection();
        String sql = "SELECT Title, Year_Produced, Average_rating FROM Movie WHERE UPPER(Title) LIKE ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("What movie name would you like to search?: ");
        String movieName = scan.nextLine();
        int columnCount;
        ResultSet rs;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, "%" + movieName.toUpperCase() + "%");
            rs = pStmt.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            printColumnNames(rs);
            while(rs.next()) {
                for(int i=0; i < columnCount; i++) {
                    System.out.print(rs.getString(i+1) + " ");
                }
                System.out.println();
            }
            rs.close();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void searchMovieByActor() {
        Connection conn = getConnection();
        String sql = "SELECT DISTINCT Title, Year_Produced, Average_rating FROM Movie NATURAL JOIN(" +
                     "SELECT Movie_ID FROM Movie_Cast NATURAL JOIN(" +
                     "SELECT Actor_Actress_ID FROM Actor_Actress WHERE " +
                     "UPPER(first_name) LIKE ? OR UPPER(last_name) LIKE ?))";
        Scanner scan = new Scanner(System.in);
        System.out.println("What actor/actress name would you like to search?: ");
        String actorName = scan.nextLine();
        int columnCount;
        ResultSet rs;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, "%" + actorName.toUpperCase() + "%");
            pStmt.setString(2, "%" + actorName.toUpperCase() + "%");
            rs = pStmt.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            printColumnNames(rs);
            while(rs.next()) {
                for(int i=0; i < columnCount; i++) {
                    System.out.print(rs.getString(i+1) + " ");
                }
                System.out.println();
            }
            rs.close();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //*************************Profile Information***********************//

    private void showProfileInfo() {
        Connection conn = getConnection();
        String sql = "SELECT Title, Rating FROM Movie NATURAL JOIN(" +
                     "SELECT Movie_ID, Rating FROM Viewing_History WHERE Member_ID = ? and Profile_Name = ?)";
        Scanner scan = new Scanner(System.in);
        System.out.println("What member id and profile would you like to show?: ");
        System.out.println("Member id: ");
        String memberID = scan.nextLine();
        System.out.println("Profile name: ");
        String profileName = scan.nextLine();
        int columnCount;
        ResultSet rs;
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, memberID);
            pStmt.setString(2, profileName);
            rs = pStmt.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            printColumnNames(rs);
            while(rs.next()) {
                for(int i=0; i < columnCount; i++) {
                    System.out.print(rs.getString(i+1) + " ");
                }
                System.out.println();
            }
            rs.close();
            pStmt.close() ;
            conn.close() ;
        } catch(SQLException se) {
            printSQLExceptions(se);
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //*************************Utility Methods***********************//

    /** Prints the column names of a given table
     * @param rs the resulting table from a query
     */
    private void printColumnNames(ResultSet rs) {
        try{
            for(int i=0; i < rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getMetaData().getColumnName(i+1) + " ");
            }
            System.out.println();
        } catch(SQLException se) {
            printSQLExceptions(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** Prints error messages if an SQL Exception is thrown
     * @param se SQLException that was thrown
     */
    private void printSQLExceptions(SQLException se) {
        System.out.println( "SQL Exception:" ) ;
        while(se != null) {
            System.out.println( "State  : " + se.getSQLState()  ) ;
            System.out.println( "Message: " + se.getMessage()   ) ;
            System.out.println( "Error  : " + se.getErrorCode() ) ;
            se = se.getNextException() ;
        }
    }

    public static void main (String[] args) {
        boolean x = true;
        String username = "";
        String password = "";
        Scanner scan = new Scanner(System.in);
        while(x) {
            System.out.print("Enter username ");
            username = scan.nextLine();
            System.out.print("Enter password ");
            password = scan.nextLine();
            if (username.equals("") || password.equals("")){
                System.out.println("Please enter a valid username or password");
            } else {
                x=false;
            }
        }
        NetflixDatabase netflixDB = new NetflixDatabase(username,password);
        netflixDB.mainMenu();
    }
}
