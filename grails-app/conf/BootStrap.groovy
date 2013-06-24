import com.chinichian.webPodcaster.Podcasts;

class BootStrap {

    def init = { servletContext ->
        new Podcasts(podcastGroup: 'star', name: 'NOVA', url: 'http://feeds.pbs.org/pbs/wgbh/nova-video').save(failOnError: true) 
        new Podcasts(podcastGroup: 'tech', name: 'TED', url: 'http://feeds.feedburner.com/TedtalksHD?format=xml').save(failOnError: true) 
        new Podcasts(podcastGroup: 'tech', name: 'Gadget Lab', url: 'http://downloads.wired.com/podcasts/xml/gadgetlab.xml').save(failOnError: true) 
        
		new Podcasts(podcastGroup: 'star', name: 'Nasa Cast', url: 'http://downloads.wired.com/podcasts/xml/gadgetlab.xml').save(failOnError: true)
        new Podcasts(podcastGroup: 'star', name: 'Hubble Cast', url: 'http://www.spacetelescope.org/rss/vodcastfullhd.xml').save(failOnError: true)
        new Podcasts(podcastGroup: 'star', name: 'Hidden Universe', url: 'http://www.spitzer.caltech.edu/features/hd/hdfeed.xml').save(failOnError: true)
        new Podcasts(podcastGroup: 'star', name: 'Nasa jet', url: 'http://www.jpl.nasa.gov/multimedia/rss/podfeed-hd.xml').save(failOnError: true)
		
		new Podcasts(podcastGroup: 'fun', name: 'Dilbert', url: 'http://ringtales.com/dilbert.xml').save(failOnError: true)
        new Podcasts(podcastGroup: 'fun', name: 'Fashion', url: 'http://www.style.com/services/rss/feeds/fashionshow_podcast.xml').save(failOnError: true)
        
		new Podcasts(podcastGroup: 'nature', name: 'PBS - Nature', url: 'http://www.pbs.org/wnet/nature/rss/podcast.xml').save(failOnError: true)

		new Podcasts(podcastGroup: 'news', name: 'NBC', url: 'http://podcastfeeds.nbcnews.com/audio/podcast/MSNBC-NN-NETCAST-M4V.xml').save(failOnError: true)
        new Podcasts(podcastGroup: 'news', name: 'Global National', url: 'http://feeds.feedburner.com/GlobalNationalVideoPodcast?format=xml').save(failOnError: true) 
        new Podcasts(podcastGroup: 'news', name: 'Al Jazeera', url: 'http://feeds.aljazeera.net/podcasts/aljazeeraworldHD?format=xml').save(failOnError: true)
		new Podcasts(podcastGroup: 'news', name: 'The National with Rex Murphy', url: 'http://www.cbc.ca/mediafeeds/rss/cbc/rexmurphy-video-podcast.xml').save(failOnError: true) 
		new Podcasts(podcastGroup: 'news', name: 'CNET', url: 'http://feeds.feedburner.com/cnet/allhdpodcast?format=xml').save(failOnError: true)
		
		new Podcasts(podcastGroup: 'farsi', name: 'voa-lastnews', url: 'https://itunes.apple.com/podcast/id521148297').save(failOnError: true)
		new Podcasts(podcastGroup: 'farsi', name: 'voa-offogh', url: 'https://itunes.apple.com/podcast/id417497999').save(failOnError: true)
		new Podcasts(podcastGroup: 'farsi', name: 'radio-israel', url: 'https://itunes.apple.com/ca/podcast/radio-israel-in-persian-radyw/id658129550').save(failOnError: true)
		
		//new Podcasts(podcastGroup: '', name: '', url: '').save(failOnError: true)
		//new Podcasts(podcastGroup: '', name: '', url: '').save(failOnError: true)
    }
    def destroy = {
    }
}
