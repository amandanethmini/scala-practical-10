object transfer {
  def main(args: Array[String]): Unit = {
    val account1 = new Account("A123", 1000.0)
    val account2 = new Account("B456", 500.0)

    account1.deposit(200.0)
    println(
      s"Account 1 Balance after deposit: ${account1.balance}"
    )

    account1.withdraw(300.0)
    println(
      s"Account 1 Balance after withdrawal: ${account1.balance}"
    )

    account1.transfer(200.0, account2)
    println(
      s"Account 1 Balance after transfer: ${account1.balance}"
    )
    println(
      s"Account 2 Balance after receiving transfer: ${account2.balance}"
    )
  }
}

class Account(val accountNumber: String, private var currentBalance: Double) {

  def balance: Double = currentBalance

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    currentBalance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(amount <= currentBalance, "Insufficient balance")
    currentBalance -= amount
  }

  def transfer(amount: Double, targetAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    require(amount <= currentBalance, "Insufficient balance for transfer")

    this.withdraw(amount)
    targetAccount.deposit(amount)
  }

  override def toString: String =
    s"Account($accountNumber, Balance: $$currentBalance)"
}
