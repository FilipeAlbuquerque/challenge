package app;

import domain.Medicine;
import domain.Patient;
import parsers.MedicineParser;
import parsers.PatientParser;
import results.PatientStatistics;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        if (args.length > 0) {
            String patientsInput = args[0];
            List<Patient> patients = new PatientParser().fromInput(patientsInput);
            List<Medicine> medicines = new MedicineParser().fromInput(getMedicinesInput(args));
            List<Patient> patientResults = new PatientsFutureSimulator(patients, medicines).getResults();
            System.out.println(new PatientStatistics(patientResults).getPatients());
        } else {
            System.out.println("Provide parameters");
        }
    }

    private static String getMedicinesInput(String[] args) {
        return (args.length > 1) ? args[1] : "";
    }
}
