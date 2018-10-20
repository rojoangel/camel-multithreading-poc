Camel Multithreading PoC
========================

This project has been build using

    mvn archetype:generate                           \
      -DarchetypeGroupId=org.apache.camel.archetypes \
      -DarchetypeArtifactId=camel-archetype-spring   \
      -DarchetypeVersion=2.22.1                      \
      -DgroupId=poc.performance                      \
      -DartifactId=test

To build this project use

    mvn install

To run the tests for this project with Maven use

    mvn camel:run

To run the non concurrency test use

    make run_no_concurrency_test

To run the parallel processing test use

    make run_parallel_processing_test

To run the unbounded parallel processing test use

    make run_unbounded_parallel_processing_test

To run the 20 fixed thread pool test use

    make run_20_fixed_thread_pool_test

To run the 20 seda thread pool test use

    make run_20_seda_thread_pool_test

For more help see the Apache Camel documentation

    http://camel.apache.org/

