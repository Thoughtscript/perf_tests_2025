# Notes

`20,000` Concurrent Users split into `2` Thread Groups with ramp up of `180`.

## Config

`dockerfile`

```dockerfile
CMD [ "uvicorn", "main:app", "--host", "0.0.0.0", "--workers", "8", "--port", "6767", "--no-access-log"]
```

## Load

1. CPU utilization hovers around `7%` in Docker.
1. These apps are barebones and unaided by greater CPU resources, Caching, etc. No Proxy out in front.