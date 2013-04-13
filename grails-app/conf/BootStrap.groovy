import com.chinichian.webPodcaster.Podcasts;

class BootStrap {

    def init = { servletContext ->
        new Podcasts(name: 'cnet', url: 'http://feeds.feedburner.com/allcnetvideopodcasts?format=xml').save(failOnError: true)  
        new Podcasts(name: 'nova', url: 'http://feeds.pbs.org/pbs/wgbh/nova-video').save(failOnError: true) 
        new Podcasts(name: 'Global National', url: 'http://feeds.feedburner.com/GlobalNationalVideoPodcast?format=xml').save(failOnError: true) 
        new Podcasts(name: 'TED', url: 'http://feeds.feedburner.com/TedtalksHD?format=xml').save(failOnError: true) 
        new Podcasts(name: 'The National with Rex Murphy', url: 'http://www.cbc.ca/mediafeeds/rss/cbc/rexmurphy-video-podcast.xml').save(failOnError: true) 
        new Podcasts(name: 'Gadget Lab', url: 'http://downloads.wired.com/podcasts/xml/gadgetlab.xml').save(failOnError: true) 
        new Podcasts(name: 'Nasa Cast', url: 'http://downloads.wired.com/podcasts/xml/gadgetlab.xml').save(failOnError: true)
        new Podcasts(name: 'Hubble Cast', url: 'http://www.spacetelescope.org/rss/vodcastfullhd.xml').save(failOnError: true)
        new Podcasts(name: 'Hidden Universe', url: 'http://www.spitzer.caltech.edu/features/hd/hdfeed.xml').save(failOnError: true)
        new Podcasts(name: 'Dilbert', url: 'http://ringtales.com/dilbert.xml').save(failOnError: true)
        new Podcasts(name: 'Fashion', url: 'http://www.style.com/services/rss/feeds/fashionshow_podcast.xml').save(failOnError: true)
        new Podcasts(name: 'PBS - Nature', url: 'http://www.pbs.org/wnet/nature/rss/podcast.xml').save(failOnError: true)
        new Podcasts(name: '', url: '').save(failOnError: true)
        new Podcasts(name: '', url: '').save(failOnError: true)
        new Podcasts(name: '', url: '').save(failOnError: true)
        
    }
    def destroy = {
    }
}
