package com.example.Housing.Controller;

import com.example.Housing.Model.HouseDTO;
import com.example.Housing.Model.HouseModel;
import com.example.Housing.Model.ResponseEntity;
import com.example.Housing.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("housing")
public class HouseController {

    @Autowired
    HouseService houseService;

    @PostMapping("save")
    public ResponseEntity<HouseModel> save(@RequestBody HouseModel house) {
        return houseService.saveHouse(house);
    }

    @PostMapping("saveAll")
    public ResponseEntity<List<HouseModel>> saveAll(@RequestBody HouseDTO housesDto) {
        return houseService.saveAllHouse(housesDto);
    }

    @GetMapping("get")
    public ResponseEntity<HouseModel> getHouse(@RequestHeader(name = "id") int id){
        return houseService.getHouse(id);
    }

    @GetMapping("getAll")
    public  ResponseEntity<List<HouseModel>> getAllHouse(){
       return houseService.getAllHouse();
    }

    @GetMapping("avg-price-allover")
    public ResponseEntity<Double> getAvgSalePrice(){
       return houseService.getAvgSalePrice();
    }

    @GetMapping("get-max-price")
    public ResponseEntity<Long> getMaxSalePrice(){
      return houseService.getMaxSalePrice();
    }

    @GetMapping("get-min-price")
    public ResponseEntity<Long> getMinSalePrice(){
       return houseService.getMinSalePrice();
    }

    @GetMapping("get-by-location")
    public ResponseEntity<Double> findAvgByLocation(@RequestHeader(name = "location") String location){
        return houseService.getAvgPriceByGivenLocation(location);
    }

    @GetMapping("getAll-avg-of-all-location")
    public ResponseEntity<Map<String , Double>> getAllAvgOfAllLocation(){
        return houseService.avgSalePriceByAllLocation();
    }

    @GetMapping("getAllPaginated")
    public ResponseEntity<Page<HouseModel>> getAllHousesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return houseService.getAllHousesPaginated(page, size);
    }
}
