package com.chinichian.webPodcaster
import com.chinichian.webPodcaster.ItemVideo;

class ItemListService { 

    def retriveItems(def items) {
        def itemList = []  
        for (item in items){
            ItemVideo itemVideo = new ItemVideo();
            itemVideo.title = item.title.text()
            
            itemVideo.date = new Date(item.pubDate.text()).getDateString() 
             
            if (item.enclosure.@url.text()) itemVideo.videoUrl = item.enclosure.@url.text() 
            else if(item.content.@url.text()) itemVideo.videoUrl = item.content.@url.text()
            else if(item.link.text()) itemVideo.videoUrl = item.link.text()
            
            itemList.add(itemVideo)
          }
          
        return itemList  
    }
    
}
