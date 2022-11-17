package com.composetv.ui.weight

import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.NativeKeyEvent
import androidx.compose.ui.input.key.type

fun KeyEvent.isActionDown() = this.type == KeyEventType.KeyDown

fun KeyEvent.isActionUp() = this.type == KeyEventType.KeyUp

fun KeyEvent.isUp() = this.nativeKeyEvent.keyCode == NativeKeyEvent.KEYCODE_DPAD_UP

fun KeyEvent.isDown() = this.nativeKeyEvent.keyCode == NativeKeyEvent.KEYCODE_DPAD_DOWN

fun KeyEvent.isLeft() = this.nativeKeyEvent.keyCode == NativeKeyEvent.KEYCODE_DPAD_LEFT

fun KeyEvent.isRight() = this.nativeKeyEvent.keyCode == NativeKeyEvent.KEYCODE_DPAD_RIGHT

fun KeyEvent.isCenter() = this.nativeKeyEvent.keyCode == NativeKeyEvent.KEYCODE_DPAD_CENTER
