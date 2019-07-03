package patients;

import java.util.List;

import domain.DrugsEfects;
import domain.Patient;
import domain.StateOfPatient;
import static domain.StateOfPatient.DEAD;

public class Dead implements Patient {

    @Override
    public StateOfPatient getState() {
        return DEAD;
    }

    @Override
    public Patient reactTo(List<DrugsEfects> drugs) {
        if (drugs.contains(DrugsEfects.RESURRECT)){
            return new Healthy();
        }

        return new Dead();
    }

}
