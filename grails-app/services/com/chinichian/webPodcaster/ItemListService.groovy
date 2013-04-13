package com.chinichian.webPodcaster
import com.chinichian.webPodcaster.Item;

class ItemListService { 
    def retriveItems(def items) {
        for (item in items){
            println "----"+item.pubDate.text()
          }
        
        
    }
}
