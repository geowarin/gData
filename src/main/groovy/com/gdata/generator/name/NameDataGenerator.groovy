package com.gdata.generator.name

import com.gdata.generator.LocalizedGenerator
import com.gdata.generator.country.Country
import com.google.inject.Inject

/**
 *
 * Date: 14/02/15
 * Time: 12:18
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class NameDataGenerator extends LocalizedGenerator<String> {

    @Inject
    NameDataGenerator(Country country) {
        super(country)
    }

    @Override
    String generate() {
        return pickRandom()
    }
}
