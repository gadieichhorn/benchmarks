package com.rds.benchmarks.exceptions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(2)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class CustomExceptionBenchmark {

    @State(value = Scope.Thread)
    public static class CustomExceptionBenchmarkState {
        TestException exception = new TestException();
    }

    @Benchmark
    public void create(CustomExceptionBenchmarkState state, Blackhole blackhole) {
        try {
            throw new TestException();
        } catch (TestException ex) {
            blackhole.consume(ex.getMessage());
        }
    }

    @Benchmark
    public void staticThrow(CustomExceptionBenchmarkState state, Blackhole blackhole) {
        try {
            throw state.exception;
        } catch (TestException ex) {
            blackhole.consume(ex.getMessage());
        }
    }

}
