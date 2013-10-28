<!DOCTYPE html>
<html>
	<head>
		<title>Welcome to webPodcaster</title>
	</head>
	<body>
	    <g:each var="podcast" in="${podcasts}">
	        <a href="playAllPodcasts?groupName=${podcast.podcastGroup}&max=30">${podcast.podcastGroup}</a> 
	        -- 
	        <a href="itemList?name=${podcast.name}&max=30">${podcast.name}</a> 
	        -- 
	        <a href="playAllPodcastVideos?name=${podcast.name}&max=30"> Play All </a><br>
	    </g:each>
	</body>
</html>	
