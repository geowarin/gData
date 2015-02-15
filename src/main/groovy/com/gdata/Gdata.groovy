package com.gdata

import com.gdata.generator.ListGenerator
import com.gdata.generator.ObjectGenerator
import com.gdata.generator.country.Country
import com.gdata.generator.person.FirstName
import com.gdata.generator.person.LastName

/**
 *
 * Date: 14/02/15
 * Time: 12:17
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class Gdata {

    static void main(String[] args) {
        ObjectGenerator personGenerator = new ObjectGenerator()
        personGenerator.country = Country
        personGenerator.name = FirstName
        personGenerator.lastName = LastName
        println new ListGenerator(personGenerator).generate(2)
    }
}
