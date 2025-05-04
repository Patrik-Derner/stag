package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Specialization;
import pro1.apiDataModel.SpecializationsList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main7 {
    public static String specializationDeadlines(int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

        String json = Api.getSpecializations(year);
//        System.out.println("RAW JSON: " + json); // DEBUG (pro získání struktury Jsonu)

        Gson gson = new Gson();
        SpecializationsList response = gson.fromJson(json, SpecializationsList.class);
        List<Specialization> list = response.prijimaciObor;

//        if (list == null) { // DEBUG
//            System.out.println("Chyba: seznam prijimacky je null");
//            return "";
//        }

        return list.stream()
                .map(s -> s.eprDeadlinePrihlaska.value)
                .filter(d -> d != null && !d.isEmpty())
                .sorted(Comparator.comparing(dateStr -> LocalDate.parse(dateStr, formatter))).distinct()
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        System.out.println(specializationDeadlines(2025));
    }
}

// Program funguje jen nevim proč to hází datum navíc (30.4.2025) který není v Main7Test
// Chvíli jsem z toho byl zmatenej protože nevim jestli to je chyba z mé strany nebo ze strany testera