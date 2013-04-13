import com.chinichian.webPodcaster.Podcasts;

class BootStrap {

    def init = { servletContext ->
        new Podcasts(name: 'cnet', url: 'http://feeds.feedburner.com/allcnetvideopodcasts?format=xml').save(failOnError: true)  
        new Podcasts(name: 'nova', url: 'http://feeds.pbs.org/pbs/wgbh/nova-video').save(failOnError: true) 
        new Podcasts(name: 'globalnews', url: 'http://globalnews.ca/toronto/feed/').save(failOnError: true) 
    }
    def destroy = {
    }
}
