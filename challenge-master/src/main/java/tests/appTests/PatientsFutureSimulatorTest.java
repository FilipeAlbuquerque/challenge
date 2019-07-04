package tests.appTests;

import app.PatientsFutureSimulator;
import domain.Medicine;
import domain.Patient;
import org.junit.Test;
import patients.Diabetes;
import patients.Fever;
import patients.Healthy;
import patients.Tuberculosis;

import java.util.Collections;
import java.util.List;

import static domain.Medicine.*;
import static domain.StateOfPatient.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class PatientsFutureSimulatorTest {


    @Test
    public void DiabetesPatientWithoutMedicines() {

        List<Patient> patients = asList(new Diabetes(), new Diabetes());
        List<Medicine> medicines = Collections.emptyList();

        List<Patient> result = new PatientsFutureSimulator(patients, medicines).getResults();

        assertEquals(result.get(0).getState(), DEAD);
        assertEquals(result.get(1).getState(), DEAD);
    }

    @Test
    public void feversPatientWithParacetamol() {

        List<Patient> patients = Collections.singletonList(new Fever());
        List<Medicine> medicines = Collections.singletonList(PARACETAMOL);

        List<Patient> result = new PatientsFutureSimulator(patients, medicines).getResults();

        assertEquals(result.get(0).getState(), HEALTHY);
    }


    @Test
     public void testInsulinAntibiotic() {
        
        List<Patient> patients = asList(new Tuberculosis(), new Diabetes(),
                new Healthy(), new Fever(), new Fever());
        List<Medicine> medicines = asList(INSULIN, ANTIBIOTIC);

        List<Patient> patientsResult = new PatientsFutureSimulator(patients, medicines).getResults();

        assertEquals(patientsResult.get(0).getState(), HEALTHY);
        assertEquals(patientsResult.get(1).getState(), DIABETES);
        assertEquals(patientsResult.get(2).getState(), FEVER);
        assertEquals(patientsResult.get(3).getState(), FEVER);
        assertEquals(patientsResult.get(4).getState(), FEVER);
        
      }
}
