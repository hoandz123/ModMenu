#pragma once

#include <EGL/egl.h>
#include <GLES3/gl3.h>

void DrawESP();
void ImGul();

bool setup = false;

void SetupImgui() { 
    IMGUI_CHECKVERSION();
    ImGui::CreateContext();
    ImGuiIO& io = ImGui::GetIO();
    
    io.DisplaySize = ImVec2((float)glWidth, (float)glHeight);
    ImGui_ImplOpenGL3_Init("#version 300 es");
    ImGui::StyleColorsDark();
    ImFontConfig font_cfg;
    font_cfg.SizePixels = 22.0f;
    io.Fonts->AddFontFromMemoryTTF(Roboto_Regular, 22, 22.0f, &font_cfg, io.Fonts->GetGlyphRangesVietnamese());
    setup = true;
}





