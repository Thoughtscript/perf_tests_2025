# spring_perf_tests_2025

[![](https://img.shields.io/badge/Spring%20Boot-3.5.0-green.svg)](https://spring.io/projects/spring-boot)
[![](https://img.shields.io/badge/Maven-3.8.6-white.svg)](https://maven.apache.org/download.cgi)
[![](https://img.shields.io/badge/Docker-blue.svg)](https://www.docker.com/) 

```bash
docker compose up
```

## Endpoints

1. http://localhost:7777/api/example/all
1. http://localhost:8888/api/example/all

## Testing

1. Using [Test Client](https://github.com/Thoughtscript/test_client)
2. [Postman](https://www.postman.com/)

## Findings

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
| Total Duration | `137347ms`  |  `137114ms` | `213513` |
| Average Client Request Duration | `0ms` | `0ms` | `1ms` |
| Docker Desktop Memory Utilization | `378.9MB` | `412.1MB` | `201.1MB` |
| Docker Desktop Peak CPU Utilization  | `291.54%` | `63%` | `54.72%` |
| Docker Desktop CPU Utilization  | `29.41%` | `26.25%` |  `41.52%` |
| Docker  | `maven:3.9.6-eclipse-temurin-22-alpine` | `maven:3.9.6-eclipse-temurin-22-alpine` | `node:23.11.1` |
| Repo  | [This very one](https://github.com/Thoughtscript/spring_perf_tests_2025) | [This very one](https://github.com/Thoughtscript/spring_perf_tests_2025) | [mearn_2024](https://github.com/Thoughtscript/mearn_2024) | 
| Config of Note  | Virtual Threads (`100`) | Webflux/Reactor Threads (`5-10`) |  HTTPS Fork Cluster (`4`) w/ backing Mongo DB |
| Version | Java `22`, Spring Boot `3.5.0` | Java `22`, Spring Boot `3.5.0` | Node `23.11.1`, Mongo `7.0.9` |
| Endpoints | http://localhost:8888/api/example/all | http://localhost:7777/api/example/all | https://localhost:8888/api/event/<UUID> |

> Tested on Machine: `AMD Ryzen 5 5600X (6/12 Core), 32 GB RAM, Windows 11 Pro`