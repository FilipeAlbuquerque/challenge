package patients;

import java.util.List;

import domain.DrugsEfects;
import domain.Patient;
import domain.StateOfPatient;
import static domain.StateOfPatient.TUBERCULOSIS;

import static domain.DrugsEfects.CURES_TUBERCULOSIS;
import static domain.DrugsEfects.KILL;

public class Tuberculosis implements Patient {

    @Override
    public StateOfPatient getState() {
        return TUBERCULOSIS;
    }

    @Override
    public Patient reactTo(List<DrugsEfects> drugs) {
        if (drugs.contains(KILL)) {
            return new Dead();
        } else if (drugs.contains(CURES_TUBERCULOSIS)) {
            return new Healthy();
        } else {
            return new Tuberculosis();
        }
    }
}
