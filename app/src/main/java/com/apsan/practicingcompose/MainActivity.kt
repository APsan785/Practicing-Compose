package com.apsan.practicingcompose

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var textField by remember {
                mutableStateOf("")
            }

            val coroutineScope = rememberCoroutineScope()
            val scaffoldState = rememberScaffoldState()

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF14CF53))
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxHeight(0.5F)
                            .padding(55.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        val focusManager = LocalFocusManager.current
                        OutlinedTextField(
                            value = textField, onValueChange = {
                                textField = it
                            }, modifier = Modifier.fillMaxWidth(), singleLine = true,
                            label = {
                                Text(text = "Enter Text Here...", color = Color.White)
                            },
                            textStyle = TextStyle(color = Color.Yellow, fontSize = 15.sp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                textColor = Color.Yellow,
                                backgroundColor = Color(0xFF462208),
                                cursorColor = Color.White,
                                focusedBorderColor = Color.Yellow,
                                unfocusedBorderColor = Color.White,
                                focusedLabelColor = Color.Yellow
                            ),
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Done,
                                keyboardType = KeyboardType.Text
                            ),
                            keyboardActions = KeyboardActions(onDone = {
                                focusManager.clearFocus()
                            })
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            val getActivity = LocalContext.current as Activity
                            Button(
                                onClick = {
                                    coroutineScope.launch {
                                        scaffoldState.snackbarHostState.showSnackbar("Hey Bro $textField")
                                    }

                                    val imm: InputMethodManager = getActivity.getSystemService(
                                        INPUT_METHOD_SERVICE
                                    ) as InputMethodManager
                                    //Find the currently focused view, so we can grab the correct window token from it.
                                    //Find the currently focused view, so we can grab the correct window token from it.
                                    var view: View? = getActivity.currentFocus
                                    //If no view currently has focus, create a new one, just so we can grab a window token from it
                                    //If no view currently has focus, create a new one, just so we can grab a window token from it
                                    if (view == null) {
                                        view = View(getActivity)
                                    }
                                    imm.hideSoftInputFromWindow(view.windowToken, 0)


                                },
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Blue,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "Click Me!!")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyColumn(modifier = Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp)) {
                        items(5000) {
                            Text(
                                text = "Item Number $it",
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFC6BEDA))
                                    .padding(18.dp),
                                color = Color(0xFFD654B1)
                            )
                        }
                    }
                }
            }
        }
    }
}
// scaffold for top bar nav drawer snackbar