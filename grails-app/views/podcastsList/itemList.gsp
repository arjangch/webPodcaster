<html>
<body>
    <g:each var="videoItem" in="${videoItemList}" status="i">
        <g:if test="${i < 30}">
                ${videoItem.date} -- 
                <a href="${videoItem.videoUrl}">${videoItem.title}</a><br/>
        </g:if>
    </g:each>
</body>
</html>