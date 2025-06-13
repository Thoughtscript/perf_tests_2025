'use strict'

/**
 * @Author - Adam In Tae Gerard - https://www.linkedin.com/in/adamintaegerard/
 *
 * Core Https server
 */

const C = require('../config').SERVER, 
  FS = require('node:fs')

module.exports = {
  createHttpsServer: () => {
    const OPTS = {
      key: FS.readFileSync(C.SSL.KEY_PATH),
      cert: FS.readFileSync(C.SSL.CERT_PATH)
    }
  
    const S = require('node:https').createServer(OPTS, require('./express').createServer())

    console.log('HTTPS initialized!')

    S.listen(C.HTTPS_PORT, () => { console.log(`HTTPS server started on port: ${S.address().port}`) })

    return S
  }
}
