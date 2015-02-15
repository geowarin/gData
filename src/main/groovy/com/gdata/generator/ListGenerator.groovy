package com.gdata.generator

/**
 *
 * Date: 15/02/15
 * Time: 17:31
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ListGenerator {
    ObjectGenerator generator

    ListGenerator(ObjectGenerator generator) {
        this.generator = generator
    }

    List generate(int number) {
        List result = []
        number.times {
            result.push(generator.generate())
        }
        result
    }
}
