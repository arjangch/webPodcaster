package com.chinichian.webPodcaster
import com.chinichian.webPodcaster.ItemVideo;

class ItemListService { 
    def retriveItems(def items) {
        def itemList = []  
        for (item in items){
            ItemVideo itemVideo = new ItemVideo();
            itemVideo.date = item.pubDate.text()
            if(item.content.@url.text()) itemVideo.videoUrl = item.content.@url.text()
            else if(item.link.text()) itemVideo.videoUrl = item.link.text()
            else if (item.enclosure.@url.text()) itemVideo.videoUrl = item.enclosure.@url.text()
            itemList.add(itemVideo)
          }
          
        return itemList  
    }
    
}
