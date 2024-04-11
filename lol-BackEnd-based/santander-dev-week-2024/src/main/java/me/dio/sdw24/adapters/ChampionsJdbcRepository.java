package me.dio.sdw24.adapters;

import me.dio.sdw24.Champions;
import me.dio.sdw24.domain.model.ports.ChampionsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
// utiliza jdbc para realizar consultar ao banco de dados de uma forma simples
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// adaptador de saida;
@Repository
public class ChampionsJdbcRepository implements ChampionsRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Champions> rowMapper;
    // implementação do repositorio e da camada rest, unica camada que conhece o spring para adaptação de dados
    //RowMaper adapata as informações do banco de dados para o nosso modelo

    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> mapRow(rs);
    }
    private Champions mapRow(ResultSet rs) throws SQLException {
        return new Champions(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }
    // jdbc para realizar as consultas simples

    // busca uma lista de todos os campeoes na tabela de banco de dados, passando o rowMapper ele vai entender que deve ser feito a adaptação de dados
    @Override
    public List<Champions> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHAMPIONS", rowMapper);
    }

    // busca 1 campeao por id, executa pela carry e retorna o campeao na lista, e pega o primeiro elemento da lista ou elemento vazio caso não exista nd
    @Override
    public Optional<Champions> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?";
        List<Champions> champions =jdbcTemplate.query(sql, rowMapper, id);
        return champions.stream().findFirst();
    }
}
