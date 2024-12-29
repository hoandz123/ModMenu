LOCAL_PATH := $(call my-dir)
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


define get_sources
$(wildcard $(1)/*.c) $(wildcard $(1)/*.cpp)
endef


LOCAL_SRC_FILES := Main.cpp \
    $(call get_sources, $(LOCAL_PATH)/Includes) \
    $(call get_sources, $(LOCAL_PATH)/Includes/Substrate) \
    $(call get_sources, $(LOCAL_PATH)/Includes/KittyMemory) \
    $(call get_sources, $(LOCAL_PATH)/Includes/And64InlineHook) \

include $(BUILD_SHARED_LIBRARY)
