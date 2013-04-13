package com.chinichian.webPodcaster

import org.springframework.dao.DataIntegrityViolationException

class PodcastsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [podcastsInstanceList: Podcasts.list(params), podcastsInstanceTotal: Podcasts.count()]
    }

    def create() {
        [podcastsInstance: new Podcasts(params)]
    }

    def save() {
        def podcastsInstance = new Podcasts(params)
        if (!podcastsInstance.save(flush: true)) {
            render(view: "create", model: [podcastsInstance: podcastsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'podcasts.label', default: 'Podcasts'), podcastsInstance.id])
        redirect(action: "show", id: podcastsInstance.id)
    }

    def show(Long id) {
        def podcastsInstance = Podcasts.get(id)
        if (!podcastsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'podcasts.label', default: 'Podcasts'), id])
            redirect(action: "list")
            return
        }

        [podcastsInstance: podcastsInstance]
    }

    def edit(Long id) {
        def podcastsInstance = Podcasts.get(id)
        if (!podcastsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'podcasts.label', default: 'Podcasts'), id])
            redirect(action: "list")
            return
        }

        [podcastsInstance: podcastsInstance]
    }

    def update(Long id, Long version) {
        def podcastsInstance = Podcasts.get(id)
        if (!podcastsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'podcasts.label', default: 'Podcasts'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (podcastsInstance.version > version) {
                podcastsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'podcasts.label', default: 'Podcasts')] as Object[],
                          "Another user has updated this Podcasts while you were editing")
                render(view: "edit", model: [podcastsInstance: podcastsInstance])
                return
            }
        }

        podcastsInstance.properties = params

        if (!podcastsInstance.save(flush: true)) {
            render(view: "edit", model: [podcastsInstance: podcastsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'podcasts.label', default: 'Podcasts'), podcastsInstance.id])
        redirect(action: "show", id: podcastsInstance.id)
    }

    def delete(Long id) {
        def podcastsInstance = Podcasts.get(id)
        if (!podcastsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'podcasts.label', default: 'Podcasts'), id])
            redirect(action: "list")
            return
        }

        try {
            podcastsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'podcasts.label', default: 'Podcasts'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'podcasts.label', default: 'Podcasts'), id])
            redirect(action: "show", id: id)
        }
    }
}
