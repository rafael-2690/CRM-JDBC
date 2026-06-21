import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LectureManager {
    public static void main(String[] args) {


        LectureDAO dao = new LectureDAO();

        List<Lecture> lectures = dao.lista();

        for(Lecture l : lectures){
            System.out.println("---------");
            System.out.println(l.getTitle());
            System.out.println(l.getDate());
            System.out.println(l.getSpeaker());
            System.out.println(l.getId());
        }
    }
}
