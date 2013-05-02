<!DOCTYPE html>
<html>
	<head>
		<title>Welcome to webPodcaster</title>
	</head>
	<body>
	    <g:each var="podcast" in="${podcasts}">
	        <a href="podcastsList/itemList?name=${podcast.name}&max=30">${podcast.name}</a><br>
	    </g:each>
	</body>
</html>	
