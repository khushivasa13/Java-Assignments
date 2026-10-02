import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    abstract int getValidityDays();
}

class Basic extends Plan {
    int getValidityDays() {
        return 30;
    }
}

class Standard extends Plan {
    int getValidityDays() {
        return 90;
    }
}

class Premium extends Plan {
    int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new Basic();
            } else if (type.equals("STANDARD")) {
                plan = new Standard();
            } else {
                plan = new Premium();
            }

            LocalDate startDate = LocalDate.parse(date);

            LocalDate renewalDate =
                    startDate.plusDays(plan.getValidityDays());

            System.out.println(
                    name + ": " + renewalDate
            );
        }

        sc.close();
    }
}