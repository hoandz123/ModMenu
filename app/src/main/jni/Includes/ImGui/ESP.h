#ifndef ImGuiAndroid_ESP
#define ImGuiAndroid_ESP
#include <cstdio>
#include "ImGui/imgui_internal.h"
#include <stdio.h>
namespace EspGUI {
    void DrawLine(ImVec2 start, ImVec2 end, ImVec4 color = HexToImGuiColor("FFFFFFFF")) {
        auto background = ImGui::GetBackgroundDrawList();
        if(background) {
            background->AddLine(start, end, ImColor(color.x,color.y,color.z,color.w));
        }
    }
    void DrawLine(ImVec2 start, ImVec2 end, float thickness = 1.0f, ImVec4 color = HexToImGuiColor("FFFFFFFF")) {
        auto background = ImGui::GetBackgroundDrawList();
        if(background) {
            background->AddLine(start, end, ImColor(color.x, color.y, color.z, color.w), thickness);
        }
    }
    void DrawBox(ImVec4 rect, ImVec4 color) {
        ImVec2 v1(rect.x, rect.y);
        ImVec2 v2(rect.x + rect.z, rect.y);
        ImVec2 v3(rect.x + rect.z, rect.y + rect.w);
        ImVec2 v4(rect.x, rect.y + rect.w);

        DrawLine(v1, v2, color);
        DrawLine(v2, v3, color);
        DrawLine(v3, v4, color);
        DrawLine(v4, v1, color);
    }
    void DrawCircle(ImVec2 pos, float radius, bool filled = false, ImVec4 color = HexToImGuiColor("FFFFFFFF")) {
        auto background = ImGui::GetBackgroundDrawList();
        if(background) {
            if(filled) {
                background->AddCircleFilled(pos, radius, ImColor(color.x,color.y,color.z,color.w));
            } else {
                background->AddCircle(pos, radius, ImColor(color.x,color.y,color.z,color.w));
            }
        }
    }
    void DrawText(ImVec2 position, const char* text, float size, ImVec4 color) {
        if (!text || strlen(text) == 0) return; // Kiểm tra chuỗi văn bản rỗng

        ImVec2 text_size = ImGui::CalcTextSize(text); // Tính kích thước của văn bản
        ImVec2 centered_position = {
                position.x - text_size.x / 2.0f,
                position.y - text_size.y / 2.0f
        }; // Căn chỉnh trung tâm

        auto background = ImGui::GetBackgroundDrawList();
        if (background) {
            background->AddText(NULL, size, centered_position, ImColor(color.x, color.y, color.z, color.w), text);
        }
    }
    
    void DrawText(ImVec2 position, int value) {
        char format_text[1024]; 
        sprintf(format_text, "%d", value);
        ImGui::GetForegroundDrawList()->AddText({ (position.x - ImGui::CalcTextSize(format_text).x / 2.0f) , (position.y - ImGui::CalcTextSize(format_text).y / 2.0f) }, ImGui::ColorConvertFloat4ToU32({ 1,1,1,1.0f }), format_text);
    }

    void DrawText(ImVec2 position, const char *chuoi) {
        char format_text[1024]; 
        sprintf(format_text, "%s", chuoi);
        ImGui::GetForegroundDrawList()->AddText({ (position.x - ImGui::CalcTextSize(format_text).x / 2.0f) , (position.y - ImGui::CalcTextSize(format_text).y / 2.0f) }, ImGui::ColorConvertFloat4ToU32({ 1,1,1,1.0f }), format_text);
    }
    
    void DrawText(ImVec2 position, std::string text) {
        const char* chuoi = text.c_str();
        char format_text[1024]; 
        sprintf(format_text, "%s", chuoi);
        ImGui::GetForegroundDrawList()->AddText({ (position.x - ImGui::CalcTextSize(format_text).x / 2.0f) , (position.y - ImGui::CalcTextSize(format_text).y / 2.0f) }, ImGui::ColorConvertFloat4ToU32({ 1,1,1,1.0f }), format_text);
    }

    
    void DrawBox(ImVec2 p, ImVec2 size, float fontsize, ImVec4 color, const char *text) { 
        auto background = ImGui::GetBackgroundDrawList();
        ImVec2 textPos(p.x - (size.x/2) + (size.x - ImGui::CalcTextSize(text).x)/2, p.y + (size.y - ImGui::CalcTextSize(text).y)/2);
        background->AddRectFilled(ImVec2(p.x - (size.x/2), p.y) , ImVec2(p.x + (size.x/2), p.y + size.y), ImColor(color));
        background->AddText(NULL, fontsize, textPos, ImColor(1.0f, 1.0f, 1.0f, 1.0f), text);
    }
    //HP 1
    void DrawCircleHealth(int currentHealth, int maxHealth, float radius, ImVec2 position) {
        float a_max = ((3.14159265359f * 2.0f));
        ImU32 healthColor = IM_COL32(45, 180, 45, 255);
        if (currentHealth <= (maxHealth * 0.6)) {
            healthColor = IM_COL32(180, 180, 45, 255);
        }
        if (currentHealth < (maxHealth * 0.3)) {
            healthColor = IM_COL32(180, 45, 45, 255);
        }
        ImGui::GetForegroundDrawList()->PathArcTo(position, radius, (-(a_max / 4.0f)) + (a_max / maxHealth) * (maxHealth - currentHealth), a_max - (a_max / 4.0f));
        ImGui::GetForegroundDrawList()->PathStroke(healthColor, ImDrawFlags_None, 4);
    }
    ImColor GetHealthColor (float health, float maxHp = 100.0f) {
        float r = std::min(519 * (maxHp - health) / maxHp, 255.0f);
        float g = std::min(510 * health / maxHp, 255.0f); 
        return ImVec4(r/ 255.0f, g / 255.0f, 0.f, 1.0f);
    }
    //HP 2
    void DrawHealthBar(float currentHealth, float maxHealth, ImVec2 enemyPos) {
        auto barSize = ImVec2(30, 8);
        auto fillWidth = barSize.x * (currentHealth / maxHealth);
        auto screenPos = ImVec2(enemyPos.x - barSize.x / 2, enemyPos.y + barSize.y / 2); 
        auto drawList = ImGui::GetBackgroundDrawList();
        drawList->AddRectFilled (screenPos, ImVec2(screenPos.x + barSize.x, screenPos.y + barSize.y), IM_COL32 (0, 0, 0, 180));
        drawList->AddRectFilled (screenPos, ImVec2(screenPos.x + fillWidth, screenPos.y + barSize.y), GetHealthColor(currentHealth, maxHealth));
    }
    void DrawCrosshair(ImVec2 pos, float crosshairSize, ImVec4 color = HexToImGuiColor("FFFFFFFF")) {
        ImGui::GetForegroundDrawList()->AddLine({ pos.x - crosshairSize, pos.y }, { pos.x + crosshairSize, pos.y }, ImColor(color));
        ImGui::GetForegroundDrawList()->AddLine({ pos.x, pos.y - crosshairSize }, { pos.x, pos.y + crosshairSize }, ImColor(color));
    }

    void DrawInvertedTriangle(ImVec2 pos, float triangleSize, const ImVec4& color) {
        pos = ImVec2(pos.x, pos.y - triangleSize / 2);
        const ImVec2 p0 = ImVec2(pos.x - triangleSize, pos.y - triangleSize);  // Đỉnh trên bên trái
        const ImVec2 p1 = ImVec2(pos.x + triangleSize, pos.y - triangleSize);  // Đỉnh trên bên phải
        const ImVec2 p2 = ImVec2(pos.x, pos.y + triangleSize);  // Đỉnh dưới giữa
    
    
        ImGui::GetForegroundDrawList()->AddTriangleFilled(p0, p1, p2, IM_COL32(
            static_cast<int>(color.x * 255),
            static_cast<int>(color.y * 255),
            static_cast<int>(color.z * 255),
            static_cast<int>(color.w * 255)
        ));
    }



    

}
#endif ImGuiAndroid_ESP
