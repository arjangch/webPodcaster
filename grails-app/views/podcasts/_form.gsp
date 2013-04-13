<%@ page import="com.chinichian.webPodcaster.Podcasts" %>



<div class="fieldcontain ${hasErrors(bean: podcastsInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="podcasts.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${podcastsInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: podcastsInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="podcasts.url.label" default="Url" />
		
	</label>
	<g:textField name="url" value="${podcastsInstance?.url}"/>
</div>

