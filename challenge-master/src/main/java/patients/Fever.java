package patients;

import java.util.List;
import domain.StateOfPatient;

import static domain.StateOfPatient.FEVER;

import domain.DrugsEffects;
import domain.Patient;

import static domain.DrugsEffects.CURES_FEVER;
import static domain.DrugsEffects.KILL;;

public class Fever implements Patient {

    @Override
    public StateOfPatient getState() {
        return FEVER;
    }

    @Override
    public Patient reactTo(List<DrugsEffects> drugs) {
        if (drugs.contains(KILL)) {
            return new Dead();

        } else if (drugs.contains(CURES_FEVER)) {
            return new Healthy();
        }
        return new Fever();
    }
}
