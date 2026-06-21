import java.time.LocalDate;

public class LectureManager {
    public static void main(String[] args) {
        Lecture lecture1 = new Lecture();

        lecture1.setSpeaker("Rafael");
        lecture1.setTitle("Palestra sobre Java");
        lecture1.setDate(LocalDate.of(2026, 6, 20));

        System.out.println(lecture1.getTitle());
        System.out.println(lecture1.getSpeaker());
        System.out.println(lecture1.getDate());

    }
}
