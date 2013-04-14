package com.chinichian.webPodcaster
import com.chinichian.webPodcaster.Video; 

class ItemListService { 

    def retriveItems(def items) {
        def videoItemList = []  
        for (item in items){
            Video video = new Video();
            video.title = item.title.text()
            
            video.date = new Date(item.pubDate.text()).getDateString() 
             
            if (item.enclosure.@url.text()) video.videoUrl = item.enclosure.@url.text() 
            else if(item.content.@url.text()) video.videoUrl = item.content.@url.text()
            else if(item.link.text()) video.videoUrl = item.link.text()
            
            videoItemList.add(video)
          }
          
        return videoItemList  
    }
    
}
