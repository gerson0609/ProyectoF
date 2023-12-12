package com.example.proyecto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Nota> getAllNotas() {
        try {
            // Replace 'app_log' with your actual table name and adjust the query as needed
            String query = "SELECT * FROM to_do_app.Notas";
            List<Map<String, Object>> resultNotas = jdbcTemplate.queryForList(query);
            List<Nota> notas = new ArrayList<>();

            for (Map<String, Object> row : resultNotas) {
                int id = (int) row.get("id");
                String nombre = (String) row.get("nombre");
                String titulo = (String) row.get("titulo");
                String descripcion = (String) row.get("descripcion");
                String prioridad = (String) row.get("prioridad");

                Nota nota = new Nota(id, nombre, descripcion, id, titulo, prioridad);
                notas.add(nota);
            }
            return notas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Usuario authenticateUser(String username, String password) {
        System.out.println("logId = " + username);
        try {
            String query = "SELECT * FROM to_do_app.Users WHERE Username = ? and Password =?";

            return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                int userID = (int)rs.getInt("UserID");
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");
                String email = rs.getString("Email");
              //   public User( String username,String email, String password) {
        
                return new Usuario(userID, Username ,email, Password);
            }, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Nota> getAllNot() {
        return null;
    }
    /**
     * @param id
     * @return
     */

    public Nota getNota(int id) {
        System.out.println("logId = " + id);
        try {
            String query = "SELECT * FROM to_do_app.Notas WHERE id = ?";
        System.out.println("query = " + query);
            return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                int Uid = (int)rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String titulo = rs.getString("titulo");
                int prioridad = (int)rs.getInt("prioridad");
                System.out.println(rs);
                
                return new Nota(id, nombre, descripcion, titulo, prioridad);
            },id);
        } catch (Exception e) {
            e.printStackTrace();
                    System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateNota(Nota nota) {
        try {
            String query = "UPDATE to_do_app.Productos SET nombre = ?, descripcion = ? WHERE id = ?";
            jdbcTemplate.update(query, nota.getNombre(),nota.getDescripcion() , nota.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertNota(Nota nota) {
        try {
            String query = "INSERT to_do_app.Notas SET nombre = ?, descripcion = ? ";
            jdbcTemplate.update(query, nota.getNombre(),nota.getDescripcion());
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions if needed
        }
    }

    public int deleteNota(int id) {
        try {
            String query = "DELETE FROM to_do_app.Notas WHERE id = ?";
            jdbcTemplate.update(query, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
