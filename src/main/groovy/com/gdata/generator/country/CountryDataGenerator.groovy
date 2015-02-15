package com.gdata.generator.country

import com.gdata.generator.DataGenerator
import com.google.inject.Provider

/**
 *
 * Date: 14/02/15
 * Time: 12:18
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class CountryDataGenerator extends DataGenerator<Country> implements Provider<Country> {

    @Override
    Country generate() {
        return pickRandom()
    }

    @Override
    Country get() {
        return pickRandom()
    }
}
