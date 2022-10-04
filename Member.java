import java.util.*;

public class Member extends Person {
    private float height; //measured in meters: must be between 1 & 3 inclusive
    private float startWeight; //measured in kgs: Must be between 35 and 250
    private Assessment assessment;
    private String chosenPackage;
    private TreeMap<String, Assessment> assessments = new TreeMap<>();

    public Member(String email, String name, String address,
                  String gender, float height, float startWeight, String chosenPackage) {
        super(email, name, address, gender);
        setHeight(height);
        setStartWeight(startWeight);
        setChosenPackage(chosenPackage);
    }

    public void addAssessment(String date, float weighRecord, float thighMeasurement, float waistMeasurement, String trainer, String comment) {
        assessment = new Assessment(
                weighRecord, thighMeasurement, waistMeasurement, trainer, comment);
        assessments.put(date, assessment);
    }

    
    public void listAssessments() {
        try {
            if (assessments.size() != 0) {
                for (String assessment : assessments.keySet()) {
                    System.out.println("\nDate: " + assessment + "\n" + assessments.get(assessment));
                }
            } else {
                System.out.println("\nNo assessments found");
            }
        } catch (Exception e) {
            System.out.println("\nNo assessments found");
        }
    }

    public Assessment getAssessment(String date) {
        try {
            Assessment assessment = assessments.get(date);
        } catch (Exception e) {
            assessment = null;
        }
        return assessment;
    }

    public Assessment latestAssessment() {
        try {
            String assessmentKey = assessments.lastKey();
            assessment = getAssessment(assessmentKey);
        } catch (Exception e) {
            assessment = null;
        }
        return assessment;
    }

    public Assessment secondMostRecentAssessment() {
        try {
            List<Assessment> targetList = new ArrayList<>(assessments.values());
            Assessment assessment = null;
            for (int i = 0; i < targetList.size() - 1; i++) {
                assessment = targetList.get(i);
            }
            return assessment;
        } catch (Exception e) {
            assessment = null;
        }
        return assessment;
    }

   
    public Assessment firstAssessment() {
        try {
            String assessmentKey = assessments.firstKey();
            assessment = assessments.get(assessmentKey);
        } catch (Exception e) {
            System.out.println("Error encountered, not enough data for: " + getName());
            assessment = null;
        }
        return assessment;
    }

   
    public float weightProgress() {
        Assessment assessment = latestAssessment();
        float lastWeight;
        Assessment lastAssessment = secondMostRecentAssessment();
        float currentWeight = assessment.getWeighRecord();
        if (lastAssessment!=null) {
            lastWeight = lastAssessment.getWeighRecord();
        }
        else{
            lastWeight= currentWeight;
        }
        float progress = lastWeight - currentWeight;
        return progress;
    }

   
    public float waistMeasureProgress() {
        Assessment latestAssessment = latestAssessment();
        Assessment lastAssessment = secondMostRecentAssessment();
        float progress = lastAssessment.getWaistMeasurement() - latestAssessment.getWaistMeasurement();
        return progress;
    }


   
    public float getHeight() {
        return height;
    }

    public float getStartWeight() {
        return startWeight;
    }

  
    public String getChosenPackage() {
        return chosenPackage;
    }

    public TreeMap<String, Assessment> getAssessments() {
        return assessments;
    }

  
    public void setHeight(float height) {
        if (height >= 1 && height <= 3) {
            this.height = height;
        } else if (height > 3) {
            this.height = 3;
        } else if (height < 1) {
            this.height = 1;
        }
    }

    
    public void setStartWeight(float startWeight) {
        if (startWeight >= 35 && startWeight <= 250) {
            this.startWeight = startWeight;
        } else if (startWeight < 35) {
            this.startWeight = 35;
        } else if (startWeight > 250) {
            this.startWeight = 250;
        }
    }


    public void setChosenPackage(String chosenPackage) {
        this.chosenPackage = chosenPackage;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nHeight:" + height
                + "\nStart Weight:" + startWeight
                + "\nchosenPackage:" + chosenPackage;
    }
}