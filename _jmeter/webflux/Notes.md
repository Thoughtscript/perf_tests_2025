# Notes

## Config

Webflux `application.yml`

```yaml
server:
  port: 7777

spring:
  task:
    execution:
      pool:
        core-size: 6
        queue-capacity: 250
        max-size: 12
```

## Load

1. CPU surprisingly doesn't usually exceed `40%` in Docker.
2. Despite that fact, with `2+` Thread Groups and `>10000` users per, the Container will often crash.
3. The above settings help to stabilize that under higher load.
4. These apps are barebones and unaided by greater CPU resources, Caching, etc.