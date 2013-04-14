<html>
<body>
    <g:each var="videoItem" in="${videoItemList}" status="i">
        <g:if test="${i < 30}">
            <p>
                ${videoItem.date} -- 
                <a href="${videoItem.videoUrl}">${videoItem.title}</a>
            </p>
        </g:if>
    </g:each>
</body>
</html>