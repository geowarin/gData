package com.gdata

import com.gdata.generator.ObjectGenerator
import com.gdata.generator.country.Country
import com.gdata.generator.name.FirstName

/**
 *
 * Date: 14/02/15
 * Time: 12:17
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class Gdata {

    static void main(String[] args) {

        ObjectGenerator generator = new ObjectGenerator()
        generator.addField('country', Country)
        generator.addField('name', FirstName)
        println generator.generate()
    }
}
