object bank {
  def main(args: Array[String]): Unit = {
    val account1 = new Account("A123", 1000.0)
    val account2 = new Account("B456", -200.0)
    val account3 = new Account("C789", 500.0)
    val account4 = new Account("D012", -100.0)

    val bank = List(account1, account2, account3, account4)

    // 4.1 List of Accounts with negative balances
    val negativeBalanceAccounts = findNegativeBalanceAccounts(bank)
    println("Accounts with negative balances:")
    negativeBalanceAccounts.foreach(account => println(account))

    // 4.2 Calculate the sum of all account balances
    val totalBalance = calculateTotalBalance(bank)
    println(s"\nTotal balance of all accounts: $$${totalBalance}")

    // 4.3 Calculate the final balances after applying interest
    applyInterest(bank)
    println("\nFinal balances after applying interest:")
    bank.foreach(account => println(account))
  }

  // 4.1 List of Accounts with negative balances
  def findNegativeBalanceAccounts(accounts: List[Account]): List[Account] = {
    accounts.filter(_.balance < 0)
  }

  // 4.2 Calculate the sum of all account balances
  def calculateTotalBalance(accounts: List[Account]): Double = {
    accounts.map(_.balance).sum
  }

  // 4.3 Calculate the final balances after applying interest
  def applyInterest(accounts: List[Account]): Unit = {
    accounts.foreach { account =>
      if (account.balance > 0) {
        account.deposit(account.balance * 0.05)
      } else {
        account.withdraw(account.balance.abs * 0.1)
      }
    }
  }
}

class Account(val accountNumber: String, private var currentBalance: Double) {

  def balance: Double = currentBalance

  // Method to deposit money
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    currentBalance += amount
  }

  // Method to withdraw money
  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(amount <= currentBalance.abs, "Insufficient balance")
    currentBalance -= amount
  }

  override def toString: String =
    s"Account($accountNumber, Balance: $$${currentBalance})"
}
