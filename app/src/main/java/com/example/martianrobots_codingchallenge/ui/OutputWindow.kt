package com.example.martianrobots_codingchallenge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.martianrobots_codingchallenge.R
import com.example.martianrobots_codingchallenge.data.Robot

//Output Window that gets updated when robot mutableStateList gets updated with a new Robot.
@Composable
fun OutputWindow(robots: List<Robot>) {
    Column {
        Text(stringResource(R.string.robots))
        Spacer(modifier = Modifier.height(8.dp))
        for (robot in robots) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    "Initial: ${robot.initialPosition.x}, ${robot.initialPosition.y} ${robot.initialOrientation}",
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                )
                if (robot.isLost) {
                    Text(
                        "Output: ${robot.position.x}, ${robot.position.y} ${robot.orientation} LOST!",
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                } else {
                    Text(
                        "Output: ${robot.position.x}, ${robot.position.y} ${robot.orientation}",
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}