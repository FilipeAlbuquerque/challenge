package patients;

import java.util.List;

import domain.DrugsEfects;
import domain.Patient;
import domain.StateOfPatient;

import static domain.StateOfPatient.DIABETES;

import static domain.DrugsEfects.KILL;
import static domain.DrugsEfects.PREVENT_DIABETIC_FROM_DYING;

public class Diabetes implements Patient {

    @Override
    public StateOfPatient getState() {
        return DIABETES;
    }

    @Override
    public Patient reactTo(List<DrugsEfects> drugs) {
        if (drugs.contains(KILL)) {
            return new Dead();
        } else if (drugs.contains(PREVENT_DIABETIC_FROM_DYING)) {
            return new Diabetes();
        }
        return new Dead();
    }

}
