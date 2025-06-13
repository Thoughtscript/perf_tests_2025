# spring_perf_tests_2025

[![](https://img.shields.io/badge/Spring%20Boot-3.5.0-green.svg)](https://spring.io/projects/spring-boot)
[![](https://img.shields.io/badge/Maven-3.8.6-white.svg)](https://maven.apache.org/download.cgi)
[![](https://img.shields.io/badge/Node.js-23.11.1-yellowgreen.svg)](https://nodejs.org/en/) 
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

| Detail  | Spring Boot | Spring WebFlux | Node.js | 
| ---  | --- | --- | --- | 
| Near Concurrent Connections  | `100,000` in `2` cycles | `100,000` in `2` cycles |  `100,000` in `2` cycles |
| Total Duration | `137347ms`  |  `137114ms` | `131182ms` |
| Average Client Request Duration | `0ms` | `0ms` | `0ms` |
| Docker Desktop Memory Utilization | `378.9MB` | `412.1MB` | `224.4MB` |
| Docker Desktop Peak CPU Utilization  | `291.54%` | `63%` | `25.83%` |
| Docker Desktop CPU Utilization  | `29.41%` | `26.25%` |  `27.43%` |
| Docker  | `maven:3.9.6-eclipse-temurin-22-alpine` | `maven:3.9.6-eclipse-temurin-22-alpine` | `node:23.11.1` |
| Config of Note  | Virtual Threads (`100`) | Webflux/Reactor Threads (`5-10`) |  HTTPS Fork Cluster (`8`) |
| Version | Java `22`, Spring Boot `3.5.0` | Java `22`, Spring Boot `3.5.0` | Node `23.11.1` |
| Endpoints | http://localhost:8888/api/example/all | http://localhost:7777/api/example/all | https://localhost:8787/api/example/all |

> Tested on Machine: `AMD Ryzen 5 5600X (6/12 Core), 32 GB RAM, Windows 11 Pro`

## JMeter Findings

> Available [here](./_jmeter/).