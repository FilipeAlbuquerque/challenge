package tests.drugs;

import app.DrugsEffectsStream;
import domain.DrugsEffects;
import domain.Medicine;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static domain.DrugsEffects.*;
import static domain.Medicine.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class DrugsEffectsTest {

    @Test
    public void insulineMixedWithAntibiotic() {


        List<Medicine> medicines = asList(ANTIBIOTIC, INSULIN);

        List<DrugsEffects> drugs = new DrugsEffectsStream(medicines).get();

        assertContainsDrugsEffects(drugs, HEALTHY_PEOPLE_CATCH_FEVER);
        assertContainsDrugsEffects(drugs, PREVENT_DIABETIC_FROM_DYING);
    }

    @Test
    public void feverWithAspirine() {

        List<Medicine> medicines = Collections.singletonList(ASPIRIN);

        List<DrugsEffects> rules = new DrugsEffectsStream(medicines).get();

        assertContainsDrugsEffects(rules, CURES_FEVER);
    }


    @Test
    public void tuberculosisWithAntibiotic() {

        List<Medicine> medicines = Collections.singletonList(ANTIBIOTIC);

        List<DrugsEffects> drugs = new DrugsEffectsStream(medicines).get();

        assertContainsDrugsEffects(drugs, CURES_TUBERCULOSIS);
    }

    @Test
    public void insulinePreventsFromDying() {

        List<Medicine> medicines = Collections.singletonList(INSULIN);

        List<DrugsEffects> rules = new DrugsEffectsStream(medicines).get();

        assertContainsDrugsEffects(rules, PREVENT_DIABETIC_FROM_DYING);
    }

    @Test
    public void killPatientAspirineWithParacetamol() {

        List<Medicine> medicines = asList(ASPIRIN, PARACETAMOL);

        List<DrugsEffects> rules = new DrugsEffectsStream(medicines).get();

        List<DrugsEffects> result = Collections.singletonList(KILL);
        assertEquals(rules, result);
    }

    private void assertContainsDrugsEffects(List<DrugsEffects> rules, DrugsEffects catchFever) {
        assertTrue(rules.contains(catchFever));
    }
}
