package com.google.ai.sample

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.nestedscroll.NestedScrollSource

@Composable
fun QuestionScreen(onSubmit: (String) -> Unit) {
    val answers = remember {
        mutableStateListOf("", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState) // adaugă scroll vertical
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Question 1: What is your employment status? (Employed, Self-employed, Student, " +
                "Retired, Unemployed)")
        BasicTextField(
            value = answers[0],
            onValueChange = { answers[0] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 2: What is your primary source of income? (Salary, Freelance, Business, " +
                "Investments, Other)")
        BasicTextField(
            value = answers[1],
            onValueChange = { answers[1] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 3: What is your average monthly income?")
        BasicTextField(
            value = answers[2],
            onValueChange = { answers[2] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 4: How stable is your income? (Fixed, Variable, Seasonal, Unpredictable)")
        BasicTextField(
            value = answers[3],
            onValueChange = { answers[3] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 5: Do you have any secondary sources of income? If yes, how much on average?")
        BasicTextField(
            value = answers[4],
            onValueChange = { answers[4] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 6: Do you have any dependents (children, parents, spouse) you financially support?")
        BasicTextField(
            value = answers[5],
            onValueChange = { answers[5] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 7: How much do you spend on groceries each month?")
        BasicTextField(
            value = answers[6],
            onValueChange = { answers[6] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 8: What is your average monthly utility bill cost? (Electricity, Water, Gas, Internet, etc.)")
        BasicTextField(
            value = answers[7],
            onValueChange = { answers[7] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 9: How much do you spend on transportation (fuel, public transport, car maintenance)?")
        BasicTextField(
            value = answers[8],
            onValueChange = { answers[8] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 10: Do you have any regular subscriptions (Netflix, Spotify, Gym, Magazines, etc.)?")
        BasicTextField(
            value = answers[9],
            onValueChange = { answers[9] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 11: How much do you spend on entertainment and dining out?")
        BasicTextField(
            value = answers[10],
            onValueChange = { answers[10] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 12: How much do you spend on shopping (clothing, gadgets, accessories)?")
        BasicTextField(
            value = answers[11],
            onValueChange = { answers[11] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 13: Do you set aside money for travel or vacations? If yes, how much per month?")
        BasicTextField(
            value = answers[12],
            onValueChange = { answers[12] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 14: What is your total estimated monthly expenditure?")
        BasicTextField(
            value = answers[13],
            onValueChange = { answers[13] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 15: Do you usually save money? (Yes/No)")
        BasicTextField(
            value = answers[14],
            onValueChange = { answers[14] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 16: Do you currently have savings? If yes, how much on average do you save per month?")
        BasicTextField(
            value = answers[15],
            onValueChange = { answers[15] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 17: How much would you like to save per month?")
        BasicTextField(
            value = answers[16],
            onValueChange = { answers[16] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 18: Are you currently investing in stocks, mutual funds, crypto, or real estate? If yes, how much per month?")
        BasicTextField(
            value = answers[17],
            onValueChange = { answers[17] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 19: What is your biggest financial challenge? (Overspending, Low Income, Debt, Saving, Other)")
        BasicTextField(
            value = answers[18],
            onValueChange = { answers[18] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Text("Question 20: Are there any specific financial habits you want to improve?")
        BasicTextField(
            value = answers[19],
            onValueChange = { answers[19] = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Button(
            onClick = {
                val allAnswersAsString = answers.joinToString(separator = "\n")
                onSubmit(allAnswersAsString)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Submit")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun QuestionScreenPreview() {
//    QuestionScreen { response ->
//        println("User submitted: $response")
//    }
}
