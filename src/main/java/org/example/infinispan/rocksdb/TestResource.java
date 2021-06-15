package org.example.infinispan.rocksdb;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.example.infinispan.rocksdb.model.IndexedModel;
import org.example.infinispan.rocksdb.model.TestModel;
import org.infinispan.Cache;
import org.infinispan.manager.EmbeddedCacheManager;

@ApplicationScoped
@Path("/")
public class TestResource {

    @Inject
    EmbeddedCacheManager cacheManager;

    private Cache<String, TestModel> testCache;
    private Cache<String, IndexedModel> indexedCache;

    @PostConstruct
    void init() {
        testCache = cacheManager.getCache("test");
        indexedCache = cacheManager.getCache("indexed");
    }

    @PUT
    @Path("/test")
    @SuppressWarnings("QsUndeclaredPathMimeTypesInspection")
    public void putTest() {
        TestModel model = new TestModel();
        testCache.put(model.getField1(), model);
    }

    @PUT
    @Path("/indexed")
    @SuppressWarnings("QsUndeclaredPathMimeTypesInspection")
    public void put() {
        IndexedModel model = new IndexedModel();
        indexedCache.put(model.getField1(), model);
    }
}
