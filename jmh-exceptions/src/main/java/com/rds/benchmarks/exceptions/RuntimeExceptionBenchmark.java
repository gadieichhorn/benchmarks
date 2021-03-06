package com.rds.benchmarks.exceptions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(2)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class RuntimeExceptionBenchmark {

    @State(value = Scope.Thread)
    public static class RuntimeExceptionBenchmarkState {
        RuntimeException exception = new RuntimeException("STATIC");
    }

    @Benchmark
    public void create(RuntimeExceptionBenchmarkState state, Blackhole blackhole) {
        try {
            throw new RuntimeException("TEST");
        } catch (RuntimeException ex) {
            blackhole.consume(ex.getMessage());
        }
    }

    @Benchmark
    public void staticThrow(RuntimeExceptionBenchmarkState state, Blackhole blackhole) {
        try {
            throw state.exception;
        } catch (RuntimeException ex) {
            blackhole.consume(ex.getMessage());
        }
    }

}
