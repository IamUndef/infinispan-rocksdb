package org.example.infinispan.rocksdb;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import java.io.InputStream;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import org.infinispan.commons.dataconversion.MediaType;
import org.infinispan.commons.util.FileLookupFactory;
import org.infinispan.configuration.parsing.ConfigurationBuilderHolder;
import org.infinispan.configuration.parsing.ParserRegistry;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

@ApplicationScoped
class Bootstrapper {

    private EmbeddedCacheManager manager;

    @Produces
    @ApplicationScoped
    EmbeddedCacheManager getCacheManager() {
        return manager;
    }

    void onStart(@SuppressWarnings("unused") @Observes StartupEvent event) throws Exception {
        InputStream configurationStream = FileLookupFactory.newInstance().lookupFileStrict("infinispan.xml", Thread.currentThread().getContextClassLoader());
        ConfigurationBuilderHolder configHolder = new ParserRegistry().parse(configurationStream, null, MediaType.APPLICATION_XML);
        manager = new DefaultCacheManager(configHolder, true);
    }

    void onStop(@SuppressWarnings("unused") @Observes ShutdownEvent event) throws Exception {
        if (manager != null) {
            manager.close();
        }
    }
}
