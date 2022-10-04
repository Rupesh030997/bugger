import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.System.exit;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class MenuController {
    private Scanner input = new Scanner(System.in);
    private GymAPI gym = new GymAPI();
    private Member currentMember;
    private Trainer currentTrainer;
    private InputReader inputReader;
    private Responder responder;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
    private LocalDateTime now = LocalDateTime.now();
    private ArrayList<String> searchOutput;
    private boolean goodInput;


    public static void main(String[] args) {
        MenuController drive = new MenuController();
        drive.runMainMenu();
 
    }

    private int mainMenu() {
        int option = -1;
        try {
            System.out.println("\nGym Menu");
            System.out.println("=================================");
            System.out.println("1) Login");
            System.out.println("2) Register");
            System.out.println("0) Exit");
            option = input.nextInt();
        } catch (Exception e) {
            input.nextLine();
            System.out.println("Access Denied");
            System.exit(0);
        }
        return option;
    }

    public int login() {
        goodInput = false;
        int option = -1;
        while (!goodInput) {
            try {
                System.out.println("\nGym Menu > Login");
                System.out.println("=================================");
                System.out.println("Are you a Member or Trainer?");
                System.out.println("1) Member");
                System.out.println("2) Trainer");
                System.out.println("0) Return");
                option = input.nextInt();
                goodInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Issue with input, please try again");
            }
        }
        return option;
    }

    public int register() {
        goodInput = false;
        int option = -1;
        while (!goodInput) {
            try {
                System.out.println("\nGym Menu > Register");
                System.out.println("=================================");
                System.out.println("Are you a Member or Trainer?");
                System.out.println("1) Member");
                System.out.println("2) Trainer");
                System.out.println("0) Return");
                option = input.nextInt();
                goodInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Issue with input, please try again");
            }
        }
        return option;
    }

    private int memberMenu() {
        goodInput = false;
        int option = -1;
        while (!goodInput) {
            try {
                System.out.println("\nMember: " + currentMember.getName());
                System.out.println("Gym Menu > Member Menu");
                System.out.println("=================================");
                System.out.println("1) View Profile");
                System.out.println("2) View Progress");
                System.out.println("3) Update Profile");
                System.out.println("4) Build workout");
                System.out.println("0) Exit");
                option = input.nextInt();
                goodInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Issue with input, please try again");
            }
        }
        return option;
    }

    public int progressMemberMenu() {
        goodInput = false;
        int option = -1;
        while (!goodInput) {
            try {
                System.out.println("\nUser: " + currentMember.getName());
                System.out.println("Gym Menu > Member Menu > Member Progress");
                System.out.println("=================================");
                System.out.println("1) View progress by weight");
                System.out.println("2) View progress by waist measurement");
                System.out.println("0) Return");
                option = input.nextInt();
                goodInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Issue with input, please try again");
            }
        }
        return option;
    }

    public int editMemberMenu() {
        goodInput = false;
        int option = -1;
        while (!goodInput) {
            try {
                System.out.println("\nUser: " + currentMember.getName());
                System.out.println("Gym Menu > Member Menu > Update Profile");
                System.out.println("=================================");
                System.out.println("1) Update Name");
                System.out.println("2) Update Home Address");
                System.out.println("0) Return");
                option = input.nextInt();
                goodInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Issue with input, please try again");
            }
        }
        return option;
    }

    private int trainerMenu() {
        goodInput = false;
        int option = -1;
        while (!goodInput) {
            try {
                System.out.println("\nTrainer: " + currentTrainer.getName());
                System.out.println("Gym Size: " + "Members(" + gym.numberOfMembers() + ")" + " Trainers(" + gym.numberOfTrainers() + ")");
                System.out.println("Gym Menu > Trainer Menu");
                System.out.println("=================================");
                System.out.println("1) Add a new member");
                System.out.println("2) Add a new trainer");
                System.out.println("3) List all members");
                System.out.println("4) List all trainers");
                System.out.println("5) Search for a member by email");
                System.out.println("6) Search for a member by name");
                System.out.println("7) Search for a trainer by name");
                System.out.println("8) Manage a Members Assessments");
                System.out.println("\t1) Add Assessment for member");
                System.out.println("\t2) Edit member assessment");
                System.out.println("\t3) Edit comment on member assessment");
                System.out.println("\t4) Get all assessments for a member");
                System.out.println("\t5) Get member BMI analysis");
                System.out.println("9) All members weight analysis");
                System.out.println("\t1) Get imperial and metric measurements for all members");
                System.out.println("\t2) Calculate current BMI for all members");
                System.out.println("\t3) Get list of members with ideal weight");
                System.out.println("\t4) List members by BMI category");
                System.out.println("0) Exit");
                option = input.nextInt();
                goodInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Issue with input, please try again");
            }
        }
        return option;
    }

    public int trainerSubMenu() {
        goodInput = false;
        int option = -1;
        while (!goodInput) {
            try {
                System.out.println("\nTrainer: " + currentTrainer.getName() + "\tMember: " + currentMember.getName());
                System.out.println("Gym Size: " + "Trainers(" + gym.numberOfTrainers() + ")" + " Members(" + gym.numberOfMembers() + ")");
                System.out.println("Gym Menu > Member Menu > Manage Members Assessments");
                System.out.println("=================================");
                System.out.println("1) Add Assessment for " + currentMember.getName());
                System.out.println("2) Edit " + currentMember.getName() + "'s" + " assessments");
                System.out.println("3) Edit assessment comment for " + currentMember.getName());
                System.out.println("4) Get all assessments for " + currentMember.getName());
                System.out.println("5) Get BMI analysis for " + currentMember.getName());
                System.out.println("0) Return");
                option = input.nextInt();
                goodInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Issue with input, please try again");
            }
        }
        return option;
    }

    public int analyticsMenu() {
        goodInput = false;
        int option = -1;
        while (!goodInput) {
            try {
                System.out.println("\nTrainer: " + currentTrainer.getName());
                System.out.println("Gym Size: " + "Members(" + gym.numberOfMembers() + ")" + " Trainers(" + gym.numberOfTrainers() + ")");
                System.out.println("Gym Menu > Member Menu > Weight analysis");
                System.out.println("=================================");
                System.out.println("1) Get imperial and metric measurements for all members");
                System.out.println("2) Calculate current BMI for all members");
                System.out.println("3) Get list of members with ideal weight");
                System.out.println("4) List members by BMI category");
                System.out.println("0) Return");
                option = input.nextInt();
                goodInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Issue with input, please try again");
            }
        }
        return option;
    }

    private void runMainMenu() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    runLogin();
                    break;
                case 2:
                    runRegister();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            option = mainMenu();

        }
    }

    public void runLogin() {
        int option = login();
        while (option != 0) {
            switch (option) {
                case 1:
                    memberLogin();
                    break;
                case 2:
                    trainerLogin();
                    break;
                case 0:
                    exit(0);
                    break;
            }
            option = login();
        }
    }

    public void memberLogin() {
        try {
            input.nextLine();
            System.out.println("\nGym Menu > Login > Member Login");
            System.out.println("=================================");
            System.out.println("Enter your Member ID/Email");
            String memberEmail = input.nextLine();
            Member member = gym.searchMembersByEmail(memberEmail);
            if (member.getEmail().equalsIgnoreCase(memberEmail)) {
                currentMember = member;
                runMemberMenu();
            } else {
                System.out.println("Access Denied");
                exit(0);
            }
        } catch (Exception e) {
            System.err.println("Access Denied");
            exit(0);
        }
    }

    public void trainerLogin() {
        try {
            input.nextLine();
            System.out.println("\nGym Menu > Login > Trainer Login");
            System.out.println("=================================");
            System.out.println("Enter your Trainer ID/Email");
            String trainerEmail = input.nextLine();
            Trainer trainer = gym.searchTrainersByEmail(trainerEmail);
            if (trainer.getEmail().equalsIgnoreCase(trainerEmail)) {
                currentTrainer = trainer;
                runTrainerMenu();
            } else {
                System.err.println("Access Denied");
                exit(0);
            }
        } catch (Exception e) {
            System.err.println("Access Denied");
            exit(0);
        }
    }

    public void runRegister() {
        int option = register();
        while (option != 0) {
            switch (option) {
                case 1:
                    addMember();
                    System.out.println("Congratulations, you may now log in\n");
                    runLogin();
                    break;
                case 2:
                    addTrainer();
                    System.out.println("Congratulations, you may now log in\n");
                    runLogin();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            option = 0;
        }
    }

    private void runMemberMenu() {
        int option = memberMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    System.out.println(currentMember.toString());
                    System.out.println("\nPress any key to continue...");
                    input.nextLine();
                    input.nextLine();
                    break;
                case 2:
                    runMemberProgressMenu(); //ISSUES WITH THIS
                    break;
                case 3:
                    runMemberEditMenu();
                    break;
                case 4:
                    runWorkoutWizard();
                    break;
                case 0:
                    exit(0);
                    System.out.println("\nLogging out...\n");
                    currentMember = null;
                    break;
            }
            option = memberMenu();
        }
    }

    public void runWorkoutWizard() {
        inputReader = new InputReader();
        responder = new Responder();
        responder.printWelcome();
        goodInput = false;
        int option = -1;
        while (!goodInput) {
            try {
                System.out.println("Select build mode");
                System.out.println("1) Random workout");
                System.out.println("2) Select a body part to work out");
                option = input.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("\nRandom workout");
                        System.out.println("=================================");
                        randomWorkout();
                        responder.printGoodbye();
                        break;
                    case 2:
                        System.out.println("Workout Search");
                        System.out.println("=================================");
                        workoutKeyWordSearch();
                        responder.printGoodbye();
                        break;
                }

                goodInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Issue with input, please try again");
            }
        }
    }

    public void randomWorkout() {
        input.nextLine();
        String response = responder.generateResponse();
        System.out.println(response);
        System.out.println("Enter any key to continue..");
        input.nextLine();
    }

    public void workoutKeyWordSearch() {
        System.out.println("What body part would you like to work? ");
        System.out.println("chest...legs...back?");
        HashSet<String> search = inputReader.getInput();
        input.nextLine();
        String response = responder.generateResponseSearch(search);
        System.out.println("\n" + response);
        System.out.println("Enter any key to continue..");
        input.nextLine();
    }

    private void memberSetForMemberEdit() {
        goodInput = false;
        while (!goodInput) {
            try {
                System.out.println("\nSelect member to view/edit");
                System.out.println("=================================");
                System.out.println("Enter member by name");
                input.nextLine();
                String memberName = input.nextLine();
                searchOutput = gym.searchMembersIDByName(memberName);
                int i = 1;
                if (searchOutput.size() > 0) {
                    System.out.println("Select member to update");
                    for (String searchResult : searchOutput) {
                        System.out.println(i + ") " + searchResult);
                        i++;
                    }
                    int memberselect = input.nextInt();
                    String memberEmail = searchOutput.get(memberselect - 1);
                    currentMember = gym.searchMembersByEmail(memberEmail);
                } else {
                    System.out.println("\nEnter any key to continue..");
                    input.nextLine();
                    System.out.println("No members found!");
                }
                goodInput=true;
            } catch (Exception e) {
                System.err.println("\nIssue with input");
                runTrainerMenu();
            }

        }
        runTrainerSubMenu();
    }

    private void runAnalyticsMenu() {
        int option = analyticsMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    listMemberDetailsImperialAndMetric();
                    break;
                case 2:
                    allMembersBmi();
                    break;
                case 3:
                    listMembersWithIdealWeight();
                    break;
                case 4:
                    listMembersBySpecificBMICategory();
                case 0:
                    runTrainerMenu();
                    break;
            }
            option = analyticsMenu();
        }
        currentMember = null;
    }

    private void runTrainerSubMenu() {
        int option = trainerSubMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    addMemberAssessment();
                    break;
                case 2:
                    editAssessment();
                    break;
                case 3:
                    editComment();
                    break;
                case 4:
                    getAllAssessmentsForMember();
                    break;
                case 5:
                    getBmiAnalysis();
                    break;
                case 0:
                    runTrainerMenu();
                    break;
            }
            option = trainerSubMenu();
        }
        currentMember = null;
    }

    private void runMemberEditMenu() {
        int option = editMemberMenu();
        while (option != -0) {
            switch (option) {
                case 1:
                    editName();
                    break;
                case 2:
                    editAddress();
                    break;
                case 0:
                    runMemberMenu();
                default:
                    break;
            }
            option = editMemberMenu();
        }
    }

    private void runMemberProgressMenu() {
        int option = progressMemberMenu();
        while (option != -0) {
            switch (option) {
                case 1:
                    weightProgress();
                    break;
                case 2:
                    waistMeasureProgress();
                    break;
                case 0:
                    runMemberMenu();
                default:
                    break;
            }
            option = progressMemberMenu();
        }
    }

    public void weightProgress() {
        input.nextLine();
        if (currentMember.getAssessments().size() == 0) {
            System.out.println("\nYour starting weight was:" + currentMember.getStartWeight());
            System.out.println("\nNot enough data, please book in for an assessment");
        } else {
            if (currentMember.getAssessments().size() == 1) {
                System.out.println("\nYour starting weight was:" + currentMember.getStartWeight());
                System.out.println("Measurement from your last assessment");
                System.out.println(currentMember.latestAssessment());
            } else if (currentMember.getAssessments().size() > 1) {
                System.out.println("Latest Assessment");
                System.out.println(currentMember.latestAssessment());
                System.out.println("\nMeasurement from your last assessment");
                System.out.println(currentMember.secondMostRecentAssessment());

            }
            float progress = currentMember.weightProgress();
            if (progress > 2) {
                System.out.println("\nCongratulations, you have lost " + progress + "kgs. Keep up the good work");
            } else if (progress < 0) {
                System.out.println("\nYou have gone up " + (progress * -1) + "kgs. keep working at it");
            } else if (progress == 0) {
                System.out.println("\nNot enough data, come back next week");
            } else {
                System.out.println("\nYour weight has fluctuated " + (progress) + "kgs. keep working at it");
            }
            System.out.println("\nEnter any key to continue..");
            input.nextLine();
        }
    }

    public void waistMeasureProgress() {
        input.nextLine();
        if (currentMember.getAssessments().size() == 0) {
            System.out.println("\nNot enough data, please book in for an assessment");
        } else {
            if (currentMember.getAssessments().size() == 1) {
                System.out.println("\nMeasurement from your last assessment");
                System.out.println(currentMember.secondMostRecentAssessment().getWaistMeasurement());
            } else if (currentMember.getAssessments().size() > 1) {
                System.out.println("Latest Waist Measurement");
                System.out.println(currentMember.latestAssessment().getWaistMeasurement());
                System.out.println("\nMeasurement from your last assessment");
                System.out.println(currentMember.secondMostRecentAssessment().getWaistMeasurement());

            }
            float progress = currentMember.waistMeasureProgress();
            if (progress > 2) {
                System.out.println("\nCongratulations, you have lost " + progress + "cm's off your waist. Keep up the good work");
            } else if (progress < 0) {
                System.out.println("\nYou have gone up " + (progress * -1) + "cm's. keep working at it");
            } else if (progress == 0) {
                System.out.println("\nNot enough data, come back next week");
            } else {
                System.out.println("\nYour weight has fluctuated " + (progress) + "cm's. keep working at it");
            }

            System.out.println("\nEnter any key to continue..");
            input.nextLine();
        }
    }

    public void editName() {
        try {
            System.out.println("\nEdit name for " + currentMember.getName());
            System.out.println("=================================");
            input.nextLine();
            System.out.println("\nEnter your name: ");
            String name = input.nextLine();
            currentMember.setName(name);
            System.out.println("Your name has been updated to " + name);
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
        
    }

    public void editAddress() {
        try {
            System.out.println("\nEdit address for " + currentMember.getName());
            System.out.println("=================================");
            input.nextLine();
            System.out.println("\nEnter Home Address: ");
            String address = input.nextLine();
            currentMember.setAddress(address);
            System.out.println("Your address has been updated to " + address);
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
        
    }

    private void runTrainerMenu() {
        int option = trainerMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    addMember();
                    break;
                case 2:
                    addTrainer();
                    break;
                case 3:
                    listMembers();
                    break;
                case 4:
                    listTrainers();
                    break;
                case 5:
                    searchMembersByEmail();
                    break;
                case 6:
                    searchMembersByName();
                    break;
                case 7:
                    searchTrainersByName();
                    break;
                case 8:
                    memberSetForMemberEdit();
                    break;
                case 9:
                    runAnalyticsMenu();
                    break;
                case 0:
                    exit(0);
                    System.out.println("\nLogging out...\n");
                    currentTrainer = null;
                    break;
            }
            option = trainerMenu();
        }
    }

    public void listMembers() {
        input.nextLine();
        System.out.println("\nMember List:");
        System.out.println("=================================");
        System.out.println(gym.listMembers());
        System.out.println("\nEnter any key to continue..");
        input.nextLine();
    }

    public void listTrainers() {
        input.nextLine();
        System.out.println("\nTrainer List:");
        System.out.println("=================================");
        System.out.println(gym.listTrainers());
        System.out.println("\nEnter any key to continue..");
        input.nextLine();
    }

    public void searchMembersByEmail() {
        try {
            System.out.println("\nSearch Members by email");
            System.out.println("=================================");
            input.nextLine();
            System.out.println("\nEnter Member email");
            String memberEmail = input.nextLine();
            Member member = gym.searchMembersByEmail(memberEmail);
            if (member.getEmail().equals(memberEmail)) {
                System.out.println(member);
            } else {
                System.out.println("Member not found");
                runTrainerMenu();
            }
            System.out.println("\nEnter any key to continue..");
            input.nextLine();
            runTrainerMenu();
        } catch (Exception e) {
            System.err.println("Invalid input");
            runTrainerMenu();
        }
    }

   
    public void searchTrainersByName() {
        try {
            System.out.println("\nSearch Trainers by name");
            System.out.println("=================================");
            input.nextLine();
            System.out.println("Enter Trainer name");
            String trainerName = input.nextLine();
            searchOutput = gym.searchTrainersListByName(trainerName);
            int i = 1;
            for (String searchResult : searchOutput) {
                System.out.println(i + ") " + searchResult);
                i++;
            }
            System.out.println("\nEnter any key to continue..");
            input.nextLine();
            runTrainerMenu();
        } catch (Exception e) {
            System.err.println("Invalid input");
            runTrainerMenu();
        }
    }

    public void searchMembersByName() {
        try {
            System.out.println("\nSearch Members by name");
            System.out.println("=================================");
            input.nextLine();
            System.out.println("Enter Member name");
            String memberName = input.nextLine();
            searchOutput = gym.searchMembersListByName(memberName);
            int i = 1;
            for (String searchResult : searchOutput) {
                System.out.println(i + ") " + searchResult);
                i++;
            }
            System.out.println("\nEnter any key to continue..");
            input.nextLine();
            runTrainerMenu();
        } catch (Exception e) {
            System.err.println("Invalid input");
            runTrainerMenu();
        }
    }

  
    public void addMemberAssessment() {
        goodInput = false;
            try {
                System.out.println("Add Member Assessment");
                System.out.println("=================================");
                input.nextLine();
                System.out.println("Enter Client Weight: ");
                float weighRecord = input.nextFloat();
                System.out.println("Enter Client Thigh Measurement:");
                float thighMeasurement = input.nextFloat();
                System.out.println("Enter Client Waist Measurement:");
                float waistMeasurement = input.nextFloat();
                String trainer = currentTrainer.getName();
                input.nextLine();
                System.out.println("Enter Additional Comments:");
                String comment = input.nextLine();
                String dateString = "" + dtf.format(now);
                gym.addMemberAssessment(currentMember, dateString, weighRecord, thighMeasurement, waistMeasurement, trainer, comment);
            } catch (Exception e) {
                System.err.println("\nInvalid input");

        }
   
    }

    
    public void editAssessment() {
        goodInput = false;
        int i = 4;
        while (!goodInput && i > 0) {
            try {
                System.out.println("Edit Member Assessment");
                System.out.println("=================================");
                input.nextLine();
                currentMember.listAssessments();
                System.out.println("\nEnter any key to continue..");
                input.nextLine();
                System.out.println("\nEnter the date of assessment(Format yy/mm/dd): ");
                String date = input.nextLine().toLowerCase();
                Assessment updateAssessmentcurrent = currentMember.getAssessment(date);
                System.out.println("Enter Client Weight: ");
                float weighRecord = input.nextFloat();
                System.out.println("Enter Client Thigh Measurement:");
                float thighMeasurement = input.nextFloat();
                System.out.println("Enter Client Waist Measurement:");
                float waistMeasurement = input.nextFloat();
                System.out.println("Enter Additional Comments:");
                input.nextLine();
                String comment = input.nextLine();
                updateAssessmentcurrent.setWeight(weighRecord);
                updateAssessmentcurrent.setThighMeasurement(thighMeasurement);
                updateAssessmentcurrent.setWaistMeasurement(waistMeasurement);
                updateAssessmentcurrent.setComment(comment);
                goodInput = true;
            } catch (Exception e) {
                i--;
                System.err.println("\nInvalid input, you have " + i + " tries remaining");
            }
        }
  
    }

    public void editComment() {
        goodInput = false;
        int i = 4;
        while (!goodInput && i > 0) {
            try {
                System.out.println("Edit Member Assessment Comment");
                System.out.println("=================================");
                input.nextLine();
                currentMember.listAssessments();
                System.out.println("\nEnter any key to continue..");
                input.nextLine();
                System.out.println("\nEnter the date of assessment(Format yy/mm/dd): ");
                String date = input.nextLine().toLowerCase();
                Assessment updateAssessmentcurrent = currentMember.getAssessment(date);
                System.out.println("The comment currently saved for this assessment: \n \"" + updateAssessmentcurrent.getComment() + "\" ");
                System.out.println("Enter new Comments:");
                String comment = input.nextLine();
                updateAssessmentcurrent.setComment(comment);
                goodInput = true;
            } catch (Exception e) {
                i--;
                System.err.println("\nInvalid input, you have " + i + " tries remaining");
            }
        }
       
    }

    public void getAllAssessmentsForMember() {
        System.out.println("List all Assessments for " + currentMember.getName());
        System.out.println("=================================");
        input.nextLine();
        currentMember.listAssessments();
        System.out.println("\nEnter any key to continue..");
        input.nextLine();
    }

    public void getBmiAnalysis() {
        System.out.println("BMI analysis for " + currentMember.getName());
        System.out.println("=================================");
        input.nextLine();
        System.out.println(gym.bmiAnalysis(currentMember));
        System.out.println("\nEnter any key to continue..");
        input.nextLine();
    }

    public void listMemberDetailsImperialAndMetric() {
        try {
            System.out.println("\nList member details imperial and metric");
            System.out.println("=================================");
            input.nextLine();
            System.out.println(gym.listMemberDetailsImperialAndMetric());
            System.out.println("\nEnter any key to continue..");
            input.nextLine();
        } catch (Exception e) {
            runAnalyticsMenu();
        }
    }

    
    public void allMembersBmi() {
        try {
            System.out.println("\nBMI analysis for all members");
            System.out.println("=================================");
            input.nextLine();
            System.out.println(gym.allMembersBmi());
            System.out.println("\nEnter any key to continue..");
            input.nextLine();
        } catch (Exception e) {
            runAnalyticsMenu();
        }
    }

    public void listMembersWithIdealWeight() {
        try {
            System.out.println("\nList members with ideal weight");
            System.out.println("=================================");
            input.nextLine();
            ArrayList<Member> idealBwMembers = gym.listMembersWithIdealWeight();
                for (Member member : idealBwMembers) {
                    double weight;
                    if (member.getAssessments().size() > 0) {
                        weight = member.latestAssessment().getWeighRecord();
                    } else {
                        weight = member.getStartWeight();
                    }
                    weight = GymUtility.toTwoDecimalPlaces(weight);
                    System.out.println("Member name: " + member.getName() + "\nis "
                            + member.getHeight() + " metres tall and weighs " + weight + "kg's");
                }
            System.out.println("\nEnter any key to continue..");
            input.nextLine();
        } catch (Exception e) {
            runAnalyticsMenu();
        }
        System.out.println("\nEnter any key to continue..");
        input.nextLine();
        runAnalyticsMenu();
    }

    public void listMembersBySpecificBMICategory() {
        try {
            System.out.println("\nBMI analysis for all members");
            System.out.println("=================================");
            System.out.println("1) Severely Underweight");
            System.out.println("2) Underweight");
            System.out.println("3) Normal");
            System.out.println("4) Overweight");
            System.out.println("5) Moderately Obese");
            System.out.println("6) Severely Obese");
            input.nextLine();
            int option = input.nextInt();
            input.nextLine();
            String category = "";
            switch (option) {
                case 1:
                    category = "Severely Underweight";
                    break;
                case 2:
                    category = "Underweight";
                    break;
                case 3:
                    category = "Normal";
                    break;
                case 4:
                    category = "Overweight";
                    break;
                case 5:
                    category = "Moderately Obese";
                    break;
                case 6:
                    category = "Severely Obese";
                    break;
            }
            ArrayList<Member> membersBycat = gym.listMembersBySpecificBMICategory(category);
            if (membersBycat.size() > 0) {
                System.out.println("\n" + category);
                for (Member member : membersBycat) {
                    System.out.println("Member name: " + member.getName() + "\n Email: " + member.getEmail());
                }
            } else {
                System.out.println(category + ":\tNo members found fit this category.");
            }
            System.out.println("\nEnter any key to continue..");
            input.nextLine();
        } catch (Exception e) {
            runAnalyticsMenu();
        }
        runAnalyticsMenu();
    }

    
    public void addMember() {
        goodInput = false;
        while (!goodInput) {
            try {
                System.out.println("\nAdd Member");
                System.out.println("=================================");
                input.nextLine();
                int packageInput;
                System.out.println("Enter name: ");
                String name = input.nextLine();
                String email = "";
                System.out.println("Enter email: ");
                email = input.nextLine();
                do {
                    if ((gym.searchTrainersByEmail(email) != null) || (gym.searchMembersByEmail(email) != null)) {
                        System.err.println("This email is already taken, please try again");
                        System.out.println("Enter email: ");
                        email = input.nextLine();
                    }
                }
                while ((gym.searchTrainersByEmail(email) != null) || (gym.searchMembersByEmail(email) != null));
                System.out.println("Enter Home Address: ");
                String address = input.nextLine();
                System.out.println("Enter Gender: ");
                String gender = input.nextLine();
                gender = gender.substring(0, 1);
                System.out.println("Enter Height: ");
                float height = input.nextFloat();
                System.out.println("Enter Weight: ");
                float startWeight = input.nextFloat();
                System.out.println("Are you joining as a student? (Y/N)");
                char studentval = input.next().charAt(0);
                if ((studentval == 'Y') || (studentval == 'y')) {
                    input.nextLine();
                    String chosenPackage = "";
                    System.out.println("Please enter your college name: ");
                    String collegeName = input.nextLine();
                    if (collegeName.equalsIgnoreCase("wit")) {
                        chosenPackage = packageSelection(4);
                    } else {
                        chosenPackage = packageSelection(3);
                    }
                    System.out.println("Enter Student Number: ");
                    int studentNumber = input.nextInt();
                    gym.addMember(new StudentMember(email, name, address, gender, height, startWeight, chosenPackage, studentNumber, collegeName));
                    System.out.println(name + " was added successfully");
                    System.out.println("\nEnter any key to continue..");
                    input.nextLine();
                    input.nextLine();
                    goodInput = true;
                } else {
                    System.out.println("Which Package would you like to sign up for? (1/2)");
                    System.out.println("\n(1) " + packageSelection(1) + "\n\n" + "(2) " + packageSelection(2));
                    packageInput = input.nextInt();
                    String chosenPackage = packageSelection(packageInput);
                    gym.addMember(new PremiumMember(email, name, address, gender, height, startWeight, chosenPackage));
                    System.out.println(name + " was added successfully");
                    System.out.println("\nEnter any key to continue..");
                    input.nextLine();
                    input.nextLine();
                    goodInput = true;
                }
            } catch (Exception e) {
                input.nextLine();
                System.err.println("\nInvalid input, try again");
                addMember();
            }
        }
        currentMember = null;
       
    }

    public void addTrainer() {
        goodInput = false;
        while (!goodInput) {
            try {
                System.out.println("\nAdd Trainer");
                System.out.println("=================================");
                input.nextLine();
                System.out.println("Enter name: ");
                String name = input.nextLine();
                String email = "";
                System.out.println("Enter email: ");
                email = input.nextLine();
                do {
                    if ((gym.searchTrainersByEmail(email) != null) || (gym.searchMembersByEmail(email) != null)) {
                        System.err.println("This email is already taken, please try again");
                        System.out.println("Enter email: ");
                        email = input.nextLine();
                    }
                }
                while ((gym.searchTrainersByEmail(email) != null) || (gym.searchMembersByEmail(email) != null));
                System.out.println("Enter Home Address: ");
                String address = input.nextLine();
                System.out.println("Enter Gender: ");
                String gender = input.nextLine();
                gender = gender.substring(0, 1);
                System.out.println("Enter Speciality: ");
                String speciality = input.nextLine();
                gym.addTrainer(new Trainer(email, name, address, gender, speciality));
                System.out.println(name + " was added successfully");
                System.out.println("\nEnter any key to continue..");
                input.nextLine();
                goodInput = true;
            } catch (Exception e) {
                System.err.println("\nInvalid input, try again");
                addTrainer();
            }
        }
   
    }

    private String packageSelection(int option) {
        HashMap<String, String> packages = new HashMap<String, String>();
        packages.put("Package 1", "Allowed access anytime to gym.\nFree access to all classes.\nAccess to all changing areas including deluxe changing rooms.");
        packages.put("Package 2", "Allowed access anytime to gym.\n€3 fee for all classes.\nAccess to all changing areas including deluxe changing rooms.");
        packages.put("Package 3", "Allowed access to gym at off-peak times.\n€5 fee for all classes. \nNo access to deluxe changing rooms.");
        packages.put("WIT", "Allowed access to gym during term time.\n€4 fee for all classes.  \nNo access to deluxe changing rooms.");
        String packageChosen;
        switch (option) {
            case 1:
                packageChosen = packages.get("Package 1");
                break;
            case 2:
                packageChosen = packages.get("Package 2");
                break;
            case 3:
                packageChosen = packages.get("Package 3");
                break;
            case 4:
                packageChosen = packages.get("WIT");
                break;
            default:
                packageChosen = packages.get("Package 2");
        }
        return packageChosen;
    }


    /*private void loadFromXML() {
        try {
            gym.load();
        } catch (Exception e) {
            System.err.println("Error loading from XML file...\n" + e);
        }
    }

    private void saveToXML() {
        try {
            gym.store();
        } catch (Exception e) {
            System.err.println("Error saving to XML file...\n" + e);
        }
    }*/
}