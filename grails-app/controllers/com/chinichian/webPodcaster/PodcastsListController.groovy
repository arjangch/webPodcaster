package com.chinichian.webPodcaster
import com.chinichian.webPodcaster.ItemListService

class PodcastsListController {
    def itemListService
    
    def index() { 
        def podcasts = Podcasts.listOrderByPodcastGroup()
        render (view: "index", model: [podcasts: podcasts])
    } 
    
    def itemList() { 
        params.max = params.max?:30
        def url = Podcasts.findByName(params.name).url
        def rootNode = new XmlSlurper().parse(url)
        def videoItemList = itemListService.retriveItems(rootNode.channel.item)
        render (view: "itemList", model: [params:params, videoItemList : videoItemList])
    }
	
	def playAllPodcastVideos() {
		params.max = params.max?:30
		def url = Podcasts.findByName(params.name).url
		def rootNode = new XmlSlurper().parse(url)
		def videoItemList = itemListService.retriveItems(rootNode.channel.item)
		render (view: "playAllPodcastVideos", model: [params:params, videoItemList : videoItemList])
	}
	
	def playAllPodcasts() {
		def map = [:]
		params.max = params.max?:30
		def podcasts
		if (params.groupName){
			podcasts = Podcasts.findAllByPodcastGroup(params.groupName)
		}else {
			podcasts = Podcasts.listOrderByName()
		}
		
		podcasts.each() {  
			if (it.name.trim().size() > 0) {
				def url = Podcasts.findByName(it.name ).url
				def rootNode = new XmlSlurper().parse(url)
				def videoItemList = itemListService.retriveItems(rootNode.channel.item)
				videoItemList.each() {map.put( it.date, it.videoUrl) }; 
			}
		}
		map.sort();
		render (view: "playAllPodcasts", model: [params:params, map : map])
	}
	
}
