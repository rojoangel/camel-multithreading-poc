Camel Multithreading PoC
========================

This project has been build using

    mvn archetype:generate                          \
      -DarchetypeGroupId=org.apache.camel.archetype \
      -DarchetypeArtifactId=camel-archetype-spring  \
      -DarchetypeVersion=2.22.1                     \
      -DgroupId=poc.performance                     \
      -DartifactId=test

To build this project use

    mvn install

To run this project with Maven use

    mvn camel:run

For more help see the Apache Camel documentation

    http://camel.apache.org/

