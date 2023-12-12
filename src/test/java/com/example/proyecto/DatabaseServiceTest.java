package com.example.proyecto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

class DatabaseServiceTest {
    private DatabaseService databaseService;
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        databaseService = new DatabaseService(jdbcTemplate);
    }
    @Test
    void testGetAllNota() {
        
        List<Map<String, Object>> mockResult = new ArrayList<>();
        mockResult.add(Map.of("id", 1, "nombre", "Nota 1", "descripcion", "Description 1"));
        mockResult.add(Map.of("id", 2, "nombre", "Nota 2", "descripcion", "Description 2"));

        
        when(jdbcTemplate.queryForList("SELECT * FROM to_do_app.Productos")).thenReturn(mockResult);

        
        List<Nota> actualNotas = databaseService.getAllNotas();

        
        List<Nota> expectedNota = new ArrayList<>();
        expectedNota.add(new Nota(0, null, null, 0, null, null));
        expectedNota.add(new Nota(0, null, null, null, 0));
        
        assertEquals(expectedNota, actualNotas);
    }
    @Test
    void testGetNota() {
    
    when(jdbcTemplate.queryForObject(
            eq("SELECT * FROM to_do_app.Nota WHERE id = ?"),
            any(RowMapper.class),
            eq(1)
    )).thenReturn(new Nota(0, null, null, 0, null, null));

    
    Nota actualNota = databaseService.getNota(1);

    
    Nota expectedNota = new Nota(0, null, null, null, 0);

    
    assertEquals(expectedNota, actualNota);;
    }
   
    @Test
    void testInsertNota() {
        
        when(jdbcTemplate.update(
                "INSERT to_do_app.Notas SET nombre = ?, descripcion = ?",
                "Nota Test", "Description Test")).thenReturn(1);

        
        Nota notaToInsert = new Nota(0, null, null, 0, null, null);
        databaseService.insertNota(notaToInsert);

        
        verify(jdbcTemplate).update(
            "INSERT to_do_app.Notas SET nombre = ?, descripcion = ? ",
            "Nota Test",
            "Description Test"
        );
    
    }
    
}
