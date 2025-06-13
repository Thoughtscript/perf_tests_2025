'use strict'

/**
 * @Author - Adam In Tae Gerard
 *
 * Public API.
 */

const express = require('express'),
  publicApi = express.Router(),
  
  E = require('../services/ExampleService')

publicApi

  // https://localhost:8787/api/example/all
  .get("/example/all", async (req, res) => {
    const responseData = await E.SCAN()
    return res.send({ status: 200, data: JSON.stringify(responseData) })
  })

console.log(`Public API initialized`)

module.exports = publicApi
