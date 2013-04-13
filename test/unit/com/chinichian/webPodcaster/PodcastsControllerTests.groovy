package com.chinichian.webPodcaster



import org.junit.*
import grails.test.mixin.*

@TestFor(PodcastsController)
@Mock(Podcasts)
class PodcastsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/podcasts/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.podcastsInstanceList.size() == 0
        assert model.podcastsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.podcastsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.podcastsInstance != null
        assert view == '/podcasts/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/podcasts/show/1'
        assert controller.flash.message != null
        assert Podcasts.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/podcasts/list'

        populateValidParams(params)
        def podcasts = new Podcasts(params)

        assert podcasts.save() != null

        params.id = podcasts.id

        def model = controller.show()

        assert model.podcastsInstance == podcasts
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/podcasts/list'

        populateValidParams(params)
        def podcasts = new Podcasts(params)

        assert podcasts.save() != null

        params.id = podcasts.id

        def model = controller.edit()

        assert model.podcastsInstance == podcasts
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/podcasts/list'

        response.reset()

        populateValidParams(params)
        def podcasts = new Podcasts(params)

        assert podcasts.save() != null

        // test invalid parameters in update
        params.id = podcasts.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/podcasts/edit"
        assert model.podcastsInstance != null

        podcasts.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/podcasts/show/$podcasts.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        podcasts.clearErrors()

        populateValidParams(params)
        params.id = podcasts.id
        params.version = -1
        controller.update()

        assert view == "/podcasts/edit"
        assert model.podcastsInstance != null
        assert model.podcastsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/podcasts/list'

        response.reset()

        populateValidParams(params)
        def podcasts = new Podcasts(params)

        assert podcasts.save() != null
        assert Podcasts.count() == 1

        params.id = podcasts.id

        controller.delete()

        assert Podcasts.count() == 0
        assert Podcasts.get(podcasts.id) == null
        assert response.redirectedUrl == '/podcasts/list'
    }
}
