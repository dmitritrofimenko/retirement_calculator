
package retcalc

import org.scalactic.{Equality, TolerantNumerics, TypeCheckedTripleEquals}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RetCalcSpec extends AnyWordSpec with Matchers with TypeCheckedTripleEquals {

  implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.0001)

  "RetCalc.futureCapital" should {
    "calculate the amount of savings I will have in n months" in {
      // Excel =-FV(0.04/12,25*12,1000,10000,0)
      val actual = RetCalc.futureCapital(
        interestRate = 0.04 / 12, nbOfMonths = 25 * 12,
        netIncome = 3000, currentExpenses = 2000,
        initialCapital = 10000)
      val expected = 541267.1990
      actual should ===(expected)
    }
  }
}