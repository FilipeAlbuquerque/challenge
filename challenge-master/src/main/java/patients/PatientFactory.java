package patients;

import domain.StateOfPatient;
import domain.Patient;

public class PatientFactory {

    public static Patient createPatient(StateOfPatient stateOfPatient) {

        switch (stateOfPatient) {

            case FEVER:
                return new Fever();

            case DEAD:
                return new Dead();

            case DIABETES:
                return new Diabetes();

            case TUBERCULOSIS:
                return new Tuberculosis();

            case HEALTHY:
                return new Healthy();

            default: throw new RuntimeException("Cannot create a Patient");

        }
    }
}
