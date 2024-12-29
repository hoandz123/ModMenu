LOCAL_PATH := $(call my-dir)




include $(CLEAR_VARS)
LOCAL_MODULE := libcurl
LOCAL_SRC_FILES := Includes/curl/curl-android-$(TARGET_ARCH_ABI)/lib/libcurl.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := libssl
LOCAL_SRC_FILES := Includes/curl/openssl-android-$(TARGET_ARCH_ABI)/lib/libssl.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := libcrypto
LOCAL_SRC_FILES := Includes/curl/openssl-android-$(TARGET_ARCH_ABI)/lib/libcrypto.a
include $(PREBUILT_STATIC_LIBRARY)

#=================================================================================
include $(CLEAR_VARS)
LOCAL_MODULE   := libdobby
LOCAL_SRC_FILES := $(LOCAL_PATH)Includes/Dobby/libraries/$(TARGET_ARCH_ABI)/libdobby.a
LOCAL_SRC_FILES := Includes/Dobby/libraries/$(TARGET_ARCH_ABI)/libdobby.a
include $(PREBUILT_STATIC_LIBRARY)
#=================================================================================










include $(CLEAR_VARS)
LOCAL_MODULE    := MyLibName
LOCAL_CFLAGS := -w -s -Wno-error=format-security -fvisibility=hidden -fpermissive -fexceptions
LOCAL_CPPFLAGS := -w -s -Wno-error=format-security -fvisibility=hidden -Werror -std=c++17
LOCAL_CPPFLAGS += -Wno-error=c++11-narrowing -fpermissive -Wall -fexceptions
LOCAL_LDFLAGS += -Wl,--gc-sections,--strip-all,-llog
LOCAL_LDLIBS := -llog -landroid -lEGL -lGLESv2
LOCAL_ARM_MODE := arm

LOCAL_C_INCLUDES += $(LOCAL_PATH)
LOCAL_C_INCLUDES += $(LOCAL_PATH)/Includes
LOCAL_C_INCLUDES += $(LOCAL_PATH)/Includes/curl/curl-android-$(TARGET_ARCH_ABI)/include
LOCAL_C_INCLUDES += $(LOCAL_PATH)/Includes/curl/openssl-android-$(TARGET_ARCH_ABI)/include


define get_sources
$(wildcard $(1)/*.c) $(wildcard $(1)/*.cpp)
endef


LOCAL_SRC_FILES := Main.cpp \
    $(call get_sources, $(LOCAL_PATH)/Includes) \
    $(call get_sources, $(LOCAL_PATH)/Includes/Substrate) \
    $(call get_sources, $(LOCAL_PATH)/Includes/KittyMemory) \
    $(call get_sources, $(LOCAL_PATH)/Includes/And64InlineHook) \
	$(call get_sources, $(LOCAL_PATH)/IL2Cpp) \
	$(call get_sources, $(LOCAL_PATH)/Includes/Tools) \
    $(call get_sources, $(LOCAL_PATH)/Includes/base64) \
    $(call get_sources, $(LOCAL_PATH)/Includes/ImGui) \

LOCAL_STATIC_LIBRARIES					:= libcurl libssl libcrypto libdobby
include $(BUILD_SHARED_LIBRARY)
