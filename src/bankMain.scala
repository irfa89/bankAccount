import java.time.LocalDate

import com.bank.entries.{Account, Bank, CoreChecking, CreditCard, Customer, RewardsSavings, StudentCheckings}

object bankMain {
  def main(args:Array[String]):Unit = {
    println("Welcome to Banking")

    val coreChecking = new CoreChecking(1000,0.025)
    val studentCheckings = new StudentCheckings(0,0.010)
    val rewardsSavings = new  RewardsSavings(10000,0.10,1)
    val creditCard = new CreditCard(99.0,14.23,20)
    val products = Set(coreChecking,studentCheckings,rewardsSavings,creditCard)

    val bobMartin = new Customer("Bob","Martinn","bob@martin.com",LocalDate.of(1983,8,22))
    val bobCheckingAccount = new Account(bobMartin,coreChecking,1000)
    val bobSavingAccount = new Account(bobMartin,rewardsSavings,20000)
    val bobCreditAccount = new Account(bobMartin,creditCard,4500)
    val accounts = Set(bobCheckingAccount,bobSavingAccount,bobCreditAccount)

    val bank = new Bank("Bank of NY","NY", "US","bank@ny.com",products, Set(bobMartin),accounts)

    println(bobCheckingAccount)

    bobCheckingAccount.deposit(100)
    println(bobCheckingAccount)

    bobCheckingAccount.withdraw(200)
    println(bobCheckingAccount)

  }

}
