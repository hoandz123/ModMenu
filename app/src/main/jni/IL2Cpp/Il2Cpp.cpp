

#include "Il2cpp.h"
#include "Logger.h"
#include <unordered_map>
#include <string>
#include <tuple>

typedef unsigned short UTF16;
typedef wchar_t UTF32;
typedef char UTF8;

namespace {
	Il2CppString *(*il2cpp_string_new)(const char *str);
    Il2CppString *(*il2cpp_string_new_utf16)(const wchar_t *str, int32_t length);
	void **(*il2cpp_domain_get_assemblies)(const void *domain, size_t *size);
	void *(*il2cpp_domain_get)();
	const void *(*il2cpp_assembly_get_image)(const void *assembly);
	const char *(*il2cpp_image_get_name)(void *image);
    void *(*il2cpp_class_from_name)(const void *image, const char *namespaze, const char *name);
    void *(*il2cpp_class_get_field_from_name)(void *klass, const char *name);
	void (*il2cpp_field_static_get_value)(void *field, void *value);
    void (*il2cpp_field_static_set_value)(void *field, void *value);
	void *(*il2cpp_class_get_method_from_name)(void *klass, const char *name, int argsCount);
	size_t (*il2cpp_field_get_offset)(void *field);
    bool (*il2cpp_is_vm_thread)(void * thread);
    size_t (*il2cpp_image_get_class_count)(const void *image);
    void *(*il2cpp_image_get_class)(void *image, size_t index);
    const char *(*il2cpp_class_get_name)(void *klass);
}

void *IL2Cpp::Il2CppGetImageByName(const char *image) {
	size_t size;
	
	void **assemblies = il2cpp_domain_get_assemblies(il2cpp_domain_get(), &size);
	
	for(int i = 0; i < size; ++i) {
		void *img = (void *)il2cpp_assembly_get_image(assemblies[i]);
		const char *img_name = il2cpp_image_get_name(img);
		
		if (strcmp(img_name, image) == 0) {
			return img;
		}
	}
	return nullptr;
}

void *IL2Cpp::Il2CppGetClassType(const char *image, const char *namespaze, const char *clazz) {
	static std::map<std::string, void *> cache;
	
	std::string s = image;
	s += namespaze;
	s += clazz;
	if (cache.count(s) > 0)
		return cache[s];
		
	void *img = IL2Cpp::Il2CppGetImageByName(image);
	if (!img) {
		return nullptr;
	}
	
	void *klass = il2cpp_class_from_name(img, namespaze, clazz);
	if (!klass) {
		return nullptr;
	}
	
	cache[s] = klass;
	return klass;
}

void IL2Cpp::Il2CppGetStaticFieldValue(const char *image, const char *namespaze, const char *clazz, const char *name, void *output) {
	void *klass = IL2Cpp::Il2CppGetClassType(image, namespaze, clazz);
	if (!klass) {
		return;
	}
    void *field = il2cpp_class_get_field_from_name(klass, name);
	if (!field) {
		return;
	}
	il2cpp_field_static_get_value(field, output);
}

void IL2Cpp::Il2CppGetStaticFieldValue(const char *namespaze, const char *clazz, const char *name, void *output) {
    static std::unordered_map<std::string, void*> cache;
    std::string key = std::string(namespaze) + "|" + clazz + "|" + name;
    auto it = cache.find(key);
    if (it != cache.end()) {
        void *field = il2cpp_class_get_field_from_name(it->second, name);
        if (!field) {
            return;
        }
        il2cpp_field_static_get_value(field, output);
        return;
    }
    size_t size;
    void **assemblies = il2cpp_domain_get_assemblies(il2cpp_domain_get(), &size);
    for(int i = 0; i < size; ++i) {
        void *img = (void *)il2cpp_assembly_get_image(assemblies[i]);
        const char *img_name = il2cpp_image_get_name(img);
        void *klass = IL2Cpp::Il2CppGetClassType(img_name, namespaze, clazz);
        if (klass) {
            void *field = il2cpp_class_get_field_from_name(klass, name);
            if (!field) {
                return;
            }
            il2cpp_field_static_get_value(field, output);
            cache[key] = klass;
        }
    }
}


void IL2Cpp::Il2CppGetStaticFieldValue(const char *clazz, const char *name, void *output) {
    static std::unordered_map<std::string, void*> cache;
    std::string key = std::string(clazz) + "|" + name;
    auto it = cache.find(key);
    if (it != cache.end()) {
        void *field = il2cpp_class_get_field_from_name(it->second, name);
        if (!field) {
            return;
        }
        il2cpp_field_static_get_value(field, output);
        return;
    }
    size_t size;
    void **assemblies = il2cpp_domain_get_assemblies(il2cpp_domain_get(), &size);
    for(int i = 0; i < size; ++i) {
        void *image = (void *)il2cpp_assembly_get_image(assemblies[i]);
        auto classCount = il2cpp_image_get_class_count(image);
        for (int j = 0; j < classCount; ++j) {
            void* klass = il2cpp_image_get_class(image, j);
            if (!klass) {
                continue;
            }
            const char *nameClazz = il2cpp_class_get_name(klass);
            if (strcmp(nameClazz, clazz) == 0) {
                void *field = il2cpp_class_get_field_from_name(klass, name);
                if (!field) {
                    return;
                }
                il2cpp_field_static_get_value(field, output);
                cache[key] = klass;
            }

        }
    }
}


void IL2Cpp::Il2CppSetStaticFieldValue(const char *image, const char *namespaze, const char *clazz, const char *name, void* value) {
	void *klass = IL2Cpp::Il2CppGetClassType(image, namespaze, clazz);
	if (!klass) {
		return;
	}
	void *field = il2cpp_class_get_field_from_name(klass, name);
	if (!field) {
		return;
	}
	il2cpp_field_static_set_value(field, value);
}

void *IL2Cpp::Il2CppGetMethodOffset(const char *image, const char *namespaze, const char *clazz, const char *name, int argsCount) {
    static std::unordered_map<std::string, void*> cache;
    std::string key = std::string(image) + "|" + namespaze + "|" + clazz + "|" + name + "|" + std::to_string(argsCount);
    auto it = cache.find(key);
    if (it != cache.end()) {
        return it->second;
    }

    void *klass = IL2Cpp::Il2CppGetClassType(image, namespaze, clazz);
	if (!klass) {
		return nullptr;
	}
	void **method = (void**)il2cpp_class_get_method_from_name(klass, name, argsCount);
	if (!method) {
		return nullptr;
	}
    cache[key] = *method;
	return *method;
}
void *IL2Cpp::Il2CppGetMethodOffset(const char *namespaze, const char *clazz, const char *name, int argsCount) {
    static std::unordered_map<std::string, void*> cache;
    std::string key = std::string(namespaze) + "|" + clazz + "|" + name + "|" + std::to_string(argsCount);
    auto it = cache.find(key);
    if (it != cache.end()) {
        return it->second;
    }
    size_t size;
    void **assemblies = il2cpp_domain_get_assemblies(il2cpp_domain_get(), &size);
    for(int i = 0; i < size; ++i) {
        void *img = (void *)il2cpp_assembly_get_image(assemblies[i]);
        const char *img_name = il2cpp_image_get_name(img);
        void *klass = IL2Cpp::Il2CppGetClassType(img_name, namespaze, clazz);
        if (klass) {
            void **method = (void**)il2cpp_class_get_method_from_name(klass, name, argsCount);
            if (method) {
                cache[key] = *method;
                return *method;
            }
        }
    }
    LOGE("Il2CppGetMethodOffset not found %s %s %s %d", namespaze, clazz, name, argsCount);
    return nullptr;
}
void *IL2Cpp::Il2CppGetMethodOffset(const char *clazz, const char *name, int argsCount) {
    static std::unordered_map<std::string, void*> cache;
    std::string key = std::string(clazz) + "|" + name + "|" + std::to_string(argsCount);
    auto it = cache.find(key);
    if (it != cache.end()) {
        return it->second;
    }
    size_t size;
    void **assemblies = il2cpp_domain_get_assemblies(il2cpp_domain_get(), &size);
    for(int i = 0; i < size; ++i) {
        void *image = (void *)il2cpp_assembly_get_image(assemblies[i]);
        auto classCount = il2cpp_image_get_class_count(image);
        for (int j = 0; j < classCount; ++j) {
            void* klass = il2cpp_image_get_class(image, j);
            if (!klass) {
                continue;
            }
            const char *nameClazz = il2cpp_class_get_name(klass);
            if (strcmp(nameClazz, clazz) == 0) {
                void **method = (void**)il2cpp_class_get_method_from_name(klass, name, argsCount);
                if (method) {
                    cache[key] = *method;
                    return *method;
                }
            }

        }
    }
    LOGE("IL2Cpp::Il2CppGetMethodOffset %s %s not found\n", clazz, name);
    return nullptr;
}
size_t IL2Cpp::Il2CppGetFieldOffset(const char *image, const char *namespaze, const char *clazz, const char *name) {
    static std::unordered_map<std::string, size_t> cache;
    std::string key = std::string(image) + "|" + namespaze + "|" + clazz + "|" + name;
    auto it = cache.find(key);
    if (it != cache.end()) {
        return it->second;
    }
    void *klass = IL2Cpp::Il2CppGetClassType(image, namespaze, clazz);
	if (!klass) {
		return -1;
	}
	void *field = il2cpp_class_get_field_from_name(klass, name);
	if (!field) {
		return -1;
	}
	auto result = il2cpp_field_get_offset(field);
    cache[key] = result;
	return result;
}
size_t IL2Cpp::Il2CppGetFieldOffset(const char *namespaze, const char *clazz, const char *name) {
    static std::unordered_map<std::string, size_t> cache;
    std::string key = std::string(namespaze) + "|" + clazz + "|" + name;
    auto it = cache.find(key);
    if (it != cache.end()) {
        return it->second;
    }
    size_t size;
    void **assemblies = il2cpp_domain_get_assemblies(il2cpp_domain_get(), &size);
    for(int i = 0; i < size; ++i) {
        void *img = (void *)il2cpp_assembly_get_image(assemblies[i]);
        const char *img_name = il2cpp_image_get_name(img);
        void *klass = IL2Cpp::Il2CppGetClassType(img_name, namespaze, clazz);
        if (klass) {
            void *field = il2cpp_class_get_field_from_name(klass, name);
            if (!field) {
                return -1;
            }
            auto result = il2cpp_field_get_offset(field);
            cache[key] = result;
            return result;
        }
    }
    return -1;
}
size_t IL2Cpp::Il2CppGetFieldOffset(const char *clazz, const char *name) {
    static std::unordered_map<std::string, size_t> cache;
    std::string key = std::string(clazz) + "|" + name;
    auto it = cache.find(key);
    if (it != cache.end()) {
        return it->second;
    }
    size_t size;
    void **assemblies = il2cpp_domain_get_assemblies(il2cpp_domain_get(), &size);
    for(int i = 0; i < size; ++i) {
        void *image = (void *)il2cpp_assembly_get_image(assemblies[i]);
        auto classCount = il2cpp_image_get_class_count(image);
        for (int j = 0; j < classCount; ++j) {
            void* klass = il2cpp_image_get_class(image, j);
            if (!klass) {
                continue;
            }
            const char *nameClazz = il2cpp_class_get_name(klass);
            if (strcmp(nameClazz, clazz) == 0) {
                void *field = il2cpp_class_get_field_from_name(klass, name);
                if (!field) {
                    return -1;
                }
                auto result = il2cpp_field_get_offset(field);
                cache[key] = result;
                return result;
            }

        }
    }
    return -1;
}




int is_surrogate(UTF16 uc) {
    return (uc - 0xd800u) < 2048u;
}

int is_high_surrogate(UTF16 uc) {
    return (uc & 0xfffffc00) == 0xd800;
}

int is_low_surrogate(UTF16 uc) {
    return (uc & 0xfffffc00) == 0xdc00;
}

UTF32 surrogate_to_utf32(UTF16 high, UTF16 low) {
    return (high << 10) + low - 0x35fdc00;
}

const char* utf16_to_utf8(const UTF16* source, size_t len) {
    std::u16string s(source, source + len);
    std::wstring_convert<std::codecvt_utf8_utf16<char16_t>, char16_t> convert;
    return convert.to_bytes(s).c_str();
}

const wchar_t* utf16_to_utf32(const UTF16* source, size_t len) {
	auto output = new UTF32[len + 1];

    for (int i = 0; i < len; i++) {
        const UTF16 uc = source[i];
        if (!is_surrogate(uc)) {
            output[i] = uc;
        }
        else {
            if (is_high_surrogate(uc) && is_low_surrogate(source[i]))
                output[i] = surrogate_to_utf32(uc, source[i]);
            else
                output[i] = L'?';
        }
    }

    output[len] = L'\0';
    return output;
}

const char* Il2CppString::CString() {
    return utf16_to_utf8(&this->start_char, this->length);
}

const wchar_t* Il2CppString::WCString() {
    return utf16_to_utf32(&this->start_char, this->length);
}

Il2CppString *Il2CppString::Create(const char *s) {
    return il2cpp_string_new(s);
}

Il2CppString *Il2CppString::Create(const wchar_t *s, int len) {
    return il2cpp_string_new_utf16(s, len);
}

void IL2Cpp::Il2CppAttach() {
	void *IL2Cpp_Handle = nullptr;
	
	while (!IL2Cpp_Handle) {
		IL2Cpp_Handle = dlopen("libil2cpp.so", 4);
		sleep(1);
	}
    sleep(1);

    il2cpp_class_get_name = (const char *(*)(void *)) dlsym(IL2Cpp_Handle, "il2cpp_class_get_name");
    il2cpp_image_get_class = (void *(*)(void *, size_t)) dlsym(IL2Cpp_Handle, "il2cpp_image_get_class");
    il2cpp_image_get_class_count = (size_t (*)(const void *)) dlsym(IL2Cpp_Handle, "il2cpp_image_get_class_count");
    il2cpp_is_vm_thread = (bool (*)(void *)) dlsym(IL2Cpp_Handle, "il2cpp_is_vm_thread");
	il2cpp_domain_get_assemblies = (void **(*)(const void *, size_t *)) dlsym(IL2Cpp_Handle, "il2cpp_domain_get_assemblies");
	il2cpp_string_new = (Il2CppString *(*)(const char *)) dlsym(IL2Cpp_Handle, "il2cpp_string_new");
    il2cpp_string_new_utf16 = (Il2CppString *(*)(const wchar_t *, int32_t)) dlsym(IL2Cpp_Handle, "il2cpp_string_new_utf16");
	il2cpp_domain_get = (void *(*)()) dlsym(IL2Cpp_Handle, "il2cpp_domain_get");
    il2cpp_assembly_get_image = (const void *(*)(const void *)) dlsym(IL2Cpp_Handle, "il2cpp_assembly_get_image");
	il2cpp_image_get_name = (const char *(*)(void *)) dlsym(IL2Cpp_Handle, "il2cpp_image_get_name");
    il2cpp_class_from_name = (void* (*)(const void*, const char*, const char *)) dlsym(IL2Cpp_Handle, "il2cpp_class_from_name");
    il2cpp_class_get_field_from_name = (void* (*)(void*, const char *)) dlsym(IL2Cpp_Handle, "il2cpp_class_get_field_from_name");
    il2cpp_field_static_get_value = (void (*)(void*, void *)) dlsym(IL2Cpp_Handle, "il2cpp_field_static_get_value");
	il2cpp_field_static_set_value = (void (*)(void*, void *)) dlsym(IL2Cpp_Handle, "il2cpp_field_static_set_value");
    il2cpp_class_get_method_from_name = (void* (*)(void *, const char*, int)) dlsym(IL2Cpp_Handle, "il2cpp_class_get_method_from_name");
    il2cpp_field_get_offset = (size_t (*)(void *)) dlsym(IL2Cpp_Handle, "il2cpp_field_get_offset");

    dlclose(IL2Cpp_Handle);

    sleep(1);
    while (!il2cpp_is_vm_thread(nullptr)) {
        sleep(1);
    }
}
