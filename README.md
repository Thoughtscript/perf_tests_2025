# perf_tests_2025

[![](https://img.shields.io/badge/Spring%20Boot-3.5.0-green.svg)](https://spring.io/projects/spring-boot)
[![](https://img.shields.io/badge/Maven-3.8.6-white.svg)](https://maven.apache.org/download.cgi)
[![](https://img.shields.io/badge/Node.js-23.11.1-yellowgreen.svg)](https://nodejs.org/en/) 
[![](https://img.shields.io/badge/FastAPI-0.115.12-yellow.svg)](https://fastapi.tiangolo.com/) 
[![](https://img.shields.io/badge/Golang-1.24.0-lightblue.svg)](https://go.dev/) 
[![](https://img.shields.io/badge/Docker-blue.svg)](https://www.docker.com/) 

## Testing

```bash
docker compose up
```

1. Using [Test Client](https://github.com/Thoughtscript/test_client)
2. [Postman](https://www.postman.com/)
3. Using [JMeter](https://jmeter.apache.org/)

## Test Client Findings

These have been [tested](https://github.com/Thoughtscript/test_client) up to `100,000` near-concurrent requests/connections partly to:
1. See what kind of load they can handle.
2. And to isolate the impact of other dependencies that might cause inefficient Virtual Threading elsewhere.

Configuration:
```yaml
client:
  logging:
    full: true
    stats: true
  concurrent:
    workers: 100000
    cycles: 2
    pause: 1000
```

> Verifies that there are no errors: no `5XX`, no `4XX` - retrieves and logs Response Body.

| Detail  | Spring Boot | Spring WebFlux | Node.js | FastAPI | Go |
| ---  | --- | --- | --- | --- | --- |
| Near Concurrent Connections  | `100,000` in `2` cycles | `100,000` in `2` cycles |  `100,000` in `2` cycles | `100,000` in `2` cycles |  `100,000` in `2` cycles |
| Total Duration | `137347ms`  |  `137114ms` | `131182ms` | `145531ms` | `113625ms` |
| Average Client Request Duration | `0ms` | `0ms` | `0ms` | `0ms` | `0ms` |
| Docker Desktop Memory Utilization | `378.9MB` | `412.1MB` | `224.4MB` | `273.1MB` | `135.5MB ` |
| Docker Desktop Peak CPU Utilization  | `291.54%` | `63%` | `25.83%` | `28.6%`| `20%` |
| Docker Desktop CPU Utilization  | `29.41%` | `26.25%` |  `27.43%` | `27.14%` | `19.84%` |
| Docker  | `maven:3.9.6-eclipse-temurin-22-alpine` | `maven:3.9.6-eclipse-temurin-22-alpine` | `node:23.11.1` | `python:3.12.3` | `golang:1.24.0` |
| Config of Note  | Virtual Threads (`100`) | Webflux/Reactor Threads (`5-10`) |  HTTPS Fork Cluster (`8`), SSL | Uvicorn Workers (`8`) | Go Routines/Channels, SSL |
| Version | Java `22`, Spring Boot `3.5.0` | Java `22`, Spring Boot `3.5.0` | Node `23.11.1` | Python `3.12.3`, fastapi `0.115.12` | Go `1.24.0` |
| Endpoints | http://localhost:8888/api/example/all | http://localhost:7777/api/example/all | https://localhost:8787/api/example/all | http://localhost:6767/api/example/all | https://localhost:9999/api/example/all |

> Tested on Machine: `AMD Ryzen 5 5600X (6/12 Core), 32 GB RAM, Windows 11 Pro`

## JMeter Findings

> Available [here](./_jmeter/).

## Resources and Links

1. Node [1M Users](https://noncodersuccess.medium.com/how-id-scale-a-website-to-1-million-users-with-node-js-examples-53fb58c22302)
2. Node [500K Users - 1K Concurrent](https://medium.com/unboxd/how-i-built-an-app-with-500-000-users-in-5-days-on-a-100-server-77deeb238e83)
3. Node [10K Concurrent](https://www.metabrew.com/article/a-million-user-comet-application-with-mochiweb-part-1)
4. Node [100K Users - 50K Concurrent](https://blog.devgenius.io/how-a-failed-startup-led-me-to-master-node-js-design-patterns-c9dd88e46afe)
5. WebFlux [10K Concurrent](https://aabir-hassan.medium.com/demystifying-spring-webflux-the-event-loop-threading-models-and-schedulers-part-1-7d2711d2f60e)
6. Node, Boot, and WebFlux [10K, 1K, and 10K Concurrent](https://www.brilworks.com/blog/node-js-vs-spring-boot/), respectively
7. Boot [15K Concurrent](https://haril.dev/en/blog/2023/11/10/Spring-MVC-Traffic-Testing)