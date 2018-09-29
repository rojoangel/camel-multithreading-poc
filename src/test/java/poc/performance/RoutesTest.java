package poc.performance;

import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.Produce;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringRunner.class)
@BootstrapWith(CamelTestContextBootstrapper.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/camel-context.xml"})
public class RoutesTest {

    @Produce(uri = "direct:non-parallel")
    private FluentProducerTemplate nonParallelProducer;

    @Produce(uri = "direct:parallel-processing")
    private FluentProducerTemplate parallelProcessingProducer;

    @Produce(uri = "direct:unbounded-pool-parallel-processing")
    private FluentProducerTemplate unboudedPoolParallelProcessingProducer;

    @Produce(uri = "direct:20-pool-parallel-processing")
    private FluentProducerTemplate fixed20PoolParallelProcessingProducer;

    @Produce(uri = "direct:20-seda-parallel-processing")
    private FluentProducerTemplate seda20PoolParallelProcessingProducer;

    @Test
    public void nonParallelTest() {
        nonParallelProducer.send();
    }

    @Test
    public void parallelProcessingTest() {
        parallelProcessingProducer.send();
    }

    @Test
    public void unboundedPoolParallelProcessingTest() {
        unboudedPoolParallelProcessingProducer.send();
    }

    @Test
    public void fixed20PoolParallelProcessingTest() {
        fixed20PoolParallelProcessingProducer.send();
    }

    @Test
    public void seda20PoolParallelProcessingTest() {
        seda20PoolParallelProcessingProducer.send();
    }
}
