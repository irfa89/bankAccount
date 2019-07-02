package com.bank.entries

abstract class Product {
  val name : String

  override def toString:String = "product=" + name

}

abstract class Deposits extends Product{
  val interestRatePerYear : Double
  val minimumBalancePerMonth : Int
}

abstract class Checking extends Deposits

abstract class Savings extends Deposits{
  val transactionAllowedPerMonth: Int
}

class CoreChecking(bal:Int,rate:Double) extends Checking {
  println("Created core checking product")
  override val interestRatePerYear: Double = rate
  override val minimumBalancePerMonth: Int = bal
  override val name: String = "Core Checking"
}

class StudentCheckings(bal: Int,rate:Double) extends Checking {
  println("Created student checking product")
  override val interestRatePerYear: Double = rate
  override val minimumBalancePerMonth: Int = bal
  override val name: String = "Student Checking"
}

class RewardsSavings(bal:Int,rate:Double,trans:Int) extends Savings{
  println("Created rewards saving product")
  override val interestRatePerYear: Double = rate
  override val minimumBalancePerMonth: Int = bal
  override val transactionAllowedPerMonth: Int = trans
  override val name: String = "Rewards Saving"
}

abstract class Lending extends Product{
  val annualFee:Double
  val apr:Double
  val rewardsPercent: Double
}

class CreditCard(fee:Double,rate:Double,pct:Double) extends Lending{
  println("Created credit card product")
  override val annualFee: Double = fee
  override val apr: Double = rate
  override val rewardsPercent: Double = pct
  override val name: String = "Credit Card"
}