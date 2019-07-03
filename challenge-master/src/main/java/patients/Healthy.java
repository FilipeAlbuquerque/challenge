package patients;

import java.util.List;

import domain.DrugsEfects;
import domain.Patient;
import domain.StateOfPatient;

import static domain.StateOfPatient.HEALTHY;
import static domain.DrugsEfects.KILL;
import static domain.DrugsEfects.HEALTHY_PEOPLE_CATCH_FEVER;

public class Healthy implements Patient {

    @Override
    public StateOfPatient getState() {
        return HEALTHY;
    }

    @Override
    public Patient reactTo(List<DrugsEfects> drugs) {
        if (drugs.contains(KILL)) {
            return new Dead();
        } else if (drugs.contains(HEALTHY_PEOPLE_CATCH_FEVER)) {
            return new Fever();
        } else {
            return new Healthy();
        }
    }
}
