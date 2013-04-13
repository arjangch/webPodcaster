<html>
<body>
    <g:each var="item" in="${items}" status="i">
        <g:if test="${i < 30}">
            <p>
                ${new Date(item.pubDate.text())} -- 
                <a href="${item.content.@url.text()}">${item.content.@url.text()}</a> - 
                <a href="${item.link.text()}">${item.link.text()}</a> - 
                <a href="${item.enclosure.@url.text()}">${item.enclosure.@url.text()}</a>
            </p>
        </g:if>
        
    </g:each>
</body>
</html>