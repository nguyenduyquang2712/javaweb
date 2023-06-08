package com.example.demo.repository.watch;

import com.example.demo.model.product.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Repository
@Transactional
public interface IWatchRepository extends JpaRepository<Watch, Integer> {
    @Query(value = "select * from watch where delete_status=0", nativeQuery = true)
    List<Watch> getAllWatch();

    @Modifying
    @Query(value = "INSERT INTO `watch` ( `name`,   `date_of_manufacture`, `description`, `price`,`status`,`img_url` , `category_id`, `brand_id`) VALUES ( :name,  :date_of_manufacture, :description, :price,:status ,:img_url, :category_id, :brand_id)", nativeQuery = true)
    void createWatch(@Param("name") String name,
                     @Param("date_of_manufacture") String date_of_manufacture,
                     @Param("description") String description,
                     @Param("price") Double price,
                     @Param("status") String status,
                     @Param("img_url") String img_url,
                     @Param("category_id") Integer category_id,
                     @Param("brand_id") Integer brand_id);

    @Modifying
    @Query(value="update `watch` set `name`=:name, date_of_manufacture=:date_of_manufacture, description=:description, price=:price,status=:status, img_url=:img_url,category_id=:category_id,brand_id=:brand_id where id=:id", nativeQuery=true)
    void updateWatch(@Param("id") Integer id,
                     @Param("name") String name,
                     @Param("date_of_manufacture") String date_of_manufacture,
                     @Param("description") String description,
                     @Param("price") Double price,
                     @Param("status") String status,
                     @Param("img_url") String img_url,
                     @Param("category_id") Integer category_id,
                     @Param("brand_id") Integer brand_id);

    @Modifying
    @Query(value = "update watch set delete_status=1 where id = :id",nativeQuery=true)
    void deleteWatchById(@Param("id") Integer id);

    @Query(value="select * from watch where `name` like %:searchName% and delete_status=0",nativeQuery=true)
    List<Watch> getSearchWatches(@Param("searchName") String searchName);


    @Query(value="select * from watch where brand_id = :brandId and delete_status=0",nativeQuery=true)
    List<Watch> getSearchWatchesByBrand(@Param("brandId") Integer brandId);
}