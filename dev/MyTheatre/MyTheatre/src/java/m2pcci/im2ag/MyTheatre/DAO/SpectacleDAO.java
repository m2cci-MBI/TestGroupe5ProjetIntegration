package m2pcci.im2ag.MyTheatre.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import m2pcci.im2ag.MyTheatre.Models.Representation;
import m2pcci.im2ag.MyTheatre.Models.Spectacle;

/**
 *
 * @author sedirih
 */
public class SpectacleDAO {

    private static final String QUERY1 = "SELECT numeroSpectacle,nomSpectacle,DateRep FROM lesSpectacles natural join LesRepresentations where nomSpectacle = ?";
    private static String QUERY3 = "SELECT  numeroSpectacle,nomSpectacle ,dateRep, nbPlacesRestantes FROM PlacesRestantes "
            + " natural join LesSpectacles WHERE nbPlacesRestantes >70 and dateRep > ? and dateRep < ? ORDER BY dateRep";

    /**
     * donne un spectacle sans le détail de ses representations
     *
     * @param ds
     * @param nomSpectacle
     * @return
     * @throws SQLException
     */
    public static List<Spectacle> infosSpectacle(DataSource ds, String nomSpectacle) throws SQLException {
       try (Connection conn = ds.getConnection();
       PreparedStatement pstmt = conn.prepareStatement(QUERY1)) {
        pstmt.setString(1, nomSpectacle);
        ResultSet rs = pstmt.executeQuery();
         List<Spectacle> spectacles = new ArrayList();
               while (rs.next()) {
                    String nomS = rs.getString("nomSpectacle");
                    int numS = rs.getInt("numeroSpectacle");
                    Spectacle sp = new Spectacle(numS, nomS);
                    sp.addRepresentation(new Representation(rs.getString("dateRep"), rs.getInt("numeroSpectacle")));
                    spectacles.add(sp);
                }

        return spectacles;

    }
    }
    /**
     * Donne une de liste de tous les spectacles pour lesquels il y a une representation entre deux dates données.
     *
     * @param ds
     * @param dateDebut
     * @param dateFin
     * @return une liste de spectacles, avec pour chaque spectacle une representation (avec la date et l'heure). Si il existe
     *         pour un spectacle plusieurs représentations entre dateDebut et dateFin, le spectacle apparaît plusieurs fois dans la
     *         liste. La liste est triée selon l'ordre chronologique des representations.
     * @throws SQLException
     */

    public static List<Spectacle> getRepEntreDeuxDates(DataSource ds, String dateDebut, String dateFin) throws SQLException {
        try (Connection conn = ds.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(QUERY3)) {
            // List<Spectacle> res = new ArrayList();
            pstmt.setString(1, dateDebut + " 00:00:00");
            pstmt.setString(2, dateFin + " 24:00:00");

            try (ResultSet rs = pstmt.executeQuery()) {
                List<Spectacle> spectacles = new ArrayList();
                while (rs.next()) {
                    String nomS = rs.getString("nomSpectacle");
                    int numS = rs.getInt("numeroSpectacle");
                    Spectacle sp = new Spectacle(numS, nomS);
                    sp.addRepresentation(new Representation(rs.getString("dateRep"), rs.getInt("numeroSpectacle"), rs.getInt("nbPlacesRestantes")));
                    spectacles.add(sp);
                }

                return spectacles;
            }

        }
    }
    

}
