package modul5latihan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganisasiDAO {
    private Connection connection;

    public OrganisasiDAO() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public List<Organisasi> getAllOrganisasi() {
        List<Organisasi> organisasiList = new ArrayList<>();
        String query = "SELECT * FROM organisasi";
        
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Organisasi organisasi = new Organisasi(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("alamat")
                );
                organisasiList.add(organisasi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return organisasiList;
    }
    
    public void insertOrganisasi(Organisasi organisasi) {
        String query = "INSERT INTO organisasi (nama, alamat) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, organisasi.getNama());
            stmt.setString(2, organisasi.getAlamat());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateOrganisasi(Organisasi organisasi) {
        String query = "UPDATE organisasi SET nama=?, alamat=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, organisasi.getNama());
            stmt.setString(2, organisasi.getAlamat());
            stmt.setInt(3, organisasi.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteOrganisasi(int id) {
        String query = "DELETE FROM organisasi WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
