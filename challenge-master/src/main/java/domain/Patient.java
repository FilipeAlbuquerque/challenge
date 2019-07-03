package domain;

import java.util.List;

import domain.DrugsEfects;
import domain.StateOfPatient;

public interface Patient {

    StateOfPatient getState();

    Patient reactTo(List<DrugsEfects> rule);
}
