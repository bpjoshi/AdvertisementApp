package com.bpjoshi.advertismentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bpjoshi.advertismentapp.model.Advert;
/**
 * @author bpjoshi(Bhagwati Prasad)
 */
@Repository
public class AdvertRepository {
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean createAdvert(Advert advert) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				advert);
		return jdbcTemplate
				.update("insert into adverts (name, text, email) values (:name, :text, :email)",
						params) == 1;
	}

	@Transactional
	public int[] createAdverts(List<Advert> adverts) {

		SqlParameterSource[] params = SqlParameterSourceUtils
				.createBatch(adverts.toArray());

		return jdbcTemplate
				.batchUpdate(
						"insert into adverts (id, name, text, email) values (:id, :name, :text, :email)",
						params);
	}

	public List<Advert> getAdverts() {

		return jdbcTemplate.query("select * from adverts",
				new RowMapper<Advert>() {

					public Advert mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Advert advert = new Advert();
						advert.setId(rs.getInt("id"));
						advert.setName(rs.getString("name"));
						advert.setText(rs.getString("text"));
						advert.setEmail(rs.getString("email"));
						return advert;
					}

				});
	}

	public boolean update(Advert advert) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				advert);

		return jdbcTemplate
				.update("update adverts set name=:name, text=:text, email=:email where id=:id",
						params) == 1;
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbcTemplate.update("delete from adverts where id=:id", params) == 1;
	}

	public Advert getAdvert(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbcTemplate.queryForObject(
				"select * from adverts where id=:id", params,
				new RowMapper<Advert>() {

					public Advert mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Advert advert = new Advert();

						advert.setId(rs.getInt("id"));
						advert.setName(rs.getString("name"));
						advert.setText(rs.getString("text"));
						advert.setEmail(rs.getString("email"));

						return advert;
					}

				});
	}

}
