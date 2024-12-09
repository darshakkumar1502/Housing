package com.example.Housing.Repository;

import com.example.Housing.Model.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.List;

public interface HouseRepository extends JpaRepository <HouseModel, Integer> {
    @Query("select AVG(h.salePrice) from HouseModel h")
    Double getAvgSalePrice();

    @Query("select h.location, AVG(h.salePrice) from HouseModel h group by h.location")
    List<Object[]> findAverageSalePriceByLocation();

    @Query("SELECT AVG(h.salePrice) FROM HouseModel h WHERE h.location=?1")
    double findAveragePriceByGivenLocation(String location);

    @Query("select MAX(h.salePrice) from HouseModel h")
    Long getMaxSalePrice();

    @Query("select MIN(h.salePrice) from HouseModel h")
    Long getMinSalePrice();
}
