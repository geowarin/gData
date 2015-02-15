package com.gdata.generator

import com.gdata.generator.country.Country
import com.gdata.generator.name.FirstName
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
        bind(Country).toProvider(Country.Loader).in(Singleton)
        bind(FirstName).toProvider(FirstName.Loader).in(Singleton)
    }
}
