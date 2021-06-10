package org.example.infinispan.rocksdb;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.example.infinispan.rocksdb.model.TestModel;
import org.infinispan.Cache;
import org.infinispan.manager.EmbeddedCacheManager;

@ApplicationScoped
@Path("/")
public class TestResource {

    @Inject
    EmbeddedCacheManager cacheManager;

    private Cache<String, TestModel> cache;

    @PostConstruct
    void init() {
        cache = cacheManager.getCache("test");
    }

    @PUT
    @SuppressWarnings("QsUndeclaredPathMimeTypesInspection")
    public void put() {
        TestModel model = new TestModel();
        cache.put(model.getField1(), model, 1, TimeUnit.MINUTES);
    }
}
