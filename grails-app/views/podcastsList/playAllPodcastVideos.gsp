<html>
<head>
	<script type="text/javascript">
	    var videoIndex = 0;
	    var videoUrls=new Array(
			<g:each var="videoItem" in="${videoItemList}" status="i">
				<g:if test="${i < params.int('max')}">
					"${videoItem.videoUrl}",
				</g:if>
			</g:each>
		    "http://traffic.libsyn.com/dilbert/d157.m4v"    
		);
	    
	    function playnext() {
	        videoPlayer.src = videoUrls[videoIndex];
	        videoIndex++;
	    }
	</script>
</head>
<body onload="playnext()">
	<video id="videoPlayer" src="" autoplay autobuffer controls onended="playnext();"/>
</body>
</html>