package domain;

import java.util.List;

public interface Patient {

    StateOfPatient getState();

    Patient reactTo(List<DrugsEffects> rule);
}
