'use strict'

/**
 *
 * @Author - Adam In Tae Gerard
 *
 * Config.
 */

// Note that these correspond to the non-root user/password in docker-compose.yml

module.exports = {
    SERVER: {
        CORS: ['http://localhost:4200', 'http://localhost:1234' ],
        HTTPS_PORT: 8787,
        SSL: {
            KEY_PATH: './auth/key.pem',
            CERT_PATH: './auth/certificate.pem',
        }
    },

    API: {
        LOGGING_ENABLED: true
    },

    CLUSTER: {
        WORKERS: 8
    }
}