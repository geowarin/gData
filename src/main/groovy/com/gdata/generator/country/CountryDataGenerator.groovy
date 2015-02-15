package com.gdata.generator.country

import com.gdata.loader.DataLoader
import com.google.inject.Provider

/**
 *
 * Date: 14/02/15
 * Time: 12:18
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class CountryDataGenerator implements DataLoader<Country>, Provider<Country> {

    CountryDataGenerator() {
        loadData()
    }

    @Override
    Country get() {
        data
    }
}
