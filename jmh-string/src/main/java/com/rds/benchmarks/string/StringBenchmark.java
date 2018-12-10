package com.rds.benchmarks.string;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Fork(2)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class StringBenchmark {

    @State(value = Scope.Thread)
    public static class RuntimeExceptionBenchmarkState {
        private final List<String> data = Stream.iterate(0, i -> i + 1)
                .limit(100)
                .map(i -> UUID.randomUUID().toString())
                .collect(Collectors.toList());
    }

    @Benchmark
    public void stringBenchmark(RuntimeExceptionBenchmarkState state, Blackhole blackhole) {
        String results = "";
        for (String s : state.data) {
            results += s;
        }
        blackhole.consume(results);
    }

    @Benchmark
    public void stringBuilderBenchmark(RuntimeExceptionBenchmarkState state, Blackhole blackhole) {
        StringBuilder builder = new StringBuilder();
        for (String s : state.data) {
            builder.append(s);
        }
        blackhole.consume(builder.toString());
    }

    @Benchmark
    public void stringBufferBenchmark(RuntimeExceptionBenchmarkState state, Blackhole blackhole) {
        StringBuffer buffer = new StringBuffer();
        for (String s : state.data) {
            buffer.append(s);
        }
        blackhole.consume(buffer.toString());
    }

}
