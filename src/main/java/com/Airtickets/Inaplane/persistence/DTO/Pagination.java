package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pagination <dto extends BaseDTO>{

    private int currentPage;
    private int pageSize;
    private int totalPageSize;
    private long itemsSize;
    private List<dto> items;

    public Pagination() {
        this.currentPage = 0;
        this.pageSize = 5;
        this.totalPageSize = 10;
        this.itemsSize = 2;
        this.items = new ArrayList<>();

    }

    public List<dto> currentItems(){

        List<dto> resultItem = new ArrayList<>();

       try{
           if(this.getCurrentPage() == 0){
               for(int j = 0; j < this.getPageSize(); j++){
                   resultItem.add(items.get(j));
               }
               return resultItem;
           }

           for (int i = 1; i < this.getTotalPageSize(); i++){
               for(int j = 0; j <  this.getPageSize(); j++){
                   if(i == this.getCurrentPage()){
                       resultItem.add(items.stream().skip((i) * itemsSize).toList().get(j));
                   }
               }
           }
       }catch (Exception ex){
           System.out.println("currentItems has Exception: " + ex);

       }

        return resultItem;
    }

}
