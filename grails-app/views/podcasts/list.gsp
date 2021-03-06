
<%@ page import="com.chinichian.webPodcaster.Podcasts" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'podcasts.label', default: 'Podcasts')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-podcasts" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-podcasts" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'podcasts.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="podcastGroup" title="${message(code: 'podcasts.podcastGroup.label', default: 'Podcast Group')}" />
					
						<g:sortableColumn property="url" title="${message(code: 'podcasts.url.label', default: 'Url')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${podcastsInstanceList}" status="i" var="podcastsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${podcastsInstance.id}">${fieldValue(bean: podcastsInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: podcastsInstance, field: "podcastGroup")}</td>
					
						<td>${fieldValue(bean: podcastsInstance, field: "url")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${podcastsInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
