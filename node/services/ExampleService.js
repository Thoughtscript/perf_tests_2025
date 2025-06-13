'use strict'

/**
 *
 * @Author - Adam In Tae Gerard
 *
 * ExampleService.
 */

module.exports = {
    SCAN: async () => {
        const examples = []
        examples.push({"id": "1", "name": "a"})
        examples.push({"id": "2", "name": "b"})
        return examples
    }
}
