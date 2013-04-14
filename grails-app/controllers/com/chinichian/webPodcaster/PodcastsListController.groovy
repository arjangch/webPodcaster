package com.chinichian.webPodcaster
import com.chinichian.webPodcaster.ItemListService

class PodcastsListController {
    def itemListService
    
    def index() { 
        def podcasts = Podcasts.listOrderByName()
        render (view: "index", model: [podcasts: podcasts])
    } 
    
    def itemList() { 
        def url = Podcasts.findByName(params.name).url
        def rootNode = new XmlSlurper().parse(url)
        def videoItemList = itemListService.retriveItems(rootNode.channel.item)
        render (view: "itemList", model: [videoItemList : videoItemList])
    }
}
