package com.example.martianrobots_codingchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.martianrobots_codingchallenge.data.Robot
import com.example.martianrobots_codingchallenge.domain.getRobotColor

//Dynamic Grid Generator based on Grid Size defined in GridSizeInput()
@Composable
fun GridSizeOutput(gridSizeX: String, gridSizeY: String, robot: Robot?) {

    val gridX = gridSizeX.toIntOrNull()
    val gridY = gridSizeY.toIntOrNull()

    if (gridX != null && gridY != null){
        if (gridX < 51 && gridY < 51) {
            val rows = gridY + 1
            val columns = gridX + 1

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                repeat(rows) { row ->
                    Row {
                        repeat(columns) { column ->
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(2.dp)
                                    .background(
                                        color =
                                        if (robot != null && robot.position.x == column && robot.position.y == rows - row - 1) getRobotColor(
                                            robot.orientation
                                        )
                                        else if (robot != null && robot.initialPosition.x == column && robot.initialPosition.y == rows - row - 1) getRobotColor(
                                            robot.initialOrientation
                                        )
                                        else Color.Gray
                                    )
                            ) {
                                if (robot != null && robot.position.x == column && robot.position.y == rows - row - 1) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "OUT",
                                            textAlign = TextAlign.Center,
                                            fontSize = 10.sp
                                        )
                                        Text(
                                            text = robot.orientation.toString(),
                                            textAlign = TextAlign.Center,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                } else if (robot != null && robot.initialPosition.x == column && robot.initialPosition.y == rows - row - 1) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "IN",
                                            textAlign = TextAlign.Center,
                                            fontSize = 10.sp
                                        )
                                        Text(
                                            text = robot.initialOrientation.toString(),
                                            textAlign = TextAlign.Center,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}