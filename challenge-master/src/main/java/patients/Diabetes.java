package patients;

import java.util.List;

import domain.DrugsEffects;
import domain.Patient;
import domain.StateOfPatient;

import static domain.StateOfPatient.DIABETES;

import static domain.DrugsEffects.KILL;
import static domain.DrugsEffects.PREVENT_DIABETIC_FROM_DYING;

public class Diabetes implements Patient {

    @Override
    public StateOfPatient getState() {
        return DIABETES;
    }

    @Override
    public Patient reactTo(List<DrugsEffects> drugs) {
        if (drugs.contains(KILL)) {
            return new Dead();
        } else if (drugs.contains(PREVENT_DIABETIC_FROM_DYING)) {
            return new Diabetes();
        }
        return new Dead();
    }

}
