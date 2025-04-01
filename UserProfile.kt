package com.google.ai.sample

import com.google.ai.sample.util.Purchase

// 1) Enum pentru status angajare
enum class EmploymentStatus {
    FULL_TIME,
    PART_TIME,
    UNEMPLOYED,
    SELF_EMPLOYED,
    RETIRED,
    STUDENT,
    OTHER
}

// 2) Enum pentru stabilitatea venitului
enum class IncomeStability {
    FIXED,
    VARIABLE,
    SEASONAL,
    UNPREDICTABLE
}

// 3) O clasă de exemplu pentru cheltuielile lunare
data class MonthlySpendings(
    val rent: Float,
    val utilities: Float,
    val groceries: Float,
    val entertainment: Float,
    val other: Float
)

// 4) Clasa UserProfile
data class UserProfile(
    val name: String,
    val isEmployed: Boolean,          // e angajat (true/false)
    val age: Int,                     // vârsta
    val employmentStatus: EmploymentStatus, // enum-ul de mai sus
    val monthlyIncome: Double,         // venit lunar
    val savingsPercentage: Double,     // procentaj savings
    val hasSecondaryIncome: Boolean,  // are venit secundar?
    val secondaryIncomeValue: Double?,  // valoarea venitului secundar
    val incomeStability: IncomeStability, // enum-ul de stabilitate
    val monthlySpendings: Purchase // clasa cu cheltuieli lunare
)

data class UserProfileWtihQuestions(
    val userProfileStrings: List<String>
)
