<html>
<body>
    <g:each var="item" in="${items}" status="i">
        <g:if test="${i < 30}">
            <p>
                ${item.pubDate.text()} - <a href="${item.link.text()}">${item.title.text()}</a></br>
            </p>
        </g:if>
    </g:each>
</body>
</html>