package com.example.Housing.Service;

import com.example.Housing.Model.HouseDTO;
import com.example.Housing.Model.HouseModel;
import com.example.Housing.Model.ResponseEntity;
import com.example.Housing.Repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HouseService {
    @Autowired
    HouseRepository houseRepository;

    public ResponseEntity<HouseModel> saveHouse(HouseModel house) {
     try {
       return new ResponseEntity<>(houseRepository.save(house), HttpStatus.OK, "save successfully");
     } catch (Exception e) {
         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "failed to save");
     }
    }

    public ResponseEntity<List<HouseModel>> saveAllHouse(HouseDTO list) {
        try {
            return new ResponseEntity<>(houseRepository.saveAll(list.getList()),HttpStatus.OK,"save all successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR,"failed to save");
        }
    }

    public ResponseEntity<HouseModel> getHouse(int id) {
        try {
            return new ResponseEntity<>(houseRepository.findById(id).get(), HttpStatus.OK,"get successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    public ResponseEntity<List<HouseModel>> getAllHouse() {
        try {
            return new ResponseEntity<>(houseRepository.findAll(),HttpStatus.OK,"get successfully");
        } catch (Exception e) {
           return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    public ResponseEntity<Double> getAvgSalePrice(){
        try {
            return new ResponseEntity<>(houseRepository.getAvgSalePrice(),HttpStatus.OK,"get successfully");
        } catch (Exception e) {
           return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR,"request failed");
        }
    }

    public ResponseEntity<Long> getMaxSalePrice(){
        try{
           return new ResponseEntity<>(houseRepository.getMaxSalePrice(), HttpStatus.OK, "get successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "request failed");
        }
    }

    public ResponseEntity<Long> getMinSalePrice(){
        try{
            return new ResponseEntity<>(houseRepository.getMinSalePrice(), HttpStatus.OK, "get successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseEntity<Double> getAvgPriceByGivenLocation(String location) {
        try {
           return new ResponseEntity<>(houseRepository.findAveragePriceByGivenLocation(location), HttpStatus.OK, "get successfully");
        } catch (Exception e) {
          return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseEntity<Map<String, Double>> avgSalePriceByAllLocation(){
        List<Object[]> result = houseRepository.findAverageSalePriceByLocation();
        Map<String, Double> map = new HashMap<>();
        try {
            for (Object[] row : result) {
                map.put(String.valueOf(row[0]), (Double) row[1]);
            }
            return new ResponseEntity<>(map, HttpStatus.OK, "get successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseEntity<Page<HouseModel>> getAllHousesPaginated(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<HouseModel> housesPage = houseRepository.findAll(pageable);
            return new ResponseEntity<>(housesPage, HttpStatus.OK, "get successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
