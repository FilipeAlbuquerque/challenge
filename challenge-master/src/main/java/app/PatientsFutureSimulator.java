package app;

import domain.DrugsEffects;
import domain.Medicine;
import domain.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class PatientsFutureSimulator {

    List<DrugsEffects> drugs;
    private List<Patient> patients;

    public PatientsFutureSimulator(List<Patient> patients, List<Medicine> medicines) {
        this.patients = patients;
        drugs = new DrugsEffectsStream(medicines).get();
    }

    public List<Patient> getResults() {
        return patients.stream()
                .map(patients -> patients.reactTo(drugs))
                .collect(Collectors.toList());
    }
}

