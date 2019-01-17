//
// Created by zhangchao042 on 2019/1/17.
//

#include <jni.h>
#include <string>
#include <iostream>
using namespace std;


extern "C"
JNIEXPORT jint JNICALL
Java_zc_neu_com_securitystorage_AES_add(JNIEnv *env, jclass type, jint a, jint b) {

    return a + b;

}