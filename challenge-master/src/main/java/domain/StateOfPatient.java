package domain;

import java.util.Arrays;

public enum StateOfPatient {

    FEVER("F"), HEALTHY("H"), DIABETES("D"), TUBERCULOSIS("T"), DEAD("X");

    String code;

    StateOfPatient(String code) {
        this.code = code;
    }

    public static StateOfPatient getStateFrom(String code) {
        return Arrays.stream(StateOfPatient.values())
                .filter(x -> x.getCode()
                        .equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No state available"));
    }

    public String getCode() {
        return code;
    }
}
