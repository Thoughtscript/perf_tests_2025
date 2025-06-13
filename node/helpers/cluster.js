'use strict'

/**
 * @Author - Adam In Tae Gerard - https://www.linkedin.com/in/adamintaegerard/
 *
 * Core cluster logic.
 */

const { createHttpsServer } = require('./https'),
    CL = require('cluster'),
    C = require('../config').CLUSTER

const createHttpsCluster = () => {
    if (CL.isMaster) {
        let cpuCount = Math.min(
            require('os').cpus().length,
            C.WORKERS)

        for (let i = 0; i < cpuCount; i++) {
            CL.fork()
        }

        CL.on('fork', worker => console.log(`Worker %d created: ${worker.id}`))
            .on('exit', worker => {
                console.error(`Worker %d died: ${worker.id}`)
                CL.fork()
            })

    } else {
        createHttpsServer()

    }
}

module.exports = {
    createHttpsCluster: createHttpsCluster
}

try {
    createHttpsCluster()

} catch (ex) {
    console.error(ex)
}