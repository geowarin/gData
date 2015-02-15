package com.gdata

import com.gdata.generator.ObjectGenerator
import com.gdata.generator.country.CountryDataGenerator
import com.gdata.generator.name.NameDataGenerator

/**
 *
 * Date: 14/02/15
 * Time: 12:17
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class Gdata {

    static void main(String[] args) {

        ObjectGenerator generator = new ObjectGenerator()
        generator.addField('name', NameDataGenerator)
//        generator.addField('country', CountryDataGenerator)
        println generator.generate()
    }
}
