<html>
<body>
	<table>
		<g:each var="videoItem" in="${videoItemList}" status="i">
			<tr>
			<g:if test="${i < 30}">
				<td>${i})</td>
				<td>${videoItem.date}</td>
				<td><a href="${videoItem.videoUrl}">${videoItem.title}</a></td>
			</g:if>
			</tr>
		</g:each>
	</table>
</body>
</html>