#include <jni.h>
#include <string>
#include <iostream>
using namespace std;

//extern "C" JNIEXPORT string JNICALL
//Java_zc_neu_com_securitystorage_MainActivity_stringFromJNI(
//        JNIEnv* env,
//        jobject /* this */, jint a, jint b) {
//
//    //std::string hello = env->GetStringUTFChars(ss,0);
//    //const int num = env->GetIntField(a,env->GetIntField);
//    //const int len = hello.size();
//    int num1 = a;
//    int num2 = b;
//    int sum = num1 + num2;
//
//    //string slen = std::to_string(len);
//    return std::to_string(sum);
//    //return env->NewStringUTF(slen.c_str());
//
//
//}

int add(int a,int b){
    return a + b + 10;
}

extern "C"
JNIEXPORT jint JNICALL
Java_zc_neu_com_securitystorage_MainActivity_add(JNIEnv *env, jobject instance, jint a,
                                                           jint b) {

    // TODO

    int num1 = a;
    int num2 = b;
    int sum = add(a,b);
    return sum;
}

extern "C"
JNIEXPORT jint JNICALL
Java_zc_neu_com_securitystorage_MainActivity_getInt(JNIEnv *env, jclass type) {

    return 1001;

}

