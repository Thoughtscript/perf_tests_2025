# Notes

`20,000` Concurrent Users split into `2` Thread Groups with ramp up of `180`.

## Config

Node `config.js`

```javascript
    API: {
        LOGGING_ENABLED: false
    },

    CLUSTER: {
        WORKERS: 8
    }
```

## Load

1. CPU hovers around `26%` in Docker.
   

