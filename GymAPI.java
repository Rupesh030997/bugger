import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import java.util.ArrayList;


public class GymAPI {
    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;

   
    public GymAPI() {
        members = new ArrayList<Member>();
        trainers = new ArrayList<Trainer>();
    }


   
    public String listMemberDetailsImperialAndMetric() {
        String str = "";
        if (members.size() != 0) {
            for (Member member : members) {
                String name;
                float weight;
                float height;
                if (member.latestAssessment() != null) {
                    name = member.getName();
                    weight = member.latestAssessment().getWeighRecord();
                    height = member.getHeight();
                    str = str + name + ": "
                            + weight + " kg(" + (GymUtility.roundDecimalPlaces(weight * 2.20)) + " lbs)\t\t"
                            + height + " metres (" + (GymUtility.roundDecimalPlaces(height * 39.37)) + " inches)\n";
                } else {
                    name = member.getName();
                    weight = member.getStartWeight();
                    height = member.getHeight();
                    str = str + name + ": "
                            + weight + " kg(" + (GymUtility.roundDecimalPlaces(weight * 2.20)) + " lbs)\t\t"
                            + height + " metres (" + (GymUtility.roundDecimalPlaces(height * 39.37)) + " inches)\n";
                }
            }
        } else {
            str = "No registered members";
        }
        return str;
    }

   
    public ArrayList<Member> listMembersWithIdealWeight() {
        ArrayList<Member> membersWithIdealWeight = new ArrayList<Member>();
        if (members.size() >0) {
                for (Member member : members) {
                    Assessment assessment = member.latestAssessment();
                    if (assessment!=null) {
                        Boolean idealBW = GymUtility.isIdealBodyWeight(member, assessment);
                        if (idealBW) {
                            membersWithIdealWeight.add(member);
                        }
                    }
                }
                return membersWithIdealWeight;
            }
        return membersWithIdealWeight;
        }


  
    public String allMembersBmi() {
        String membersBmiAnalysis = "";
        if (members.size() != 0) {
            ArrayList<Member> membersWithIdealWeight = new ArrayList<Member>();
                for (Member member : members) {
                    Assessment assessment = member.latestAssessment();
                    double currentBmi = GymUtility.calculateBMI(member, assessment);
                    membersBmiAnalysis = membersBmiAnalysis + "Name: " + member.getName() + "\tBMI: " + currentBmi + "\n";
                }
                return membersBmiAnalysis;
        }
        return membersBmiAnalysis = "No data found";
    }

  
    public String bmiAnalysis(Member member) {
        Assessment assessment = member.latestAssessment();
        double calculateBMI = GymUtility.calculateBMI(member, assessment);
        String currentBmiCat = GymUtility.determineBMICategory(calculateBMI);
        Boolean idealBW = GymUtility.isIdealBodyWeight(member, assessment);
        String endOfString;
        if (idealBW == true) {
            endOfString = " has an ideal body weight";
        } else {
            endOfString = " does not have an ideal body weight";
        }
        String name = member.getName();
        String str = "\nMember:" + member.getName()
                + "\n--Has a BMI of " + calculateBMI
                + "\n--This is categorised as " + currentBmiCat
                + "\n--" + name + endOfString;
        return str;
    }

    
    public ArrayList<Member> listMembersBySpecificBMICategory(String category) {
        ArrayList<Member> listMembersByBMICategory = new ArrayList<Member>();
        if (members.size() > 0) {
            for (Member member : members) {
                Assessment assessment = member.latestAssessment();
                double calculateBMI = GymUtility.calculateBMI(member, assessment);
                String currentBmiCat = GymUtility.determineBMICategory(calculateBMI);
                if (currentBmiCat.toLowerCase().contains(category.toLowerCase())){
                    listMembersByBMICategory.add(member);
                }
            }
        }
        return listMembersByBMICategory;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

  
    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    
    public void addMember(Member member) {
        members.add(member);
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }


    public String listMembers() {
        if (members.size() == 0) {
            return "No members found";
        } else {
            String memberList = "";
            int counter = 1;
            for (Member member : members) {
                memberList = memberList + counter + " : " + "Name: " + member.getName()
                        + "\t\tEmail: " + member.getEmail() + "\n";
                counter++;
            }
            return memberList;
        }
    }

    public String listTrainers() {
        if (trainers.size() == 0) {
            return "No trainers found";
        } else {
            String trainerList = "";
            int counter = 1;
            for (Trainer trainer : trainers) {
                trainerList = trainerList + counter + " : " + "Email: " + trainer.getEmail()
                        + "\n\tName: " + trainer.getName()
                        + "\tSpeciality: " + trainer.getSpeciality() + "\n";
                counter++;
            }
            return trainerList;
        }
    }

    public int numberOfMembers() {
        return members.size();
    }

    public int numberOfTrainers() {
        return trainers.size();
    }

    public boolean isValidMemberIndex(int index) {
        if (members.size() > 0) {
            if (index < members.size()) {
                return true;
            } else if (index > members.size()) {
                return false;
            }
        }
        return false;
    }

    public boolean isValidTrainerIndex(int index) {
        if (trainers.size() > 0) {
            if (index < trainers.size()) {
                return true;
            } else if (index > trainers.size()) {
                return false;
            }
        }
        return false;
    }

    public Member searchMembersByEmail(String emailEntered) {
        if (members.size() != 0) {
            Member memberSearch = null;
            for (Member member : members) {
                if (member.getEmail().equalsIgnoreCase(emailEntered)) {
                    memberSearch = member;
                    return memberSearch;
                }
            }
            return memberSearch;
        } else
            return null;
    }

    public ArrayList<String> searchTrainersByName(String nameEntered) {
        ArrayList<String> trainerSearch = new ArrayList<String>();
        if (trainers.size() > 0) {
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getName().toLowerCase().contains((nameEntered.toLowerCase()))) {
                    trainerSearch.add(trainers.get(i).getName());
                }
            }
            return trainerSearch;
        } else {
            return trainerSearch;
        }
    }

    public ArrayList<String> searchTrainersListByName(String nameEntered) {
        ArrayList<String> trainerSearch = new ArrayList<String>();
        if (trainers.size() > 0) {
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getName().toLowerCase().contains((nameEntered.toLowerCase()))) {
                    trainerSearch.add(i, (i + 1) + " Name: " + trainers.get(i).getName() + "\tEmail: " + trainers.get(i).getEmail());
                }
            }
            return trainerSearch;
        } else {
            return trainerSearch;
        }
    }

    public ArrayList<String> searchMembersByName(String nameEntered) {
        ArrayList<String> memberSearch = new ArrayList<String>();
        if (members.size() > 0) {
            for (int i = 0; i < members.size(); i++) {
                if ((members.get(i).getName()).toLowerCase().contains((nameEntered.toLowerCase()))) {
                    memberSearch.add(members.get(i).getName());
                }
            }
            return memberSearch;
        } else {
            return memberSearch;
        }
    }

    public ArrayList<String> searchMembersIDByName(String nameEntered) {
        ArrayList<String> memberSearch = new ArrayList<String>();
        if (members.size() > 0) {
            for (int i = 0; i < members.size(); i++) {
                if ((members.get(i).getName()).toLowerCase().contains((nameEntered.toLowerCase()))) {
                    memberSearch.add(members.get(i).getEmail());
                }
            }
            return memberSearch;
        } else {
            return memberSearch;
        }
    }

    public ArrayList<String> searchMembersListByName(String nameEntered) {
        ArrayList<String> memberSearch = new ArrayList<String>();
        if (members.size() > 0) {
            for (int i = 0; i < members.size(); i++) {
                if ((members.get(i).getName()).toLowerCase().contains((nameEntered.toLowerCase()))) {
                    memberSearch.add("Name: " + members.get(i).getName() + "\tEmail: " + members.get(i).getEmail());
                }
            }
            return memberSearch;
        } else {
            memberSearch.add(0, "No members found");
            return memberSearch;
        }
    }

    public Trainer searchTrainersByEmail(String emailEntered) {
        if (trainers.size() != 0) {
            Trainer trainerSearch = null;
            for (Trainer trainer : trainers) {
                if (trainer.getEmail().equalsIgnoreCase(emailEntered)) {
                    trainerSearch = trainer;
                }
            }
            return trainerSearch;
        } else
            return null;
    }

    public void addMemberAssessment(Member member, String date, float weighRecord, float thighMeasurement, float waistMeasurement, String trainer, String comment) {
        member.addAssessment(date, weighRecord, thighMeasurement, waistMeasurement, trainer, comment);
    }

}