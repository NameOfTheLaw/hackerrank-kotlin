package minimaxsum

import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.data_driven.data
import org.jetbrains.spek.data_driven.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.Assert

class MiniMaxSumFunctionalImplSpec : SubjectSpek<(Array<Int>) -> Pair<Long, Long>>({
    subject { ::miniMaxSumFunctional }

    val dataWithVariousNumbersInArrays = arrayOf(
            data("1, 2, 3, 4, 5", arrayOf(1, 2, 3, 4, 5), Pair(10L, 14L)),
            data("5, 4, 3, 2, 1", arrayOf(5, 4, 3, 2, 1), Pair(10L, 14L)),
            data("5, 0, 0, 0, 0", arrayOf(5, 0, 0, 0, 0), Pair(0L, 5L)),
            data("5, 5, 5, 5, 10", arrayOf(5, 5, 5, 5, 10), Pair(20L, 25L)))

    val dataWithSingleNumbers = arrayOf(
            data(0, 0L),
            data(5, 20L))

    describe("calculation min and max sums") {

        on("array of five %s's",
                *dataWithSingleNumbers
        ) { num, expectedSum ->
            it("should return $expectedSum as a mins and maxs sums") {
                Assert.assertEquals(Pair(expectedSum, expectedSum), subject(Array(5) { num }))
            }
        }

        on("array of %s",
                *dataWithVariousNumbersInArrays
        ) { _, array, expected ->
            it("should return ${expected.first} as a mins sum and ${expected.second} as a maxs sums") {
                Assert.assertEquals(expected, subject(array))
            }
        }
    }
})