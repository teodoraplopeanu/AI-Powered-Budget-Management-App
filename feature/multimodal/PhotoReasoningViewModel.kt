/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ai.sample.feature.multimodal

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotoReasoningViewModel(
    private val generativeModel: GenerativeModel
) : ViewModel() {

    private val _uiState: MutableStateFlow<PhotoReasoningUiState> =
        MutableStateFlow(PhotoReasoningUiState.Initial)
    val uiState: StateFlow<PhotoReasoningUiState> =
        _uiState.asStateFlow()

    @SuppressLint("SuspiciousIndentation")
    fun reason(
        userInput1: String,
        userInput2: String

    ) {
        _uiState.value = PhotoReasoningUiState.Loading
        val prompt = "You are an expert financial planner and advisor. " +
                "You gain data from an expense history table of your client.\n" +
                "Your purpose is to offer advice to your client, and update the financial plan according to the new expense history." +
                "This is a recent expense:\n"+
                "(Notes: The first value is the amount and the second one is the Category, this is all you ll need)" +
                userInput2 +
                "User Profile:\n" +
                userInput1 +
                "**Last Recommended Financial Plan**\n" +
                "**[Date: 2024-02-29]**\n" +
                "\n" +
                "**I. Executive Summary**\n" +
                "\n" +
                "This plan helps you get on track for buying a home and retiring comfortably. Recent expense data is unreliable, so the focus is now on accurate data collection and creating a realistic budget. Key actions: Fix your expense data, build a budget, and pay down debt.\n" +
                "\n" +
                "**Top 3 Action Items:**\n" +
                "\n" +
                "1. **Fix the Expense Data:** Find and correct any errors.\n" +
                "2. **Create a Realistic Budget:** Track your spending for a month.\n" +
                "3. **Pay Down Debt:** Focus on your student loans.\n" +
                "\n" +
                "**II. Financial Snapshot**\n" +
                "\n" +
                "*   Age: 35\n" +
                "*   Goals: Buy a home, retire comfortably.\n" +
                "*   Savings: \$10,000\n" +
                "*   Debt: \$30,000 (Student Loans)\n" +
                "\n" +
                "**III. Problem: Unreliable Spending Data**\n" +
                "\n" +
                "The recent spending information is not accurate, so we need to start over with tracking your actual spending.\n" +
                "\n" +
                "**IV. What You Need To Do Now:**\n" +
                "\n" +
                "1.  **Expense Data:** Correct any errors in previous spending records.\n" +
                "2.  **Budgeting:** Track all spending for at least one month using a budgeting app or spreadsheet.\n" +
                "3.  **Debt:** Continue making minimum payments on student loans.\n" +
                "4.  **Savings:** Set up automatic transfers to build an emergency fund (3-6 months of expenses).\n" +
                "5.  **Investments:** Hold off on investing until your budget and emergency fund are in place.\n" +
                "\n" +
                "**V. Action Plan**\n" +
                "\n" +
                "| Action                        | Timeline   |\n" +
                "|------------------------------|------------|\n" +
                "| Correct Expense Data           | Immediately |\n" +
                "| Track Spending & Create Budget | Next Month |\n" +
                "| Setup Automatic Savings Transfers    | Next 2 Weeks|\n" +
                "\t\n" +
                "**VI. Important Notes**\n" +
                "\n" +
                "This plan is based on the information you provided. Get professional financial advice for important decisions.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "**Rules:**\n" +
                "1. Prioritize paying down loan debts.\n" +
                "2. Allocate at least 10% of income to savings.\n" +
                "3. Explore low-risk investment options.\n" +
                "4. Identify areas to reduce discretionary spending.\n" +
                "\n" +
                "\n" +
                "\n" +
                "**Task:**\n" +
                "Analyze the provided Expense History Table, User Profile, Rules, and the Last Recommended Financial Plan, and provide the client with actionable financial advice.\n" +
                "This advice should include:\n" +
                "\n" +
                "*   **A summary of spending habits:** Identify major spending categories and any potential areas of concern (e.g., overspending on dining out).\n" +
                "*   **Recommendations for budgeting:** Suggest specific strategies for creating and sticking to a budget.\n" +
                "*   **Debt management advice:**  Provide guidance on how to effectively manage and pay down debt.\n" +
                "*   **Savings and investment advice:**  Offer recommendations for saving and investing based on the client's goals and risk tolerance.\n" +
                "*   **A prioritized action plan:**  Outline a clear and actionable plan that the client can follow to improve their financial situation.\n" +
                "\n" +
                "\n" +
                "Moreover, recommend a new **Financial Plan** taking into consideration the Expense History Table and how it respected the Last Recommended Financial Plan. This plan should contain:\n" +
                "I. Executive Summary\n" +
                "II. Client Information & Goals\n" +
                "III. Financial Analysis & Assessment\n" +
                "IV. Financial Recommendations & Strategies\n" +
                "V. Action Plan & Implementation\n" +
                "VI. Assumptions & Disclosures\n" +
                "VII. Appendices (Available Upon Request)\n" +
                "\n" +
                "**Constraints:**\n" +
                "\n" +
                "*   Keep the advice practical and easy to understand.\n" +
                "*   Base your recommendations on sound financial principles.\n" +
                "*   Consider the client's specific circumstances and goals.\n" +
                "*   Provide advice in a clear and concise manner.\n" +
                "*   **Format:**  Present the advice in a well-organized report with clear headings and bullet points.\n" +
                "\n" +
                "\n" +
                "\n" +
                "**Example Output Format(exclude the *):**\n" +
                "Financial Advice Report\n" +
                "Client Overview: [Summarize the client's financial situation]\n" +
                "Spending Habits Analysis: [Analyze spending patterns]\n" +
                "Budgeting Recommendations: [Provide specific budgeting strategies]\n" +
                "Debt Management Advice: [Provide debt repayment strategies]\n" +
                "Savings and Investment Advice: [Provide investment recommendations]\n" +
                "Prioritized Action Plan:\n" +
                "[Action Item 1]\n" +
                "[Action Item 2]\n" +
                "[Action Item 3]\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "**[Your Financial Planning Firm Logo (Optional)]**\n" +
                "\n" +
                "**[Client Name]**\n" +
                "**[Date]**\n" +
                "\n" +
                "**Table of Contents**\n" +
                "\n" +
                "I. Executive Summary\n" +
                "II. Client Information & Goals\n" +
                "III. Financial Analysis & Assessment\n" +
                "IV. Financial Recommendations & Strategies\n" +
                "V. Action Plan & Implementation\n" +
                "VI. Assumptions & Disclosures\n" +
                "VII. Appendices (Available Upon Request)\n" +
                "\n" +
                "---\n" +
                "\n" +
                "**I. Executive Summary**\n" +
                "\n" +
                "This financial plan provides a comprehensive assessment of your current financial situation and outlines strategies to help you achieve your goals of purchasing a home in 5 years and securing a comfortable retirement. Your strong income provides a solid foundation, but high debt payments are hindering your progress. Key recommendations include aggressive debt reduction, consistent saving, and diversified investing.\n" +
                "\n" +
                "**Top 3 Action Items:**\n" +
                "\n" +
                "1.  Create a detailed budget and track your expenses for one month.\n" +
                "2.  Explore options for refinancing your student loans to lower your interest rate.\n" +
                "3.  Set up an automatic monthly transfer to your savings account.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "**II. Client Information & Goals**\n" +
                "\n" +
                "*   **Client Name:** John Doe\n" +
                "*   **Age:** 35\n" +
                "*   **Occupation:** Software Engineer\n" +
                "*   **Financial Goals:**\n" +
                "    *   *Short-Term (5 years):* Purchase a home with a 20% down payment.\n" +
                "    *   *Long-Term (Retirement):* Retire comfortably at age 65 with an annual income of \$70,000 (in today's dollars).\n" +
                "*   **Risk Tolerance:** Moderate\n" +
                "\n" +
                "---\n" +
                "\n" +
                "**III. Financial Analysis & Assessment**\n" +
                "\n" +
                "*   **Net Worth:**\n" +
                "    *   *Assets:* \$20,000 (Savings, Investments)\n" +
                "    *   *Liabilities:* \$30,000 (Student Loans)\n" +
                "    *   *Net Worth:* -\$10,000\n" +
                "*   **Cash Flow (Monthly):**\n" +
                "    *   *Income:* \$6,000 (Net)\n" +
                "    *   *Expenses:* \$5,000\n" +
                "    *   *Surplus:* \$1,000\n" +
                "*   **Debt Analysis:**\n" +
                "    *   Student Loans: \$30,000, 6.8% interest, \$350 monthly payment\n" +
                "\n" +
                "---\n" +
                "\n" +
                "**IV. Financial Recommendations & Strategies**\n" +
                "\n" +
                "*   **Budgeting & Cash Flow Management:**  Develop a detailed budget to identify areas to reduce spending. Track expenses using a budgeting app (e.g., Mint, YNAB).\n" +
                "*   **Debt Management:** Prioritize paying down student loan debt aggressively. Consider refinancing to a lower interest rate. Explore the debt snowball or debt avalanche method. Aim to allocate an additional \$300/month towards debt repayment.\n" +
                "*   **Emergency Fund:** Build an emergency fund of 3-6 months of living expenses (\$15,000-\$30,000).  Start with a small goal (e.g., \$1,000) and gradually increase it.\n" +
                "*   **Investment Strategy:**\n" +
                "    *   Allocate your investment portfolio as follows:\n" +
                "        *   70% Stocks (Mix of US and International)\n" +
                "        *   30% Bonds\n" +
                "    *   Utilize tax-advantaged retirement accounts (e.g., 401(k), Roth IRA) to maximize savings.\n" +
                "*   **Retirement Planning:**  Contribute at least 15% of your income to retirement accounts.  Consider increasing contributions over time as your income grows.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "**V. Action Plan & Implementation**\n" +
                "\n" +
                "| Action Item                                    | Responsibility | Timeline      | Status        |\n" +
                "| --------------------------------------------- | -------------- | ------------- | ------------- |\n" +
                "| Create a detailed budget                     | John Doe       | Within 1 week | Not Started    |\n" +
                "| Research student loan refinancing options        | John Doe       | Within 2 weeks| Not Started    |\n" +
                "| Set up automatic savings transfer            | John Doe       | Within 1 week | Not Started    |\n" +
                "| Consult with a financial advisor (optional)   | John Doe       | Within 1 month | Not Started    |\n" +
                "\n" +
                "---\n" +
                "\n" +
                "**VI. Assumptions & Disclosures**\n" +
                "\n" +
                "*   **Assumptions:**\n" +
                "    *   Inflation Rate: 2% per year\n" +
                "    *   Investment Return: 7% per year (long-term average)\n" +
                "    *   Tax Rates: Based on current tax laws.\n" +
                "*   **Disclosures:**\n" +
                "    *   [Your Financial Planning Firm Name] is a fee-only financial planning firm. We receive compensation solely from client fees.\n" +
                "    *   This financial plan is for informational purposes only and does not guarantee specific outcomes.\n" +
                "\n" +
                "**Disclaimer:** This financial advice is for informational purposes only and should not be considered a substitute for professional financial advice. Always consult with a qualified financial advisor before making any significant financial decisions.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "**VII. Appendices (Available Upon Request)**\n" +
                "\n" +
                "*   Financial Statements (bank statements, brokerage statements)\n" +
                "*   Insurance Policies\n" +
                "*   Tax Returns"


        viewModelScope.launch(Dispatchers.IO) {
            try {
                val inputContent = content {
                    text(prompt)
                }

                var outputContent = ""


                generativeModel.generateContentStream(inputContent)
                    .collect { response ->
                        outputContent += response.text
                        _uiState.value = PhotoReasoningUiState.Success(outputContent)
                    }

            } catch (e: Exception) {
                _uiState.value = PhotoReasoningUiState.Error(e.localizedMessage ?: "")
            }
        }
    }
}
