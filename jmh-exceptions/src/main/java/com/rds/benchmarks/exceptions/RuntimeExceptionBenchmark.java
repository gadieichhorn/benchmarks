package com.rds.benchmarks.exceptions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

public class RuntimeExceptionBenchmark {

    @State(value = Scope.Thread)
    public static class RuntimeExceptionBenchmarkState {
        static final RuntimeException exception = new RuntimeException();
        int source = 42;
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void create(RuntimeExceptionBenchmarkState state, Blackhole blackhole) {
        try {
            throw new RuntimeException("TEST");
        } catch (IllegalStateException ex) {
            blackhole.consume(ex);
        }
    }

}
