# Benchmarks

Different benchmarks tests packaged as docker containers for different target architecture 

## Build

> mvn clean install

you should have similar docker images created
> docker images

    REPOSITORY                              TAG                                IMAGE ID            CREATED             SIZE
    realisedatasystems/jmh-string-x64       0.0.1-SNAPSHOT                     8ec5623c6e47        4 minutes ago       93.9MB
    realisedatasystems/jmh-string-x64       0.0.1-SNAPSHOT.20181210063608480   8ec5623c6e47        4 minutes ago       93.9MB
    realisedatasystems/jmh-string-x64       latest                             8ec5623c6e47        4 minutes ago       93.9MB
    realisedatasystems/jmh-exceptions-x64   0.0.1-SNAPSHOT                     9f5cb51c9c8d        4 minutes ago       94MB
    realisedatasystems/jmh-exceptions-x64   0.0.1-SNAPSHOT.20181210063608480   9f5cb51c9c8d        4 minutes ago       94MB
    realisedatasystems/jmh-exceptions-x64   latest                             9f5cb51c9c8d        4 minutes ago       94MB


## Run

using compose

### String tests
Up
>  docker-compose -f jmh-string/docker-compose.yml up

Down
>  docker-compose -f jmh-string/docker-compose.yml down

results are under volume folder

### Exception tests
Up
>  docker-compose -f jmh-exceptions/docker-compose.yml up

Down
>  docker-compose -f jmh-exceptions/docker-compose.yml down

results are under volume folder


## View

Using the JMH visulaiser you can upload each result file and analyse benchmark

https://jmh.morethan.io/


