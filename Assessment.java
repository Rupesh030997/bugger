public class Assessment {

    private float weighRecord;
    private float thighMeasurement;
    private float waistMeasurement;
    private String trainer;
    private String comment;

    public Assessment(float weighRecord, float thighMeasurement, float waistMeasurement, String comment) {
        this.weighRecord = weighRecord;
        this.thighMeasurement = thighMeasurement;
        this.waistMeasurement = waistMeasurement;
        this.comment = comment;
    }

    public Assessment(float weighRecord, float thighMeasurement, float waistMeasurement, String trainer, String comment) {
        this.weighRecord = weighRecord;
        this.thighMeasurement = thighMeasurement;
        this.waistMeasurement = waistMeasurement;
        this.comment = comment;
        this.trainer = trainer;
    }

  
    public float getWeighRecord() {
        return weighRecord;
    }

    public float getThighMeasurement() {
        return thighMeasurement;
    }

   
    public float getWaistMeasurement() {
        return waistMeasurement;
    }


    public String getComment() {
        return comment;
    }

   
    public void setWeight(float weighRecord) {
        this.weighRecord = weighRecord;
    }


    public void setThighMeasurement(float thighMeasurement) {
        this.thighMeasurement = thighMeasurement;
    }

   
    public void setWaistMeasurement(float waistMeasurement) {
        this.waistMeasurement = waistMeasurement;
    }

   
    public void setComment(String comment) {
        this.comment = comment;
    }

    
    public String toString() {
        return "Trainer: " + trainer + "\tComment: " + comment
                + "\n\tWeight Recording: " + weighRecord
                + "\tThigh Measurement: " + thighMeasurement
                + "\tWaist Measurement: " + waistMeasurement;
    }
}