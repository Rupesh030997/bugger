public class PremiumMember extends Member {

    public PremiumMember(String email, String name, String address,
                         String gender, float height, float startWeight, String chosenPackage) {
        super(email, name, address, gender, height, startWeight, chosenPackage);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPremium Member**";

    }
}