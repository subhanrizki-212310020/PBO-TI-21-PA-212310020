package com.ibik.pbo.praktikum.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibik.pbo.praktikum.model.Mahasiswa;

public class MahasiswaDAO {

    private String query_mysql_insert_data = "INSERT INTO mahasiswa (NPM, Nama, Nilai) VALUES (?, ?, ?)";
    private String query_mysql_select_data = "SELECT * FROM mahasiswa";
    private String query_mysql_delete_data = "DELETE FROM mahasiswa WHERE NPM = ?";
    private String query_mysql_update_data = "UPDATE mahasiswa SET NPM = ?, Nama = ?, Nilai = ?";

    // Method for input data into database
    public void InputDataMahasiswa(Mahasiswa mhs) throws Exception {
        Connection conn = new ConnectionDB().connect();
        PreparedStatement psInputData = conn.prepareStatement(query_mysql_insert_data);

        psInputData.setString(1, mhs.getNpm());
        psInputData.setString(2, mhs.getNamaLengkap());
        psInputData.setString(3, mhs.getNilai());

        psInputData.executeUpdate();
        conn.close();
    }

    // Method for show data from database
    public List<Mahasiswa> SearchAllData() throws Exception {
        List<Mahasiswa> data = new ArrayList<Mahasiswa>();
        Connection conn = new ConnectionDB().connect();

        PreparedStatement psSelect = conn.prepareStatement(query_mysql_select_data);
        ResultSet rs = psSelect.executeQuery();

        while(rs.next()) {
            Mahasiswa mhs = ConvertResultSet(rs);
            data.add(mhs);
        }

        conn.close();
        return data;
    }

    private Mahasiswa ConvertResultSet(ResultSet rs) throws SQLException {
        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.setNpm(rs.getString("NPM"));
        mahasiswa.setNamaLengkap(rs.getString("Nama"));
        mahasiswa.setNilai(rs.getString("Nilai"));

        return mahasiswa;
    }

    // Method for delete data from database
    public void DeleteData(String NPM) throws Exception {
        if(NPM == null) return;

        Connection conn = new ConnectionDB().connect();
        PreparedStatement psDelete = conn.prepareStatement(query_mysql_delete_data);

        psDelete.setString(1, NPM);

        psDelete.executeUpdate();
        conn.close();
    }

    // Method for update data into database
    public void UpdateData(Mahasiswa mhs) throws Exception {
        Connection conn = new ConnectionDB().connect();
        PreparedStatement psUpdate = conn.prepareStatement(query_mysql_update_data);

        psUpdate.setString(1, mhs.getNpm());
        psUpdate.setString(2, mhs.getNamaLengkap());
        psUpdate.setString(3, mhs.getNilai());

        psUpdate.executeUpdate();
        conn.close();
    }

}
