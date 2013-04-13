<html>
<body>
    <g:each var="itemVideo" in="${itemList}" status="i">
        <g:if test="${i < 30}">
            <p>
                ${itemVideo.date} -- 
                <a href="${itemVideo.videoUrl}">${itemVideo.videoUrl}</a>
            </p>
        </g:if>
    </g:each>
</body>
</html>