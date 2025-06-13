'use strict'

/**
 *
 * @Author - Adam In Tae Gerard
 *
 * Tests.
 */

const request = require('supertest'),
    assert = require('assert'),
    L = require('./library'),
    desc = L.describe,
    test = L.it,

    EXPECTED_STRING_HASH = JSON.stringify([{ "id": "1", "name": "a" }, { "id": "2", "name": "b" }]),
    EXPECTED_STATUS_CODE = 200,
    
    EXAMPLE_SVC = require('../services/ExampleService')

desc('ExampleService Tests', () => {
    test('should return the correct data', async () => {
        assert.equal(JSON.stringify(await EXAMPLE_SVC.SCAN()), EXPECTED_STRING_HASH)
        console.log(`ExampleService tests: Passed!`)
    })
})

desc('REST API Tests', () => {
    test('should return the correct data', () => {
        request(require('../helpers/express').createServer())
            .get('/api/example/all')
            .expect({ 
                status: EXPECTED_STATUS_CODE, 
                data: EXPECTED_STRING_HASH 
            })
            .expect(EXPECTED_STATUS_CODE)
            .end((err, res) => {
                if (err) throw err
                console.log(`API tests: Passed!`)
            })
    })
})