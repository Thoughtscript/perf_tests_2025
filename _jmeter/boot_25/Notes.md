# Notes

`20,000` Concurrent Users split into `2` Thread Groups with ramp up of `180`.

## Config

Boot `application.yml`

```yaml
server:
  port: 8989
  tomcat:
    max-connections: 200
    # Tomcat thread pool
    threads:
      min: 2
      max: 4

spring:
  threads:
    virtual:
      enabled: true
  task:
    execution:
      pool:
        core-size: 5 # Doesn't have an effect if virtual threads are enabled.
        queue-capacity: 100 # Doesn't have an effect if virtual threads are enabled.
        max-size: 10 # Doesn't have an effect if virtual threads are enabled.
    simple:
      concurrency-limit: 100 # Default unbounded
```

## Load

1. CPU surprisingly doesn't usually exceed `6.97%` in Docker.
1. These apps are barebones and unaided by greater CPU resources, Caching, etc.