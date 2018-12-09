package com.rds.benchmarks.exceptions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExceptionBenchmark {

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void illegalStateException(Blackhole blackhole) {
        try {
            throw new IllegalStateException("TEST");
        } catch (IllegalStateException ex) {
            blackhole.consume(ex);
        }
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void timeoutException(Blackhole blackhole) {
        try {
            throw new TimeoutException("TEST");
        } catch (TimeoutException ex) {
            blackhole.consume(ex);
        }
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void nullPointerException(Blackhole blackhole) {
        try {
            throw new NullPointerException("TEST");
        } catch (NullPointerException ex) {
            blackhole.consume(ex);
        }
    }

}
