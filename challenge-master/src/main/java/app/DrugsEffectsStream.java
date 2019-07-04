package app;

import domain.Medicine;
import domain.DrugsEffects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static domain.DrugsEffects.*;

public class DrugsEffectsStream {

    private static final int CHANCES = 9999999;

    private final List<Medicine> medicines;

    private List<DrugsEffects> drugs = new ArrayList<>();

    public DrugsEffectsStream(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public List<DrugsEffects> get() {
        if (containsAspirinAndParacetamol()) {
            return Collections.singletonList(KILL);
        }
        if (containsInsulinAndAntibiotic()) {
            drugs.add(HEALTHY_PEOPLE_CATCH_FEVER);
        }
        if (containsAspirinOrParacetamol()) {
            drugs.add(CURES_FEVER);
        }
        if (containsInsulin()) {
            drugs.add(PREVENT_DIABETIC_FROM_DYING);
        }
        if (containsAntibiotic()) {
            drugs.add(CURES_TUBERCULOSIS);
        }
        if (oneInChances()) {
            drugs.add(RESURRECT);
        }
        return drugs;
    }

    private boolean containsAspirinAndParacetamol() {
        return medicines.contains(Medicine.ASPIRIN) && medicines.contains(Medicine.PARACETAMOL);
    }

    private boolean containsInsulinAndAntibiotic() {
        return containsAntibiotic() && containsInsulin();
    }

    private boolean containsAspirinOrParacetamol() {
        return medicines.contains(Medicine.ASPIRIN) || medicines.contains(Medicine.PARACETAMOL);
    }

    private boolean containsInsulin() {
        return medicines.contains(Medicine.INSULIN);
    }

    private boolean containsAntibiotic() {
        return medicines.contains(Medicine.ANTIBIOTIC);
    }

    private boolean oneInChances() {
        return new Random().nextInt(CHANCES) == 1;
    }
}