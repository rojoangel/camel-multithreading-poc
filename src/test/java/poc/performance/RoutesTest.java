package poc.performance;

import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.Produce;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringRunner.class)
@BootstrapWith(CamelTestContextBootstrapper.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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

    @EndpointInject(uri = "mock:check-direct-msgs-received")
    private MockEndpoint mockCheckDirectMsgsReceivedEndpoint;

    @EndpointInject(uri = "mock:check-seda-msgs-received")
    private MockEndpoint mockCheckSedaMsgsReceivedEndpoint;

    @Test
    public void nonParallelTest() throws Exception {
        mockCheckDirectMsgsReceivedEndpoint.expectedMessageCount(1000);
        nonParallelProducer.send();
        mockCheckDirectMsgsReceivedEndpoint.assertIsSatisfied();
    }

    @Test
    public void parallelProcessingTest() throws Exception {
        mockCheckDirectMsgsReceivedEndpoint.expectedMessageCount(1000);
        parallelProcessingProducer.send();
        mockCheckDirectMsgsReceivedEndpoint.assertIsSatisfied();
    }

    @Test
    public void unboundedPoolParallelProcessingTest() throws Exception {
        mockCheckDirectMsgsReceivedEndpoint.expectedMessageCount(1000);
        unboudedPoolParallelProcessingProducer.send();
        mockCheckDirectMsgsReceivedEndpoint.assertIsSatisfied();
    }

    @Test
    public void fixed20PoolParallelProcessingTest() throws Exception {
        mockCheckDirectMsgsReceivedEndpoint.expectedMessageCount(1000);
        fixed20PoolParallelProcessingProducer.send();
        mockCheckDirectMsgsReceivedEndpoint.assertIsSatisfied();
    }

    @Test
    public void seda20PoolParallelProcessingTest() throws Exception {
        mockCheckSedaMsgsReceivedEndpoint.expectedMessageCount(1000);
        seda20PoolParallelProcessingProducer.send();
        mockCheckSedaMsgsReceivedEndpoint.assertIsSatisfied();

    }
}
