#pragma once

namespace {
	int (*ANativeWindow_getWidth_)(const void* window);
}





static float scaleX,scaleY;
static int screenWidth = -1, glWidth, screenHeight = -1, glHeight;
static float density = -1;
static bool g_Initialized;
void displayKeyboard(bool pShow);





