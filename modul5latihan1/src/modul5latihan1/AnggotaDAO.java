package modul5latihan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnggotaDAO {
    private Connection connection;

    public AnggotaDAO() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public List<Anggota> getAllAnggota() {
        List<Anggota> anggotaList = new ArrayList<>();
        String query = "SELECT * FROM anggota";
        
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Anggota anggota = new Anggota(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("telepon")
                );
                anggotaList.add(anggota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return anggotaList;
    }
    
    public void insertAnggota(Anggota anggota) {
        String query = "INSERT INTO anggota (nama, alamat, telepon) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, anggota.getNama());
            stmt.setString(2, anggota.getAlamat());
            stmt.setString(3, anggota.getTelepon());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateAnggota(Anggota anggota) {
        String query = "UPDATE anggota SET nama=?, alamat=?, telepon=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, anggota.getNama());
            stmt.setString(2, anggota.getAlamat());
            stmt.setString(3, anggota.getTelepon());
            stmt.setInt(4, anggota.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteAnggota(int id) {
        String query = "DELETE FROM anggota WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
