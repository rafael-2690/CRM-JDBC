import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LectureDAO {
    private Connection conection;

    public LectureDAO(){
        ConnectionFactory.connectionCreate();
        this.conection = ConnectionFactory.getConnection();
    }
    
    public void save(Lecture lecture){
        String sql= "INSERT INTO palestra(title, speaker, data) VALUES (?,?,?)";

        Connection conn;
        try(PreparedStatement stmt = conection.prepareStatement(sql)){
            stmt.setString(1, lecture.getTitle());
            stmt.setString(2, lecture.getSpeaker());
            stmt.setObject(3, lecture.getDate());

            stmt.executeUpdate();

            System.out.println("Lecture has been saved successfully");
        }
        catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Lecture> lista(){
        String sql= "SELECT id, title, speaker, data FROM palestra";
        List<Lecture> lectures = new ArrayList<>();

        try(PreparedStatement stmt = conection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Lecture l = new Lecture();

                    l.setId(rs.getInt("id"));
                    l.setTitle(rs.getString("title"));
                    l.setSpeaker(rs.getString("speaker"));
                    l.setDate(rs.getObject("data", java.time.LocalDate.class));

                    lectures.add(l);
                }
            }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return lectures;
    }
}
