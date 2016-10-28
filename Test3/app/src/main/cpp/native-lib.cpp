#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_example_davidwalker_test3_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "This is Shtuff";
    return env->NewStringUTF(hello.c_str());
}
