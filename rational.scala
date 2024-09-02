object rational {

  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    private val gcdValue = gcd(n.abs, d.abs)
    val numerator: Int = n / gcdValue
    val denominator: Int = d / gcdValue

    def neg: Rational = new Rational(-numerator, denominator)

    override def toString: String = s"$numerator/$denominator"

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }
  }

  def main(args: Array[String]): Unit = {
    println("Enter the numerator:")
    val numerator = scala.io.StdIn.readLine().toInt

    println("Enter the denominator:")
    val denominator = scala.io.StdIn.readLine().toInt

    val x = new Rational(numerator, denominator)
    println(s"Original: $x")
    println(s"Negated: ${x.neg}")
  }
}
