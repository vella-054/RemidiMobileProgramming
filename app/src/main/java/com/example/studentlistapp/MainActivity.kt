package com.example.studentlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studentlistapp.ui.theme.StudentListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentListAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentList(
                        students = getStudentList(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun getStudentList(): List<Student> {
        return listOf(
            Student("SSI202203170", "SYEFULLOH.S"),
            Student("SSI202203159", "FATKHUL LATIF"),
            Student("SSI202203165", "DANING NENE RARASASI"),
            Student("SSI202203288", "DEA TRI HANIFAH"),
            Student("SSI202203181", "RIAN KURNIAWAN"),
            Student("Vella Anggraeni", "SSI202203085"),
            Student("ERVINA MARESA", "SSI202203260"),
            Student("TRIMANTO", "SSI202203184"),
            Student("SALIA DELAFANTRI", "SSI202203169"),
            Student("NANIK WANI ARISTA", "SSI202203330"),
            Student("IMAM ARIZAL", "SSI202203162")
        )
    }
}

@Composable
fun StudentList(students: List<Student>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(students) { student ->
            val color = when {
                students.indexOf(student) % 11 == 0 -> Color.Red
                students.indexOf(student) % 11 == 1 -> Color.Red
                students.indexOf(student) % 11 == 2 -> Color.Red
                students.indexOf(student) % 11 == 3 -> Color.Red
                students.indexOf(student) % 11 == 4 -> Color.Red
                students.indexOf(student) % 11 == 5 -> Color.Blue
                students.indexOf(student) % 11 == 6 -> Color.Green
                students.indexOf(student) % 11 == 7 -> Color.Green
                students.indexOf(student) % 11 == 8 -> Color.Green
                students.indexOf(student) % 11 == 9 -> Color.Green
                students.indexOf(student) % 11 == 10 -> Color.Green
                else -> Color.Cyan
            }
            StudentItem(student, color)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun StudentItem(student: Student, color: Color, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = student.name, style = MaterialTheme.typography.headlineSmall, color = color)
        Text(text = student.id, style = MaterialTheme.typography.bodyMedium, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun StudentListPreview() {
    StudentListAppTheme {
        StudentList(
            students = listOf(
                Student("Sample Name", "Sample ID")
            )
        )
    }
}

data class Student(val name: String, val id: String)
