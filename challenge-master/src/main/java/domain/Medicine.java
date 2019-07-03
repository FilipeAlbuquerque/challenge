package domain;

import java.util.Arrays;

public enum Medicine {

    ASPIRIN("As"), ANTIBIOTIC("An"), INSULIN("I"), PARACETAMOL("P");

    private String medicine;

    Medicine(String medicine) {
        this.medicine = medicine;
    }

    public static Medicine getMedicineWith(String medicine) {
        return Arrays.stream(Medicine.values())
                .filter(x -> x.getMedicine()
                        .equals(medicine))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Invalid medicine"));
    }

    public String getMedicine() {
        return medicine;
    }
}
