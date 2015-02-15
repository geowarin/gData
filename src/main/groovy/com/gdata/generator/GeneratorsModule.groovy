package com.gdata.generator

import com.gdata.generator.country.Country
import com.gdata.generator.country.CountryDataGenerator
import com.gdata.generator.name.NameDataGenerator
import com.google.inject.AbstractModule
import com.google.inject.Singleton

/**
 *
 * Date: 15/02/15
 * Time: 14:41
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class GeneratorsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CountryDataGenerator).in(Singleton)
        bind(Country).toProvider(CountryDataGenerator)
        bind(NameDataGenerator)
    }
}
