
<%@ page import="com.chinichian.webPodcaster.Podcasts" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'podcasts.label', default: 'Podcasts')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-podcasts" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-podcasts" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list podcasts">
			
				<g:if test="${podcastsInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="podcasts.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${podcastsInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${podcastsInstance?.podcastGroup}">
				<li class="fieldcontain">
					<span id="podcastGroup-label" class="property-label"><g:message code="podcasts.podcastGroup.label" default="Podcast Group" /></span>
					
						<span class="property-value" aria-labelledby="podcastGroup-label"><g:fieldValue bean="${podcastsInstance}" field="podcastGroup"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${podcastsInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="podcasts.url.label" default="Url" /></span>
					
						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${podcastsInstance}" field="url"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${podcastsInstance?.id}" />
					<g:link class="edit" action="edit" id="${podcastsInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
