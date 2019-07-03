package parsers;

import java.util.List;
import java.util.stream.Collectors;

import domain.Patient;
import domain.StateOfPatient;
import patients.PatientFactory;
import static java.util.Arrays.stream;

public class PatientParser {

    public PatientParser() {

    }

    public List<Patient> fromInput(String patientStates) {

        return getStateOfPatient(patientStates)
                .stream()
                .map(patientState -> PatientFactory.createPatient(patientState))
                .collect(Collectors.toList());
    }

    private List<StateOfPatient> getStateOfPatient(String patientStates) {

        String[] split = patientStates.split(",");

        return stream(split)
                .map(StateOfPatient::getStateFrom)
                .collect(Collectors.toList());
    }

}