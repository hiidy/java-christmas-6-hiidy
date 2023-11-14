package christmas.domain.discount;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SpecialDayCalender {

    private static final Set<Integer> specialDays = new HashSet<>();

    static {
        initializeStarDays();
    }

    private static void initializeStarDays() {
        specialDays.add(3);
        specialDays.add(10);
        specialDays.add(17);
        specialDays.add(24);
        specialDays.add(25);
        specialDays.add(31);
    }

    public static Set<Integer> specialDays() {
        return Collections.unmodifiableSet(specialDays);
    }

    public boolean isStarDay(int dayOfMonth) {
        return specialDays.contains(dayOfMonth);
    }
}
