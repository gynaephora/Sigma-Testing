/*
An e-commerce site tracks the purchases made each day. The product that is purchased the most one day is the featured product for the following day. If there is a tie for the product purchased most frequently, those product names are ordered alphabetically ascending and the last name in the list is chosen.

Example
products = [‘redShirt’, ‘greenPants’, ‘redShirt’, ‘orangeShoes’, ‘blackPants’, ‘blackPants’]

greenPants and orangeShoes were purchased once.
redShirt and blackPants were each purchased 2 times on the given day.
After ordering the products alphabetically ascending, redShirt is the last product listed.
redShirt is the featured product for the following day.

Function Description
Complete the function featuredProduct in the editor below.

featuredProduct has the following parameter(s):
    string products[n]:  an array of strings where each represents a purchased product

Returns:
    string: the name of the featured product

Constraints
1 ≤ n ≤ 10000
*/

import java.util.*

val inputs = arrayOf(
    arrayOf("redShirt", "greenPants", "redShirt", "orangeShoes", "blackPants", "blackPants"),
    arrayOf("banana", "panama")
)

val expectedResults = arrayOf("redShirt", "panama")

fun featuredProduct(products: Array<String>) :String{
    val productsSet = products.toSortedSet()
    var productsSortedMap = mutableMapOf<String, Int>()

    for(i in productsSet) {
        productsSortedMap[i] = products.count { it == i}
    }
    val maxValueOfProductCount = productsSortedMap.maxOf { it.value }
    return productsSortedMap.filterValues { it== maxValueOfProductCount}.toList().last().first
}

fun main(args: Array<String>) {
    val actualResults = inputs.map(::featuredProduct).toTypedArray()
    when (Arrays.equals(actualResults, expectedResults)) {
        true -> System.out.println("The code works correctly")
        false -> System.out.println("Mistake: ${Arrays.toString(actualResults)} != ${Arrays.toString(expectedResults)}")
    }
}





