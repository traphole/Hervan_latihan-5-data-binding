/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5latihan1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KotaDAO {
    public List<Kota> getAllKota() {
        // List untuk menyimpan data kota
        List<Kota> kotaList = new ArrayList<>();
        String query = "SELECT * FROM kota";

        try (
            // Membuat koneksi ke database
            Connection koneksi = DBConnection.getConnection();
            // Membuat statement
            Statement stmt = koneksi.createStatement();
            // Query untuk mengambil data user
            ResultSet rs = stmt.executeQuery(query)) {

            // Menambahkan data ke ArrayList
            while (rs.next()) {
                int id = rs.getInt("id");
                String namaKota = rs.getString("nama");

                kotaList.add(new Kota(id, namaKota));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return kotaList;
    }
}