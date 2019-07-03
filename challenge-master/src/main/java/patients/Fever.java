package patients;

import java.util.List;
import domain.StateOfPatient;

import static domain.StateOfPatient.FEVER;

import domain.DrugsEfects;
import domain.Patient;

import static domain.DrugsEfects.CURES_FEVER;
import static domain.DrugsEfects.KILL;;

public class Fever implements Patient {

    @Override
    public StateOfPatient getState() {
        return FEVER;
    }

    @Override
    public Patient reactTo(List<DrugsEfects> drugs) {
        if (drugs.contains(KILL)) {
            return new Dead();

        } else if (drugs.contains(CURES_FEVER)) {
            return new Healthy();
        }
        return new Fever();
    }
}
