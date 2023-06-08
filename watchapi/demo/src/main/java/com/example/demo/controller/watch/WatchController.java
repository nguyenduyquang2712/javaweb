package com.example.demo.controller.watch;

import com.example.demo.Dto.WatchDto;
import com.example.demo.model.order.OrderTable;
import com.example.demo.model.product.Brand;
import com.example.demo.model.product.Category;
import com.example.demo.model.product.Watch;
import com.example.demo.service.order.IOrderService;
import com.example.demo.service.watch.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class WatchController {
    @Autowired
    private IWatchService watchService;
    @Autowired
    private IOrderService orderService;
    @GetMapping("/watches")
    public ResponseEntity<List<Watch>> getAllWatches() {
        List<Watch> watchList = watchService.getAllWatch();
        if (watchList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Watch>>(watchList, HttpStatus.OK);
    }

    @GetMapping("/searchWatch")
    public ResponseEntity<List<Watch>> getSearchWatches(@RequestParam("searchName") String searchName){

        List<Watch> watchList = new ArrayList<Watch>();
        watchList = watchService.getSearchWatches(searchName);
        if(watchList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Watch>>(watchList, HttpStatus.OK);

    }

    @GetMapping("/searchBrand/{id}")
    public ResponseEntity<List<Watch>> getSearchWatchesByBrand(@PathVariable("id") Integer brandId){

        List<Watch> watchList = new ArrayList<Watch>();
        watchList = watchService.getSearchWatchesByBrand(brandId);
        if(watchList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Watch>>(watchList, HttpStatus.OK);

    }

    @GetMapping("/watches/{id}")
    public ResponseEntity<Watch> getWatchById(@PathVariable Integer id) {
        Optional<Watch> editWatch = watchService.getWatchById(id);
        if (!editWatch.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(editWatch.get(), HttpStatus.OK);

    }


    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> getAllBrand() {
        List<Brand> brandList = watchService.getAllBrand();
        if (brandList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(brandList, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categoryList = watchService.getAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/createWatch")
    public ResponseEntity<?> createWatch(@RequestBody WatchDto watch) {
        watchService.createWatch(watch);
        return new ResponseEntity<>(watch, HttpStatus.OK);
    }

    @PutMapping("/editWatch")
    public ResponseEntity<?> editWatch(@RequestBody WatchDto watchDto){
        if(watchService.getWatchById(watchDto.getId()) == null){
return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        watchService.updateWatch(watchDto);
        return new ResponseEntity<>(watchDto, HttpStatus.OK);
    }


    @DeleteMapping("/deleteWatch/{id}")
    public ResponseEntity<?> deleteWatch( @PathVariable Integer id){
        watchService.deleteWatchById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/addWatch/{id}")
    public ResponseEntity<?> addWatch( @PathVariable Integer id){
        if(orderService.getOrder(id) == null){
            orderService.addNewWatch(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        orderService.addAmount(id,orderService.getOrder(id).getAmount()+1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<?> getOrder(){
        List<OrderTable> orders = new ArrayList<OrderTable>();
        orders = orderService.getAll();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
    @GetMapping("/updateOrder/{id}/{amount}")
    public ResponseEntity<?> updateOrder(@PathVariable("id") Integer id, @PathVariable("amount") Integer amount){
        orderService.updateOrder(id, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("deleteOrderCart/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Integer id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("deleteAllOrder")
    public ResponseEntity<?> deleteAllOrder(){
        orderService.deleteAllOrder();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
