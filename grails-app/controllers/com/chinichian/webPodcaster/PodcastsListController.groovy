package com.chinichian.webPodcaster
import com.chinichian.webPodcaster.ItemListService

class PodcastsListController {
    def ItemListService
    
    def index() { 
        def podcasts = Podcasts.findAll()
        render (view: "index", model: [podcasts: podcasts])
    }
    
    def itemList() { 
        //http://feeds.pbs.org/pbs/wgbh/nova-video
        //http://feeds.feedburner.com/allcnetvideopodcasts?format=xml
        def url = Podcasts.findByName(params.name).url
        def rootNode = new XmlSlurper().parse(url)
        ItemListService.retriveItems(rootNode.channel.item)
        render (view: "itemList", model: [items: rootNode.channel.item])
    
    }
}
