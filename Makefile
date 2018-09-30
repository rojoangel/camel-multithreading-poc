.PHONY: run_no_concurrency_test run_parallel_processing_test run_unbounded_parallel_processing_test run_20_fixed_thread_pool_test run_20_seda_thread_pool_test

# run test without concurrency
run_no_concurrency_test:
	@ mvn -Dtest=RoutesTest#nonParallelTest test

# run test with parallel processing
run_parallel_processing_test:
	@ mvn -Dtest=RoutesTest#parallelProcessingTest test

# run test with unbounded parallel processing
run_unbounded_parallel_processing_test:
	@ mvn -Dtest=RoutesTest#unboundedPoolParallelProcessingTest test

# run test with a 20 fixed thread pool
run_20_fixed_thread_pool_test:
	@ mvn -Dtest=RoutesTest#fixed20PoolParallelProcessingTest test

# run test with a 20 seda thread pool
run_20_seda_thread_pool_test:
	@ mvn -Dtest=RoutesTest#seda20PoolParallelProcessingTest test
