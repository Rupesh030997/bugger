import java.math.BigDecimal;
import java.text.DecimalFormat;

public class GymUtility {

    public static double calculateBMI(Member member, Assessment assessment) {
        try {
            double latestWeight;
            if (assessment != null) {
                latestWeight = assessment.getWeighRecord();
            } else {
                latestWeight = member.getStartWeight();
            }
            double height = member.getHeight();
            double BMI = latestWeight / (height * height);
            return toTwoDecimalPlaces(BMI);
        } catch (Exception e) {
            return 0;
        }
    }

    public static double toTwoDecimalPlaces(double number) {
        return (int) (number * 100) / 100.0;
    }

    public static double roundDecimalPlaces(double number) {
        number =Double.parseDouble(new DecimalFormat("##.##").format(number));
        return number;
    }

    public static String determineBMICategory(double bmiValue) {
        String bmicategory = "";
        try {
            double BMIvalue = bmiValue;
            if (bmiValue > 0) {
                if (BMIvalue < 16) {
                    bmicategory = "SEVERELY UNDERWEIGHT";
                } else if (BMIvalue >= 16 && bmiValue < 18.5) {
                    bmicategory = "UNDERWEIGHT";
                } else if (BMIvalue >= 18.5 && bmiValue < 25) {
                    bmicategory = "NORMAL";
                } else if (BMIvalue >= 25 && bmiValue < 30) {
                    bmicategory = "OVERWEIGHT";
                } else if (BMIvalue >= 30 && bmiValue < 35) {
                    bmicategory = "MODERATELY OBESE";
                } else if (BMIvalue >= 35) {
                    bmicategory = "SEVERELY OBESE";
                }
                return bmicategory;
            } else {
                bmicategory = "Not enough data";
                return bmicategory;
            }
        } catch (Exception e) {
            return bmicategory;
        }
    }

    public static boolean isIdealBodyWeight(Member member, Assessment assessment) {
        double baseWeightMale = 50;
        double baseWeightFemale = 45.5;
        double baseHeight = 60; //5 feet in inches
        double mtrsToInch = 39.37;  //meters to inches

        double memberWeight;
        if (assessment != null) {
            memberWeight = assessment.getWeighRecord();
        } else {
            memberWeight = member.getStartWeight();
        }

        double memberHeight;
        if ((member.getHeight()) * mtrsToInch < baseHeight) {
            memberHeight = baseHeight;
        } else {
            memberHeight = member.getHeight() * mtrsToInch;
        }
        double weightDifference;
        String gender = member.getGender();
        if (gender.equalsIgnoreCase("m")) {
            weightDifference = memberWeight - baseWeightMale;
        } else {
            weightDifference = memberWeight - baseWeightFemale;
        }
        double heightDifference = memberHeight - baseHeight;
        double allowance = heightDifference * 2.3; //2.3kg allowance per inch over 5 foot
        double weightAllowanceDifference = weightDifference - allowance;

        if ((weightAllowanceDifference >= -0.2) && (weightAllowanceDifference <= 0.2)) {
            return true;
        }
        {
            return false;
        }

    }
}