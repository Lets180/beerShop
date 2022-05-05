package com.lets.beerShop.dao;

import com.lets.beerShop.models.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;


@Repository
@Transactional
public class BeersDAO {

  //  @PersistenceContext
 //   private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BeersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
public EntityManager entityManager = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public Beer addEM(Beer beer){
        entityManager.getTransaction().begin();
        Beer beerFromDB = entityManager.merge(beer);
        entityManager.getTransaction().commit();
        return beerFromDB;
    }

    public void deleteEM(int id){
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    public Beer showEM(int id){
        return entityManager.find(Beer.class,id);
    }

    public void updatedEM(Beer beer){
        entityManager.getTransaction().begin();
        entityManager.merge(beer);
        entityManager.getTransaction().commit();
    }

    public List<Beer> indexEM(){
        TypedQuery<Beer> namedQuery = entityManager.createNamedQuery("Beer.getAll",Beer.class);
        return namedQuery.getResultList();
    }

    //private static int BEER_COUNT;
  /*  private static final String URI = "jdbc:postgresql://localhost:5432/beershop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "180180141";
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URI,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
  /*  private List<Beer> beers;
    {
        beers = new ArrayList<>();
        beers.add(new Beer(++BEER_COUNT,"Bavaria Light","Lager",
                "12%","4,2%",50,100,
                50,0,0));
        beers.add(new Beer(++BEER_COUNT,"Bavaria Dark","Brown Ale",
                "14%","4,8%",60,110,
                50,0,0));
        beers.add(new Beer(++BEER_COUNT,"Bavaria Wheat","Wheat Ale",
                "13%","4,5%",55,100,
                30,0,0));
        beers.add(new Beer(++BEER_COUNT,"Weiss Kanzler","Wheat Ale",
                "13,5%","4,8%",60,140,
                30,0,0));
    }*/
    public List<Beer> indexHibernate(){
        return entityManager.createQuery("from beer b order by b.id desc", Beer.class).getResultList();
    }
    public List<Beer> index(){
        /*List<Beer> beers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM beer";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Beer beer = new Beer();
                beer.setId(resultSet.getInt("id"));
                beer.setBrand(resultSet.getString("brand"));
                beer.setTypeBeer(resultSet.getString("typebeer"));
                beer.setOriginalGravity(resultSet.getString("originalgravity"));
                beer.setAlcoholVolume(resultSet.getString("alcoholvolume"));
                beer.setBuyPrice(Double.parseDouble(resultSet.getString("buyprice")));
                beer.setCellPrice(Double.parseDouble(resultSet.getString("cellprice")));
                beer.setSalesVolume(Double.parseDouble(resultSet.getString("salesvolume")));
                beer.setRevenue(Double.parseDouble(resultSet.getString("revenue")));
                beers.add(beer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

          return beers;*/
        return jdbcTemplate.query("SELECT * FROM beer",new BeerMapper());
    }
   public Beer show(int id){
    //  return beers.stream().filter(beer -> beer.getId()==id).findAny().orElse(null);
       //List<Beer> beers = new ArrayList<>();
   /*    Beer beer = new Beer();
       try {
           //   Statement statement = connection.createStatement();
           //    String query = "INSERT INTO beer VALUES("+ BEER_COUNT + ",'"+ beer.getBrand() + "','"+beer.getTypeBeer() + "','"+beer.getOriginalGravity()+"','"+
           //          beer.getAlcoholVolume()+ "','"+beer.getBuyPrice()+ "','"+beer.getCellPrice() +"','"+beer.getSalesVolume() +"','"+beer.getRevenue()+"')";
           //    statement.executeUpdate(query);
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM beer WHERE id=?");
           preparedStatement.setInt(1,id);
           ResultSet resultSet = preparedStatement.executeQuery();
           //while (resultSet.next()) {
           if (resultSet.next()) {
               beer.setId(resultSet.getInt("id"));
               beer.setBrand(resultSet.getString("brand"));
               beer.setTypeBeer(resultSet.getString("typebeer"));
               beer.setOriginalGravity(resultSet.getString("originalgravity"));
               beer.setAlcoholVolume(resultSet.getString("alcoholvolume"));
               beer.setBuyPrice(Double.parseDouble(resultSet.getString("buyprice")));
               beer.setCellPrice(Double.parseDouble(resultSet.getString("cellprice")));
               beer.setSalesVolume(Double.parseDouble(resultSet.getString("salesvolume")));
               beer.setRevenue(Double.parseDouble(resultSet.getString("revenue")));
               //beers.add(beer);
           }
           //}

       } catch (SQLException e) {
           e.printStackTrace();
       }
       return beer;*/
       //return jdbcTemplate.query("SELECT * FROM beer WHERE id=?",new Object[]{id},new BeerMapper()).stream().findAny().orElse(null);
       return jdbcTemplate.query("SELECT * FROM beer WHERE id=?",new Object[]{id},
               new BeanPropertyRowMapper<>(Beer.class)).stream().findAny().orElse(null);
    }
    public void save(Beer beer){
       /* beer.setId(++BEER_COUNT);
        beer.setCurrentAmount(0);
        beer.setSalesVolume(0);
        beer.setRevenue(0);
        beers.add(beer);*/
        //try {
        //   Statement statement = connection.createStatement();
        //    String query = "INSERT INTO beer VALUES("+ BEER_COUNT + ",'"+ beer.getBrand() + "','"+beer.getTypeBeer() + "','"+beer.getOriginalGravity()+"','"+
        //          beer.getAlcoholVolume()+ "','"+beer.getBuyPrice()+ "','"+beer.getCellPrice() +"','"+beer.getSalesVolume() +"','"+beer.getRevenue()+"')";
        //    statement.executeUpdate(query);
   /*         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO beer VALUES(1,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,beer.getBrand());
            preparedStatement.setString(2,beer.getTypeBeer());
            preparedStatement.setString(3,beer.getOriginalGravity());
            preparedStatement.setString(4,beer.getAlcoholVolume());
            preparedStatement.setString(5,Double.toString(beer.getBuyPrice()));
            preparedStatement.setString(6,Double.toString(beer.getCellPrice()));
            preparedStatement.setString(7,Double.toString(0));
            preparedStatement.setString(8,Double.toString(0));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
            jdbcTemplate.update("INSERT INTO beer (brand,typebeer,originalgravity,alcoholvolume,buyprice,cellprice,currentamount,salesvolume,revenue) VALUES(?,?,?,?,?,?,?,?,?)",
                    beer.getBrand(),beer.getTypeBeer(),beer.getOriginalGravity(),beer.getAlcoholVolume(),
                    beer.getBuyPrice(),beer.getCellPrice(),0,0,0);

    }
    public void update(Beer updatedBeer,int id){
    /*    Beer beerToUpdate = show(id);
        beerToUpdate.setBrand(updatedBeer.getBrand());
        beerToUpdate.setTypeBeer(updatedBeer.getTypeBeer());
        beerToUpdate.setOriginalGravity(updatedBeer.getOriginalGravity());
        beerToUpdate.setAlcoholVolume(updatedBeer.getAlcoholVolume());
        beerToUpdate.setBuyPrice(updatedBeer.getBuyPrice());
        beerToUpdate.setCellPrice(updatedBeer.getCellPrice());*/
       // try {
            //   Statement statement = connection.createStatement();
            //    String query = "INSERT INTO beer VALUES("+ BEER_COUNT + ",'"+ beer.getBrand() + "','"+beer.getTypeBeer() + "','"+beer.getOriginalGravity()+"','"+
            //          beer.getAlcoholVolume()+ "','"+beer.getBuyPrice()+ "','"+beer.getCellPrice() +"','"+beer.getSalesVolume() +"','"+beer.getRevenue()+"')";
            //    statement.executeUpdate(query);
        /*    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE beer SET brand=?, typeBeer=?, originalGravity=?" +
                    ", alcoholVolume=?, buyPrice=?, cellPrice=?  WHERE id = ?");
            preparedStatement.setString(1,updatedBeer.getBrand());
            preparedStatement.setString(2,updatedBeer.getTypeBeer());
            preparedStatement.setString(3,updatedBeer.getOriginalGravity());
            preparedStatement.setString(4,updatedBeer.getAlcoholVolume());
            preparedStatement.setString(5,Double.toString(updatedBeer.getBuyPrice()));
            preparedStatement.setString(6,Double.toString(updatedBeer.getCellPrice()));
            preparedStatement.setInt(7,updatedBeer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
            jdbcTemplate.update("UPDATE beer SET brand=?, typeBeer=?, originalGravity=?, alcoholVolume=?, buyPrice=?," +
                            " cellPrice=?  WHERE id = ?",
                    updatedBeer.getBrand(),updatedBeer.getTypeBeer(),updatedBeer.getOriginalGravity(),
                    updatedBeer.getAlcoholVolume(),updatedBeer.getBuyPrice(),updatedBeer.getCellPrice(),
                    id);

    }
    public void delete(int id){
        //beers.removeIf(p -> p.getId()==id);
  /*      try {
            //   Statement statement = connection.createStatement();
            //    String query = "INSERT INTO beer VALUES("+ BEER_COUNT + ",'"+ beer.getBrand() + "','"+beer.getTypeBeer() + "','"+beer.getOriginalGravity()+"','"+
            //          beer.getAlcoholVolume()+ "','"+beer.getBuyPrice()+ "','"+beer.getCellPrice() +"','"+beer.getSalesVolume() +"','"+beer.getRevenue()+"')";
            //    statement.executeUpdate(query);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM beer WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        jdbcTemplate.update("DELETE FROM beer WHERE id = ?",id);
    }
}
