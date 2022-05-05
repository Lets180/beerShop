package com.lets.beerShop.dao;

import com.lets.beerShop.models.Beer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeerMapper implements RowMapper<Beer> {

    @Override
    public Beer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Beer beer = new Beer();
        beer.setId(resultSet.getInt("id"));
        beer.setBrand(resultSet.getString("brand"));
        beer.setTypeBeer(resultSet.getString("typebeer"));
        beer.setOriginalGravity(resultSet.getString("originalgravity"));
        beer.setAlcoholVolume(resultSet.getString("alcoholvolume"));
        beer.setBuyPrice(Double.parseDouble(resultSet.getString("buyprice")));
        beer.setCellPrice(Double.parseDouble(resultSet.getString("cellprice")));
        beer.setCurrentAmount(Double.parseDouble(resultSet.getString("currentamount")));
        beer.setSalesVolume(Double.parseDouble(resultSet.getString("salesvolume")));
        beer.setRevenue(Double.parseDouble(resultSet.getString("revenue")));
        return beer;
    }
}
