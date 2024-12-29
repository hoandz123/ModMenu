#include "imgui.h"
#include "imgui_impl_android.h"
#include "imgui_impl_opengl3.h"
#include <android/native_window_jni.h>
#include "Font.h"
#include "Icon.h"
#include "Iconcpp.h"
#include "ImguiPP.h"
#include "Fonts/Roboto-Regular.h"




ImVec4 HexToImGuiColor(const std::string& hexColor) {
    std::string alphaHex = hexColor.substr(0, 2);   // Lấy 2 ký tự đầu tiên (thành phần màu Alpha)
    std::string redHex = hexColor.substr(2, 2);     // Lấy 2 ký tự tiếp theo (thành phần màu Red)
    std::string greenHex = hexColor.substr(4, 2);   // Lấy 2 ký tự sau (thành phần màu Green)
    std::string blueHex = hexColor.substr(6, 2);    // Lấy 2 ký tự cuối cùng (thành phần màu Blue)

    int alpha = std::stoi(alphaHex, nullptr, 16);   // Chuyển thành phần màu Alpha sang số nguyên
    int red = std::stoi(redHex, nullptr, 16);       // Chuyển thành phần màu Red sang số nguyên
    int green = std::stoi(greenHex, nullptr, 16);   // Chuyển thành phần màu Green sang số nguyên
    int blue = std::stoi(blueHex, nullptr, 16);     // Chuyển thành phần màu Blue sang số nguyên

    float alphaFloat = static_cast<float>(alpha) / 255.0f; // Chuyển đổi thành phần màu Alpha sang dạng số thập phân (0.0f-1.0f)
    float redFloat = static_cast<float>(red) / 255.0f;     // Chuyển đổi thành phần màu Red sang dạng số thập phân (0.0f-1.0f)
    float greenFloat = static_cast<float>(green) / 255.0f; // Chuyển đổi thành phần màu Green sang dạng số thập phân (0.0f-1.0f)
    float blueFloat = static_cast<float>(blue) / 255.0f;   // Chuyển đổi thành phần màu Blue sang dạng số thập phân (0.0f-1.0f)

    return ImVec4(redFloat, greenFloat, blueFloat, alphaFloat);
}






#include "addimgui.h"
#include "ESP.h"




