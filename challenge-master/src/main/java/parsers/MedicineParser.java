package parsers;

import domain.Medicine;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class MedicineParser {

    public List<Medicine> fromInput(String medicineInput) {
        if (medicineInput.equals("")) {
            return Collections.emptyList();
        }
        String[] split = medicineInput.split(",");
        return stream(split)
                .map(Medicine::getMedicineWith)
                .collect(Collectors.toList());
    }
}
